package edu.gatech.spamr.view;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dialog;

import javax.swing.JComboBox;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

/** 
 * The GameConfigUI class represents a panel in which the map of the game is displayed
 * 
 * It has a default map and an other map and a way to see the map based on the amount of players.  
 * 
 * @author Sean Lachenberg
 * @author Aditya Mittal
 * @author Mike Vail
 * @author Puja Sheth
 * @author Raj Prateek
 * @version 1.0 10/05/2013 
 */

public class GameConfigUI extends JPanel {

	/**
	 * Create the panel.
	 */
	public GameConfigUI() {
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		//combobox
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Default Map", "Other Map"}));
		comboBox.setFont(new Font("Verdana", Font.BOLD, 11));
		comboBox.setBounds(47, 101, 103, 20);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Verdana", Font.BOLD, 11));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"4 Human Players", "3 Human Players", "2 Human Players"}));
		comboBox_1.setBounds(49, 167, 156, 20);
		add(comboBox_1);
		
		//label
		JLabel lblMapSelection = new JLabel("Map Selection");
		lblMapSelection.setFont(new Font("Verdana", Font.BOLD, 11));
		lblMapSelection.setBounds(47, 76, 103, 14);
		add(lblMapSelection);
		
		JLabel lblPlayerCount = new JLabel("Player Count");
		lblPlayerCount.setFont(new Font("Verdana", Font.BOLD, 11));
		lblPlayerCount.setBounds(47, 142, 117, 14);
		add(lblPlayerCount);
		
		JLabel lblGameConfiguration = new JLabel("Game Configuration");
		lblGameConfiguration.setFont(new Font("Verdana", Font.BOLD, 18));
		lblGameConfiguration.setBounds(47, 29, 208, 36);
		add(lblGameConfiguration);
		
		//button
		JButton btnContinue = new JButton("Continue");
		btnContinue.setFont(new Font("Verdana", Font.BOLD, 11));
		btnContinue.setBounds(183, 282, 89, 23);
		add(btnContinue);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Verdana", Font.BOLD, 8));
		comboBox_2.setBounds(47, 239, 103, 22);
		add(comboBox_2);
		
		JLabel lblDifficulty = new JLabel("Difficulty");
		lblDifficulty.setFont(new Font("Verdana", Font.BOLD, 11));
		lblDifficulty.setBounds(47, 214, 103, 14);
		add(lblDifficulty);
		
		
		//comboBox listeners
		comboBox.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e)
            {
            	//made comboBox final to get this to work (not sure if that is good)
            	String s = (String)(comboBox.getSelectedItem());
               
            	//combo box selected
                System.out.println(s);
            }
        });
		
		//buttonListener
		btnContinue.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e)
            {
                //button is pressed
            	PlayerConfigUI pcui = new PlayerConfigUI();
            	JDialog pcuiDialog = new JDialog(null, "Configure Players", Dialog.ModalityType.APPLICATION_MODAL);
            	pcuiDialog.setSize(pcui.getPreferredSize());
            	pcuiDialog.setContentPane(pcui);
            	pcuiDialog.setVisible(true);
            	while(!pcui.isCompleted()){
            		if(pcui.isCompleted())
            			pcuiDialog.dispose();
            	}
                System.out.println("You clicked the Continue button");
            }
        });
		
		
		
	}
}
