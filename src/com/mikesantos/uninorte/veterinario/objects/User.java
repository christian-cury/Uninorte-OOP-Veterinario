package com.mikesantos.uninorte.veterinario.objects;

public class User {

	private String USERNAME;
	private String PASSWORD;
	private String _TOKEN;
	private int ID;
	
	public User() {
		this(-1);
	}
	
	public User(int id) {
		this.ID = id;
	}
	
	public User setId(int id) {
		this.ID = id;
		return this;
	}
	
	public User setUsername(String username) {
		this.USERNAME = username;
		return this;
	}
	
	public User setPassword(String password) {
		this.PASSWORD = password;
		return this;
	}
	
	public User setToken(String token) {
		this._TOKEN = token;
		return this;
	}
	
	public String getUsername() {
		return this.USERNAME;
	}
	
	public String getPassword() {
		return this.PASSWORD;
	}
	
	public String getToken() {
		return this._TOKEN;
	}
	
	public int getId() {
		return this.ID;
	}
}
