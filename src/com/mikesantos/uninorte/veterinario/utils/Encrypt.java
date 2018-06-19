package com.mikesantos.uninorte.veterinario.utils;

import org.mindrot.jbcrypt.BCrypt;

public class Encrypt {
	
	private static int price = 14;
	
	public static String hashPassword(String password_plaintext) {
		String salt = BCrypt.gensalt(price);
		String hashed_password = BCrypt.hashpw(password_plaintext, salt);
		return(hashed_password);
	}
	
	public static boolean checkPassword(String password_plaintext, String stored_hash) {
		boolean password_verified = false;
		if(null == stored_hash || !stored_hash.startsWith("$2a$"))
			throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");
		password_verified = BCrypt.checkpw(password_plaintext, stored_hash);

		return(password_verified);
	}

}
