package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet {
	public void doPost (HttpServletRequest req, 
						HttpServletResponse res)  throws ServletException, IOException{
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");
		PrintWriter pw =res.getWriter();
		
		String name = req.getParameter("name");
		String addr = req.getParameter("addr");
		String language[] = req.getParameterValues("language");
		String save = req.getParameter("save");
		
		pw.print("<center><h2> client form data 처리 </h2></center>");
		if(name.length() !=0){
			pw.print("<h2>●이름:"+name+"</h2>");
		}else{
			pw.print("<h2>●이름:<이름을 입력하세요></h2>");
		}
		
		if(addr.length()!=0){
			pw.print("<h2>● 주소:"+addr+"</h2>");
		}else{
			pw.print("<h2>● 주소:<주소을 입력하세요></h2>");
		}
		
		pw.print("<h2>사용가능한  Language 선택</h2>");
		if(language!=null){
			for(int i=0;i<language.length ; i++ ){
				pw.print("<h2>● "+language[i]+"</h2>");
			}
		}else{
			pw.print("<h2>● 사용가능한 language가 없습니다.</h2>");
		}
		
		if(save!=null){
			pw.print("<h2>● 입력 정보 저장유무 :"+save+"</h2>");
		}else{
			pw.print("<h2>● 입력 정보 저장유무를 선택하세요</h2>");
		}
	}
}
