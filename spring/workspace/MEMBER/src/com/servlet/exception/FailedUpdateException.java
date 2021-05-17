package com.servlet.exception;

public class FailedUpdateException extends Exception {
	public FailedUpdateException() {
		super("수정에 실패 했습니다.");
	}
}
