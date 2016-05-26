package basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleServlet extends HttpServlet{
	public LifeCycleServlet(){
		System.out.println("LifeCycleServlet��ü����..");
	}
	public void init(){
		System.out.println("init...������ü �ʱ�ȭ �۾�");
	}
	public void service(HttpServletRequest req,
						HttpServletResponse res) throws ServletException, IOException{
		System.out.println("service..���� ������ ó���ϰ� ���� ���� �����ϴ� �żҵ�"
							+req.getMethod());
		//get������� ��û�Ǹ� doGet�� ȣ���ϰ� post������� ��û�Ǹ� doPost�żҵ带 ȣ��
		if(req.getMethod().equals("GET")){
			doGet(req,res);
		}else{
			doPost(req,res);
		}
			
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("doGet..~���� ������ ó���ϰ� ���� ���� �����ϴ� �żҵ�");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("doPost..~���� ������ ó���ϰ� ���� ���� �����ϴ� �żҵ�");
	}
	public void destroy(){
		System.out.println("destoy..������ü�� �Ҹ�ɶ� ȣ��Ǵ� �żҵ�");
	}
	
}
