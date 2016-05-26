package dept.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "search", urlPatterns = { "/search.do" })
public class DeptSearchServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse res)
			throws ServletException, IOException {
		//��û���� ����
		req.setCharacterEncoding("euc-kr");
		String search = req.getParameter("search");
		System.out.println("�˻���"+search);
		//�����Ͻ� �޼ҵ� call
		MyDeptService service = new MyDeptServiceImpl();
		ArrayList<MyDeptDTO> searchlist = service.search(search);
		System.out.println("����"+ searchlist.size());
		
		//������ ����
		req.setAttribute("searchlist", searchlist);
		req.setAttribute("pathurl", "../dept/searchlist.jsp");
		//��û������ - �и��س��� ����ȭ���� ��û�ǵ��� ������(searchlist.jsp)
		RequestDispatcher rd = 
				req.getRequestDispatcher("/layout/mainLayout.jsp");
		rd.forward(req, res);
		
	}

}











