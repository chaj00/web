package dept.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.dto.MyDeptDTO;
import dept.service.MyDeptService;
import dept.service.MyDeptServiceImpl;
@WebServlet(name = "deptupdate", urlPatterns = { "/deptupdate.do" })
public class DeptUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
												throws ServletException, IOException {
		doPost(req,res);
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("euc-kr");
		MyDeptDTO dept = new MyDeptDTO();
		dept.setDeptno(req.getParameter("deptno"));
		dept.setDeptname(req.getParameter("deptname"));
		dept.setLoc(req.getParameter("loc")) ;
		dept.setTelNum(req.getParameter("telNum"));
		
		
		MyDeptService service = new MyDeptServiceImpl();
		int result = service.update(dept);
		
		if(result>=1){	
			res.sendRedirect("/serverweb/deptlist.do");
		}
		
		
	}
	
}
