package edu.gatech.spamr.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.JPanel;

/** 
 * The TownScreenUI class creates a panel for the player to go to the store
 * 
 * @author Sean Lachenberg
 * @author Aditya Mittal
 * @author Mike Vail
 * @author Puja Sheth
 * @author Raj Prateek
 * @version 1.0 10/15/2013 
 */

public class TownScreenUI extends JPanel {
	
	private JButton storeButton;
	private JButton assayButton;
	private JButton pubButton;
	private JButton landOfficeButton;

	/**
	 * Create the panel.
	 */
	public TownScreenUI() {
		setPreferredSize((new Dimension (309, 365)));
		setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout());
		
		JPanel biggerPanel = new JPanel();
		biggerPanel.setLayout(new GridLayout(1,4));
		
		//create a store button in which the player can go to the store
		storeButton = new JButton();
		ImageIcon storeIcon = new ImageIcon(TownScreenUI.class.getResource("/edu/gatech/spamr/resources/Store-final.JPG"));
		JButton storeButton = new JButton(storeIcon);
		biggerPanel.add(storeButton);
		
		//create an assay button in which the player can go assay 
		assayButton = new JButton();
		ImageIcon assayIcon = new ImageIcon(TownScreenUI.class.getResource("/edu/gatech/spamr/resources/Assay-Office-final.jpg"));
		JButton assayButton = new JButton(assayIcon);
		biggerPanel.add(assayButton);
		
		//create a pub button in which the player can go to the pub
		pubButton = new JButton();
		ImageIcon pubIcon = new ImageIcon(TownScreenUI.class.getResource("/edu/gatech/spamr/resources/Pub-alpha.jpg"));
		biggerPanel.add(pubButton);
		
		//create a land office button in which the player can go to the office to buy/trade land with computer

		landOfficeButton = new JButton();
		ImageIcon landIcon = new ImageIcon(TownScreenUI.class.getResource("/edu/gatech/spamr/resources/Land-Office-final.jpg"));
		biggerPanel.add(landOfficeButton);
		
		
	}
	
	

}
