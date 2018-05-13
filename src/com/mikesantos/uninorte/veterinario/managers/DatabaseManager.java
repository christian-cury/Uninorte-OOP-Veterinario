package com.mikesantos.uninorte.veterinario.managers;

import java.util.HashSet;
import java.util.Set;

import com.mikesantos.uninorte.veterinario.objects.Pessoa;

public class DatabaseManager {

	
	
	
	
	
	
	
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
