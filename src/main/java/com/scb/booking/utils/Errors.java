package com.scb.booking.utils;

public enum Errors implements ErrorCode {

	INTERNAL_ERROR("INTERNAL ERROR");

	private final String message;

	Errors(String message) {
		this.message = message;
	}

	@Override
	public String getErrorCode() {
		return name();
	}

	@Override
	public String getMessage() {
		return message;
	}
}