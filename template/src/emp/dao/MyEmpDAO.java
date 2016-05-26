package emp.dao;

import java.sql.Connection;
import java.sql.SQLException;

import emp.dto.MyEmpDTO;

public interface MyEmpDAO {
	MyEmpDTO login(String id,String pass, Connection con) 
								throws SQLException;
}
