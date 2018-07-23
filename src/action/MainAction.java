package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
/*
 * 1. 로그인 여부 검증
 * 	    로그인 됨   : main.jsp 호출
 *    로그인 안됨: loginForm.jsp 호출 
 */
public class MainAction extends AdminLoginAction {

	@Override
	public ActionForward doExecute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Member mem = new Member();
		
		if(request.getSession().getAttribute("login") == null) {
			return new ActionForward(true,"start.jsp");
		}else {
			return new ActionForward(false,"main.jsp?family_num="+mem.getFamily_num());
		}
	}
}
