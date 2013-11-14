package edu.gatech.spamr.view;

import javax.swing.JPanel;

import edu.gatech.spamr.model.Game;
import edu.gatech.spamr.model.Game.Difficulty;
import edu.gatech.spamr.model.Map.MapType;



import edu.gatech.spamr.model.Store;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Window;

import javax.swing.JComboBox;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import java.awt.Dimension;

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

	//GameConfigUI variables
	private MainAppView parent;
	private int numHumans = 4; // default number of human players
	private MapType selectedMapType = MapType.DEFAULT;
	
	/**
	 * GameConfigUI consists of the logistics behind choosing the amount of players and the map type
	 * 
	 * Will store all information in a player variable
	 */
	public GameConfigUI() {
		//setting panel prefrences
		setPreferredSize(new Dimension(309, 365));
		setMinimumSize(new Dimension(309, 365));
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		//Title
		JLabel lblGameConfiguration = new JLabel("Game Configuration");
		lblGameConfiguration.setForeground(Color.LIGHT_GRAY);
		lblGameConfiguration.setFont(new Font("Verdana", Font.BOLD, 18));
		lblGameConfiguration.setBounds(47, 29, 208, 36);
		add(lblGameConfiguration);
		
		//Map combobox
		final JComboBox MapComboBox = new JComboBox();
		MapComboBox.setModel(new DefaultComboBoxModel(MapType.values()));
		MapComboBox.setFont(new Font("Verdana", Font.BOLD, 11));
		MapComboBox.setBounds(47, 113, 103, 20);
		add(MapComboBox);
		
		//Human Count combobox
		final JComboBox HumansComboBox = new JComboBox();
		HumansComboBox.setFont(new Font("Verdana", Font.BOLD, 11));
		HumansComboBox.setModel(new DefaultComboBoxModel(new String[] {"4 Human Players", "3 Human Players", "2 Human Players"}));
		HumansComboBox.setBounds(47, 180, 156, 20);
		add(HumansComboBox);
		
		//Map Label
		JLabel lblMapSelection = new JLabel("Map Selection");
		lblMapSelection.setForeground(Color.LIGHT_GRAY);
		lblMapSelection.setFont(new Font("Verdana", Font.BOLD, 12));
		lblMapSelection.setBounds(47, 88, 103, 14);
		add(lblMapSelection);
		
		//Player Count Label
		JLabel lblPlayerCount = new JLabel("Player Count");
		lblPlayerCount.setForeground(Color.LIGHT_GRAY);
		lblPlayerCount.setFont(new Font("Verdana", Font.BOLD, 12));
		lblPlayerCount.setBounds(47, 155, 117, 14);
		add(lblPlayerCount);
		
		//Difficulty combobox
		final JComboBox DifficultyComboBox = new JComboBox();
		DifficultyComboBox.setModel(new DefaultComboBoxModel(Difficulty.values()));
		DifficultyComboBox.setFont(new Font("Verdana", Font.BOLD, 11));
		DifficultyComboBox.setBounds(47, 246, 103, 22);
		add(DifficultyComboBox);
		
		//Difficulty Label
		JLabel lblDifficulty = new JLabel("Difficulty");
		lblDifficulty.setForeground(Color.LIGHT_GRAY);
		lblDifficulty.setFont(new Font("Verdana", Font.BOLD, 12));
		lblDifficulty.setBounds(47, 221, 103, 14);
		add(lblDifficulty);
		
		//Continue Button
		JButton btnContinue = new JButton("Continue");
		btnContinue.setFont(new Font("Verdana", Font.BOLD, 12));
		btnContinue.setBounds(102, 303, 103, 36);
		add(btnContinue);
		
		//buttonListener for Continue Button
		btnContinue.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e)
            {
                //updates number of Human players based on the comboBox
            	if(HumansComboBox.getSelectedIndex()==0)
            		numHumans = 4;
            	if(HumansComboBox.getSelectedIndex()==1)
            		numHumans = 3;
            	if(HumansComboBox.getSelectedIndex()==2)
            		numHumans = 2;
            	
            	//updates Game with difficulty and map selected
            	parent.getGame().setDifficulty((Difficulty) DifficultyComboBox.getSelectedItem());
            	parent.getGame().getMap().setMapType((MapType) MapComboBox.getSelectedItem());
            	
            	//print debugging
            	/*
            	System.out.println("Map Type: " + Game.getMap().getMapType().toString());
            	System.out.println("Number of Human Players: " + numHumans + " Players");
            	System.out.println("Difficulty: " + Game.getDifficulty().toString());
            	*/
            	
            	//closes pop up
            	parent.getConfigDialog().setContentPane(parent.getPlayerConfigUI());
            	parent.getConfigDialog().setTitle("Configure Players");
            	parent.getConfigDialog().validate();
            	parent.getConfigDialog().repaint();
            }
        });
		
		
		
	}
	
	//getters and setters
	public MapType getMapType(){
		return selectedMapType;
	}
	
	public int getNumHumans(){
		return numHumans;
	}
	
	private MainAppView getMainApp(){
		return parent;
	}
	
	public void setParent(MainAppView mainApp){
		parent = mainApp;
	}
	
}
