package me.devcode.SurvivalGames;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class MySQL {
	
	
	String HOST = "";
	String USER = "";
	String DATABASE = "";
	String PASSWORD = "";
	private Connection con;
	
	public MySQL(String host, String user, String database, String password) {
		this.HOST = host;
		this.USER = user; 
		this.DATABASE = database;
		this.PASSWORD = password;
		connect();
	}

	public void connect() {
	try{
		con = DriverManager.getConnection("jdbc:mysql://" + HOST + ":3306/" + USER, DATABASE, PASSWORD);
	isConnected();
	System.out.println("[MySQL] Die Verbindung zur MySQL wurde hergestellt.");
	}catch(SQLException e) {
		System.out.println("[MySQL] Fehler bei der Verbindung zur MySQL!" + e.getMessage());
	}
		
	}
	
	public void close() {
		try{
			isConnected();
			if(con != null) {
				con.close();
				System.out.println("[MySQL] Die MySQL Verbindung wurde erfolgereich geclosed!");
			}
		}catch(SQLException e) {
			System.out.println("[MySQL] Fehler bei der Beendung von MySQL!");
		}
	}
	
	public void update(String qry) {
		try{
			Statement st = con.createStatement();
			st.executeUpdate(qry);
			st.close();
		}catch(SQLException e) {
			System.err.println();
		}
	}
	
	public ResultSet query(String qry) {
		ResultSet rs = null;
		try{
			Statement st = con.createStatement();
			rs = st.executeQuery(qry);
			
		}catch (SQLException e) {
			System.err.println();
		}
		return rs;
		
	}

	public boolean isConnected() {
		try{
			return this.con != null || con.isValid(1);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}

}
