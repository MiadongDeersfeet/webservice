package com.kh.java.member.model.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.java.member.model.vo.Member;

public class MemberDao {

	public Member login(SqlSession sqlSession, Member member) {
		// 설명할 게 꽤 많습니다.
		// 로그인 할 때 SELECT 할 건 맞는데 무얼 돌려줄 것이냐? 이걸 고민해야돼요.
		
		return sqlSession.selectOne("memberMapper.login", member);
		// 유니크 제약이 걸려있기 때문에 하나의 값밖에 못가져와요. 그러니까 selectOne을 씁니다.
		// 매퍼의 네임스페이스 값을 입력해주고 참조해서 메소드명과 동일한 이름을 적어줍니다.
		// 인자값으로 member를 날려주고 앞에 return을 붙여줍니다.
	}
	
	public int signUp(SqlSession sqlSession, Member member) {
		
		return sqlSession.insert("memberMapper.signUp", member);
		
	}
	
	public int update(SqlSession sqlSession, Map<String, String> map) {
		
		return sqlSession.update("memberMapper.update", map);
	}
	
	public int delete(SqlSession sqlSession, Member member) {
		
		return sqlSession.update("memberMapper.delete", member);
	}
	
	public int updatePwd(SqlSession sqlSession, Map<String, String> map) {
	
		return sqlSession.update("memberMapper.updatePwd", map);
	}
}
