package edu.gatech.spamr.view;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JLabel;

import edu.gatech.spamr.model.Game;
import edu.gatech.spamr.model.Player;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LandSelectionUI extends JPanel {

	private MapUI mapui = new MapUI();
	private Player currentPlayer = Game.getPlayer1();
	private boolean freeLandSelection = true;
	private int propertiesOwned = 0; // if it gets to 8, free land selection is over
	private int playersPassed = 0; // if it gets to 4, everyone passed
	
	private void nextPlayer(){
		if(currentPlayer.equals(Game.getPlayer1()))
			currentPlayer = Game.getPlayer2();
		if(currentPlayer.equals(Game.getPlayer2()))
			currentPlayer = Game.getPlayer3();
		if(currentPlayer.equals(Game.getPlayer3()))
			currentPlayer = Game.getPlayer4();
		if(currentPlayer.equals(Game.getPlayer4())){
			if(propertiesOwned>=8){
				freeLandSelection = false;
			}
			if(playersPassed<4){
				currentPlayer = Game.getPlayer1();
				playersPassed = 0;
			}
			else
				System.out.println("Land Selection Phase Over!");
		}
	}
	
	/**
	 * Create the panel.
	 */
	public LandSelectionUI() {
		setPreferredSize(new Dimension(1280, 800));
		setMinimumSize(new Dimension(1280, 800));
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		JPanel mapPanel = mapui;
		mapui.setMinimumSize(new Dimension(820, 600));
		mapui.setSize(new Dimension(820, 600));
		mapPanel.setBounds(33, 107, 820, 600);
		add(mapPanel);
		
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
		
		JButton purchaseButton = new JButton("Purchase");
		purchaseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(freeLandSelection){
					if(!mapui.getCurrentTile().isOwned()){
						mapui.getCurrentTile().setOwner(currentPlayer);
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
					if(currentPlayer.getMoney()>=300){
						if(!mapui.getCurrentTile().isOwned()){
							mapui.getCurrentTile().setOwner(currentPlayer);
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
		
		JLabel lblNewLabel = new JLabel("Current Player:");
		lblNewLabel.setBounds(956, 107, 122, 50);
		add(lblNewLabel);
		
		JLabel lblMoney = new JLabel("Money:");
		lblMoney.setBounds(956, 155, 122, 50);
		add(lblMoney);
		

	}
}
