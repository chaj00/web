package emp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import emp.dto.MyEmpDTO;
import emp.service.MyEmpService;
import emp.service.MyEmpServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "login", urlPatterns = { "/login.do" })
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("euc-kr");
		
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		
		MyEmpService service = new MyEmpServiceImpl();
		MyEmpDTO emp = service.login(id, pass);
		
		HttpSession ses = req.getSession();
		
		ses.setAttribute("loginuser",emp);
		
		
		//요청재지정
		RequestDispatcher rd = req.getRequestDispatcher("/member/loginResultMain.jsp");
		rd.forward(req, res);
		
	}

}
