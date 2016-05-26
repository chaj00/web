package template;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * mainLayout.jsp에 보여질 수 있도록 view에 대한 정보를 attribute로 지정하고
 * forward하는 서블릿
 * 연결할 view의 정보는 요청 파라미터로 받아온다.
 */
@WebServlet(name = "view", urlPatterns = { "/view.do" })
public class ViewServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pathurl = request.getParameter("pathurl");
		String action = request.getParameter("action");
		System.out.println(pathurl);
		String url ="";
		if(action==null){
			url="/layout/mainLayout.jsp";
		}else{
			if(action.equals("member")){
				url="/layout/memberLayout.jsp";
			}
		}
		
		request.setAttribute("pathurl",pathurl);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
