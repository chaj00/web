package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.dto.MyDeptDTO;


@WebServlet(name = "include", urlPatterns = { "/include.do" })
public class IncludeTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter pw = response.getWriter();
		
		pw.println("<h1>��û������ ����-include</h1>");
		System.out.println("��û����������-include");
		

		MyDeptDTO dto = new MyDeptDTO("001","�����", "10��", "02");
		request.setAttribute("mydata", dto);
		
		

		RequestDispatcher rd = request.getRequestDispatcher("/jspbasic/result.jsp");
		rd.include(request, response);
		System.out.println("��������");
		pw.println("<hr/>");
		pw.println("<h1>��û������ ����-end</h1>");
		
	}

}
