package dept.service;

import static fw.JdbcTemplate.close;
import static fw.JdbcTemplate.getConnect;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dept.dao.MyDeptDAO;
import dept.dao.MyDeptDAOImpl;
import dept.dto.MyDeptDTO;
public class MyDeptServiceImpl implements MyDeptService {

	@Override
	public int register(MyDeptDTO dept) {
		Connection con = getConnect();
		MyDeptDAO dao = new MyDeptDAOImpl();
		int result = 0;
		try{
			result = dao.insert(dept, con);
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(con);
		}
		return result;
	}

	@Override
	public ArrayList<MyDeptDTO> search(String dname) {
		ArrayList<MyDeptDTO> deptlist = new ArrayList<MyDeptDTO>();
		System.out.println("¼­ºñ½º"+dname);
		Connection con = getConnect();
		MyDeptDAO dao = new MyDeptDAOImpl();
		try{
			deptlist = dao.search(dname, con);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return deptlist;
	}

	@Override
	public int delete(String deptno) {
		Connection con = getConnect();
		MyDeptDAO dao = new MyDeptDAOImpl();
		int result=0;
		try{
			result = dao.delete(con, deptno);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(con);
		}

		return result;
		
	}

	@Override
	public ArrayList<MyDeptDTO> select() {
		Connection con = getConnect();
		MyDeptDAO dao = new MyDeptDAOImpl();
		ArrayList<MyDeptDTO> list = new ArrayList();
		
		try {
			list = dao.select(con);
		} catch (SQLException e) {

			e.printStackTrace();
		}finally{
			close(con);
		}
		return list;
	}

	@Override
	public MyDeptDTO read(String deptno) {
		Connection con = getConnect();
		MyDeptDAO dao = new MyDeptDAOImpl();
		MyDeptDTO dept = new MyDeptDTO();
		try {
			dept = dao.read(deptno, con);
		} catch (SQLException e) {

			e.printStackTrace();
		}finally{
			close(con);
		}
		return dept;

	}

	@Override
	public int update(MyDeptDTO dept) {
		Connection con = getConnect();
		MyDeptDAO dao = new MyDeptDAOImpl();
		int result=0;
		try {
			result = dao.update(dept, con);
		} catch (SQLException e) {

			e.printStackTrace();
		}finally{
			close(con);
		}
		return result;
	}

}










