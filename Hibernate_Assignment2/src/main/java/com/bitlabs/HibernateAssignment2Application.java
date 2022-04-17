package com.bitlabs;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bitlabs.dao.Dao;
import com.bitlabs.dao.DaoImpl;
import com.bitlabs.entity.Users;

@SpringBootApplication
public class HibernateAssignment2Application {

	public static void main(String[] args) {
		SpringApplication.run(HibernateAssignment2Application.class, args);

		Users user =new Users();
		
		Dao dao=new DaoImpl();
		Scanner s=new Scanner(System.in);
		System.out.println("1. Add User");
		System.out.println("2. Login");
		
		System.out.println("Choose your option");
		int option=s.nextInt();
		if(option==1) {
			System.out.println("Enter uname, password, email and mobile number");
			user.setUname(s.next());
			user.setPassword(s.next());
			user.setEmail(s.next());
			user.setMobile(s.nextLong());
			
			boolean b=dao.addUser(user);
			if(b) {
				System.out.println("User details added sucessfully");
			}
			else {
				System.out.println("failed in adding user details");
			}

		}
		else if(option==2) {
			
			System.out.println("Enter uname and password");
			String uname=s.next();
			String pwd=s.next();
			
			boolean b=dao.login(uname, pwd);
			if(b) {
				System.out.println("Valid user");
			}
			else {
				System.out.println("Invalid user");
			}
		}
		else {
			System.out.println("Invalid option");
		}
	}

}
