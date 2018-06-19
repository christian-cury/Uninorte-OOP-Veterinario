package com.mikesantos.uninorte.veterinario.screens.registers;

import javax.swing.JFrame;
import javax.swing.JPanel;
import com.mikesantos.uninorte.veterinario.Veterinario;
import com.mikesantos.uninorte.veterinario.settings.FrameSettings;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Funcionario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Veterinario instance;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public Funcionario(Veterinario instance) {
		this.instance = instance;
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Funcionario.this.instance.showDashboard();
			}
		});
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		FrameSettings.setupFrame(this, 450, 190);
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 438, 26);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Registrar novo funcionário");
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(6, 44, 438, 36);
		contentPane.add(panel_1);
		
		JLabel lblNomeFuncionrio = new JLabel("Nome funcionário:");
		panel_1.add(lblNomeFuncionrio);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
		setLocationRelativeTo(null);
	}
}
