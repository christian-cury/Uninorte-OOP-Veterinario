package com.mikesantos.uninorte.veterinario.objects;

import com.mikesantos.uninorte.veterinario.enums.PorteAnimal;

public class Animal {

	private String NOME;
	private String RACA;
	private int IDADE;
	private float PESO;
	private String COMPLEMENTO;
	private PorteAnimal PORTE = PorteAnimal.PEQUENO;
	
	private long CREATED;
	private long UPDATED;
	
	public String getNOME() {
		return NOME;
	}
	public void setNOME(String nOME) {
		NOME = nOME;
	}
	public String getRACA() {
		return RACA;
	}
	public void setRACA(String rACA) {
		RACA = rACA;
	}
	public int getIDADE() {
		return IDADE;
	}
	public void setIDADE(int iDADE) {
		IDADE = iDADE;
	}
	public float getPESO() {
		return PESO;
	}
	public void setPESO(float pESO) {
		PESO = pESO;
	}
	public String getCOMPLEMENTO() {
		return COMPLEMENTO;
	}
	public void setCOMPLEMENTO(String cOMPLEMENTO) {
		COMPLEMENTO = cOMPLEMENTO;
	}
	public PorteAnimal getPORTE() {
		return PORTE;
	}
	public void setPORTE(PorteAnimal pORTE) {
		PORTE = pORTE;
	}
	public long getCREATED() {
		return CREATED;
	}
	public void setCREATED(long cREATED) {
		CREATED = cREATED;
	}
	public long getUPDATED() {
		return UPDATED;
	}
	public void setUPDATED(long uPDATED) {
		UPDATED = uPDATED;
	}
	
}
