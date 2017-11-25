package com.selenium.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;

public class Database {
	String username;
	String password;

	WebDriver driver;
	public Database(WebDriver driver2) {
		driver=driver2;
	}
	public String[] database() throws InterruptedException, ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");

		Statement smt=con.createStatement();
		ResultSet rs=smt.executeQuery("select Username,Password from hrm");
		while(rs.next())
		{
			 username=rs.getString("Username");
			password=rs.getString("Password");
			System.out.println(username+"*******"+password);
			
		}
		String ar[] = new String[2];
        ar[0]= username;
        ar[1] =  password;
		return ar;
	}
}
