package dept.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.service.MyDeptService;
import dept.service.MyDeptServiceImpl;

@WebServlet(name = "deptdelete", urlPatterns = { "/deptdelete.do" })
public class DeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		String deptno = req.getParameter("deptno");
		
		System.out.println(deptno);
		
		MyDeptService service = new MyDeptServiceImpl();
		int result = service.delete(deptno);
		
		/*if(result>=1){
			pw.print("<h1>삭제 성공</h1>");
		}else{
			pw.print("<h1>삭제 실패</h1>");
		}*/
		
		res.sendRedirect("/serverweb/deptlist.do");
	}
}
