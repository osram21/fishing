package kr.or.dgit.service;

import java.util.List;

import kr.or.dgit.domain.Member;

public interface MemberService {
	public void memberInsert(Member member)throws Exception;
	public Member selectByNo(String memberid)throws Exception;
	public List<Member> memberList()throws Exception;
	public void memberUpdate(Member member)throws Exception;
	public void delete(String memberid)throws Exception;
}
