package action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import model.Board;
import model.Cal;
import model.CalDao;

public class CalAction {
	CalDao dao = new CalDao();
	
	public ActionForward write(HttpServletRequest request, HttpServletResponse response) throws ParseException  {
			//request.setCharacterEncoding("euc-kr");
			Cal calen = new Cal();
			Calendar cal = Calendar.getInstance();
			int year = (request.getParameter("year")!=null)?Integer.parseInt(request.getParameter("year")):cal.get(Calendar.YEAR);
			int month = (request.getParameter("month")!=null)?Integer.parseInt(request.getParameter("month")):cal.get(Calendar.MONTH)+1;
			String sregdate = request.getParameter("startdate");
		    Date sdate = new SimpleDateFormat("yyyy-MM-dd").parse(sregdate);
		    String eregdate = request.getParameter("startdate");
		    Date edate = new SimpleDateFormat("yyyy-MM-dd").parse(eregdate);
		    
		    String family_num = request.getParameter("family_num");
			calen.setStart_regdate(sdate);
			calen.setEnd_regdate(edate);
			calen.setFamily_num(family_num);
			calen.setSubject(request.getParameter("subject"));
			calen.setColor(request.getParameter("color"));
			int num = dao.maxNum();
			calen.setNum(++num);
			int result = dao.insert(calen);
			String msg = null;
			String url = "calendar.ca?family_num="+family_num+"&year="+year+"&month="+ month;
			if (result > 0) {
				msg = "등록완료";
			} else {
				msg = "등록실패 ";
			}
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
		return new ActionForward(false, "../alert.jsp");
	}
	
	public ActionForward calendar
	(HttpServletRequest request, HttpServletResponse response) {
		Calendar cal = Calendar.getInstance();
		 int year = Integer.parseInt(request.getParameter("year"));
	      int month = Integer.parseInt(request.getParameter("month"));
	      String family_num = (String) request.getSession().getAttribute("num");
	      cal.set(year,month-1,1);
	      int lastday = cal.getActualMaximum(Calendar.DATE);
	      int dd = cal.get(Calendar.DAY_OF_WEEK) - 1;
	      
	      List<Cal> calen = dao.list(family_num);
	      
	      request.setAttribute("lastday", lastday);
	      request.setAttribute("dd", dd);
	      request.setAttribute("year", year);
	      request.setAttribute("month", month);
	      
	      request.setAttribute("calen", calen);
	      return new ActionForward(false, "calendar.jsp");
	   }
	public ActionForward updateForm
	(HttpServletRequest request, HttpServletResponse response) {
		String family_num = (String)request.getSession().getAttribute("num");
		int num = Integer.parseInt(request.getParameter("num"));
		Cal calen = dao.selectOne(num);
		request.setAttribute("calen", calen);
		request.setAttribute("family_num", family_num);
		return new ActionForward(false, "updateForm.jsp");
	}
	public ActionForward update
	(HttpServletRequest request, HttpServletResponse response) throws ParseException {
		String msg = null;
		String url = null;
		int num = Integer.parseInt(request.getParameter("num"));
		
		String sregdate = request.getParameter("startdate");
	    Date sdate = new SimpleDateFormat("yyyy-MM-dd").parse(sregdate);
	    String eregdate = request.getParameter("enddate");
	    Date edate = new SimpleDateFormat("yyyy-MM-dd").parse(eregdate);
		
	    Cal cal = new Cal();
	    cal.setNum(num);
		cal.setSubject(request.getParameter("subject"));
		cal.setStart_regdate(sdate);
		cal.setEnd_regdate(edate);
		cal.setFamily_num(request.getParameter("family_num"));
		cal.setColor(request.getParameter("color"));
		if(dao.update(cal)>0) {
			msg = "수정 완료 되었습니다.";
			url	= "cinfo.jsp";
		}else {
			msg = "수정 실패 하였습니다.";
			url = "updateForm.ca";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return new ActionForward(false, "../alert.jsp");
	}
}
