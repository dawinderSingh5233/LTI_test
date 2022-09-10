package com.lti.demo.DemoMaven_Project02;

import java.util.Scanner;

import com.lti.dao.EmployeeDao;
import com.lti.entity.Employee;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EmployeeDao dao = new EmployeeDao();

		while (true) {
			System.out.println();
			System.out.println("======== MENU ========");
			System.out.println("1. CREATE");
			System.out.println("2. READ");
			System.out.println("3. UPDATE");
			System.out.println("4. DELETE");
			System.out.println("5. EXIT");
			System.out.println("Enter your option: ");
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
		        System.out.print("Enter username: ");
		        String username = sc.nextLine();
		        System.out.print("Enter password: ");
		        String password = sc.nextLine();
		        System.out.print("Enter email: ");
		        String email = sc.nextLine();
		        
		        dao.addEmployee(new Employee(username,password,email));
				break;
			case 2:
				System.out.print("Enter username: ");
			    username = sc.nextLine();
			    Employee temp = dao.getEmployee(username);
			    
			    if(temp != null) {
			    	System.out.println(temp);
			    }else {
			    	System.out.println("Invalid Username");
			    }
				break;
			case 3:
				System.out.println("Enter username: ");
				String old = sc.nextLine();
				
				System.out.println("Enter Update data");
				System.out.println("Enter new username:");
				username = sc.nextLine();
				System.out.println("Enter new password:");
				password = sc.nextLine();
				System.out.println("Enter new email:");
				email = sc.nextLine();
				
				Employee e = new Employee(username,password,email);
				dao.updateEmployee(old, e);
				
				break;
			case 4:
				System.out.print("Enter username: ");
			    username = sc.nextLine();
			    dao.deleteEmployee(username);
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
			System.out.println("======================");
		}
	}
}
