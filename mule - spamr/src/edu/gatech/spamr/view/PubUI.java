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
import java.util.Random;

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
	
	Pub pubInstance = Pub.getInstance();
	
	/**
	 * PubUI panel creation to include a border layout and various buttons
	 */
	
	public PubUI(){
		setPreferredSize(new Dimension(1280, 755));
		setBackground(Color.LIGHT_GRAY);
		
	
		setLayout(null);
		JLabel pub =  new JLabel("PUB",JLabel.CENTER);	//title
		pub.setBounds(-173, 6, 1009, 48);
		
		pub.setFont(new Font("Serif", Font.BOLD, 48));
		

		
		ImageIcon table = new ImageIcon(PubUI.class.getResource("/edu/gatech/spamr/resources/potter/Leakycauldron.jpg"));
		JButton cauldron = new JButton(table);
		
		add(cauldron);
		cauldron.setBounds(51, 208, 401, 320);
		add(pub);
	
	
		
		gambleButton = new JButton("CLICK TO GAMBLE");
		gambleButton.setBounds(124, 635, 197, 85);
		add(gambleButton);

		
		/*gambleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pub pub = new Pub();
				
			//pub.calcGamble(parent.getGame().getRound(), );
				
			
			}
		});*/

		gambleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random rand = new Random();
				//updates player money
				int bonus = pubInstance.calcGamble(parent.getGame().getCurrentRound(), rand.nextInt(50001));//parent.getTimer().getTimeRemaining()); 
				System.out.println(parent.getGame().getCurrentPlayer().getName() + " recieves " + bonus + " money!");
				parent.getGame().getCurrentPlayer().updateMoney(bonus);
				
				//interrupts the current timer
				parent.getTimer().requestStop();
				
				
				//turn change
				parent.getGame().updateTurn(); //updates turn/round count in game (not current player)
				System.out.println("Turn changes to " + parent.getGame().getCurrentPlayer().getName());
				
				//screen change
				parent.cardChangeTo("TurnScreen");
				
				//pop-up
				parent.getTurnScreenUI().getTurnDialog().setCurrentPlayerText(parent.getGame().getCurrentPlayer().getName());
				parent.getTurnScreenUI().getTurnDialog().setVisible(true);
				
			}
		});
	
		JButton backButton = new JButton("GO BACK");
		backButton.setBounds(418, 635, 197, 80);
		add(backButton);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.cardChangeTo("Town");
			}
		});
	}
	
	
	public void setParent(GameScreenUI gcui){
		parent = gcui;
	}

}
