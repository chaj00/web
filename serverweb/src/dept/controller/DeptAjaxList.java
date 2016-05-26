package dept.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.dto.MyDeptDTO;
import dept.service.MyDeptService;
import dept.service.MyDeptServiceImpl;

@WebServlet(name = "ajaxlist", urlPatterns = { "/ajaxlist.do" })
public class DeptAjaxList extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyDeptService service = new MyDeptServiceImpl();
		ArrayList<MyDeptDTO> list= service.select();
		
		request.setAttribute("list", list);
		
		//요청재지정
		RequestDispatcher rd = request.getRequestDispatcher("/ajax/ajaxReadMain.jsp");
		rd.forward(request, response);
	}

}
