package com.kh.java.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.java.board.model.dao.BoardDao;
import com.kh.java.board.model.vo.Attachment;
import com.kh.java.board.model.vo.Board;
import com.kh.java.board.model.vo.Category;
import com.kh.java.common.Template;
import com.kh.java.common.vo.PageInfo;

public class BoardService {
	
	private BoardDao bd = new BoardDao();
	
	public int selectListCount() {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		int listCount = bd.selectListCount(sqlSession);
		
		sqlSession.close();
		
		return listCount;
	}
	
	public List<Board> selectBoardList(PageInfo pi) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		List<Board> boards = bd.selectBoardList(sqlSession, pi);
		
		sqlSession.close();
		
		return boards;
		
	}
	
	public List<Category> selectCategory() {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		List<Category> categories = bd.selectCategory(sqlSession);
		
		sqlSession.close();
		
		return categories;
	}
	
	public int insert(Board board, Attachment at) {
		SqlSession sqlSession = Template.getSqlSession();
		
		// INSERT를 두 번 수행
		
		// BOARD 테이블에 한 번 --> 얘는 무조건 가서 INSERT를 하는 거예요.
		int boardResult = bd.insertBoard(sqlSession, board);
		int atResult = 1;
		// ATTACHMENT 테이블에 한 번 --> 파일이 존재할 때만 가야함
		// 어태치먼트가 있으면 어태치먼트에 가야할 거 아니에요~!~!~!
		if(at != null) {
			at.setRefBno(board.getBoardNo());
			atResult = bd.insertAttachment(sqlSession, at);
		}
		
		// 두 개의 DML구문을 하나의 트랜잭션으로 묶어서 처리
		// 둘 다 성공했으면 커밋을 할 거고, 하나라도 실패했으면 롤백을 할 거예요.
		if(boardResult * atResult > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		
		// 트랜잭션 처리까지 끝내고 난 후 성공실패여부를 반환
		return (boardResult * atResult);
	}
	
	public Map<String, Object> selectBoard(int boardNo) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		// SELECT 두 번 하기 + 조회수 증가(SQL -> update) / 안알려드린 게 하나 있긴 한데 일단 일반적으로 따지면 insert 랑 update 밖에 없는 거라고 생각하세요.
		
		// 총 DB에 3번 가야함 --> 뭐부터 할까?
		// UPDATE BOARD -- 얘는 데이터를 수정하는 구문이고 commit이 필요하겠네. => 업데이트에 실패하면 조회하러 갈 필요가 없는 거잖아요.
		// SELECT BOARD -- 얘는 조회하는 구문이고 
		// SELECT ATTACHMENT -- 우선순위가 낮을듯
		
		int result = bd.increaseCount(sqlSession, boardNo);
		
		if(result > 0) { // 과감하게 두 개 같이 쓰기ㅋ_ㅋ 실제작업은 SQL -> DAO -> SERVICE 이렇게 거꾸로 가요. 계획이 다 짜여져있어야 한다는 뜻~!
			sqlSession.commit();
			Board board = bd.selectBoard(sqlSession, boardNo);
			Attachment at = bd.selectAttachment(sqlSession, boardNo);
			Long userNo = bd.selectBoardWriter(sqlSession, boardNo);
			//System.out.println(board);
			//System.out.println(at);
			Map<String, Object> map = new HashMap();
			map.put("board", board);
			map.put("at", at);
			map.put("boardWriter", userNo);
			return map;
			
		}
		
		return null;
		
	}
	
	public int deleteBoard(Board board) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = bd.deleteBoard(sqlSession, board);
		Attachment at = bd.selectAttachment(sqlSession, board.getBoardNo().intValue());
		int result2 = 1;
		
		if(at != null) {
			result2 = bd.deleteAttachment(sqlSession, board.getBoardNo());
		}
		
		if(result * result2 > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return result * result2;
		
		
	}
	
	public int update(Board board, Attachment at) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		int boardResult = bd.updateBoard(sqlSession, board);
		
		// Attachment~
		// 새 첨부파일이 없을 때
		
		int atResult = 1;
		
		// 새 첨부파일이 존재할 경우
		if(at != null) {
			// case 1
			if(at.getFileNo() != null) { // 지역변수는 초기화를 안하면 못쓴다. 필드는 초기화를 안해도 쓸 수 있다.(기본값이 들어있기 때문) 참조자료형의 기본값 = null 그래서 null이랑 비교함
				// 기존에 첨부파일이 있다 => UPDATE
				atResult = bd.updateAttachment(sqlSession, at);
			} else {
				// case 2
				// 기존 첨부파일 없음 => INSERT
				atResult = bd.insertAttachment(sqlSession, at);
			}
			// case 2
		} // 없으면 뭐 할 거 없음
		
		// 둘 다 성공했을 때만 commit;
		// 하나라도 실패했으면 rollback;
		if(boardResult * atResult > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.commit();
		
		return (boardResult * atResult);
	}
	
	public int searchedCount(Map<String, Object> map) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		int count = bd.searchedCount(sqlSession, map);
		
		sqlSession.close();
		
		return count;
	}
	
	public List<Board> selectSearchList(Map<String, Object> map) {
		SqlSession sqlSession = Template.getSqlSession();
		
		List<Board> boards = bd.selectSearchList(sqlSession, map);
		
		sqlSession.close();
		
		return boards;
	}
	
	public int insertImage(Board board, List<Attachment> files) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		// 보드에 INSERT 하는 거 만들어놨음
		// Attachment에 INSERT 하는 거 만들어놨음
		
		int result = 0;
		
		try {
			// 1. 게시글 INSERT
			result = bd.insertImageBoard(sqlSession, board);
			
			// 2. 게시글 INSERT가 성공 시에만 첨부파일들 INSERT
			if(result > 0) {
				// 첨부파일 개수만큼 INSERT
				for(Attachment file : files) {
					file.setRefBno(board.getBoardNo());
					
					result = bd.insertAttachmentList(sqlSession, file);
					
					if(result == 0) {
						break; // 반복문 탈출하자구요.
					}
					
				}
			}
			
			// 3. 다 성공했으면 commit
			if(result > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			result = 0;
		} finally {
			sqlSession.close();
		}
		
		
		return result;
	}
	
}
