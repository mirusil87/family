package action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Session;

import com.oreilly.servlet.MultipartRequest;

import model.Board;
import model.BoardDao;
import model.Reply;
import model.ReplyDao;

public class AllAction {
	BoardDao dao = new BoardDao();

	public ActionForward writeForm(HttpServletRequest request, HttpServletResponse response) {
		return new ActionForward(false, "writeForm.jsp");
	}

	public ActionForward write(HttpServletRequest request, HttpServletResponse response) {
		// request.setCharacterEncoding("euc-kr");
		String path = request.getServletContext().getRealPath("/") + "model2/board/file/";
		MultipartRequest multi;
		try {
			multi = new MultipartRequest(request, path, 100 * 1024 * 1024, "euc-kr");
			Board bo = new Board();
			bo.setName(multi.getParameter("name"));
			bo.setPass(multi.getParameter("pass"));
			bo.setSubject(multi.getParameter("subject"));
			bo.setContent(multi.getParameter("content"));
			bo.setFile1(multi.getFilesystemName("file1"));
			bo.setFamily_num(multi.getParameter("family_num"));
			int num = dao.maxNum();
			bo.setNum(++num);
			bo.setRef(num);
			int result = dao.insert(bo);
			String msg = null;
			String url = "list.bo?family_num="+bo.getFamily_num();
			if (result > 0) {
				msg = "��ϿϷ�";
			} else {
				msg = "��Ͻ��� ";
			}
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ActionForward(false, "../alert.jsp");
	}

	public ActionForward list
	(HttpServletRequest request, HttpServletResponse response) {
		int pageNum = 1;
		int limit = 10;
		if (request.getParameter("pageNum") != null) {
			try {
				pageNum = Integer.parseInt(request.getParameter("pageNum"));
			} catch (NumberFormatException e) {
				pageNum = 1;
			}
		}
		String column = request.getParameter("column");
		String find = request.getParameter("find");
		if(column == null || column.equals("")) {
			column = null;
		}
		if(find == null || find.equals("")) {
			find = null;
		}
		request.setAttribute("find", find);
		String family_num = request.getParameter("family_num");
		int boardcount = dao.boardCount(column,find,family_num); // db�� ��ϵ� �� �Խù� �� ��
		List<Board> list = dao.list(pageNum, limit,column,find,family_num);// ȭ�鿡 ��µ� �Խù� ��ü��
		int maxpage = (int) ((double) boardcount / limit + 0.95); // �ʿ��� ������ ��. �ִ� ������.
		int startpage = (((int) (pageNum / 10.0 + 0.9)) - 1) * 10 + 1;// ȭ�鿡 ������ ����������.
		int endpage = startpage + 9; // ȭ�鿡 ������ �� ������.
		if (endpage > maxpage)
			endpage = maxpage;
		/*
		 * SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd"); today : "20180404
		 * String today = df.format(new Date()); request.setAttribute("today", today);
		 */
		// ȭ�鿡 ��µ� �Խù� ��ȣ.
		int boardnum = boardcount - ((pageNum - 1) * limit);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("boardcount", boardcount);
		request.setAttribute("list", list);
		request.setAttribute("boardnum", boardnum);
		return new ActionForward(false, "list.jsp");
	}

	public ActionForward info
	(HttpServletRequest request, HttpServletResponse response) {
		String num = request.getParameter("num");
		int board_no = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		Board board = dao.selectOne(num);
		List<Reply> list = new ReplyDao().select(Integer.parseInt(num));
		dao.addReadCnt(num);
		request.setAttribute("board", board);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("list", list);
		request.setAttribute("board_no", board_no);
		return new ActionForward(false, "info.jsp");
	}
	
	public ActionForward replyForm
	(HttpServletRequest request, HttpServletResponse response) {
		String pageNum = request.getParameter("pageNum");
		Board board = dao.selectOne(request.getParameter("num"));
		request.setAttribute("board", board);
		request.setAttribute("pageNum", pageNum);
	//replayForm(request, response); ������ ���� return Ÿ�Ե� �� ������ ���븸 ���� ����
	return new ActionForward(false, "replyForm.jsp");
	
	}
	public ActionForward reply
	(HttpServletRequest request, HttpServletResponse response) {
		String pageNum = request.getParameter("pageNum");
		String family_num = request.getParameter("family_num");
		Board board = new Board();
		board.setName(request.getParameter("name"));
		board.setRef(Integer.parseInt(request.getParameter("ref")));
		board.setReflevel(Integer.parseInt(request.getParameter("reflevel")));
		board.setRefstep(Integer.parseInt(request.getParameter("refstep")));
		board.setSubject(request.getParameter("subject"));
		board.setContent(request.getParameter("content"));
		board.setPass(request.getParameter("pass"));
		board.setFamily_num(request.getParameter("family_num"));
		String msg = "�亯 ��� �Ϸ�";
		String url = "list.bo?pageNum="+pageNum+"&family_num=" + family_num;
		if (!dao.reply(board)) {
			msg = "�亯 ��� ����";
			url = "replyForm.bo?num=" + board.getNum() +"&pageNum="+pageNum +"&family_num=" + family_num;
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return new ActionForward(false, "../alert.jsp");
	}
	public ActionForward updateForm
		(HttpServletRequest request, HttpServletResponse response) {
		String pageNum = request.getParameter("pageNum");
		String family_num = request.getParameter("family_num");
		Board board = dao.selectOne(request.getParameter("num"));
		request.setAttribute("board", board);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("family_num", family_num);
		return new ActionForward(false, "updateForm.jsp");
	}
	public ActionForward update
	(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getServletContext().getRealPath("/") + "model2/board/file/";
		MultipartRequest multi;
		String msg = null;
		String url = null;
		
		try {
			multi = new MultipartRequest(request, path, 100 * 1024 * 1024, "euc-kr");
			Board bo = new Board();
			String num = multi.getParameter("num");
			String pageNum = multi.getParameter("pageNum");
			Board board = dao.selectOne(num);
			String pass1 = board.getPass();
			bo.setNum(Integer.parseInt(num));
			bo.setName(multi.getParameter("name"));
			bo.setPass(multi.getParameter("pass"));
			bo.setSubject(multi.getParameter("subject"));
			bo.setContent(multi.getParameter("content"));
			bo.setFile1(multi.getParameter("file1"));
			if (board.getFile1() == null || board.getFile1().equals("")) {
				board.setFile1(multi.getParameter("file2"));
			}
			String pass2 = multi.getParameter("pass");
			msg = "��й�ȣ�� Ʋ���ϴ�.";
			url = "updateForm.bo?num=" + board.getNum()+ "&pageNum="+pageNum+"&family_num="+board.getFamily_num();
			System.out.println(pass1);
			System.out.println(pass2);
			if(pass1.equals(pass2)) {
				if(dao.update(bo)>0) {
					msg = "���� �Ϸ� �Ǿ����ϴ�.";
					url	= "list.bo?pageNum="+pageNum+"&family_num="+board.getFamily_num();
				}
			} else {
				msg = "���� ���� �Ͽ����ϴ�.";
				url = "updateForm.bo?num=" + board.getNum()+ "&pageNum="+pageNum+"&family_num="+board.getFamily_num();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return new ActionForward(false, "../alert.jsp");
	}
}
