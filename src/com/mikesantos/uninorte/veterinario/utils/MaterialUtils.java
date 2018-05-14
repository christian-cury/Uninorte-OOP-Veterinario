package com.mikesantos.uninorte.veterinario.utils;

import java.awt.Color;

import javax.swing.JComponent;

import mdlaf.MaterialUIMovement;

public class MaterialUtils {
	
	public static Color LIGHT_GRAY = new Color(0, 0, 0);

	public static void addHover(JComponent component, Color color) {
		MaterialUIMovement.add(component, color, 5, 1000 / 30);
	}
}
