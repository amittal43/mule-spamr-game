package edu.gatech.spamr.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.JPanel;

import edu.gatech.spamr.model.Timer;

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
	private GameScreenUI parent;
	//private Timer storeTimer;
	//private JLabel timeRemaining;
	private int storeOnFire = 0;
	
	/**
	 * TownScreenUI is a representation of the various locations a player can go to in the town
	 */
	public TownScreenUI() {
		
		//sets preferences for TownScreen
		setPreferredSize(new Dimension(1280, 685));
		setBackground(Color.LIGHT_GRAY);
//		JPanel buttonPanel = new JPanel(new GridLayout(2,2));	//creates the panel
//		buttonPanel.setPreferredSize(new Dimension(800,500) );
		
		JLabel town =  new JLabel("TOWN",JLabel.CENTER);	//title
		town.setBounds(372, 8, 152, 48);
		town.setBackground(Color.DARK_GRAY);
		town.setFont(new Font("Serif", Font.BOLD, 48));
		
		//create a store button in which the player can go to the store

		setLayout(null);
		//ImageIcon storeIcon = new ImageIcon(TownScreenUI.class.getResource("/edu/gatech/spamr/resources/potter/STORE_converted.jpg"));
		/*ImageIcon storeIcon = new ImageIcon();
		storeButton = new JButton(storeIcon);

		//ImageIcon storeIcon = new ImageIcon(TownScreenUI.class.getResource("/edu/gatech/spamr/resources/potter/STORE.JPG"));
		storeButton = new JButton();

		storeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(storeOnFire == 0){
					parent.cardChangeTo("Store");
				}
			}
		}); 
		*/
		
		storeButton = new JButton();
		storeButton.setIcon(new ImageIcon(TownScreenUI.class.getResource("/edu/gatech/spamr/resources/potter/STORE_converted.jpg")));
		storeButton.setBounds(57, 68, 371, 304);
		storeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(storeOnFire == 0){
					parent.cardChangeTo("Store");
				}
			}
		});
		add(storeButton);
	
		
		//create an assay button in which the player can go assay 
		ImageIcon assayIcon = new ImageIcon(TownScreenUI.class.getResource("/edu/gatech/spamr/resources/potter/ASSAYOFFICE.jpg"));
		assayButton = new JButton(assayIcon);
		assayButton.setBounds(484, 68, 390, 304);
		add(assayButton);
		
		//create a pub button in which the player can go to the pub
		pubButton = new JButton();
		pubButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.cardChangeTo("Pub");
			}
		});
		pubButton.setIcon(new ImageIcon(TownScreenUI.class.getResource("/edu/gatech/spamr/resources/potter/PUB.jpg")));
		pubButton.setBounds(57, 403, 371, 304);
		add(pubButton);

		
		//create a land office button in which the player can go to the office to buy/trade land with computer
		landOfficeButton = new JButton();
		landOfficeButton.setIcon(new ImageIcon(TownScreenUI.class.getResource("/edu/gatech/spamr/resources/potter/LANDOFFICE.jpg")));
		landOfficeButton.setBounds(484, 403, 390, 304);
		landOfficeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.cardChangeTo("LandOffice");
			}
		});
		add(landOfficeButton);
		
		backButton = new JButton("Click to go Back");
		backButton.setBounds(341, 706, 246, 39);
		backButton.setFont(new Font("Serif", Font.PLAIN, 30));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.cardChangeTo("TurnScreen");
			}
		});
		add(backButton);
		
		//create a timer count down
		//storeTimer = new Timer();
		//timeRemaining = new JLabel("Remaining Time:" + storeTimer);
		
		//adds the panel
//		add(buttonPanel,BorderLayout.CENTER);
		add(town);
		//add(timeRemaining,BorderLayout.NORTH);
	}
		public void setParent(GameScreenUI gcui){
			parent = gcui;
		}
		
		public void setFire(int yn){
			storeOnFire = yn;
		}
	
}
	

