package kr.or.ddit.board.vo;

/*
 * db 테이블에 있는 컬럼을 기준으로 데이터를 객체화한 클래스임
 * @author pc17
 * <p> DB테이블의 '컬럼'이 이 클래스의 '멤버변수'가 된다<br>
 * DB테이블의 컬럼과 클래스의 멤버변수를 매핑하는 역할이 된다.
 */
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
