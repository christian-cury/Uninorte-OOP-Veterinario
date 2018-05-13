package com.mikesantos.uninorte.veterinario.enums;

public enum PorteAnimal {

	PEQUENO(1), 
	MEDIO(2), 
	GRANDE(3);
	
	
	private int ID;
	private PorteAnimal(int id) {
		this.ID = id;
	}
	
	public int getID() {
		return this.ID;
	}
	
	public static PorteAnimal getTypeByID(int id) {
		for(PorteAnimal type : PorteAnimal.values()) {
			if(type.getID() == id) {
				return type;
			}
		}
		return null;
	}
	
}
