package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
import model.MemberDao;

public class UpdateAction extends AdminLoginAction{

	@Override
	public ActionForward doExecute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Member mem = new Member();
		mem.setFamily_num(family_num);
		mem.setName(request.getParameter("name"));
		mem.setRelation(request.getParameter("relation"));
		mem.setPass(request.getParameter("pass"));
		mem.setTel(request.getParameter("tel"));
		mem.setAddress(request.getParameter("address"));
		mem.setPicture(request.getParameter("picture"));
			String msg = null;
			String url = null;
			int result = new MemberDao().update(mem);
			if(result >0) {
				 msg = "수정완료";
				 url = "list.me?family_num="+mem.getFamily_num();
			}else {
				 msg = "수정오류";
				 url = "updateForm.me?name=" + mem.getName();
			}
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			return new ActionForward(false,"../alert.jsp");
		}
	}
