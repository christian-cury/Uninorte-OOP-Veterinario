package com.mikesantos.uninorte.veterinario.screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;

import com.mikesantos.uninorte.veterinario.Veterinario;
import com.mikesantos.uninorte.veterinario.screens.registers.Funcionario;
import com.mikesantos.uninorte.veterinario.settings.FrameSettings;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Dashboard extends JFrame {
	private static final long serialVersionUID = -2755653260876036503L;
	private JPanel contentPane;
	private Veterinario instance;

	/**
	 * Create the frame.
	 */
	public Dashboard(Veterinario instance) {
		this.instance = instance;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 450, 300);
		
		FrameSettings.setupFrame(this);
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCriar = new JMenu("Registros");
		menuBar.add(mnCriar);
		
		JMenuItem mntmRegistrarFuncionrio = new JMenuItem("Registrar funcionário");
		mnCriar.add(mntmRegistrarFuncionrio);
		mntmRegistrarFuncionrio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showFuncionario();
				Dashboard.this.setVisible(false);
			}
		});
		
		
		setLocationRelativeTo(null);
	}
	
	
	
	private Funcionario funcionarioRegister = null;
	public void showFuncionario() {
		try {
			if(funcionarioRegister == null) funcionarioRegister = new Funcionario(this.instance);
			funcionarioRegister.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
