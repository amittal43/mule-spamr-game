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

	private MapUI mapui = new MapUI();
	private TownScreenUI tsui = new TownScreenUI();
	private MainAppView parent;
	private CardLayout cardLayout = new CardLayout(0,0);
	private JPanel cards = new JPanel(cardLayout);
	
	public void setParent(MainAppView p){
		parent = p;
	}
	

	/**
	 * Creates the GameScreen Panel and adds the other panels as cards
	 */
	@SuppressWarnings("deprecation")
	public GameScreenUI() {
		setPreferredSize(new Dimension(1280, 800));
		setMinimumSize(new Dimension(1280, 800));
		setBackground(Color.DARK_GRAY);
		
		//adding each "card" to the panel
		//cards.add(mapui);
		cards.add(mapui, "Map");
		mapui.setParent(this);
		cards.add(tsui, "Town");
		cardLayout.show(cards, "Map");
		add(cards);
	}

	public void cardChangeTo(String cardName) {
        cardLayout.show(cards, cardName);
	}
	
	public CardLayout getCardLayout(){
		return cardLayout;
	}
	
	public JPanel getCardsPanel(){
		return cards;
	}
	
	public void changeToTownScreen(){
		cardLayout.show(cards, "Town");
	}
	
}
