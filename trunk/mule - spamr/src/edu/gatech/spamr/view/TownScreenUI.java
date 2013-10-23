package edu.gatech.spamr.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

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
	
	//TownScreen Variables
	private JButton storeButton;
	private JButton assayButton;
	private JButton pubButton;
	private JButton landOfficeButton;
	private JButton backButton;
	
	/**
	 * Create the panel.
	 */
	public TownScreenUI() {
		
		//sets preferences for TownScreen
		setPreferredSize((new Dimension (1280,800)));
		setBackground(Color.LIGHT_GRAY);
		JPanel buttonPanel = new JPanel(new GridLayout(2,2));	//creates the panel
		buttonPanel.setPreferredSize(new Dimension(800,500) );
		setLayout(new BorderLayout());
		JLabel town =  new JLabel("TOWN",JLabel.CENTER);	//title
		town.setBackground(Color.WHITE);
		town.setFont(new Font("Serif", Font.BOLD, 48));
		
		//create a store button in which the player can go to the store
		storeButton = new JButton();
		
		
		//store Button
		ImageIcon storeIcon = new ImageIcon(TownScreenUI.class.getResource("/edu/gatech/spamr/resources/Store-final.JPG"));
		JButton storeButton = new JButton(storeIcon);
		storeButton.setBounds(1, 0, 112, 300);
		buttonPanel.add(storeButton);
		
		//create an assay button in which the player can go assay 
		assayButton = new JButton();
		ImageIcon assayIcon = new ImageIcon(TownScreenUI.class.getResource("/edu/gatech/spamr/resources/Assay-Office-final.jpg"));
		JButton assayButton = new JButton(assayIcon);
		assayButton.setBounds(113, 0, 112, 300);
		buttonPanel.add(assayButton);
		
		//create a pub button in which the player can go to the pub
		pubButton = new JButton();
		pubButton.setIcon(new ImageIcon(TownScreenUI.class.getResource("/edu/gatech/spamr/resources/Pub-alpha.jpg")));
		pubButton.setBounds(225, 0, 112, 300);
		ImageIcon pubIcon = new ImageIcon(TownScreenUI.class.getResource("/edu/gatech/spamr/resources/Pub-alpha.jpg"));
		buttonPanel.add(pubButton);
		
		//create a land office button in which the player can go to the office to buy/trade land with computer
		landOfficeButton = new JButton();
		landOfficeButton.setIcon(new ImageIcon(TownScreenUI.class.getResource("/edu/gatech/spamr/resources/Land-Office-final.jpg")));
		landOfficeButton.setBounds(338, 0, 112, 300);
		landOfficeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ImageIcon landIcon = new ImageIcon(TownScreenUI.class.getResource("/edu/gatech/spamr/resources/Land-Office-final.jpg"));
		buttonPanel.add(landOfficeButton);
		
		backButton = new JButton("Click to go Back");
		backButton.setFont(new Font("Serif", Font.PLAIN, 30));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(backButton,BorderLayout.PAGE_END);
		
		
		//adds the panel
		add(buttonPanel,BorderLayout.CENTER);
		add(town,BorderLayout.PAGE_START);

	}
	
}
