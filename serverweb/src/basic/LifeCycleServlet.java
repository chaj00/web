package basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleServlet extends HttpServlet{
	public LifeCycleServlet(){
		System.out.println("LifeCycleServlet객체생성..");
	}
	public void init(){
		System.out.println("init...서블릿객체 초기화 작업");
	}
	public void service(HttpServletRequest req,
						HttpServletResponse res) throws ServletException, IOException{
		System.out.println("service..실제 웹에서 처리하고 싶은 일을 정의하는 매소드"
							+req.getMethod());
		//get방식으로 요청되면 doGet을 호출하고 post방식으로 요청되면 doPost매소드를 호출
		if(req.getMethod().equals("GET")){
			doGet(req,res);
		}else{
			doPost(req,res);
		}
			
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("doGet..~실제 웹에서 처리하고 싶은 일을 정의하는 매소드");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("doPost..~실제 웹에서 처리하고 싶은 일을 정의하는 매소드");
	}
	public void destroy(){
		System.out.println("destoy..서블릿객체가 소멸될때 호출되는 매소드");
	}
	
}
