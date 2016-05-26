package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalcServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, 
						HttpServletResponse res) throws ServletException, IOException{
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");
		PrintWriter pw =res.getWriter();
		
		String num1 = req.getParameter("num1");
		String num2 = req.getParameter("num2");
		String method = req.getParameter("method");
		
		
		Calc calculator = new Calc();
		String result = Integer.toString(calculator.calc(Integer.parseInt(req.getParameter("num1")),
														Integer.parseInt(req.getParameter("num2")),
														method));
		pw.print("<h1>연산결과("+method+")</h1>" );
		pw.print("-------------------------" );
		pw.print("<h1>"+result+"</h1>");
		
	}

}
