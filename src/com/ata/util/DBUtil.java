package com.ata.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	static Connection con;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ata_tbl","root","1234");
			
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		return con;
	}

}
