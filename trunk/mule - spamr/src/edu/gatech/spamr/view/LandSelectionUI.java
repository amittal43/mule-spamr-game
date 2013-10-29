package edu.gatech.spamr.view;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JLabel;

import edu.gatech.spamr.model.Game;
import edu.gatech.spamr.model.Player;
import edu.gatech.spamr.model.Tile;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.EtchedBorder;

/** 
 * The LandSelectionUI class allows a player to select land to own  
 * 
 * @author Sean Lachenberg
 * @author Aditya Mittal
 * @author Mike Vail
 * @author Puja Sheth
 * @author Raj Prateek
 * @version 1.0 10/21/2013 
 */

public class LandSelectionUI extends JPanel {

	//Land Selection variables
	private MapUI mapui = Game.getMapUI();
	private Player currentPlayer = Game.getPlayer1();
	private Tile currentTile = mapui.getCurrentTile();
	private boolean freeLandSelection = true;
	private int propertiesOwned = 0; // if it gets to 8, free land selection is over
	private int playersPassed = 0; // if it gets to 4, everyone passed
	private GameScreenUI parent;
	private JLabel playerLabel = new JLabel(Game.getPlayer1().getName());
	private JLabel costLabel = new JLabel("0");
	
	/**
	 * nextPlayer method to allow a rotation in turn for the players to choose land
	 * 
	 * @return the name of the player that can choose land
	 */
	
	private void nextPlayer(){
		
		//rotate's which player is choosing a land tile
		if(currentPlayer.equals(Game.getPlayer1())){
			currentPlayer = Game.getPlayer2();
			playerLabel.setText(currentPlayer.getName());
		}
		else if(currentPlayer.equals(Game.getPlayer2())){
			currentPlayer = Game.getPlayer3();
			playerLabel.setText(currentPlayer.getName());
		}
		else if(currentPlayer.equals(Game.getPlayer3())){
			currentPlayer = Game.getPlayer4();
			playerLabel.setText(currentPlayer.getName());
		}
		else{ // currentPlayer is Player4
			
			//checks to see if there is free land available
			if(propertiesOwned>=8){
				freeLandSelection = false;
				costLabel.setText("300");
			}
			
			//checks to see if everyone passed
			if(playersPassed<4){
				currentPlayer = Game.getPlayer1();
				playerLabel.setText(currentPlayer.getName());
				playersPassed = 0;
			}
			else{
				System.out.println("Land Selection Phase Over!");
				parent.cardChangeTo("Map");
				parent.setLandSelectionOver();
			}
		}
	}
	
	/**
	 * Create the panel.
	 */
	public LandSelectionUI() {
		
		//sets preferences for the Land Selection panel
		setPreferredSize(new Dimension(1280, 800));
		setMinimumSize(new Dimension(1280, 800));
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		JPanel mapPanel = mapui;	//names the panel
		mapui.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		mapui.setMinimumSize(new Dimension(820, 600));
		mapui.setSize(new Dimension(820, 600));
		mapPanel.setBounds(33, 107, 820, 600);
		add(mapPanel);				//adds the panel
		
		//Pass Button
		JButton passButton = new JButton("Pass");
		passButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playersPassed++;
				System.out.println(currentPlayer.getName() + " passed!");
				nextPlayer();
			}
		});
		passButton.setFont(new Font("Verdana", Font.BOLD, 11));
		passButton.setBounds(971, 662, 122, 45);
		add(passButton);
		
		//purchase Button
		JButton purchaseButton = new JButton("Purchase");
		purchaseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(freeLandSelection){
					//checks if owned
					if(!mapui.getCurrentTile().isOwned()){
						mapui.getCurrentTile().setOwner(currentPlayer);
						mapui.colorTile(mapui.getCurrentTile(), mapui.getCurrentButton());
						System.out.println(currentPlayer.getName() + " received tile!");
						propertiesOwned++;
						nextPlayer();
						return;
					}
					else{
						System.out.println("Tile is already owned!");
						return;
					}
				}
				else{
					//checks for money
					if(currentPlayer.getMoney()>=300){
						if(!mapui.getCurrentTile().isOwned()){
							mapui.getCurrentTile().setOwner(currentPlayer);
							mapui.colorTile(mapui.getCurrentTile(), mapui.getCurrentButton());
							currentPlayer.updateMoney(-300);
							System.out.println(currentPlayer.getName() + " received tile!");
							System.out.println(currentPlayer.getName() + "'s money decreased to " + currentPlayer.getMoney());
							propertiesOwned++;
							nextPlayer();
							return;
						}
						else{
							System.out.println("Tile is already owned!");
							return;
						}
					}
					else{
						System.out.println("Not Enough Money!");
						playersPassed++; // must pass because insufficient funds
						nextPlayer();
						return;
					}
				}
					
			}
		});
		purchaseButton.setFont(new Font("Verdana", Font.BOLD, 11));
		purchaseButton.setBounds(971, 580, 122, 45);
		add(purchaseButton);
		
		JLabel landSelectionLabel = new JLabel("Land Selection Phase");
		landSelectionLabel.setFont(new Font("Verdana", Font.BOLD, 25));
		landSelectionLabel.setForeground(Color.LIGHT_GRAY);
		landSelectionLabel.setBounds(38, 23, 339, 58);
		add(landSelectionLabel);
		
		JLabel currentPlayerLabel = new JLabel("Current Player:");
		currentPlayerLabel.setForeground(Color.LIGHT_GRAY);
		currentPlayerLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		currentPlayerLabel.setBounds(956, 107, 209, 58);
		add(currentPlayerLabel);
		
		JLabel playerActiveLabel = playerLabel;
		playerActiveLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		playerActiveLabel.setForeground(Color.LIGHT_GRAY);
		playerActiveLabel.setBounds(956, 159, 163, 35);
		add(playerActiveLabel);
		
		/*JLabel moneyLabel = new JLabel("Money:"); // finish other JLabels later
		moneyLabel.setForeground(Color.LIGHT_GRAY);
		moneyLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		moneyLabel.setBounds(956, 252, 84, 50);
		add(moneyLabel);
		
		JLabel moneyActiveLabel = new JLabel("" + currentPlayer.getMoney());
		moneyActiveLabel.setForeground(Color.LIGHT_GRAY);
		moneyActiveLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		moneyActiveLabel.setBounds(1050, 260, 127, 35);
		add(moneyActiveLabel);
		
		JLabel tileCostLabel = new JLabel("Tile Cost:");
		tileCostLabel.setForeground(Color.LIGHT_GRAY);
		tileCostLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		tileCostLabel.setBounds(930, 313, 115, 21);
		add(tileCostLabel);
		
		JLabel costActiveLabel = costLabel;
		costActiveLabel.setForeground(Color.LIGHT_GRAY);
		costActiveLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		costActiveLabel.setBounds(1050, 309, 122, 28);
		add(costActiveLabel);
		
		JLabel tileOwnedLabel = new JLabel("Owned? :");
		tileOwnedLabel.setForeground(Color.LIGHT_GRAY);
		tileOwnedLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		tileOwnedLabel.setBounds(930, 349, 122, 28);
		add(tileOwnedLabel);
		
		JLabel ownActiveLabel = new JLabel("" + currentTile.isOwned());
		ownActiveLabel.setForeground(Color.LIGHT_GRAY);
		ownActiveLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		ownActiveLabel.setBounds(1050, 349, 115, 28);
		add(ownActiveLabel);
*/
	}
	
	//getters and setters
	public void setParent(GameScreenUI p){
		parent = p;
	}
}
