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

import org.json.simple.JSONObject;

import dept.dto.MyDeptDTO;
import dept.service.MyDeptService;
import dept.service.MyDeptServiceImpl;
@WebServlet(name = "ajaxread", urlPatterns = { "/ajaxread.do" })
public class DeptAjaxRead extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("euc-kr");
		res.setContentType("application/json;charset=utf-8");
		PrintWriter pw =res.getWriter();
		
		String deptno = req.getParameter("deptno");
		System.out.println(deptno);
		
		MyDeptService service = new MyDeptServiceImpl();
		MyDeptDTO dept = service.read(deptno);
		
		JSONObject deptjson = new JSONObject();
		deptjson.put("deptno", dept.getDeptno());
		deptjson.put("deptname", dept.getDeptname());
		deptjson.put("loc", dept.getLoc());
		deptjson.put("telNum", dept.getTelNum());
		System.out.println(deptjson.toJSONString());
		pw.print(deptjson.toJSONString());
		
	}
	
}
