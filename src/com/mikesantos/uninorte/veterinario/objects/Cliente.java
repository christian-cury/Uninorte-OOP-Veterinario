package com.mikesantos.uninorte.veterinario.objects;

public class Cliente extends Pessoa{
	
	private String NOME_ANIMAL;
	private String RACA;
	private int ID_ANIMAL;
	private String TIPO_ANIMAL;

	public Cliente(int id) {
		super(id);
	}
	
	public Cliente(int id, String nome) {
		super(id, nome);
	}
	
	public Cliente(int id, String nome, int idade) {
		super(id, nome, idade, -1);
	}
	
	public Cliente(int id, String nome, int idade, int cpf) {
		super(id, nome, idade, cpf);
	}

	public String getNOME_ANIMAL() {
		return NOME_ANIMAL;
	}

	public void setNOME_ANIMAL(String nOME_ANIMAL) {
		NOME_ANIMAL = nOME_ANIMAL;
	}

	public String getRACA() {
		return RACA;
	}

	public void setRACA(String rACA) {
		RACA = rACA;
	}

	public int getID_ANIMAL() {
		return ID_ANIMAL;
	}

	public void setID_ANIMAL(int iD_ANIMAL) {
		ID_ANIMAL = iD_ANIMAL;
	}

	public String getTIPO_ANIMAL() {
		return TIPO_ANIMAL;
	}

	public void setTIPO_ANIMAL(String tIPO_ANIMAL) {
		TIPO_ANIMAL = tIPO_ANIMAL;
	}

	
}
