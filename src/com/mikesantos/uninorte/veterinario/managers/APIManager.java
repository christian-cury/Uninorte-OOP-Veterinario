package com.mikesantos.uninorte.veterinario.managers;

import java.util.HashSet;
import java.util.Set;

import com.mikesantos.uninorte.veterinario.Veterinario;
import com.mikesantos.uninorte.veterinario.objects.Consulta;
import com.mikesantos.uninorte.veterinario.utils.RequestData;

public class APIManager {

	private Veterinario instance;
	public final String API_URL = "http://localhost:8000/api/v1"; 						//URL BASE 
	public final String API_URL_CONSULTAS = API_URL + "/consultas/%s";					//URL FETCH
	public final String API_URL_CONSULTAS_CREATE = API_URL + "/consultas/create";		//URL CREATE
	
	public final String API_URL_AUTHENTICATE = API_URL + "/auth";						//URL AUTH
	public APIManager(Veterinario instance) {
		this.instance = instance;
	}
	
	public Veterinario getInstance() {
		return instance;
	}
	
	
	public Set<Consulta> getConsultas(){
		return getConsultas(10);
	}
	
	public Set<Consulta> getConsultas(int size){
		HashSet<Consulta> consultas = new HashSet<>();
		try {
			RequestData request = new RequestData(API_URL_CONSULTAS);
			request.addParam("token", "");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return consultas;
	}
}
