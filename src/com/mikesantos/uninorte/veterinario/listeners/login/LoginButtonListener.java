package com.mikesantos.uninorte.veterinario.listeners.login;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mikesantos.uninorte.veterinario.Veterinario;
import com.mikesantos.uninorte.veterinario.enums.BooleanResponse;
import com.mikesantos.uninorte.veterinario.utils.Utils;

public class LoginButtonListener implements ActionListener{
	
	private JTextField jUsername;
	private JPasswordField jPassword;
	private JFrame jFrame;
	
	private Veterinario instance;
	
	public LoginButtonListener(Veterinario instance, JFrame frame, JTextField username, JPasswordField password) {
		this.instance = instance;
		this.jFrame = frame;
		this.jUsername = username;
		this.jPassword = password;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(jUsername.getText().trim().length() <= 0) {
			Utils.warning("Campo Usuário obrigatório", "Campos incompletos");
			jUsername.requestFocus();
		}else if(jPassword.getPassword().length <= 0) {
			Utils.warning("Campo Senha obrigatório", "Compos incompletos");
			jPassword.requestFocus();
		} else {
			String username = jUsername.getText().trim();
			String password = String.copyValueOf(jPassword.getPassword()).trim();
			
			BooleanResponse response = this.instance
					.getDatabaseManager()
					.authenticate(username, password);
			if(response == BooleanResponse.NULL) {
				Utils.warning("Funcionário não encontrado em nosso banco de dados", "Acesso negado");
				return;
			}
			if(response != BooleanResponse.TRUE) {
				Utils.warning("Senha inválida!", "Acesso negado");
				return;
			}
			jFrame.dispose();
			Veterinario.getInstance().showDashboard();
		}
	}
}
