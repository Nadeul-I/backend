package com.ssafy.errors.response;

import com.ssafy.errors.errorcode.ErrorCode;

public class ErrorResponse {
	private String code;
	private String message;

	public ErrorResponse(ErrorCode ec) {
		super();
		this.code = ec.getCode();
		this.message = ec.getDescription();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static ErrorResponse of(ErrorCode code) {
		return new ErrorResponse(code);
	}
}
