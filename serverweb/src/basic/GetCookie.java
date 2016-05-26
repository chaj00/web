package basic;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "getCookie", urlPatterns = { "/getCookie" })
public class GetCookie extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//쿠키의 name이 title이면 title변수의 쿠키의 값을 저장하고
		//쿠키의 name이 page면 page변수에 쿠키의 값을 저장
		
		Cookie[] cookie = request.getCookies();
		String title ="";
		String page ="";
		
		for(int i=0 ; i<cookie.length;i++){
			if(cookie[i].getName().equals("title")){
				title = cookie[i].getValue()+"_java";
			}else if(cookie[i].getName().equals("page")){
				page = cookie[i].getValue()+"page";
			}
		}
		
		System.out.println(title+":"+page);
		request.setAttribute("title", title);
		request.setAttribute("page", page);
		RequestDispatcher rd = request.getRequestDispatcher("/basic/cookieResult.jsp");
		rd.forward(request, response);
	}

}
