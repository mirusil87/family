package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
import model.MemberDao;

public class DeleteAction extends AdminLoginAction {

	@Override
	public ActionForward doExecute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		MemberDao dao = new MemberDao();
		Member mem = dao.selectOne(name);
		String msg = "�ش� ���̵�� �̹� Ż��Ǿ����ϴ�.";
		String url = "list.me?family_name="+mem.getName();
			if (dao.delete(name) > 0) {
					msg = name + "�� ���� Ż�� ��";
					url = "list.me?name="+mem.getName();
			}else {
				msg = "Ż��� ���� �߻�";
				url = "list.me?name="+mem.getName();
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return new ActionForward(false, "../alert.jsp");
	}
}
