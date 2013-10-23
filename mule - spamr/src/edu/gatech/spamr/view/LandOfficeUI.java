package edu.gatech.spamr.view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

/** 
 * The LandOfficeUI class creates a panel for the player to go to the land office  
 * 
 * @author Sean Lachenberg
 * @author Aditya Mittal
 * @author Mike Vail
 * @author Puja Sheth
 * @author Raj Prateek
 * @version 1.0 10/21/2013 
 */

public class LandOfficeUI extends JPanel {
	
	//creates an instance variable of MapUI
	private MapUI mapui = new MapUI();

	/**
	 * LandOfficeUI creates the office is the correct dimensions
	 * 
	 * @return an instance of MapUI
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
