package basic;

// ���ϸ� : URLInfoServlet.java
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/URLInfoServlet")
public class URLInfoServlet extends HttpServlet {
	public void doGet (HttpServletRequest req, HttpServletResponse res)	
                     		throws ServletException, IOException {
    PrintWriter out;
    res.setContentType("text/html; charset=EUC-KR");
		out = res.getWriter ();
		out.println("<html>");
		out.println("<head><title>Request ���� ��� Servlet</title></head>");
		out.println("<body>");
		out.println("<h3>��û ��İ� �������� ����</h3>");
		out.println("<pre>");
		out.println("Request URI : "+ req.getRequestURI());
		out.println("Request URL : "+ req.getRequestURL());
		out.println("Context Path : "+ req.getContextPath());
		out.println("Request Protocol : "+ req.getProtocol());
		out.println("Servlet Path : "+ req.getServletPath());
		out.println("</pre>");
		out.println("</body></html>");
		
   }  	
}