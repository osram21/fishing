package kr.or.dgit.domain;

import java.util.Date;

public class Board {
	private int boardNo;
	private  int memberNo;
	private String boardTitle;
	private int boardCount;
	private Date boardStartdate;
	/*----------업로드-------------*/
	
	public Board() {}
	
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
		return "Board [boardNo=" + boardNo + ", memberNo=" + memberNo + ", boardTitle=" + boardTitle + ", boardCount="
				+ boardCount + ", boardStartdate=" + boardStartdate + "]";
	}
}
