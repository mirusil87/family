package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String msg = "�α׾ƿ� �Ǽ̽��ϴ�.";
		String url = "start.jsp";
		request.getSession().invalidate();
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return new ActionForward(false,"../alert.jsp");
	}
	
	
}
