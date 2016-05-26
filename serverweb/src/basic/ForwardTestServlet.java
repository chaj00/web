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


@WebServlet(name = "forward", urlPatterns = { "/forward.do" })
public class ForwardTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter pw = response.getWriter();
		
		pw.println("<h1>요청재지정 연습-forward</h1>");
		System.out.println("요청재지정연습-forward");
		

		MyDeptDTO dto = new MyDeptDTO("001","전산실", "10층", "02");
		request.setAttribute("mydata", dto);
		
		

		RequestDispatcher rd = request.getRequestDispatcher("/jspbasic/result.jsp");
		rd.forward(request, response);
		System.out.println("서블릿종료");
		pw.println("<h1>요청재지정 연습-end</h1>");
		
	}

}
