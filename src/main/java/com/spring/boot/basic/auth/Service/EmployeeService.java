package com.spring.boot.basic.auth.Service;

import java.util.Arrays;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	public String getEmployeeName() {
		
		return "Deepak";
		
	}

	public String getEmployeeAccount() {
		
		return "Secret Account:007";
	}

	public boolean searchEmployee(String empName) {
		
		return Arrays.asList("Deepak","Dut","Shiju").contains(empName);
	}

}
