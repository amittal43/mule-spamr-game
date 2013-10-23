package edu.gatech.spamr.view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

public class LandOfficeUI extends JPanel {
	
	private MapUI mapui = new MapUI();

	/**
	 * Create the panel.
	 */
	public LandOfficeUI() {
		setPreferredSize(new Dimension(1280, 800));
		setMinimumSize(new Dimension(1280, 800));
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		JPanel panel = mapui;
		mapui.setSize(new Dimension(800, 600));
		panel.setBounds(45, 57, 820, 600);
		add(panel);

	}
}
