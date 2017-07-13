package kr.or.dgit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.dgit.domain.Board;

import kr.or.dgit.domain.Member;
import kr.or.dgit.persistence.BoardDao;

import kr.or.dgit.persistence.MemberDao;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDao dao;

	@Override
	public void memberInsert(Member member) throws Exception {
		dao.memberInsert(member);
	}

	@Override
	public Member selectByNo(String memberid) throws Exception {
		return dao.selectByNo(memberid);
	}

	@Override
	public List<Member> memberList() throws Exception {
		return dao.memberList();
	}

	@Override
	public void memberUpdate(Member member) throws Exception {
		dao.memberUpdate(member);
	}

	@Override
	public void delete(String memberid) throws Exception {
		dao.delete(memberid);
	}
}
