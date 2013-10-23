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

	//GameScreenUI Variables
	private MapUI mapui = new MapUI();
	private LandSelectionUI lsui = new LandSelectionUI();
	private TownScreenUI tsui = new TownScreenUI();
	private MainAppView parent;
	private static CardLayout cardLayout = new CardLayout(0,0);
	private JPanel cards = new JPanel(cardLayout);
	
	/**
	 * Creates the GameScreen Panel and adds the other panels as cards
	 */
	@SuppressWarnings("deprecation")
	public GameScreenUI() {
		
		//setting preferences
		setPreferredSize(new Dimension(1280, 800));
		setMinimumSize(new Dimension(1280, 800));
		setBackground(Color.DARK_GRAY);
		
		//adding each "card" to the panel
		cards.add(mapui, "Map");
		mapui.setParent(this);
		cards.add(lsui, "LandSelection");
		cards.add(tsui, "Town");
		cardLayout.show(cards, "LandSelection");
		add(cards);
	}

	//getters and setters
	public void cardChangeTo(String cardName) {
        cardLayout.show(cards, cardName);
	}
	
	public static CardLayout getCardLayout(){
		return cardLayout;
	}
	
	public JPanel getCardsPanel(){
		return cards;
	}
	
	public void setParent(MainAppView p){
		parent = p;
	}
	

	
}
