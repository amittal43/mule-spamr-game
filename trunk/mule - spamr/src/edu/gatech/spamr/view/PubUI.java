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
	
	 
	private GameScreenUI parent;
	
	JButton gambleButton;
	
	public PubUI(){
		setPreferredSize((new Dimension (1280,800)));
		setBackground(Color.LIGHT_GRAY);
		JPanel buttonPanel = new JPanel(new FlowLayout());	//creates the panel
		//buttonPanel.setPreferredSize(new Dimension(200, 800));
		setLayout(new BorderLayout());
		JLabel pub =  new JLabel("PUB",JLabel.CENTER);	//title
		//pub.setBackground(Color.DARK_GRAY);
		pub.setFont(new Font("Serif", Font.BOLD, 48));
		//setLayout(new BorderLayout());
		add(pub, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.EAST);
		
		gambleButton = new JButton("CLICK TO GAMBLE");
		buttonPanel.add(gambleButton);
	
		JButton backbutton = new JButton("GO BACK");
		buttonPanel.add(backbutton);
		backbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.cardChangeTo("Town");
			}
		});
		
	}
	
	public void setParent(GameScreenUI gcui){
		parent = gcui;
	}
	

}
