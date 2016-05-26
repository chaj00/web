package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeptServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, 
    					HttpServletResponse res) throws ServletException, IOException{
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");
		PrintWriter pw =res.getWriter();
		
		String deptno = req.getParameter("deptno");
		String deptname = req.getParameter("deptname");
		String loc = req.getParameter("loc");
		String telnum = req.getParameter("telnum");
		
		Dept dept = new Dept();
		int result = dept.insert(deptno, deptname, loc, telnum);
		
		if(result>=1){
			pw.print("<h1>입력 성공</h1>");
		}else{
			pw.print("<h1>입력 실패</h1>");
		}
		
	}

}
