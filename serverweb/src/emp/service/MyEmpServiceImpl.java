package emp.service;

import static fw.JdbcTemplate.close;
import static fw.JdbcTemplate.getConnect;

import java.sql.Connection;
import java.sql.SQLException;

import emp.dao.MyEmpDAO;
import emp.dao.MyEmpDAOImpl;
import emp.dto.MyEmpDTO;


public class MyEmpServiceImpl implements MyEmpService {

	@Override
	public MyEmpDTO login(String id, String pass) {
		Connection con = getConnect();
		MyEmpDAO dao = new MyEmpDAOImpl();
		MyEmpDTO emp = null;
		try{
			emp = dao.login(id,pass, con);
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(con);
		}
		return emp;
		
	}
	
	@Override
	public boolean idcheck(String id) {
		Connection con = getConnect();
		MyEmpDAO dao = new MyEmpDAOImpl();
		boolean result=false;
		try {
			result = dao.idCheck(con, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(null, null, con);
		return result;
	}

}
