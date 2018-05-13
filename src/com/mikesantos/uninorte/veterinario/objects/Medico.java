package com.mikesantos.uninorte.veterinario.objects;

public class Medico extends Pessoa{

	private int CRMV;
	
	public Medico(int id) {
		super(id);
	}
	
	public Medico(int id, String nome) {
		super(id, nome);
	}
	
	public Medico(int id, String nome, int idade) {
		super(id, nome, idade, -1);
	}
	
	public Medico(int id, String nome, int idade, int cpf) {
		super(id, nome, idade, cpf);
	}

	public int getCRMV() {
		return CRMV;
	}

	public void setCRMV(int cRMV) {
		CRMV = cRMV;
	}

	
	
}
