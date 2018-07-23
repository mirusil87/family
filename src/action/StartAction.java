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
		String msg = "아이디를 확인하세요";
		String url = "start.jsp";
		if(mem != null) {
			if(familynum.equals(""+mem.getFamily_num()) && pass.equals(mem.getPass())) {
				msg = mem.getName() + "로그인 하셨습니다.";
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
				msg = "비밀번호가 틀립니다.";
			}
			
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return new ActionForward(false,"../alert.jsp");
	}
}
