package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
import model.MemberDao;
import model.Pic;
import model.PicDao;

public class StartAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int num =Integer.parseInt(request.getParameter("family_num"));
		String familynum = request.getParameter("family_num");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		MemberDao dao = new MemberDao();
		Member mem = dao.selectOne(name);
		String msg = "���̵� Ȯ���ϼ���";
		String url = "start.jsp";
		if(mem != null) {
			if(familynum.equals(""+mem.getFamily_num()) && pass.equals(mem.getPass())) {
				msg = mem.getName() + "�α��� �ϼ̽��ϴ�.";
				request.getSession().setAttribute("login", name);
				PicDao da = new PicDao();
				request.getSession().setAttribute("num", ""+num);
				Pic pic = da.selectOne(num);
				url = "main.jsp?familynum="+familynum+"&picture="+pic.picture;
				request.setAttribute("pic", pic);
				request.setAttribute("msg", msg);
				request.setAttribute("url", url);
				return new ActionForward(false,"../alert.jsp");
			} else {
				msg = "��й�ȣ�� Ʋ���ϴ�.";
			}
			
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return new ActionForward(false,"../alert.jsp");
	}
}
