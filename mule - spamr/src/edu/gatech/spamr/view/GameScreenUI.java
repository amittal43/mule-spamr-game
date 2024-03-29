package edu.gatech.spamr.view;

import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Point;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;

import edu.gatech.spamr.model.Game;
import edu.gatech.spamr.model.Map;
import edu.gatech.spamr.model.Timer;

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
	private MainAppView parent;
	//private MapUI mapui = new MapUI(this.getGame().getMap());
	private TurnScreenUI turnui;
	private PubUI pubui = new PubUI();
	private LandSelectionUI lsui;
	private boolean landSelectionOver = false;
	private TownScreenUI tsui = new TownScreenUI();
	private static CardLayout cardLayout = new CardLayout(0,0);
	private JPanel cards = new JPanel(cardLayout);
	private StoreUI storeui = new StoreUI();
	private LandOfficeUI landui = new LandOfficeUI();
	private MuleMenuUI muleui;
	private Timer stopWatch = new Timer();
	private SaveDialog sdialog = new SaveDialog(this);
	private StatPanel stats = StatPanel.getInstance();
	
	/**
	 * Creates the GameScreen Panel and adds the other panels as cards
	 * 
	 * @return a screen that has all the different locations a player can go to
	 */
	public GameScreenUI(MainAppView main) {
		
		parent = main;
		//turnui = new TurnScreenUI(this);
		//lsui = new LandSelectionUI(this);
		//muleui = new MuleMenuUI(this);
		
		//setting preferences
		setPreferredSize(new Dimension(1280, 800));
		setMinimumSize(new Dimension(1280, 800));
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		cards.setLocation(0, 0);
		cards.setSize(new Dimension(980, 800));
		cards.setPreferredSize(new Dimension(980, 800));
		
		stats.setLocation(new Point(980,0));
		stats.setSize(new Dimension(300, 800));
		add(stats);
		
		//adding each "card" to the panel
		/*cards.add(turnui, "TurnScreen");
		turnui.setParent(this);
		cards.add(lsui, "LandSelection");
		lsui.setParent(this);*/
		cards.add(tsui, "Town");
		tsui.setParent(this);
		cards.add(pubui, "Pub");
		pubui.setParent(this);
		cards.add(storeui, "Store");
		storeui.setParent(this);
		cards.add(landui, "LandOffice");
		landui.setParent(this);
		//cards.add(muleui, "Mule");
		//muleui.setParent(this);
		//cardLayout.show(cards, "LandSelection");
		
		
		add(cards);
		//Game.setParent(this);
	}

	//getters and setters
	public void cardChangeTo(String cardName) {
        cardLayout.show(cards, cardName);
        
        if(cardName.equals("TurnScreen")){
        	turnui.getMapUI().updateBorders();
        	turnui.validate();
        	turnui.repaint();
        }
        
        if(cardName.equals("Mule")){
        	muleui.getMapUI().updateBorders();
        	turnui.validate();
        	turnui.repaint();
        }
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
	
	public MainAppView getMainAppView(){
		return parent;
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
	
	/*public MapUI getMapUI(){
		return mapui;
	}*/
	
	public TurnScreenUI getTurnScreenUI(){
		return turnui;
	}
	
	public Game getGame(){
		return parent.getGame();
	}
	
	public Timer getTimer(){
		return stopWatch;
	}
	
	public SaveDialog getSaveDialog(){
		return sdialog;
	}
	
	public TownScreenUI getTsui(){
		return tsui;
	}
	
	public void initializeMapScreens(){
		lsui = new LandSelectionUI(this);
		turnui = new TurnScreenUI(this);
		muleui = new MuleMenuUI(this);
		cards.add(turnui, "TurnScreen");
		turnui.setParent(this);
		cards.add(lsui, "LandSelection");
		lsui.setParent(this);
		cards.add(muleui, "Mule");
		muleui.setParent(this);
		cardLayout.show(cards, "LandSelection");
	}
}
