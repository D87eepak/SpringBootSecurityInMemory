package com.spring.boot.basic.auth.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class EmployeeForbiddenException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmployeeForbiddenException(String exception) {
		super(exception);
	}
}
