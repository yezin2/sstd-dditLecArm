package com.servlet.exception;

public class FailedDeleteException extends Exception {
	public FailedDeleteException() {
		super("삭제에 실패했습니다.");
	}
}
