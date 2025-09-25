package com.kh.bank.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.bank.model.vo.Bank;

public class BankDao {

	public int openAcc(SqlSession session, Bank customer) {
		return session.insert("bankMapper.openAcc", customer);
		
	}
}
