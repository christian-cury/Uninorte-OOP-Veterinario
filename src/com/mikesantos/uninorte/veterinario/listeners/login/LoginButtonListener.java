package com.mikesantos.uninorte.veterinario.listeners.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.mikesantos.uninorte.veterinario.Veterinario;
import com.mikesantos.uninorte.veterinario.objects.swing.MTextField;
import com.mikesantos.uninorte.veterinario.utils.Utils;

public class LoginButtonListener implements ActionListener{
	
	private JTextField jUsername;
	private MTextField jPassword;
	private JFrame jFrame;
	
	public LoginButtonListener(JFrame frame, JTextField username, MTextField password) {
		this.jFrame = frame;
		this.jUsername = username;
		this.jPassword = password;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(jUsername.getText().trim().length() <= 0) {
			Utils.warning("Campo Usuário obrigatório", "Campos incompletos");
			jUsername.requestFocus();
		}else if(jPassword.getText().length() <= 0) {
			Utils.warning("Campo Senha obrigatório", "Compos incompletos");
			jPassword.requestFocus();
		} else {
			System.out.println(jPassword.getPassword());
			System.out.println(jPassword.getPassword().toString());
			String password = String.copyValueOf(jPassword.getPassword());
			System.out.println(password);
			jFrame.dispose();
			Veterinario.getInstance().showDashboard();
		}
	}
}
