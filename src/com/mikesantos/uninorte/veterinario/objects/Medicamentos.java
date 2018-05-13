package com.mikesantos.uninorte.veterinario.objects;

public abstract class Medicamentos {
	
	private int ID;
	private String NOME;
	private float VALOR;
	private long VALIDADE;
	private long FABRICACAO;
	private String COMPLEMENTO;
	
	private long CREATED;
	private long UPDATED;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNOME() {
		return NOME;
	}
	public void setNOME(String nOME) {
		NOME = nOME;
	}
	public float getVALOR() {
		return VALOR;
	}
	public void setVALOR(float vALOR) {
		VALOR = vALOR;
	}
	public long getVALIDADE() {
		return VALIDADE;
	}
	public void setVALIDADE(long vALIDADE) {
		VALIDADE = vALIDADE;
	}
	public long getFABRICACAO() {
		return FABRICACAO;
	}
	public void setFABRICACAO(long fABRICACAO) {
		FABRICACAO = fABRICACAO;
	}
	public String getCOMPLEMENTO() {
		return COMPLEMENTO;
	}
	public void setCOMPLEMENTO(String cOMPLEMENTO) {
		COMPLEMENTO = cOMPLEMENTO;
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
