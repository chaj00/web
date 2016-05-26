package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, 
    		HttpServletResponse res) throws ServletException, IOException{
		req.setCharacterEncoding("euc-kr");
		//������ �ڵ� - �������� ������ �� �ֵ��� ��Ʈ���� ��´�.
		res.setContentType("text/html;charset=euc-kr");
		PrintWriter pw =res.getWriter();
	
		String userId = req.getParameter("userId");
		String userName = req.getParameter("userName");
		String passwd= req.getParameter("passwd");
		String gender = req.getParameter("gender");
		String job = req.getParameter("job");
		String item[] = req.getParameterValues("item");
		
		pw.print("<h1>���̵�:"+userId+"</h1>");
		pw.print("<h1>�̸�:"+userName+"</h1>");
		pw.print("<h1>�н�����:"+passwd+"</h1>");
		pw.print("<h1>����:"+gender+"</h1>");
		pw.print("<h1>����:"+job+"</h1>");
		pw.print("<h1>���ɺо�:");
		for(int i=0;i<item.length;i++){
			if(i==item.length-1){
				pw.print(item[i]);
			}else{
				pw.print(item[i]+",");
			}
			
		}
		pw.print("</h1>");
	}

}
