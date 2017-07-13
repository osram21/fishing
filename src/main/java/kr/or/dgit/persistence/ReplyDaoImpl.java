package kr.or.dgit.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.dgit.domain.Criteria;
import kr.or.dgit.domain.Reply;

@Repository
public class ReplyDaoImpl implements ReplyDao{
	@Autowired
	private SqlSession session;
	private static final String namespace = "kr.or.dgit.persistence.ReplyDao";
	@Override
	public List<Reply> replyList(int boardNo) throws Exception {
		return session.selectList(namespace+".replyList",boardNo);
	}

	@Override
	public void replyInsert(Reply r) throws Exception {
		session.insert(namespace+".replyInsert",r);
	}

	@Override
	public void replyUpdate(Reply r) throws Exception {
		session.update(namespace+".replyUpdate",r);
	}

	@Override
	public void replyDel(int replyNo) throws Exception {
		session.delete(namespace+".replyDel",replyNo);
	}

	@Override
	public List<Reply> listPage(int boardNo, Criteria cri) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("boardNo", boardNo);
		map.put("cri", cri);
		return session.selectList(namespace+".listPage",map);
	}

	@Override
	public int count(int boardNo) throws Exception {
		return session.selectOne(namespace+".count",boardNo);
	}
	
}
