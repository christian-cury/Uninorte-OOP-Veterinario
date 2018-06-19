package com.mikesantos.uninorte.veterinario.managers;

import com.mikesantos.uninorte.veterinario.Veterinario;
import com.mikesantos.uninorte.veterinario.objects.User;
import com.mikesantos.uninorte.veterinario.utils.RequestData;

public class AuthenticationManager {

	private Veterinario instance;
	public AuthenticationManager(Veterinario instance) {
		this.instance = instance;
	}
	
	public boolean authenticate(User user) {
		try {
			RequestData request = new RequestData(this.instance.getApiManager().API_URL_AUTHENTICATE);
			request.setAuthentication(user.getUsername(), user.getPassword());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
