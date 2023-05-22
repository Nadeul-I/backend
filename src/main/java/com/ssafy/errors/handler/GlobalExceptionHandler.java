package com.ssafy.errors.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ssafy.errors.errorcode.ErrorCode;
import com.ssafy.errors.response.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	public static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<?> handleAllException(final Exception ex) {
		logger.warn("handleAllException", ex);
		final ErrorCode errorCode = ErrorCode.INVALID_INPUT_VALUE;
		return handleExceptionInternal(errorCode);
	}

	private ResponseEntity<?> handleExceptionInternal(final ErrorCode errorCode) {
		ErrorResponse response = ErrorResponse.of(errorCode);
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.valueOf(errorCode.getStatus()));
	}
}
