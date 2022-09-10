package com.lti.dao;

import java.sql.*;

import com.lti.entity.Employee;

public class EmployeeDao {
	private Connection conn;

	public EmployeeDao() {
		this.conn = DatabaseConnection.getConnection();
	}

	public void addEmployee(Employee emp) {
		try {
			String query = "INSERT INTO Employee values(?,?,?)";

			PreparedStatement pStmt = this.conn.prepareStatement(query);
			pStmt.setString(1, emp.getUsername());
			pStmt.setString(2, emp.getPassword());
			pStmt.setString(3, emp.getEmail());
			pStmt.executeUpdate();
			pStmt.close();

			System.out.println("Employee Data Inserted successfully!");
		} catch (Exception e) {
			System.out.println("Exception: insert() Exception");
		}
	}

	public Employee getEmployee(String username) {
		Employee emp = null;

		try {
			String query = String.format("SELECT * FROM Employee WHERE username='%s'", username);
			Statement stmt = this.conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next()) {
				String temp1 = rs.getString(1);
				String temp2 = rs.getString(2);
				String temp3 = rs.getString(3);
				emp = new Employee(temp1,temp2,temp3);
			}
		} catch (Exception e) {
			System.out.println("Exception: get() Exception");
		}

		return emp;
	}
	
	public void deleteEmployee(String username) {
		try {
			String query = "DELETE FROM Employee WHERE username = ?";
			PreparedStatement pStmt = this.conn.prepareStatement(query);
			pStmt.setString(1, username);
			pStmt.executeUpdate();
			
			System.out.println("Employee Delete Successfully!");
		}catch(Exception e) {
			System.out.println("Exception: delete() exception");
		}
	}
	
	public void updateEmployee(String old, Employee e) {
		try {
			if(this.getEmployee(old) == null) {
				System.out.println("Invalid Employee Data!");
				return;
			}
			String query = "UPDATE Employee SET username=?,password=?,email=? WHERE username=?";
			PreparedStatement pStmt = this.conn.prepareStatement(query);
			pStmt.setString(1, e.getUsername());
			pStmt.setString(2, e.getPassword());
			pStmt.setString(3, e.getEmail());
			pStmt.setString(4,old);
			
			pStmt.executeUpdate();
			System.out.println("Employee data updated successfully!");
		}catch(Exception ex) {
			System.out.println("Exception: update() exception");
		}
	}
}
