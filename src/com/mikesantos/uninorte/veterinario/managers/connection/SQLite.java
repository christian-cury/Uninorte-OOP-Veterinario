package com.mikesantos.uninorte.veterinario.managers.connection;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

public class SQLite extends DatabaseConnection{
	
	private File file;
	
	private Connection connection = null;
	public SQLite(File file) {
		this.file = file;
		connect();
	}
	
	public void connect() {
		try {
			Class.forName("org.sqlite.JDBC");
    		this.connection = DriverManager.getConnection("jdbc:sqlite:" + file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Connection getConnection() {
		return this.connection;
	}

	@Override
	public void close() {
		try {
			if(isConnected()) this.connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean isConnected() {
		if(this.connection == null) return false;
		return true;
	}

}
