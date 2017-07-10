package kr.or.dgit.domain;

import java.util.Date;

public class Member {
	private int memberNo;
	private String memberId;
	private String memberPass;
	private String memberName;
	private String memberEmail;
	private Date memberStartdate;
	
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPass() {
		return memberPass;
	}
	public void setMemberPass(String memberPass) {
		this.memberPass = memberPass;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public Date getMemberStartdate() {
		return memberStartdate;
	}
	public void setMemberStartdate(Date memberStartdate) {
		this.memberStartdate = memberStartdate;
	}
	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPass=" + memberPass
				+ ", memberName=" + memberName + ", memberEmail=" + memberEmail + ", memberStartdate=" + memberStartdate
				+ "]";
	}
}
