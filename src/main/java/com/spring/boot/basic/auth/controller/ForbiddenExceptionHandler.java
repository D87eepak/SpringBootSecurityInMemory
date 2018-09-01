package com.spring.boot.basic.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.boot.basic.auth.error.EmployeeForbiddenException;

@Controller
public class ForbiddenExceptionHandler {

	
	@GetMapping("/403")
	public void exceptionHandler()throws EmployeeForbiddenException{
	
		throw new EmployeeForbiddenException("Not Authorize for this request");
	}
}
