package kr.or.dgit.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.dgit.domain.Board;
import kr.or.dgit.domain.Member;

@Repository
public class MemberDaoImpl implements MemberDao{
	@Autowired
	private SqlSession session;
	
	private static String namespace = "kr.or.dgit.persistence.MemberDao";

	@Override
	public void memberInsert(Member member) throws Exception {
		session.insert(namespace+".memberInsert",member);
	}

	@Override
	public Member selectByNo(String memberid) throws Exception {
		return session.selectOne(namespace+".memberbyNo",memberid);
	}

	@Override
	public List<Member> memberList() throws Exception {
		return session.selectList(namespace+".memberList");
	}

	@Override
	public void memberUpdate(Member member) throws Exception {
		session.update(namespace+".memberUpdate",member);
	}

	@Override
	public void delete(String memberid) throws Exception {
		session.delete(namespace+".memberDel",memberid);
	}

	@Override
	public Member Login(String memberId, String memberPass) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("memberId", memberId);
		map.put("memberPass", memberPass);
		return session.selectOne(namespace+".login",map);
	}

	
	

}
