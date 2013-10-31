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


public class PubUI extends JPanel {
	
	 
	private GameScreenUI parent;
	
	JButton gambleButton;
	
	public PubUI(){
		setPreferredSize((new Dimension (1280,800)));
		setBackground(Color.LIGHT_GRAY);
		JPanel buttonPanel = new JPanel(new FlowLayout());	//creates the panel
		//buttonPanel.setPreferredSize(new Dimension(200, 800));
		setLayout(new BorderLayout());
		JLabel pub =  new JLabel("PUB",JLabel.CENTER);	//title
		//pub.setBackground(Color.DARK_GRAY);
		pub.setFont(new Font("Serif", Font.BOLD, 48));
		//setLayout(new BorderLayout());
		add(pub, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.EAST);
		
		gambleButton = new JButton("CLICK TO GAMBLE");
		gambleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pub pub = new Pub();
				
			//pub.calcGamble(Game.getRound(), );
				
			
			}
		});
		buttonPanel.add(gambleButton);
		gambleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Pub.calcGamble(Game.getCurrentRound(), #timeleft); //int for how much money player gets
				Game.updateTurn(); //updates turn/round count in game (not current player)
				parent.cardChangeTo("Map");
				Timer.startTurn(Game.getCurrentPlayer(), Game.getCurrentRound());
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
