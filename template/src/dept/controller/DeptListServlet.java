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
@WebServlet(name = "deptlist", urlPatterns = { "/deptlist.do" })
public class DeptListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse res)
			throws ServletException, IOException {
		//��û���� ����
		//�����Ͻ� �޼ҵ� call
		MyDeptService service = new MyDeptServiceImpl();
		ArrayList<MyDeptDTO> deptlist = service.select();
		System.out.println("����"+ deptlist.size());
		
		//������ ����
		req.setAttribute("deptlist", deptlist);
		req.setAttribute("pathurl", "../dept/list.jsp");
		//��û������ - �и��س��� ����ȭ���� ��û�ǵ��� ������(list.jsp)
		RequestDispatcher rd = 
				req.getRequestDispatcher("/layout/mainLayout.jsp");
		rd.forward(req, res);
		
	}

}











