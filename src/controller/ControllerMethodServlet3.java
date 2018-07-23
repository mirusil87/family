package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.ActionForward;
import action.CalAction;

/**
 * Servlet implementation class ControllerMethodServlet
 */
@WebServlet(
		urlPatterns= {"*.ca"},
		initParams= {
				@WebInitParam(name="properties",
							value="method2.properties")
				}
		)
public class ControllerMethodServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Properties pr = new Properties();
    @Override
    public void init(ServletConfig config) throws ServletException {
    	String props = config.getInitParameter("properties");
    	FileInputStream f = null;
    	try {
			f = new FileInputStream(config.getServletContext().getRealPath("/") + "WEB-INF/" + props);
			pr.load(f);
		} catch (IOException e) {
			throw new ServletException(e); 
		} finally {
			try {
				if(f != null) f.close();
			} catch (IOException e2) {}
		}
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		ActionForward forward = null;
		String command = null;
		try {
			command = request.getRequestURI();
			if(command.indexOf(request.getContextPath())==0) {
				command = command.substring(request.getContextPath().length());
			}
			Class[] paramType =
					new Class[] {HttpServletRequest.class, HttpServletResponse.class};
			Object[] paramObjs = new Object[] {request,response};
			String methodName = pr.getProperty(command);
			Method method = CalAction.class.getMethod(methodName, paramType);
			CalAction action = new CalAction();
			forward = (ActionForward)method.invoke(action, paramObjs);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getView());
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getView());
				dispatcher.forward(request, response);
			}
		}else {
			response.sendRedirect("nopage.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
