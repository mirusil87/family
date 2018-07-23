package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
import model.MemberDao;

/*
 *  관리자로 로그인 한 경우만 실행이 가능함.
 *  1. 모든 사용자 정보를 Member 객체의 List로 저장.
 *  2. List 객체를 속성을 이용해서 View(list.jsp)로 전달
 */
public class ListAction extends AdminLoginAction{

	@Override
	public ActionForward doExecute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Member> list = new MemberDao().list();
		request.setAttribute("list", list);
		return new ActionForward(false,"list.jsp");
	}

}
