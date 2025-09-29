package com.kh.java.member.model.service;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.java.common.Template;
import com.kh.java.member.model.dao.MemberDao;
import com.kh.java.member.model.vo.Member;

public class MemberService {

	private MemberDao md = new MemberDao();
	
	public Member login(Member member) {
		// 로그인 처리 -> DAO에게 보내서 있나 없나 검증 -> 결과값 반환
		// 엉뚱한 입력값이 날아왔을 수도 있어요. 얼마든지 앞단을 우회해서 값을 보낼 수도 있구요.
		// 이 값들을 가지고 DB에 가도 되는지 입력값에 대한 검증 과정이 필요합니다.
		// 그런데 아래 패턴 뿐만 아니라 빈문자열이 올 수도 있고 null이 올 수도 있고 ... 이런 부분도 검증이 필요해요.
		// validateMember(member); 비즈니스 로직
		
		SqlSession sqlSession = Template.getSqlSession();
		
		Member loginMember = md.login(sqlSession, member);
		
		sqlSession.close();
		
		return loginMember;
	}
	
	public void validateMember(Member member) {
		
		if(member.getUserId() == null || member.getUserId().trim().isEmpty()) {
			return;
		}
		String pattern = "^[a-zA-Z0-9]{4,20}$";
		if(!member.getUserId().matches(pattern)) {
			return;
		}
	}
	
	public int signUp(Member member) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = md.signUp(sqlSession, member);
		
		if(result > 0) {
		sqlSession.commit();
		}
		
		sqlSession.close();
		
		return result;
		
	}
	
	public int update(Map<String, String> map) {
		SqlSession session  = Template.getSqlSession();
		
		int result = md.update(session, map);
		
		if(result > 0) {
			session.commit();
		}
		
		session.close();
		
		return result;
	}
	
	public int delete(Member member) {
		SqlSession session = Template.getSqlSession();
		
		int result = md.delete(session, member);
		
		if(result > 0) {
			session.commit();
		}
		
		session.close();
		
		return result;
	}
	
	public int updatePwd(Map<String, String> map) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = md.updatePwd(sqlSession, map);
		
		if(result > 0) {
			sqlSession.commit();
			
		}
		sqlSession.close();
		
		return result;
	}
}
