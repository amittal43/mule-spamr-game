package edu.gatech.spamr.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.gatech.spamr.model.Game;
import edu.gatech.spamr.model.Pub;
import edu.gatech.spamr.model.Round;
import edu.gatech.spamr.model.Timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

/**
 * PubUI class to create a location in which the players can gamble
 * 
 * @author Puja Sheth
 * @author Mike Vail
 * @author Sean Lachenberg
 * @author Raj Prateek
 * @author Aditya Mittal
 *
 */

public class PubUI extends JPanel {
	
	private GameScreenUI parent;
	
	JButton gambleButton;
	
	/**
	 * PubUI panel creation to include a border layout and various buttons
	 */
	
	public PubUI(){
		setPreferredSize((new Dimension (1280,800)));
		setBackground(Color.LIGHT_GRAY);
		JPanel buttonPanel = new JPanel(new FlowLayout());	//creates the panel
		
		setLayout(new BorderLayout());
		JLabel pub =  new JLabel("PUB",JLabel.CENTER);	//title
		
		pub.setFont(new Font("Serif", Font.BOLD, 48));

		add(pub, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.EAST);
		
		gambleButton = new JButton("CLICK TO GAMBLE");
		/*gambleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pub pub = new Pub();
				
			//pub.calcGamble(Game.getRound(), );
				
			
			}
		});*/
		buttonPanel.add(gambleButton);
		gambleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//updates player money
				int bonus = Pub.calcGamble(Game.getCurrentRound(), Timer.getTimeRemaining()); 
				System.out.println(Game.getCurrentPlayer().getName() + " recieves " + bonus + " money!");
				Game.getCurrentPlayer().updateMoney(bonus);
				
				//interrupts the current timer
				System.out.println("Timer Thread: " + Game.getTurnTimer().toString());
				Game.getTurnTimer().interrupt();
				
				
				//turn change
				Game.updateTurn(); //updates turn/round count in game (not current player)
				System.out.println("Turn changes to " + Game.getCurrentPlayer().getName());
				
				//screen change
				parent.cardChangeTo("TurnScreen");
				
				//pop-up
				parent.getTurnScreenUI().getTurnDialog().setVisible(true);
				
			}
		});
	
		JButton backbutton = new JButton("GO BACK");
		buttonPanel.add(backbutton);
		backbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.cardChangeTo("Town");
			}
		});
		
	}
	
	public void setParent(GameScreenUI gcui){
		parent = gcui;
	}
	

}
