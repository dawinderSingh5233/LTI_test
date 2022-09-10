package com.lti.demo.DemoMaven_Project02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.lti.dao.DatabaseConnection;
import com.lti.dao.EmployeeDao;
import com.lti.entity.Employee;

public class DaoTest {
	public static EmployeeDao dao;
	
	@BeforeAll
	public static void getDAO() {
		dao = new EmployeeDao();
	}
	
	@Test
	public void testConnection() {
		Connection conn = DatabaseConnection.getConnection();
		assertNotNull(conn,"Connection Test Passed successfully!");
	}
	
	@Test
	public void dataInsertionTest() {
		Employee emp = new Employee("emp","emp","emp@testapp.com");
		dao.addEmployee(emp);
		Employee emp2 = dao.getEmployee("emp");
		assertEquals(emp.getPassword(),emp2.getPassword(),"Data Insertion Test Failed :(");
	}
	
	@Test
	public void deleteTest() {
		Employee emp2 = new Employee("emp2","emp2","emp2@testapp.com");
		dao.addEmployee(emp2);
		
		dao.deleteEmployee("emp2");
		Employee temp = dao.getEmployee("emp2");
		
		assertEquals(temp,null,"Deletion Test Failed :(");
	}
	
	@Test
	public void updateTest() {
		Employee emp1 = new Employee("emp","emp","emp@testapp.com");
		dao.addEmployee(emp1);
		dao.updateEmployee("emp", new Employee("emp1","emp1","emp1@testapp.com"));
		Employee emp2 = dao.getEmployee("emp1");
		assertEquals(emp2.getUsername(),"emp1","Update Test Failed :(");
	}
}

