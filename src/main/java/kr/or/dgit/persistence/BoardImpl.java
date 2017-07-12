package kr.or.dgit.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.dgit.domain.Board;
import kr.or.dgit.domain.Content;

@Repository
public class BoardImpl implements BoardDao{
	@Autowired
	private SqlSession session;
	
	private static String namespace = "kr.or.dgit.persistence.BoardDao";
	@Override
	public void boardInsert(Board board) throws Exception {
		session.insert(namespace+".boardInsert",board);
	}
	@Override
	public void contentInsert(Board board) throws Exception {
		session.insert(namespace+".contentInsert",board);
	}
	@Override
	public List<Board> boardList() throws Exception {
		return session.selectList(namespace+".boardList");
	}
	@Override
	public Board boardRead(int boardNo) throws Exception {
		return session.selectOne(namespace+".boardRead",boardNo);
	}
	@Override
	public void boardDel(int boardNo) throws Exception {
		session.delete(namespace+".boardDel",boardNo);
	}
	@Override
	public void contentDel(int boardNo) throws Exception {
		session.delete(namespace+".contentDel",boardNo);
	}
	@Override
	public void boardUpdate(Board board) throws Exception {
		session.update(namespace+".boardUpdate",board);
		
	}
	@Override
	public void contentUpdate(Board board) throws Exception {
		session.update(namespace+".contentUpdate",board);
	}

}
