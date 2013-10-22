package edu.gatech.spamr.view;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Dimension;

/** 
 * The GameScreenUI class creates a panel for the player to begin the game  
 * 
 * @author Sean Lachenberg
 * @author Aditya Mittal
 * @author Mike Vail
 * @author Puja Sheth
 * @author Raj Prateek
 * @version 1.0 10/15/2013 
 */

public class GameScreenUI extends JPanel {

	private MapUI mapui = new MapUI();
	
	/**
	 * Create the panel.
	 */
	public GameScreenUI() {
		setPreferredSize(new Dimension(800, 600));
		setMinimumSize(new Dimension(800, 600));
		setBackground(Color.DARK_GRAY);
		setLayout(new CardLayout(0, 0));
		this.add(mapui);
		
		JLabel lblReadyToPlay = new JLabel("Ready To Play!");
		lblReadyToPlay.setHorizontalAlignment(SwingConstants.CENTER);
		lblReadyToPlay.setForeground(Color.LIGHT_GRAY);
		lblReadyToPlay.setFont(new Font("Verdana", Font.BOLD, 24));
		add(lblReadyToPlay, "name_679395047145474");

	}

}
