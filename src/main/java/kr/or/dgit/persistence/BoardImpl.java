package kr.or.dgit.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.dgit.domain.Board;

@Repository
public class BoardImpl implements BoardDao{
	@Autowired
	private SqlSession session;
	
	private static String namespace = "kr.or.dgit.persistence.BoardDao";
	@Override
	public void boardInsert(Board board) throws Exception {
		session.insert(namespace+".boardInsert",board);
	}

}
