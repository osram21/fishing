package kr.or.dgit.domain;

public class Content {
	private int boardNo;
	private String boardContent;
	
	public Content() {}
	public Content(int boardNo, String boardContent) {
		super();
		this.boardNo = boardNo;
		this.boardContent = boardContent;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	@Override
	public String toString() {
		return "Content [boardNo=" + boardNo + ", boardContent=" + boardContent + "]";
	}
}
