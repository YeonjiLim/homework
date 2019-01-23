package com.ssafy.edu.java;

public class CodeNotFoundException extends Exception {

	public CodeNotFoundException() {
		super("상품 번호가 존재하지 않습니다.");
	}

	public CodeNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CodeNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public CodeNotFoundException(String message) {
		super(message);
	}

	public CodeNotFoundException(Throwable cause) {
		super(cause);
	}

}
