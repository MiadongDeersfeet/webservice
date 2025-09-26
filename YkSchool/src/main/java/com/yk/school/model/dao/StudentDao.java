package com.yk.school.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.yk.school.model.vo.Student;

public class StudentDao {

	public Student login(SqlSession sqlSession, Student student) {
		
		return sqlSession.selectOne("studentMapper.login", student);
	}
	
	public int signUp(SqlSession sqlSession, Student student) {
		
		return sqlSession.insert("studentMapper.signUp", student);
		
		
	}
}
