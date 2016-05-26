package emp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet(name = "logout", urlPatterns = { "/logout.do" })
public class LogoutServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession ses = req.getSession(false);
		
		if(ses!=null){
			ses.invalidate();
			
		}
		res.sendRedirect("/serverweb/index.jsp");
		
	}


}
