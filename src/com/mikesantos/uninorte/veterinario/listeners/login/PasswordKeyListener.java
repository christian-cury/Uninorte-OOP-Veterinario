package com.mikesantos.uninorte.veterinario.listeners.login;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PasswordKeyListener implements KeyListener{

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.KEY_PRESSED) {
			System.out.println("Key: " + e.getKeyChar());
		}
		System.out.println("Key 3: " + e.getKeyChar() + " - " + e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
