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
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse res)
			throws ServletException, IOException {
		//요청정보 추출
		//비지니스 메소드 call
		MyDeptService service = new MyDeptServiceImpl();
		ArrayList<MyDeptDTO> deptlist = service.select();
		System.out.println("서블릿"+ deptlist.size());
		
		//데이터 공유
		req.setAttribute("deptlist", deptlist);
		req.setAttribute("pathurl", "../dept/list.jsp");
		//요청재지정 - 분리해놓은 응답화면이 요청되도록 재지정(list.jsp)
		RequestDispatcher rd = 
				req.getRequestDispatcher("/layout/mainLayout.jsp");
		rd.forward(req, res);
		
	}

}











