package kr.or.dgit.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.dgit.domain.Board;
import kr.or.dgit.domain.Criteria;
import kr.or.dgit.domain.SerchCriteria;

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
	@Override
	public List<Board> listPage(int page) throws Exception {
		if(page<=0){
			page = 1;
		}
		page = (page-1)*10;//해당 page의 시작 게시물 index를 구함
		return session.selectList(namespace+".listPage",page);
	}
	@Override
	public void updatecnt(int boardNo) throws Exception {
		session.selectOne(namespace+".updateCnt",boardNo);
	}
	@Override
	public List<Board> listCriteria(Criteria cri) throws Exception {
		return session.selectList(namespace+".listCriteria",cri);
	}
	@Override
	public int totalCount() throws Exception {
		return session.selectOne(namespace+".totalCount");
	}
	@Override
	public List<Board> listSearch(SerchCriteria cri) throws Exception {
		return session.selectList(namespace+".listSearch",cri);
	}
	@Override
	public int searchCount(SerchCriteria cri) throws Exception {
		return session.selectOne(namespace+".searchCount",cri);
	}
}
