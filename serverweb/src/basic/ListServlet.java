package basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.dto.MyDeptDTO;

public class ListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
												throws ServletException, IOException {
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");
		PrintWriter pw =res.getWriter();
		
		Dept dao = new Dept();
		ArrayList<MyDeptDTO> list= dao.select();
		
		pw.print("<table border=1 style='border-collapse:collapse' >");
		pw.print("<tr>");
		pw.print("<th>�μ���ȣ</th><th>�μ��̸�</th><th>�μ���ġ</th><th>��ȭ��ȣ</th><th>����</th>");
		pw.print("</tr>");
		for(int i =0; i<list.size();i++){
			pw.print("<tr>");
			pw.print("<td>"+list.get(i).getDeptno()+"</td>");
			pw.print("<td>"+list.get(i).getDeptname()+"</td>");
			pw.print("<td>"+list.get(i).getLoc()+"</td>");
			pw.print("<td>"+list.get(i).getTelNum()+"</td>");
			pw.print("<td><a href='/serverweb/del.do?deptno="
														+list.get(i).getDeptno()
																			+"'>����</a></td>");
			pw.print("</tr>");
		}
		pw.print("</table>");
	}
	
}
