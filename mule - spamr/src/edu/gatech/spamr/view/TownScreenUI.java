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
		
		storeButton = new JButton();
		ImageIcon storeIcon = new ImageIcon("");
		JButton storeButton = new JButton(storeIcon);
		biggerPanel.add(storeButton);
		
		
		assayButton = new JButton();
		ImageIcon assayIcon = new ImageIcon();
		JButton assayButton = new JButton(assayIcon);
		biggerPanel.add(assayButton);
		
	}
	
	

}
