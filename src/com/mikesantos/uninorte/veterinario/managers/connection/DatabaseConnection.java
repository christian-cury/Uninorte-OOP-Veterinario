package com.mikesantos.uninorte.veterinario.managers.connection;

import java.sql.Connection;

public abstract class DatabaseConnection {

	public abstract Connection getConnection();
	public abstract void close();
	public abstract boolean isConnected();
}
