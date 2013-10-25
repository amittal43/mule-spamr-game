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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PubUI extends JPanel {
	
	 
	private TownScreenUI parent;
	JButton gambleButton;
	
	public PubUI(){
		setPreferredSize((new Dimension (1280,800)));
		setBackground(Color.LIGHT_GRAY);
		JPanel buttonPanel = new JPanel(new GridLayout(1,2));	//creates the panel
		buttonPanel.setPreferredSize(new Dimension(800,500) );
		setLayout(new BorderLayout());
		JLabel town =  new JLabel("PUB",JLabel.CENTER);	//title
		town.setBackground(Color.DARK_GRAY);
		town.setFont(new Font("Serif", Font.BOLD, 48));
		
		
		gambleButton = new JButton();
		buttonPanel.add(gambleButton);
	}
	
	
	public void setParent(TownScreenUI tsui){
		TownScreenUI parent = tsui;
	}

}
