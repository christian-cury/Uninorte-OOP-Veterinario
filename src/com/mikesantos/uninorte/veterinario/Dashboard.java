package com.mikesantos.uninorte.veterinario;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;

import com.mikesantos.uninorte.veterinario.settings.FrameSettings;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Dashboard extends JFrame {
	private static final long serialVersionUID = -2755653260876036503L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 450, 300);
		
		FrameSettings.setupFrame(this);
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("Teste");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("Item 1");
		menu.add(menuItem);
		
		
		setLocationRelativeTo(null);
	}
}
