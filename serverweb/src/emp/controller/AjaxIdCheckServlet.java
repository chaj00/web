package emp.controller;

import java.io.IOException;
import java.io.PrintWriter;

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

@WebServlet(name = "idcheck", urlPatterns = { "/idcheck.do" })
public class AjaxIdCheckServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("euc-kr");
		
		res.setContentType("text/html;charset=euc-kr");
		PrintWriter pw =res.getWriter();
		
		String id = req.getParameter("id");
		MyEmpService service = new MyEmpServiceImpl();
		System.out.println(id);
		boolean result = service.idcheck(id);
		System.out.println(result);
		if(result){
			pw.println("사용 불가능한아이디입니다.");
		}else{	
			pw.println("사용가능한아이디입니다.");
		}
		//요청재지정
		//RequestDispatcher rd = req.getRequestDispatcher("/member/loginResultMain.jsp");
		//rd.forward(req, res);
		
	}
}
