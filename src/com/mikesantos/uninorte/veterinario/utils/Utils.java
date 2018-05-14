package com.mikesantos.uninorte.veterinario.utils;

import javax.swing.JOptionPane;

public class Utils {

	public static void alert(String infoMessage, String titleBar){
		JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void warning(String message, String title) {
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE);
	}
	
	public static boolean confirm(String message, String title) {
		int dialogResult = JOptionPane.showConfirmDialog (null, message, title, JOptionPane.YES_NO_OPTION);
		if(dialogResult == JOptionPane.YES_OPTION){
			return true;
		}
		return false;
	}
	
	public static void msgBox(String message, String title, int messageType) {
		JOptionPane.showMessageDialog(null, message, title, messageType);
	}
	
}
