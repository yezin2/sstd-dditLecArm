package kr.or.ddit.board.vo;

public class BoardVO {
	
	private String boardNo;
	private String boardTitle;
	private String boardAuthor;
	private String boardContent;
	private String boardDate;
	
	private long atchFileId= -1;

	@Override
	public String toString() {
		return "BoardVO [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardAuthor=" + boardAuthor
				+ ", boardContent=" + boardContent + ", boardDate=" + boardDate + "]";
	}

	public String getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardAuthor() {
		return boardAuthor;
	}

	public void setBoardAuthor(String boardAuthor) {
		this.boardAuthor = boardAuthor;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}

	public long getAtchFileId() {
		return atchFileId;
	}

	public void setAtchFileId(long atchFileId) {
		this.atchFileId = atchFileId;
	}
	
	
}
