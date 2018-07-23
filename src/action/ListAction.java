package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
import model.MemberDao;

/*
 *  �����ڷ� �α��� �� ��츸 ������ ������.
 *  1. ��� ����� ������ Member ��ü�� List�� ����.
 *  2. List ��ü�� �Ӽ��� �̿��ؼ� View(list.jsp)�� ����
 */
public class ListAction extends AdminLoginAction{

	@Override
	public ActionForward doExecute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Member> list = new MemberDao().list();
		request.setAttribute("list", list);
		return new ActionForward(false,"list.jsp");
	}

}
