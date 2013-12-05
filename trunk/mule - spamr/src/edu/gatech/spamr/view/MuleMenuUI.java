package edu.gatech.spamr.view;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

import edu.gatech.spamr.model.Game;
import edu.gatech.spamr.model.Store;
import edu.gatech.spamr.model.Store.Resource;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.MatteBorder;

/** 
 * The MuleMenuUI class creates a panel for the player to choose mules based on types  
 * 
 * @author Sean Lachenberg
 * @author Aditya Mittal
 * @author Mike Vail
 * @author Puja Sheth
 * @author Raj Prateek
 * @version 1.0 11/05/2013 
 */

public class MuleMenuUI extends JPanel {

	private GameScreenUI parent;
	private MapUI mapui;
	private Store store;
	
	JButton btnFoodMule = new JButton("Food Mule");
	JButton btnEnergyMule = new JButton("Energy Mule");
	JButton btnOreMule = new JButton("Ore Mule");
	JButton btnGoBack = new JButton("Go Back");
	JButton btnConfirm = new JButton("Confirm");
	
	private JButton currentSelected = btnFoodMule;
	private JButton lastSelected = btnConfirm;
	private Resource selectedMule = Resource.FOOD;
	
	
	/**
	 * Create the panel.
	 */
	public MuleMenuUI(GameScreenUI p) {
		
		parent = p;
		store = parent.getGame().getStore();
		mapui = new MapUI(parent.getGame().getMap());
		
		setBackground(Color.DARK_GRAY);
		setMinimumSize(new Dimension(1280, 800));
		setPreferredSize(new Dimension(1280, 684));
		mapui.setLocation(104, 108);
		
		mapui.setParent(parent);
		mapui.updateBorders();
		setLayout(null);
		mapui.setBorder(null);
		mapui.setMinimumSize(new Dimension(820, 600));
		mapui.setSize(new Dimension(820, 600));
		mapui.setPreferredSize(new Dimension(820, 600));
		add(mapui);				//adds the panel
		
		JLabel playerTurnLabel = new JLabel("MULE Menu");
		playerTurnLabel.setFont(new Font("Verdana", Font.BOLD, 25));
		playerTurnLabel.setForeground(Color.LIGHT_GRAY);
		playerTurnLabel.setBounds(16, 45, 163, 32);
		add(playerTurnLabel);
		btnFoodMule.setFont(new Font("Verdana", Font.BOLD, 16));
		
		btnFoodMule.setBorder(new LineBorder(Color.BLACK,2));
		btnFoodMule.addActionListener(new ActionListener() {
			//create action listener
			public void actionPerformed(ActionEvent e) {
				selectedMule = Resource.FOOD;
				lastSelected = currentSelected;
				lastSelected.setBorder(null);
				currentSelected = btnFoodMule;
				currentSelected.setBorder(new LineBorder(Color.BLACK,2));
			}
		});
		btnFoodMule.setBounds(191, 35, 139, 58);
		add(btnFoodMule);
		btnEnergyMule.setFont(new Font("Verdana", Font.BOLD, 16));
		
		btnEnergyMule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedMule = Resource.ENERGY;
				lastSelected = currentSelected;
				lastSelected.setBorder(null);
				currentSelected = btnEnergyMule;
				currentSelected.setBorder(new LineBorder(Color.BLACK,2));
			}
		});
		btnEnergyMule.setBounds(348, 36, 139, 58);
		add(btnEnergyMule);
		btnOreMule.setFont(new Font("Verdana", Font.BOLD, 16));
		
		btnOreMule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedMule = Resource.ORE;
				lastSelected = currentSelected;
				lastSelected.setBorder(null);
				currentSelected = btnOreMule;
				currentSelected.setBorder(new LineBorder(Color.BLACK,2));
			}
		});
		btnOreMule.setBounds(499, 36, 139, 58);
		add(btnOreMule);
		btnGoBack.setFont(new Font("Verdana", Font.BOLD, 16));
		btnGoBack.setPreferredSize(new Dimension(170, 58));
		btnGoBack.setSize(new Dimension(170, 58));
		
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.cardChangeTo("Store");
			}
		});
		btnGoBack.setBounds(793, 36, 139, 58);
		add(btnGoBack);
		btnConfirm.setSize(new Dimension(170, 58));
		btnConfirm.setFont(new Font("Verdana", Font.BOLD, 16));
		
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(parent.getGame().getCurrentPlayer().getMoney()<store.getMulePrice(selectedMule)){
					System.out.println("Insufficient Funds");
					parent.cardChangeTo("Store");
				}
				
				else if(mapui.getCurrentTile().getOwner() != parent.getGame().getCurrentPlayer()){
					System.out.println("You Do Not Own This Tile");
					System.out.println("You paid for the MULE anyways");
					System.out.println("The MULE ran away!");
					parent.getGame().getCurrentPlayer().updateMoney(store.getMulePrice(selectedMule));
					parent.cardChangeTo("Store");
				}
				
				else{
					if(null == mapui.getCurrentTile().getMule()){
						System.out.println("" + parent.getGame().getCurrentPlayer().getName() + " placed a " + selectedMule.toString() + " MULE on Tile " + mapui.getCurrentTile().getTileIndex());
						parent.getGame().getStore().buyMULE(selectedMule, parent.getGame().getCurrentPlayer(), mapui.getCurrentTile());
						parent.cardChangeTo("Store");
					} else {
						System.out.println(parent.getGame().getCurrentPlayer().getName() + " already has a MULE here, your new MULE ran away!");
					}
				}
			}
		});
		btnConfirm.setBounds(650, 36, 131, 58);
		add(btnConfirm);

	}


	public void setParent(GameScreenUI gameScreenUI) {
		parent = gameScreenUI;
	}


	public MapUI getMapUI() {
		return mapui;
	}
	
	public void setMapUI(MapUI m){
		mapui = m;
	}
}
