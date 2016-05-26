package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.dto.MyDeptDTO;


@WebServlet(name = "redirectTest", urlPatterns = { "/redirectTest.do" })
public class SendRedirectTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html);charset=euc-kr");
		PrintWriter pw = response.getWriter();
		
		pw.println("<h1>요청재지정 연습-sendRedirect</h1>");
		System.out.println("요청재지정연습-sendRedirect");
		//데이터 공유 -db에서 가져온 데이터 or 비지니스로직을 실행한 결과
		MyDeptDTO dto = new MyDeptDTO("001","전산실", "10층", "02");
		request.setAttribute("mydata", dto);
		
		
		//요청재지정
		response.sendRedirect("/serverweb/jspbasic/result.jsp");
	}

}
