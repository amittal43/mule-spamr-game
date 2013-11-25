package edu.gatech.spamr.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;


/** 
 * The TitleScreenUI class creates a panel for the player to begin the game 
 * after seeing the creation information  
 * 
 * @author Sean Lachenberg
 * @author Aditya Mittal
 * @author Mike Vail
 * @author Puja Sheth
 * @author Raj Prateek
 * @version 1.0 10/15/2013 
 */

public class TitleScreenUI extends JPanel {

	//Create instance variable
	private MainAppView parent;
	private Image background;
	
	
	/**
	 * TitleScreenUI returns a screen in which the user can enter the game
	 * 
	 * @return screen in which player can enter game
	 */
	public TitleScreenUI() {
		
		//sets preferences for the Title Screen
		//setPreferredSize(new Dimension(1280, 800));
		//setMinimumSize(new Dimension(1280, 800));
		
		//set the background with image
		background = new ImageIcon("/mule-spamr/src/edu/gatech/spamr/resources/potter/game_screen.jpg").getImage();
		Dimension size = new Dimension(background.getWidth(null), background.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
		
		JButton btnStart = new JButton("START");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				parent.setUpConfigDialog();
			}
		});
		btnStart.setFont(new Font("Verdana", Font.BOLD, 18));
		btnStart.setBounds(581, 453, 132, 54);
		add(btnStart);
		
	}
	
		public void paintComponent(Graphics g) {
			Graphics2D g2d = (Graphics2D)g;
			g2d.drawImage(background, 0, 0, null);
			
		}
		
		//Title
//		JLabel lblNewLabel = new JLabel("MULE: SPAMR Edition");
//		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
//		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
//		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel.setBounds(479, 256, 359, 38);
//		lblNewLabel.setForeground(Color.LIGHT_GRAY);
//		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 30));
//		add(lblNewLabel);
		
		//public void startButton() {
		//start button
//		JButton btnStart = new JButton("START");
//		btnStart.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				parent.setUpConfigDialog();
//			}
//		});
//		btnStart.setFont(new Font("Verdana", Font.BOLD, 18));
//		btnStart.setBounds(581, 453, 132, 54);
//		add(btnStart);

//	}
	
	//getters and setters
	public void setParent(MainAppView main){
		parent = main;
	}
}
