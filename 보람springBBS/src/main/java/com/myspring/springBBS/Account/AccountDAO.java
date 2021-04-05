package com.myspring.springBBS.Account;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public class AccountDAO {
	@Autowired
	SqlSessionTemplate temp;
	
	public String dbCheck(String id) {
		int ck=(Integer)temp.selectOne("acct.idCheck",id);
		return ck>0 ? "t":"f"; // t �ߺ� ���̵� / f ��� ���� 
	}//end
	
	
	public void dbInsert(AccountDTO dto) {
		temp.insert("acct.insert", dto);
		System.out.println("Sacct���̺� dbInsert success");
		temp.insert("login.insert", dto);
		System.out.println("login���̺� dbInsert success");
	}//end
	
}//class EDN
