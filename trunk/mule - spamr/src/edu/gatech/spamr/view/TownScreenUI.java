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
	
	private JPanel storePanel;
	private JPanel assayPanel;
	private JPanel pubPanel;
	private JPanel landOfficePanel;

	/**
	 * Create the panel.
	 */
	public TownScreenUI() {
		setPreferredSize((new Dimension (309, 365)));
		setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout());
		
		JPanel biggerPanel = new JPanel();
		biggerPanel.setLayout(new GridLayout(1,4));
		
		storePanel = new JPanel();
		ImageIcon storeIcon = new ImageIcon();
		JButton storeButton = new JButton(storeIcon);
		biggerPanel.add(storePanel);
		
		
		assayPanel = new JPanel();
		ImageIcon assayIcon = new ImageIcon();
		JButton assayButton = new JButton(assayIcon);
		biggerPanel.add(assayPanel);
		
	}
	
	

}
