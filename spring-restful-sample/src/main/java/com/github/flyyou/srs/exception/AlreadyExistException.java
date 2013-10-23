package com.github.flyyou.srs.exception;

public class AlreadyExistException extends IllegalStateException {

	private static final long serialVersionUID = 1L;

	public AlreadyExistException() {
	}

	public AlreadyExistException(String message) {
		super(message);
	}

}
