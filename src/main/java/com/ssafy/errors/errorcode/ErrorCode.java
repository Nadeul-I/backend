package com.ssafy.errors.errorcode;

public enum ErrorCode implements EnumModel{

	INVALID_INPUT_VALUE(400, "COMMON-001", "유효성 검증에 실패한 경우");

	private final int status;
	private final String code;
	private final String description;

	ErrorCode(int status, String code, String description) {
		this.status = status;
		this.code = code;
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
}
