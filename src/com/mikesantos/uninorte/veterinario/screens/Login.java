package com.mikesantos.uninorte.veterinario.screens;

import javax.swing.JFrame;


import javax.swing.JPanel;
import javax.swing.JPasswordField;

import com.mikesantos.uninorte.veterinario.Veterinario;
import com.mikesantos.uninorte.veterinario.listeners.login.LoginButtonListener;
import com.mikesantos.uninorte.veterinario.settings.FrameSettings;
import com.mikesantos.uninorte.veterinario.utils.MaterialUtils;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;
	private Veterinario instance;

	/**
	 * Create the frame.
	 */
	public Login(Veterinario instance) {
		this.instance = instance;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		FrameSettings.setupFrame(this, 450, 190);
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 438, 26);
		contentPane.add(panel);
		
		JLabel titleLabel = new JLabel("Acesso Veterinária Uninorte");
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		panel.add(titleLabel);
		
		JPanel usernamePanel = new JPanel();
		usernamePanel.setBounds(6, 36, 438, 36);
		contentPane.add(usernamePanel);
		
		JLabel usernameLabel = new JLabel("Usuário:");
		usernamePanel.add(usernameLabel);
		
		username = new JTextField();
		usernamePanel.add(username);
		username.setColumns(30);
		
		JPanel passwordPanel = new JPanel();
		passwordPanel.setBounds(6, 78, 438, 36);
		contentPane.add(passwordPanel);
		
		JLabel passwordLabel = new JLabel("Senha:   ");
		passwordPanel.add(passwordLabel);
		
		password = new JPasswordField();
//		password.enableMasking();
//		password.setHighlighter(null);
		passwordPanel.add(password);
		password.setColumns(30);
		
		
		JPanel accessPanel = new JPanel();
		accessPanel.setBounds(6, 119, 438, 36);
		contentPane.add(accessPanel);
		
		JButton btnAccess = new JButton("Acessar");
		btnAccess.addActionListener(new LoginButtonListener(this.instance, this, username, password));
		MaterialUtils.addHover(btnAccess, MaterialUtils.LIGHT_GRAY);
		accessPanel.add(btnAccess);
		
		
		
		setLocationRelativeTo(null);
	}
}
