package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Reply;
import model.ReplyDao;

public class ReplyAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int board_no = Integer.parseInt(request.getParameter("bnum")); 
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		
		String reply_content = request.getParameter("reply_content");
		String writer = request.getParameter("writer");
		Reply reply = new Reply();
		
		reply.setBnum(board_no);
		reply.setContent(reply_content);
		reply.setWriter(writer);
		int result = new ReplyDao().insert(reply);
		String msg = null;
		String url = null;
		if(result > 0) {
			msg = "댓글 등록 완료.";
			url = "info.bo?&num="+board_no+"&pageNum="+pageNum;
			request.setAttribute("board_no", board_no);
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			return new ActionForward(false,"../alert.jsp");
		} else {
			msg = "댓글 등록 실패.";
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			return new ActionForward(false,"../alert.jsp");
		}
	}
}