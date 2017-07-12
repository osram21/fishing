package kr.or.dgit.domain;

import java.util.Date;

public class Board {
	private int boardNo;
	private String memberId;
	private String boardTitle;
	private int boardCount;
	private Date boardStartdate;
	private String boardContent;
	/*----------업로드-------------*/
	
	
	public Board() {}
	
	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
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
		return "Board [boardNo=" + boardNo + ", memberId=" + memberId + ", boardTitle=" + boardTitle + ", boardCount="
				+ boardCount + ", boardStartdate=" + boardStartdate + ", boardContent=" + boardContent + "]";
	}
}
