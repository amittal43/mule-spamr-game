package edu.gatech.spamr.view;

import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.event.ItemEvent;

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

public class GameScreenUI extends JPanel {	//panel that holds cards

	
	

	/**
	 * Creates the GameScreen Panel and adds the other panels as cards
	 */
	public GameScreenUI() {
		setPreferredSize(new Dimension(1280, 800));
		setMinimumSize(new Dimension(1280, 800));
		setBackground(Color.DARK_GRAY);
		setLayout(new CardLayout(0, 0));

		//creating each "card" to the panel
		MapUI mapui = new MapUI();
		TownScreenUI tsui = new TownScreenUI();
		
		//adding each "card" to the panel
		this.add(mapui);
		this.add(tsui);
		
		
		//adding Ready To Play! Label 
		JLabel lblReadyToPlay = new JLabel("Ready To Play!");
		lblReadyToPlay.setHorizontalAlignment(SwingConstants.CENTER);
		lblReadyToPlay.setForeground(Color.LIGHT_GRAY);
		lblReadyToPlay.setFont(new Font("Verdana", Font.BOLD, 24));
		add(lblReadyToPlay, "name_679395047145474");

	}

	public void cardChangeTo(String cardName) {
        CardLayout cl = (CardLayout)(this.getLayout());
        cl.show(this, cardName);
    }
	
	
}
