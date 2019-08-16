package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3307/hb_student_tracker?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";
				
		try {
			Connection myCon =
					DriverManager.getConnection(url,user,pass);
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}

	}

}
