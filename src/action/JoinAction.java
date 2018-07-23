package action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cal;
import model.CalDao;
import model.Member;
import model.MemberDao;
/*
 * 1. �Ķ���� ���� Member ��ü�� ����. 
 * 2. Member ��ü�� db�� insert �ϱ�. 
 * 3. ȸ�������� ���� : loginForm.jsp
 * 	    ȸ������ ���н� : joinForm.jsp
 */
public class JoinAction extends AdminLoginAction{

	@Override
	public ActionForward doExecute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Member mem = new Member();
		mem.setFamily_num(request.getParameter("num"));
		mem.setBirth(request.getParameter("birth"));
		mem.setName(request.getParameter("name"));
		mem.setRelation(request.getParameter("relation"));
		mem.setPass(request.getParameter("pass"));
		mem.setAddress(request.getParameter("address"));
		mem.setTel(request.getParameter("tel"));
		mem.setPicture(request.getParameter("picture"));
		int result = new MemberDao().insert(mem);
		
		Cal calen = new Cal();
		CalDao dao = new CalDao();
		String sregdate = request.getParameter("birth");
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(sregdate);
		calen.setFamily_num(request.getParameter("num"));
		calen.setEnd_regdate(date);
		calen.setStart_regdate(date);
		calen.setSubject(request.getParameter("name")+"����");
		calen.setColor("pink");
		int num = dao.maxNum();
		calen.setNum(++num);
		int result2 = dao.insert(calen);
		System.out.println(result2);
		if(result >0) {
			request.setAttribute("msg", "ȸ������� �Ǿ����ϴ�.");
			request.setAttribute("url", "list.me?family_num="+mem.getFamily_num());
			return new ActionForward(false,"../alert.jsp");
		} else {
			request.setAttribute("msg", "ȸ����Ͽ� �����߽��ϴ�.");
			request.setAttribute("url", "joinForm.jsp");
			return new ActionForward(false,"../alert.jsp");
		}
	}
}