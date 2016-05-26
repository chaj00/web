package dept.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dept.dto.MyDeptDTO;

//DAOŬ������ �޼ҵ带 ȣ���ϰ� �����ϴ� ��ü - Ŀ�ؼǰ���(DAO�� Ŀ�ؼ��� ����)
public interface MyDeptService {
	int register(MyDeptDTO dept);//MyDeptDAOEmpl�� insert �޼ҵ带 ȣ���ϴ� �޼ҵ�
	int delete(String deptno);
	ArrayList<MyDeptDTO> search(String dname);//MyDeptDAOEmpl�� search �޼ҵ带 ȣ���ϴ� �޼ҵ�
	ArrayList<MyDeptDTO> select();
	MyDeptDTO read(String deptnon);
	int update(MyDeptDTO dept);
	
}
