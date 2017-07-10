package kr.or.dgit.domain;

import java.util.Date;

public class Board {
	private int boardNo;
	private  int memberNo;
	private String boardTitle;
	private String boardContent;
	private int boardCount;
	private Date boardStartdate;
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public int getBoardCount() {
		return boardCount;
	}
	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}
	public Date getBoardStartdate() {
		return boardStartdate;
	}
	public void setBoardStartdate(Date boardStartdate) {
		this.boardStartdate = boardStartdate;
	}
	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", memberNo=" + memberNo + ", boardTitle=" + boardTitle + ", boardContent="
				+ boardContent + ", boardCount=" + boardCount + ", boardStartdate=" + boardStartdate + "]";
	}
}
