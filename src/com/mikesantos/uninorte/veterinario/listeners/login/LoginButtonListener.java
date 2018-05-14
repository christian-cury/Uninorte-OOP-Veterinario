package com.mikesantos.uninorte.veterinario.listeners.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.mikesantos.uninorte.veterinario.Veterinario;
import com.mikesantos.uninorte.veterinario.utils.Utils;

public class LoginButtonListener implements ActionListener{
	
	private JTextField jUsername;
	private JTextField jPassword;
	private JFrame jFrame;
	
	public LoginButtonListener(JFrame frame, JTextField username, JTextField password) {
		this.jFrame = frame;
		this.jUsername = username;
		this.jPassword = password;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(jUsername.getText().trim().length() <= 0) {
			Utils.warning("Campo Usuário obrigatório", "Campos incompletos");
			jUsername.requestFocus();
		}else if(jPassword.getText().trim().length() <= 0) {
			Utils.warning("Campo Senha obrigatório", "Compos incompletos");
			jPassword.requestFocus();
		} else {
			jFrame.dispose();
			Veterinario.getInstance().showDashboard();
		}
	}
}
