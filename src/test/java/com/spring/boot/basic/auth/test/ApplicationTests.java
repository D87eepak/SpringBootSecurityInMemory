package com.spring.boot.basic.auth.test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.boot.basic.auth.Service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	EmployeeService employeeService;
	
	@Test
	public void getEmployeeName(){
		//when(employeeService.getEmployeeName()).thenReturn("ABC");
		assertEquals("ABC", employeeService.getEmployeeName());
	}
	
}
