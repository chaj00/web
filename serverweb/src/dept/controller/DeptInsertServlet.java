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
	public void doPost(HttpServletRequest req, 
    					HttpServletResponse res) throws ServletException, IOException{
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");
		PrintWriter pw =res.getWriter();
		//1. ��û���� ����
		String deptno = req.getParameter("deptno");
		String deptname = req.getParameter("deptname");
		String loc = req.getParameter("loc");
		String telNum = req.getParameter("telNum");
		
		//2. ����Ͻ� �޼ҵ� ȣ��
		MyDeptService service = new MyDeptServiceImpl();
		
		//
		MyDeptDTO dept = new MyDeptDTO(deptno, deptname, loc, telNum);
		int result = service.register(dept);
		
		//3. ��û������ -�����Ͱ���
		String msg ="";
		if(result>0){
			req.setAttribute("dept", dept);
			msg = "���Լ���";
		}else{
			msg ="���Խ���";
		}
		
		req.setAttribute("result", msg);
		
		
		RequestDispatcher rd = req.getRequestDispatcher("/dept/insertResultMain.jsp");
		rd.forward(req, res);
		
	}

}
