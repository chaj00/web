package emp.service;

import static fw.JdbcTemplate.getConnect;

import java.sql.Connection;
import java.sql.SQLException;

import emp.dao.MyEmpDAO;
import emp.dao.MyEmpDAOImpl;
import emp.dto.MyEmpDTO;

public class MyEmpServiceImp implements MyEmpService {

	@Override
	public MyEmpDTO login(String id, String pass) {
		Connection con = getConnect();
		MyEmpDTO myemp=null;
		MyEmpDAO dao = new MyEmpDAOImpl();
		try{
			myemp = dao.login(id, pass, con);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return myemp;
	}
	public static void main(String[] args){
		MyEmpServiceImp obj = new MyEmpServiceImp();
		obj.login("jang","1234");
	}
}
