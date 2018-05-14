package com.mikesantos.uninorte.veterinario.settings;

import java.awt.Dimension;

import javax.swing.JFrame;

public class FrameSettings {

	public static Dimension DIMENSION = new Dimension(600, 600);
	
	public static void setupFrame(JFrame frame) {
		frame.setMinimumSize(DIMENSION);
		frame.setMaximumSize(DIMENSION);
		frame.pack();
	}
	
	public static void setupFrame(JFrame frame, int width, int height) {
		Dimension dimension = new Dimension(width, height);
		frame.setMaximumSize(dimension);
		frame.setMinimumSize(dimension);
		frame.pack();
	}
}
