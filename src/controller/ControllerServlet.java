package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
/*
 * urlPatterns = { "*.me"	} : a.me, b.me, hello.me .... 
 * 								요청이 오면  ControllerServlet 서블릿을 호출하도록 설정
 * initParams = config 객체 
 * @WebInitParam : 환경변수값을 ControllerServlet 시작시 전달. 
 */
@WebServlet(
			urlPatterns = { "*.me"	},
			initParams  = { @WebInitParam
							 (name = "properties",
							 value = "action.properties")
							}
			)
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String,Action> commandMap = new HashMap<String,Action>();
    public ControllerServlet() {
        super();
    }
    //ControllerServlet 서블릿이 처음 호출될 때 한번 실행하는 메서드
    //config 객체에 WebInitParam 설정된 값이 전달.
    //		properties=action.properties 형태로 전달됨.
    @Override
    public void init(ServletConfig config) throws ServletException {
    	//props : action.properties 값을 저장
    	String props = config.getInitParameter("properties");
    	Properties pr = new Properties(); //Map객체
    	FileInputStream f = null;
    	try {
    		//f : action.properties 파일을 지정하고 있다. 
			f = new FileInputStream
			(config.getServletContext().getRealPath("/") + "WEB-INF/" + props);
			pr.load(f);
		} catch (IOException e) {
			throw new ServletException(e);
		} finally {
			try {
				if(f != null) f.close();
			}catch (IOException e) {}
		}
    	Iterator keyiter = pr.keySet().iterator();
    	while(keyiter.hasNext()) {
    		//command : "/model2/hello.me" 값 저장
    		String command = (String)keyiter.next();
    		//className : "action.HelloAction" 값 저장
    		String className = pr.getProperty(command);
    		try {
    			//클래스명이 정해져 있기 않기 때문에 미리 예측해서 Action 클래스로 넣고 객체화 하는 코드
    			//commandClass : action.HelloAction 클래스화 함.
				Class commandClass = Class.forName(className);
				//commandInstance : action.HelloAction 객체화 저장함. 
				Object commandInstance = commandClass.newInstance();
				commandMap.put(command, (Action)commandInstance);
			} catch (Exception e) {
				throw new ServletException(e);
			} 
    	}
    }
    //GET방식 호출시 실행되는 메서드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		Action action = null;
		ActionForward forward = null;
		String command = null;
		try {
			command = request.getRequestURI(); 
			if(command.indexOf(request.getContextPath())==0) {
				command = command.substring(request.getContextPath().length());
			}
			//action.AddAction 객체가 리턴
			action = commandMap.get(command);
			//forward = new ActionForward(false,"hello.jsp")라는 객체를 forward가 가지고 있다. 
			forward = action.execute(request, response); //이 때 request 속성 등록 (ActionForward.java)
		} catch (Exception e) {
			throw new ServletException(e);
		} 
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getView()); //request에 등록된 속성 사용불가
			}else {//forward 하기
				//request 객체를 이용한 forward 방식
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getView());//등록
				dispatcher.forward(request, response); //hello.jsp로 페이지 이동 
			}
		}else {
			response.sendRedirect("nopage.jsp");
		}
	}
	//POST방식 호출시 실행되는 메서드 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
}
