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

@WebServlet(name = "ajaxinsert", urlPatterns = { "/ajaxinsert.do" })
public class DeptAjaxInsertServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, 
    					HttpServletResponse res) throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=euc-kr");
		PrintWriter pw =res.getWriter();
		//1. 요청정보 추출
		String deptno = req.getParameter("deptno");
		String deptname = req.getParameter("deptname");
		String loc = req.getParameter("loc");
		String telNum = req.getParameter("telNum");
		
		//2. 비즈니스 메소드 호출
		MyDeptService service = new MyDeptServiceImpl();
		
		//
		MyDeptDTO dept = new MyDeptDTO(deptno, deptname, loc, telNum);
	
		System.out.println(dept.toString());
		int result = service.register(dept);
		//3. 요청재지정 -데이터공유
		String msg ="";
		if(result>0){
			req.setAttribute("dept", dept);
			msg = "삽입성공";
		}else{
			msg ="삽입실패";
		}
		
		req.setAttribute("result", msg);
		
		
		RequestDispatcher rd = req.getRequestDispatcher("/dept/insertResultMain.jsp");
		rd.forward(req, res);
		
	}

}
