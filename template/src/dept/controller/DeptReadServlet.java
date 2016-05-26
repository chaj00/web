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
@WebServlet(name = "deptread", urlPatterns = { "/deptread.do" })
public class DeptReadServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
												throws ServletException, IOException {
		doPost(req,res);
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String deptno = req.getParameter("deptno");
		String state = req.getParameter("state");
		
		MyDeptService service = new MyDeptServiceImpl();
		MyDeptDTO dept = service.read(deptno);
		
		req.setAttribute("dept", dept);
		
		String path="";
		if(state.equals("READ")){
			path = "../dept/dept_read.jsp";
		}else if(state.equals("UPDATE")){
			path ="../dept/dept_update.jsp";
		}
		
		System.out.println(dept);
		req.setAttribute("pathurl", path);
		//요청재지정
		RequestDispatcher rd = req.getRequestDispatcher("/layout/mainLayout.jsp");
		rd.forward(req, res);
	
	}
	
}
