package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDao;

public abstract class UserLoginAction implements Action{
	protected String login;
	protected String name;
	protected String family_num;
	@Override
	public ActionForward execute
		(HttpServletRequest request, HttpServletResponse response) throws Exception {
		login = (String) request.getSession().getAttribute("login");
		name = request.getParameter(name);
		family_num = request.getParameter("family_num");
		List mem = new MemberDao().selectList(name);
		if (login == null) {
			request.setAttribute("msg", "로그인 후 거래하세요");
			request.setAttribute("url", "../member/start.jsp");
			return new ActionForward(false, "../alert.jsp");
		} 
		request.setAttribute("name", name);
		request.setAttribute("family_num", family_num);
		return doExecute(request, response);
	}
	public abstract ActionForward doExecute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}