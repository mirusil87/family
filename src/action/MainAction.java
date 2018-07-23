package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
/*
 * 1. �α��� ���� ����
 * 	    �α��� ��   : main.jsp ȣ��
 *    �α��� �ȵ�: loginForm.jsp ȣ�� 
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
