package com.mikesantos.uninorte.veterinario.managers.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQL extends DatabaseConnection{

	private String driver = "com.mysql.jdbc.Driver";
	
	private String host;
	private String database;
	private String username;
	private String password;
	private int port;
	
	private Connection connection = null;
	public MySQL(String host, int port, String database, String username, String password) {
		this.host = host;
		this.port = port;
		this.database = database;
		this.username = username;
		this.password = password;
		
		connect();
	}
	
	public void connect() {
		try {
			Class.forName(driver);
			String url = String.format("jdbc:mysql://%s:%d/%s", host, port, database);
			System.out.println(url);
			connection = DriverManager.getConnection(url, this.username, this.password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return this.connection;
	}
	
	public void close() {
		try {
			if(isConnected())
				getConnection().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean isConnected() {
		if(this.connection == null) {
			return false;
		}
		return true;
	}
}
