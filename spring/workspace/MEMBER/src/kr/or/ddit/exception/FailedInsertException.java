package kr.or.ddit.exception;

public class FailedInsertException extends Exception {
	public FailedInsertException() {
		super("등록에 실패 했습니다.");
	}
}
