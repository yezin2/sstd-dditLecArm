package ddit_board.vo;

public class BoardVO {
	private String boardNo;
	private String boardTit;
	private String boardAut;
	private String boardCont;
	private String boardDay;
	
	public String getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardTit() {
		return boardTit;
	}
	public void setBoardTit(String boardTit) {
		this.boardTit = boardTit;
	}
	public String getBoardAut() {
		return boardAut;
	}
	public void setBoardAut(String boardAut) {
		this.boardAut = boardAut;
	}
	public String getBoardCont() {
		return boardCont;
	}
	public void setBoardCont(String boardCont) {
		this.boardCont = boardCont;
	}
	public String getBoardDay() {
		return boardDay;
	}
	public void setBoardDay(String boardDay) {
		this.boardDay = boardDay;
	}
	@Override
	public String toString() {
		return "BoardVO [boardNo=" + boardNo + ", boardTit=" + boardTit + ", boardAut=" + boardAut + ", boardCont="
				+ boardCont + ", boardDay=" + boardDay + "]";
	}

	
}
