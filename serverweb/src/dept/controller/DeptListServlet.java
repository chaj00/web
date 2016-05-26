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
@WebServlet(name = "deptlist", urlPatterns = { "/deptlist.do" })
public class DeptListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
												throws ServletException, IOException {

		MyDeptService service = new MyDeptServiceImpl();
		ArrayList<MyDeptDTO> list= service.select();
		
		req.setAttribute("list", list);
		
		//요청재지정
		RequestDispatcher rd = req.getRequestDispatcher("/dept/selectResultMain.jsp");
		rd.forward(req, res);
		
	}
	
}
