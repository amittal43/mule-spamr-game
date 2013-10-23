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
	
	private JButton storeButton;
	private JButton assayButton;
	private JButton pubButton;
	private JButton landOfficeButton;
	private JButton backButton;
	/**
	 * Create the panel.
	 */
	public TownScreenUI() {
		setPreferredSize((new Dimension (1280,800)));
		setBackground(Color.LIGHT_GRAY);
		JPanel buttonPanel = new JPanel(new GridLayout(2,2));
		buttonPanel.setPreferredSize(new Dimension(800,500) );
		setLayout(new BorderLayout());
		//JPanel buttonPanel = new JPanel(new FlowLayout());
		//buttonPanel.setPreferredSize((new Dimension (640,400)));
		JLabel town =  new JLabel("TOWN",JLabel.CENTER);
		town.setBackground(Color.WHITE);
		town.setFont(new Font("Serif", Font.BOLD, 48));
		//town.setHorizontalAlignment(SwingConstants.CENTER);
		//setLayout();
		
		//JPanel biggerPanel = new JPanel();
		
		//create a store button in which the player can go to the store
		storeButton = new JButton();
		//storeButton.setSize(new Dimension(200,200));
		ImageIcon storeIcon = new ImageIcon(TownScreenUI.class.getResource("/edu/gatech/spamr/resources/Store-final.JPG"));
		//biggerPanel.setLayout(null);
		JButton storeButton = new JButton(storeIcon);
		storeButton.setBounds(1, 0, 112, 300);
		//biggerPanel.add(storeButton);
		buttonPanel.add(storeButton);
		
		//create an assay button in which the player can go assay 
		assayButton = new JButton();
		ImageIcon assayIcon = new ImageIcon(TownScreenUI.class.getResource("/edu/gatech/spamr/resources/Assay-Office-final.jpg"));
		JButton assayButton = new JButton(assayIcon);
		assayButton.setBounds(113, 0, 112, 300);
		//biggerPanel.add(assayButton);
		buttonPanel.add(assayButton);
		
		//create a pub button in which the player can go to the pub
		pubButton = new JButton();
		pubButton.setIcon(new ImageIcon(TownScreenUI.class.getResource("/edu/gatech/spamr/resources/Pub-alpha.jpg")));
		pubButton.setBounds(225, 0, 112, 300);
		ImageIcon pubIcon = new ImageIcon(TownScreenUI.class.getResource("/edu/gatech/spamr/resources/Pub-alpha.jpg"));
		//biggerPanel.add(pubButton);
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
		//biggerPanel.add(landOfficeButton);
		buttonPanel.add(landOfficeButton);
		
		backButton = new JButton("Click to go Back");
		//backButton.set
		backButton.setFont(new Font("Serif", Font.PLAIN, 30));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		//backButton.
		add(backButton,BorderLayout.PAGE_END);
		
		
		
		add(buttonPanel,BorderLayout.CENTER);
		add(town,BorderLayout.PAGE_START);
		
		
	}
	
	

}
