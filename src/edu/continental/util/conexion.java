package edu.continental.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexion {

	private static String connectionURL = "jdbc:mysql://127.0.0.1/sesion02";
	private static String user = "root";
	private static String pass = "lenovo123";
	private static String driver = "com.mysql.jdbc.Driver";
	private Connection con;
	
	
	//crear 
    public  conexion(){
    	
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(connectionURL, user, pass);
		}catch(Exception e){
			System.out.println("ERROR Conexion: " + e.getMessage());
			e.getStackTrace();	
		}			
    }    
        
    public Connection getConnection(){
    	
    	return con;
    }
	
}
