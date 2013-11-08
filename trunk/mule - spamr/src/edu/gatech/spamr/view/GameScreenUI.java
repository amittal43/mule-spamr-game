package edu.gatech.spamr.view;

import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;

import edu.gatech.spamr.model.Game;

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
	private TurnScreenUI turnui = new TurnScreenUI(this);
	private PubUI pubui = new PubUI();
	private LandSelectionUI lsui = new LandSelectionUI();
	private boolean landSelectionOver = false;
	private TownScreenUI tsui = new TownScreenUI();
	private MainAppView parent;
	private static CardLayout cardLayout = new CardLayout(0,0);
	private JPanel cards = new JPanel(cardLayout);
	private StoreUI storeui = new StoreUI();
	private MuleMenuUI muleui = new MuleMenuUI();
	
	/**
	 * Creates the GameScreen Panel and adds the other panels as cards
	 * 
	 * @return a screen that has all the different locations a player can go to
	 */
	public GameScreenUI() {
		
		//setting preferences
		setPreferredSize(new Dimension(1280, 800));
		setMinimumSize(new Dimension(1280, 800));
		setBackground(Color.DARK_GRAY);
		
		//adding each "card" to the panel
		cards.add(turnui, "TurnScreen");
		turnui.setParent(this);
		cards.add(lsui, "LandSelection");
		lsui.setParent(this);
		cards.add(tsui, "Town");
		tsui.setParent(this);
		cards.add(pubui, "Pub");
		pubui.setParent(this);
		cards.add(storeui, "Store");
		storeui.setParent(this);
		cards.add(muleui, "Mule");
		muleui.setParent(this);
		cardLayout.show(cards, "LandSelection");
		
		
		add(cards);
		Game.setParent(this);
	}

	//getters and setters
	public void cardChangeTo(String cardName) {
        cardLayout.show(cards, cardName);
        //if(cardName.equals("Map")){
        	//System.out.println("updating Colors");
        	//Game.getMapUI().updateBorders(Game.getMapUI().getTiles(), Game.getMapUI().getButtons());
        //} 
        
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
	
	public void setLandSelectionOver(){
		landSelectionOver = true;
	}
	
	public boolean getLandSelectionOver(){
		return landSelectionOver;
	}
	
	public MapUI getMapUI(){
		return mapui;
	}
	
	public TurnScreenUI getTurnScreenUI(){
		return turnui;
	}
	
	
}
