package com.scb.booking.utils;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private final transient ErrorCode error;
	private final String errorCode;
	private final String errorMessage;
	private final transient Object data;

	public CustomException(ErrorCode error) {
		super(error.getMessage());
		this.error = error;
		this.errorCode = error.getErrorCode();
		this.errorMessage = error.getMessage();
		this.data = null;
	}

	public CustomException(ErrorCode error, Throwable cause) {
		super(error.getMessage(), cause);
		this.error = error;
		this.errorCode = error.getErrorCode();
		this.errorMessage = error.getMessage();
		this.data = null;
	}

	public CustomException(ErrorCode error, Throwable cause, Object data) {
		super(error.getMessage(), cause);
		this.error = error;
		this.errorCode = error.getErrorCode();
		this.errorMessage = error.getMessage();
		this.data = data;
	}

	public CustomException with(Object data) {
		return new CustomException(this.error, this.getCause(), data);
	}

	public CustomException(ErrorCode error, String message, String code, Object data) {
		super(error.getMessage());
		this.error = error;
		this.errorCode = code;
		this.errorMessage = message;
		this.data = data;
	}

}
