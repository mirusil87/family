package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
import model.MemberDao;

public class UpdateFormAction extends AdminLoginAction{
	@Override
	public ActionForward doExecute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		Member mem = new MemberDao().selectOne(name);
		request.setAttribute("mem", mem);
		return new ActionForward(false,"updateForm.jsp");
	}
}
