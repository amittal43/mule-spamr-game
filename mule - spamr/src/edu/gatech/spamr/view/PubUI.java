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
	
	public PubUI(){
		setPreferredSize((new Dimension (1280,800)));
		setBackground(Color.LIGHT_GRAY);
		
		
	}
	
	public void setParent(TownScreenUI tsui){
		TownScreenUI parent = tsui;
	}

}
