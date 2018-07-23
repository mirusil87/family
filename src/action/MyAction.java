package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Privat;
import model.PrivatDao;

public class MyAction {
	PrivatDao dao = new PrivatDao();

	public ActionForward writeForm(HttpServletRequest request, HttpServletResponse response) {
		return new ActionForward(false, "writeForm.jsp");
	}

	public ActionForward write(HttpServletRequest request, HttpServletResponse response)  {
			//request.setCharacterEncoding("euc-kr");
			Privat bo = new Privat();
			bo.setName(request.getParameter("name"));
			bo.setFamily_num(request.getParameter("family_num"));
			bo.setSubject(request.getParameter("subject"));
			bo.setContent(request.getParameter("content"));
			int num = dao.maxNum();
			bo.setNum(++num);
			int result = dao.insert(bo);
			String msg = null;
			String url = "list.pv?family_num="+bo.getFamily_num()+"&name="+bo.getName();
			if (result > 0) {
				msg = "��ϿϷ�";
			} else {
				msg = "��Ͻ��� ";
			}
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
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
		String name = request.getParameter("name");
		String family_num = request.getParameter("family_num");
		request.setAttribute("name", name);
		request.setAttribute("family_num", family_num);
		int boardcount = dao.boardCount(family_num,name); // db�� ��ϵ� �� �Խù� �� ��
		List<Privat> list = dao.list(pageNum, limit,family_num,name);// ȭ�鿡 ��µ� �Խù� ��ü��
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
		String name = request.getParameter("name");
		String family_num = request.getParameter("family_num");
		String pageNum = request.getParameter("pageNum");
		Privat board = dao.selectOne(num,name,family_num);
		dao.addReadCnt(num);
		request.setAttribute("board", board);
		request.setAttribute("pageNum", pageNum);
		return new ActionForward(false, "info.jsp");
	}
 	
	public ActionForward delete
	(HttpServletRequest request, HttpServletResponse response) {
		String num = request.getParameter("num");
		String name = request.getParameter("name");
		String family_num = request.getParameter("family_num");
		Privat board = dao.selectOne(num,name,family_num);
		String pageNum = request.getParameter("pageNum");
		String msg = null;
		String url = null;
			if(dao.delete(num)>0) {
				msg = "���� �Ϸ�";
				url = "list.pv?pageNum="+pageNum+"&family_num="+board.getFamily_num()+"&name="+board.getName();
			} else {
				msg = "���� ����";
				url = "info.pv?num=" + board.getNum()+"&pageNum="+pageNum+"&family_num="+board.getFamily_num()+"&name="+board.getName();
			}
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			return new ActionForward(false,"../alert.jsp");
	}
}
