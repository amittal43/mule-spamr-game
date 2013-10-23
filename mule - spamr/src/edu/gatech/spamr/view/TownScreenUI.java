package edu.gatech.spamr.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
	private ImageIcon storeIcon;
	
	//private MainAppView parent;
	

	/**
	 * Create the panel.
	 */
	public TownScreenUI() {
		setPreferredSize((new Dimension (1280,800)));
		setBackground(Color.LIGHT_GRAY);
		setLayout(new GridLayout(2,2));
		
		storeIcon = new ImageIcon("/edu/gatech/spamr/resources/Store-final.JPG");
		storeButton = new JButton(storeIcon);
		//storeButton.setPreferredSize(new Dimension(100,100));

		//create a store button in which the player can go to the store
		storeButton = new JButton();
		storeIcon = new ImageIcon(TownScreenUI.class.getResource("/edu/gatech/spamr/resources/Store-final.JPG"));
		//biggerPanel.setLayout(null);
		JButton storeButton = new JButton(storeIcon);
		storeButton.setBounds(1, 0, 112, 300);
		add(storeButton);
		
		//create an assay button in which the player can go assay 
		assayButton = new JButton();
		ImageIcon assayIcon = new ImageIcon(TownScreenUI.class.getResource("/edu/gatech/spamr/resources/Assay-Office-final.jpg"));
		JButton assayButton = new JButton(assayIcon);
		assayButton.setBounds(113, 0, 112, 300);	
		add(assayButton);
		
		//create a pub button in which the player can go to the pub
		pubButton = new JButton();
		pubButton.setIcon(new ImageIcon(TownScreenUI.class.getResource("/edu/gatech/spamr/resources/Pub-alpha.jpg")));
		pubButton.setBounds(225, 0, 112, 300);
		ImageIcon pubIcon = new ImageIcon(TownScreenUI.class.getResource("/edu/gatech/spamr/resources/Pub-alpha.jpg"));
		add(pubButton);
		
		//create a land office button in which the player can go to the office to buy/trade land with computer

		landOfficeButton = new JButton();
		landOfficeButton.setIcon(new ImageIcon(TownScreenUI.class.getResource("/edu/gatech/spamr/resources/Land-Office-final.jpg")));
		landOfficeButton.setBounds(338, 0, 112, 300);
		landOfficeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ImageIcon landIcon = new ImageIcon(TownScreenUI.class.getResource("/edu/gatech/spamr/resources/Land-Office-final.jpg"));
		add(landOfficeButton);
		
	}

}
