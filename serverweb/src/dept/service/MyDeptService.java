package dept.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dept.dto.MyDeptDTO;

//DAO클래스의 메소드를 호출하고 관리하는 객체 - 커넥션관리(DAO로 커넥션을 전달)
public interface MyDeptService {
	int register(MyDeptDTO dept);//MyDeptDAOEmpl의 insert 메소드를 호출하는 메소드
	int delete(String deptno);
	ArrayList<MyDeptDTO> search(String dname);//MyDeptDAOEmpl의 search 메소드를 호출하는 메소드
	ArrayList<MyDeptDTO> select();
	MyDeptDTO read(String deptnon);
	int update(MyDeptDTO dept);
	
}
