package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
import model.MemberDao;
/*
 * 관리자로 로그인 한 경우만 실행이 가능하도록 검증 클래스
 * 관리자 업무인 경우는 이 클래스를 상속받아 사용하도록 함. 
 */
public abstract class AdminLoginAction implements Action {
	protected String login;
	protected String name;
	protected String family_num;

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		login = (String) request.getSession().getAttribute("login");
		name = request.getParameter(name);
		family_num = request.getParameter("family_num");
		List mem = new MemberDao().selectList(name);
		if (login == null) {
			request.setAttribute("msg", "로그인 후 거래하세요");
			request.setAttribute("url", "start.jsp");
			return new ActionForward(false, "../alert.jsp");
		} 
		request.setAttribute("name", name);
		request.setAttribute("family_num", family_num);
		return doExecute(request, response);
	}
	public abstract ActionForward doExecute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
