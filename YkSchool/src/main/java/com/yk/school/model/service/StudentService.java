package com.yk.school.model.service;

import org.apache.ibatis.session.SqlSession;

import com.yk.school.common.Template;
import com.yk.school.model.dao.StudentDao;
import com.yk.school.model.vo.Student;

public class StudentService {
	private StudentDao sd = new StudentDao();
	private SqlSession sqlSession = Template.getSqlSession();
	// 서비스는 Dao 를 필드에 private으로 따로 빼주자
	
	public Student login(Student student) {
		// 서비스가 할 일 => 로그인 처리 -> DAO에 보내서 있는지 없는지 검증 -> 결과값 반환
		
		Student loginStudent = sd.login(sqlSession, student);
		
		sqlSession.close();
		
		return loginStudent;
	}
	
	public int signUp(Student student) {
		
		int result = sd.signUp(sqlSession, student);
		
		sqlSession.commit();
		
		return result;
		
	}


}
