package kr.or.dgit.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.dgit.domain.Criteria;
import kr.or.dgit.domain.PointReply;

@Repository
public class PointReplyImpl implements PointReplyDao{
	@Autowired
	private SqlSession session;

	private static String namespace="kr.or.dgit.persistence.PointReplyDao";
	@Override
	public List<PointReply> replyList(int pointNo) throws Exception {
		return session.selectList(namespace+".replyList",pointNo);
	}

	@Override
	public void replyInsert(PointReply pr) throws Exception {
		session.insert(namespace+".replyInsert",pr);
	}

	@Override
	public void replyUpdate(PointReply pr) throws Exception {
		session.update(namespace+".replyUpdate",pr);
	}

	@Override
	public void replyDel(int ptNo) throws Exception {
		session.delete(namespace+".replyDel",ptNo);
	}

	@Override
	public List<PointReply> listPage(int pointNo, Criteria cri) throws Exception {
		Map<String, Object>map = new HashMap<>();
		map.put("pointNo", pointNo);
		map.put("cri", cri);
		return session.selectList(namespace+".listPage",map);
	}

	@Override
	public int count(int pointNo) throws Exception {
		return session.selectOne(namespace+".count",pointNo);
	}

	@Override
	public List<PointReply> AvgPrf(int pointNo) throws Exception {
		return session.selectOne(namespace+".AvgPrf",pointNo);
	}

	@Override
	public List<PointReply> AvgPrs(Map<String, Object>map) throws Exception {
		return session.selectList(namespace+".AvgPrs",map);
	}

}
