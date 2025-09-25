package com.kh.bank.model.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.bank.common.Template;
import com.kh.bank.model.dao.BankDao;
import com.kh.bank.model.vo.Bank;

public class BankService {
	private BankDao bd = new BankDao();
	
	public int openAcc(Bank customer) {
		SqlSession session = Template.getSqlSession();
		int result = bd.openAcc(session, customer);
		
		session.commit();
		
		return result;
		
	}
}
