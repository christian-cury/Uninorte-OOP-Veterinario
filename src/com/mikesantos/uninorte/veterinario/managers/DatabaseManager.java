package com.mikesantos.uninorte.veterinario.managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

import com.mikesantos.uninorte.veterinario.Veterinario;
import com.mikesantos.uninorte.veterinario.enums.BooleanResponse;
import com.mikesantos.uninorte.veterinario.objects.Pessoa;
import com.mikesantos.uninorte.veterinario.utils.Encrypt;

public class DatabaseManager {

	private Veterinario instance;
	public DatabaseManager(Veterinario instance) {
		this.instance = instance;
	}
	
	private Connection getConnection() {
		return this.instance.getConnection().getConnection();
	}
	
	private PreparedStatement preparedStatement(String sql) {
		try {
			return getConnection().prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public BooleanResponse authenticate(String username, String password) {
		try {
			PreparedStatement query = preparedStatement("SELECT hash FROM funcionarios WHERE username=? LIMIT 1;");
			query.setString(1, username);
			ResultSet rs = query.executeQuery();
			if(rs.next()) {
				String hash = rs.getString("hash");
				if(Encrypt.checkPassword(password, hash)) {
					return BooleanResponse.TRUE;
				} else {
					return BooleanResponse.FALSE;
				}
			}
			return BooleanResponse.NULL;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return BooleanResponse.NULL;
	}
	
	
	
	public Pessoa fetchUser(int id) {
		return null;
	}
	
	public Set<String> getAnimalsList(){
		Set<String> list = new HashSet<>();
		//TODO: Connect MySQL Server
		//TODO: SELECT * FROM animalsList;
		return list;
	}
}
