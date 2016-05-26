package basic;

import java.io.IOException;


import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "setCookie", urlPatterns = { "/setCookie" })
public class SetCookie extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//원하는 정보를 갖고 있는 쿠키개체를 생성
		Cookie cookie1 = new Cookie("title", URLEncoder.encode("이클립스", "euc-kr"));
		Cookie cookie2 = new Cookie("page", "70");
		
		//쿠키에대한  유효시간 설정
		cookie1.setMaxAge(120);
		cookie2.setMaxAge(120);
		
		//쿠키를 클라이언트로 전송
		response.addCookie(cookie1);
		response.addCookie(cookie2);
	}

}
