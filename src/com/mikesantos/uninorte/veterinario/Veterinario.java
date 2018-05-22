package com.mikesantos.uninorte.veterinario;

import java.awt.EventQueue;


import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.mikesantos.uninorte.veterinario.utils.RequestData;

import mdlaf.MaterialLookAndFeel;

public class Veterinario {
	
	private static Veterinario instance = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new MaterialLookAndFeel());
				} catch (UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
				
				String response = new RequestData("https://httpbin.org/ip").get();
				System.out.println(response);
				response = new RequestData("https://httpbin.org/post").addParam("eu", "vou").addParam("te", "fuder").post();
				System.out.println(response);
				//getInstance().init();
			}
		});
	}
	
	public static Veterinario getInstance() {
		if(instance == null) {
			instance = new Veterinario();
		}
		return instance;
	}
	
	public void init() {
		try {
			Login login = new Login();
			login.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Dashboard dashboard = null;
	public void showDashboard() {
		try {
			if(dashboard == null) dashboard = new Dashboard();
			dashboard.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
