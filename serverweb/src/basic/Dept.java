package basic;

import static fw.JdbcTemplate.getConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dept.dto.MyDeptDTO;

public class Dept {
	public int insert(String deptno, String deptname, String loc, String telnum){
		System.out.println("insert.."+deptno+","+deptname+","+loc+","+telnum);
		Connection con = getConnect();
		String sql = "insert into mydept values(?,?,?,?)";
		
		int result=0;
		try {
			PreparedStatement ptmt = con.prepareStatement(sql);
			ptmt.setString(1, deptno);
			ptmt.setString(2, deptname);
			ptmt.setString(3, loc);
			ptmt.setString(4, telnum);
			result = ptmt.executeUpdate();
			System.out.println(result+"개 행 삽입성공!!!");
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("연결실패");
		}
		return result;
	}

	public ArrayList<MyDeptDTO> select(){
		Connection con = getConnect();
		String sql = "select * from mydept";
		ArrayList<MyDeptDTO> deptlist = new ArrayList<MyDeptDTO>();
		try {
			PreparedStatement ptmt = con.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			MyDeptDTO dept =null; 
			while(rs.next()){
				dept = new MyDeptDTO(rs.getString(1),
									rs.getString(2),
									rs.getString(3),
									rs.getString(4));
				deptlist.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deptlist;
	}
	
	public int delete(String deptno){
		Connection con = getConnect();
		String sql = "delete mydept where deptno= ? ";
		int result=0;
		
		try {
			PreparedStatement ptmt = con.prepareStatement(sql);
			ptmt.setString(1, deptno);
			result = ptmt.executeUpdate();
			System.out.println(result+"개 행 삭제성공!!!");
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("연결실패");
		}
		return result;
	}
}
