package com.mikesantos.uninorte.veterinario.objects;

public abstract class Pessoa {

	private int ID;
	
	private String NOME;
	private String ENDERECO;
	private String COMPLEMENTO;
	
	private int IDADE;
	private int RG;
	private int CPF;

	private long CREATED;
	private long UPDATED;
	
	
	public Pessoa(int id) {
		this(id, null);
	}
	
	public Pessoa(int id, String nome) {
		this(id, nome, -1);
	}
	
	public Pessoa(int id, String nome, int idade) {
		this(id, nome, idade, -1);
	}
	
	public Pessoa(int id, String nome, int idade, int cpf) {
		this.ID = id;
		this.NOME = nome;
		this.IDADE = idade;
		this.CPF = cpf;
	}

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

	public String getENDERECO() {
		return ENDERECO;
	}

	public void setENDERECO(String eNDERECO) {
		ENDERECO = eNDERECO;
	}

	public String getCOMPLEMENTO() {
		return COMPLEMENTO;
	}

	public void setCOMPLEMENTO(String cOMPLEMENTO) {
		COMPLEMENTO = cOMPLEMENTO;
	}

	public int getIDADE() {
		return IDADE;
	}

	public void setIDADE(int iDADE) {
		IDADE = iDADE;
	}

	public int getRG() {
		return RG;
	}

	public void setRG(int rG) {
		RG = rG;
	}

	public int getCPF() {
		return CPF;
	}

	public void setCPF(int cPF) {
		CPF = cPF;
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
