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
@WebServlet(name = "deptsearch", urlPatterns = { "/deptsearch.do" })
public class DeptSearchServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
												throws ServletException, IOException {

		//정보추출
		req.setCharacterEncoding("euc-kr");
		String deptname = req.getParameter("search");
		
		MyDeptService service = new MyDeptServiceImpl();
		
		ArrayList<MyDeptDTO> list= service.search(deptname);
		
		req.setAttribute("searchlist", list);
		
		//요청재지정
		RequestDispatcher rd = req.getRequestDispatcher("/dept/searchResultMain.jsp");
		rd.forward(req, res);
		
	}
	
}
