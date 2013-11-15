package edu.gatech.spamr.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.gatech.spamr.model.Map;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/** 
 * The LandOfficeUI class creates a panel for the player to go to the land office  
 * 
 * @author Sean Lachenberg
 * @author Aditya Mittal
 * @author Mike Vail
 * @author Puja Sheth
 * @author Raj Prateek
 * @version 1.0 10/21/2013 
 */

public class LandOfficeUI extends JPanel {
	
	//creates an instance variable of MapUI
//	private MapUI mapui = new MapUI(new Map(null));
	
	private GameScreenUI parent;

	/**
	 * LandOfficeUI creates the office is the correct dimensions
	 * 
	 * @return an instance of MapUI
	 */
	public LandOfficeUI() {
		setPreferredSize(new Dimension(1280, 755));
		setBackground(Color.LIGHT_GRAY);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(1006, 0, 274, 753);
		setLayout(null);
		JLabel pub =  new JLabel("LAND OFFICE",JLabel.CENTER);	//title
		pub.setBounds(0, 0, 1009, 48);
		
		pub.setFont(new Font("Serif", Font.BOLD, 48));
	

		add(pub);
		add(buttonPanel);
		buttonPanel.setLayout(null);
		
		JButton backButton = new JButton("GO BACK");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.cardChangeTo("Town");
			}
		});
		backButton.setBounds(77, 309, 155, 103);
		buttonPanel.add(backButton);
		
		
		JButton buyButton = new JButton("BUY");
		buyButton.setBounds(77, 17, 155, 103);
		buttonPanel.add(buyButton);
		
		JButton sellButton = new JButton("SELL");
		sellButton.setBounds(77, 156, 155, 103);
		buttonPanel.add(sellButton);
		
//		setPreferredSize(new Dimension(1280, 800));
//		setMinimumSize(new Dimension(1280, 800));
//		setBackground(Color.DARK_GRAY);
//		setLayout(null);
//		
//		JPanel panel = mapui;
//		mapui.setSize(new Dimension(800, 600));
//		panel.setBounds(45, 57, 820, 600);
//		add(panel);

	}
	
	public void setParent(GameScreenUI gcui){
		parent = gcui;
	}
}
