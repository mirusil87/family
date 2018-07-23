package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Reply;
import model.ReplyDao;

public class DeletereplyAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int board_sep = Integer.parseInt(request.getParameter("family_num"));
		int board_no = Integer.parseInt(request.getParameter("num"));
		int renum = Integer.parseInt(request.getParameter("renum"));
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		Reply reply = new Reply();
		reply.setBnum(board_no);
		reply.setRenum(renum);
		request.setAttribute("board_sep", board_sep);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("renum", renum);
		int result = new ReplyDao().deletereply(reply);
		if(result > 0) {
			String msg= "삭제 되었습니다";
			String url = "../board/info.bo?family_num=" + board_sep + "&num=" + board_no+"&pageNum=" + pageNum;
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			return new ActionForward(false,"../alert.jsp");
		} else {
		String msg ="삭제에 실패하였습니다";
		String url = "../board/info.bo?family_num=" + board_sep + "&num=" + board_no+"&pageNum=" + pageNum;
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return new ActionForward(false,"../alert.jsp");
		}
	}

}