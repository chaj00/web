package dept.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.dto.MyDeptDTO;
import dept.service.MyDeptService;
import dept.service.MyDeptServiceImpl;
@WebServlet(name = "deptinsert", urlPatterns = { "/deptinsert.do" })
public class DeptInsertServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req,
			HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("euc-kr");
		
		//1. 요청정보 추출
		String deptno = req.getParameter("deptno");
		String deptname = req.getParameter("deptname");
		String loc = req.getParameter("loc");
		String telNum = req.getParameter("telNum");

		//2. 비지니스 메소드 호출
		MyDeptService service = new MyDeptServiceImpl();
		//클라이언트가 입력한 데이터를 DTO로 변환해서 전달
		MyDeptDTO dept = new MyDeptDTO(deptno, deptname, loc, 
										telNum);
		int result = service.register(dept);

		//3. 요청재지정 - 데이터 공유
		String msg = "";
		if(result>0){
			req.setAttribute("dept", dept);
			msg = "삽입성공";
		}else{
			msg = "삽입실패";
		}
		req.setAttribute("result", msg);		
		req.setAttribute("pathurl", "../dept/insertResult.jsp");
		RequestDispatcher rd =
				req.getRequestDispatcher("/layout/mainLayout.jsp");
		rd.forward(req, res);
		
	}
	
}














