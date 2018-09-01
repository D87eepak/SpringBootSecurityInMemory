package com.spring.boot.basic.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.basic.auth.Service.EmployeeService;
import com.spring.boot.basic.auth.error.EmployeeForbiddenException;
import com.spring.boot.basic.auth.error.EmployeeNotFoundException;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@GetMapping("/name")
	public String getEmployeeName(){
		
		
		return service.getEmployeeName();
	}
	@GetMapping("/account")
	@PreAuthorize("hasRole('ADMIN')")
	public String getEmployeeAccount() throws EmployeeForbiddenException{
		
		return service.getEmployeeAccount();
	}
	
	@GetMapping("/search/{empName}")
	@PreAuthorize("hasRole('USER')")
	public String searchEmployee(@PathVariable String empName) throws EmployeeForbiddenException,EmployeeNotFoundException{
		
		if(!service.searchEmployee(empName))
			throw new EmployeeNotFoundException("User Name Not Found");
		
		return "UserName exist";
	}
	
}
