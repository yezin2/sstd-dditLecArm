package com.servlet.exception;

public class SelecteNullpointerException extends Exception {
	public SelecteNullpointerException() {
		super("조회할 데이터가 없습니다.");
	}

}
