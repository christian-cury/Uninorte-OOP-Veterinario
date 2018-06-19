package com.mikesantos.uninorte.veterinario;

import java.awt.EventQueue;

import java.io.File;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.mikesantos.uninorte.veterinario.managers.APIManager;
import com.mikesantos.uninorte.veterinario.managers.DatabaseManager;
import com.mikesantos.uninorte.veterinario.managers.connection.DatabaseConnection;
import com.mikesantos.uninorte.veterinario.managers.connection.MySQL;
import com.mikesantos.uninorte.veterinario.managers.connection.SQLite;
import com.mikesantos.uninorte.veterinario.screens.Dashboard;
import com.mikesantos.uninorte.veterinario.screens.Login;
import com.mikesantos.uninorte.veterinario.screens.registers.Funcionario;

import mdlaf.MaterialLookAndFeel;

public class Veterinario {
	
	private final String database_host = "localhost";
	private final int database_port = 3306;
	private final String database_dbname= "veterinario";
	private final String database_username = "root";
	private final String database_password = "root";
	
	private static Veterinario instance = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new MaterialLookAndFeel());
				} catch (UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
				getInstance().init();
				getInstance().getDatabaseManager();
			}
		});
	}
	
	public static Veterinario getInstance() {
		if(instance == null) {
			instance = new Veterinario();
		}
		return instance;
	}
	
	public void init() {
		try {
			Login login = new Login(this);
			login.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Dashboard dashboard = null;
	public void showDashboard() {
		try {
			if(dashboard == null) dashboard = new Dashboard(this);
			dashboard.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private DatabaseManager dbManager = null;
	private DatabaseConnection dbConnection = null;
	public DatabaseManager getDatabaseManager() {
		if(dbManager == null) {
			try {
				System.out.println("Trying connect to MySQL");
				dbConnection = new MySQL(this.database_host, this.database_port, this.database_dbname, this.database_username, this.database_password);
				if(dbConnection.isConnected()) System.out.println("MySQL connected with success!");
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(!dbConnection.isConnected()) {
				System.out.println("MySQL Connection failed. Trying connect to a SQLite");
				File storage = new File(new File("").getAbsoluteFile(), "storage.db");
				try {
					if(!storage.exists()) storage.createNewFile();
				} catch (Exception e) {
					e.printStackTrace();
				}
				dbConnection = new SQLite(storage);
				System.out.println("SQLite connected with success");
			}
			dbManager = new DatabaseManager(this);
		}
		return dbManager;
	}
	
	public DatabaseConnection getConnection() {
		if(dbConnection == null) getDatabaseManager();
		return dbConnection;
	}
	
	
	private APIManager apiManager = null;
	public APIManager getApiManager() {
		if(apiManager == null) {
			apiManager = new APIManager(this);
		}
		return apiManager;
	}
	
}
