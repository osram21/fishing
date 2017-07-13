package kr.or.dgit.domain;

import java.util.Date;

public class Reply {
	private int replyNo;
	private int boardNo;
	private String memberId;
	private String replyContent;
	private  Date replyStartdate;
	
	public int getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public Date getReplyStartdate() {
		return replyStartdate;
	}
	public void setReplyStartdate(Date replyStartdate) {
		this.replyStartdate = replyStartdate;
	}
	@Override
	public String toString() {
		return "reply [replyNo=" + replyNo + ", boardNo=" + boardNo + ", memberId=" + memberId + ", replyContent="
				+ replyContent + ", replyStartdate=" + replyStartdate + "]";
	}
	
}
