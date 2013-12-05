package edu.gatech.spamr.view;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.gatech.spamr.model.Game;
import edu.gatech.spamr.model.Player;
import edu.gatech.spamr.model.Store;
import edu.gatech.spamr.model.Game.Difficulty;
import edu.gatech.spamr.model.Store.Resource;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

/** 
 * The StoreUI class creates a panel for the player to buy/sell items  
 * 
 * @author Sean Lachenberg
 * @author Aditya Mittal
 * @author Mike Vail
 * @author Puja Sheth
 * @author Raj Prateek
 * @version 1.0 11/05/2013 
 */

public class StoreUI extends JPanel{
	
	private GameScreenUI parent;
	private Resource selected = Resource.FOOD;
	
	/**
	 * StoreUI panel to create the store in which the player can buy/sell items
	 */
	
	public StoreUI(){
		setPreferredSize(new Dimension(1280, 751));
		setBackground(Color.LIGHT_GRAY);
	
		setLayout(null);
		JLabel store =  new JLabel("STORE",JLabel.CENTER);	
		store.setBounds(-16, 6, 845, 48);
		
		store.setFont(new Font("Serif", Font.BOLD, 48));
		
		add(store);

		
		

		ImageIcon foodIcon = new ImageIcon(StoreUI.class.getResource("/edu/gatech/spamr/resources/potter/FOOD.png"));


		JButton foodButton = new JButton(foodIcon);
		foodButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selected = Resource.FOOD;
			}//actionPerformed
		});
		foodButton.setSize(352, 278);
		foodButton.setLocation(33, 118);

//		foodButton.setSize(316, 267);
//		foodButton.setLocation(148, 89);

		add(foodButton);
		

		ImageIcon energyIcon = new ImageIcon(StoreUI.class.getResource("/edu/gatech/spamr/resources/potter/ENERGY.jpg"));

		JButton energyButton = new JButton(energyIcon);
		energyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selected = Resource.ENERGY;
			}
		});

		energyButton.setSize(370, 278);
		energyButton.setLocation(420, 118);

//		energyButton.setSize(410, 353);
//		energyButton.setLocation(536, 61);

		add(energyButton);
		
		ImageIcon oreIcon = new ImageIcon(StoreUI.class.getResource("/edu/gatech/spamr/resources/potter/Collectible-Harry-Potter-Sorcerers-Stone1.jpg"));
		JButton oreButton = new JButton(oreIcon);
		oreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selected = Resource.ORE;
			}
		});

		oreButton.setSize(352, 218);
		oreButton.setLocation(33, 455);

//		oreButton.setSize(344, 279);
//		oreButton.setLocation(163, 412);

		add(oreButton);
		
		ImageIcon muleIcon = new ImageIcon(StoreUI.class.getResource("/edu/gatech/spamr/resources/potter/Thestral_on_land.gif"));
		JButton muleButton = new JButton(muleIcon);
		muleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.cardChangeTo("Mule");
				
				/*JDialog dialog = new JDialog();
				dialog.setPreferredSize(new Dimension(400,400));
				dialog.setVisible(true);
				dialog.setLayout(new FlowLayout());
				JButton energyMule = new JButton("Energy Mule");
				JButton foodMule = new JButton("Food Mule");
				JButton oreMule = new JButton("Ore Mule");
				dialog.add(energyMule);
				dialog.add(foodMule);
				dialog.add(oreMule);
				energyMule.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//selected = "ENERGY MULE";
					}
					
				});
				foodMule.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//selected = "FOOD MULE";
					}
					
				});
				oreMule.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//selected = "ORE MULE";
					}
					
				});*/
								
			}
		});

		muleButton.setSize(383, 218);
		muleButton.setLocation(409, 455);

//		muleButton.setSize(316, 248);
//		muleButton.setLocation(598, 443);

		add(muleButton);

		
		JButton backbutton = new JButton("GO BACK");
		backbutton.setBounds(667, 689, 155, 60);
		add(backbutton);
		
		JButton sellButton = new JButton("SELL");
		sellButton.setBounds(390, 689, 155, 60);
		add(sellButton);
		
		JButton buyButton = new JButton("BUY");
		buyButton.setBounds(162, 688, 155, 63);
		add(buyButton);
		buyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//looks at which resource is selected (defaulted at food normally)
				if(selected.equals(Resource.FOOD)) {
					System.out.println(parent.getGame().getCurrentPlayer().getName() + "'s current Food: " + parent.getGame().getCurrentPlayer().getFoodQuantity());
					System.out.println(parent.getGame().getCurrentPlayer().getName() + "'s current Money: " + parent.getGame().getCurrentPlayer().getMoney());
					System.out.println("Store's current Food: " + parent.getGame().getStore().getFoodQuantity());
					if(parent.getGame().getStore().getFoodQuantity() > 0){
						if(parent.getGame().getCurrentPlayer().getMoney() >= parent.getGame().getStore().getFoodQuantity()){
							parent.getGame().getStore().buyResource(parent.getGame().getCurrentPlayer(), Resource.FOOD, 1);
						}//money
					}//quantity	
					System.out.println(parent.getGame().getCurrentPlayer().getName() + "'s Food after purchase: " + parent.getGame().getCurrentPlayer().getFoodQuantity());
					System.out.println(parent.getGame().getCurrentPlayer().getName() + "'s Money after purchase: " + parent.getGame().getCurrentPlayer().getMoney());
					System.out.println("Store's Food after purchase: " + parent.getGame().getStore().getFoodQuantity());
					
				} else if(selected.equals(Resource.ENERGY)) {
					if(parent.getGame().getStore().getEnergyQuantity() > 0){
						System.out.println(parent.getGame().getCurrentPlayer().getName() + "'s current Energy: " + parent.getGame().getCurrentPlayer().getEnergyQuantity());
						System.out.println(parent.getGame().getCurrentPlayer().getName() + "'s current Money: " + parent.getGame().getCurrentPlayer().getMoney());
						System.out.println("Store's current Energy: " + parent.getGame().getStore().getEnergyQuantity());
						if(parent.getGame().getCurrentPlayer().getMoney() >= parent.getGame().getStore().getEnergyQuantity()){
							parent.getGame().getStore().buyResource(parent.getGame().getCurrentPlayer(), Resource.ENERGY, 1);
						}//money
					}//quantity
					System.out.println(parent.getGame().getCurrentPlayer().getName() + "'s Energy after purchase: " + parent.getGame().getCurrentPlayer().getEnergyQuantity());
					System.out.println(parent.getGame().getCurrentPlayer().getName() + "'s Money after purchase: " + parent.getGame().getCurrentPlayer().getMoney());
					System.out.println("Store's Energy after purchase: " + parent.getGame().getStore().getEnergyQuantity());
					
				} else if(selected.equals(Resource.ORE)) {
					System.out.println(parent.getGame().getCurrentPlayer().getName() + "'s current Ore: " + parent.getGame().getCurrentPlayer().getOreQuantity());
					System.out.println(parent.getGame().getCurrentPlayer().getName() + "'s current Money: " + parent.getGame().getCurrentPlayer().getMoney());
					System.out.println("Store's current Ore: " + parent.getGame().getStore().getOreQuantity());
					if(parent.getGame().getStore().getOreQuantity() > 0){
						if(parent.getGame().getCurrentPlayer().getMoney() >= parent.getGame().getStore().getOreQuantity()){
							parent.getGame().getStore().buyResource(parent.getGame().getCurrentPlayer(), Resource.ORE, 1);
						}//money
					}//quantity
					System.out.println(parent.getGame().getCurrentPlayer().getName() + "'s Ore after purchase: " + parent.getGame().getCurrentPlayer().getOreQuantity());
					System.out.println(parent.getGame().getCurrentPlayer().getName() + "'s Money after purchase: " + parent.getGame().getCurrentPlayer().getMoney());
					System.out.println("Store's Ore after purchase: " + parent.getGame().getStore().getOreQuantity());
	
				} else {
					System.out.println("Invalid Resource Selected?");
				}
			}
		});
		sellButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//switches between what resource is being sold
				if(selected.equals(Resource.FOOD)) {
					
					System.out.println(parent.getGame().getCurrentPlayer().getName() + "'s current Food: " + parent.getGame().getCurrentPlayer().getFoodQuantity());
					System.out.println(parent.getGame().getCurrentPlayer().getName() + "'s current Money: " + parent.getGame().getCurrentPlayer().getMoney());
					System.out.println("Store's current Food: " + parent.getGame().getStore().getFoodQuantity());
					
					if(parent.getGame().getCurrentPlayer().getFoodQuantity() > 0){
						parent.getGame().getStore().sellResource(parent.getGame().getCurrentPlayer(), Resource.FOOD, 1);
					}//quantity
					
					System.out.println(parent.getGame().getCurrentPlayer().getName() + "'s Food after selling: " + parent.getGame().getCurrentPlayer().getFoodQuantity());
					System.out.println(parent.getGame().getCurrentPlayer().getName() + "'s Money after selling: " + parent.getGame().getCurrentPlayer().getMoney());
					System.out.println("Store's Food after selling: " + parent.getGame().getStore().getFoodQuantity());
					
				} else if(selected.equals(Resource.ENERGY)) {
					
					System.out.println(parent.getGame().getCurrentPlayer().getName() + "'s current Energy: " + parent.getGame().getCurrentPlayer().getEnergyQuantity());
					System.out.println(parent.getGame().getCurrentPlayer().getName() + "'s current Money: " + parent.getGame().getCurrentPlayer().getMoney());
					System.out.println("Store's current Energy: " + parent.getGame().getStore().getEnergyQuantity());
					
					if(parent.getGame().getCurrentPlayer().getEnergyQuantity() > 0){
						parent.getGame().getStore().sellResource(parent.getGame().getCurrentPlayer(), Resource.ENERGY, 1);
					}//quantity
					
					System.out.println(parent.getGame().getCurrentPlayer().getName() + "'s Energy after selling: " + parent.getGame().getCurrentPlayer().getEnergyQuantity());
					System.out.println(parent.getGame().getCurrentPlayer().getName() + "'s Money after selling: " + parent.getGame().getCurrentPlayer().getMoney());
					System.out.println("Store's Energy after selling: " + parent.getGame().getStore().getEnergyQuantity());
					
				} else if(selected.equals(Resource.ORE)) {
					
					System.out.println(parent.getGame().getCurrentPlayer().getName() + "'s current Ore: " + parent.getGame().getCurrentPlayer().getOreQuantity());
					System.out.println(parent.getGame().getCurrentPlayer().getName() + "'s current Money: " + parent.getGame().getCurrentPlayer().getMoney());
					System.out.println("Store's current Ore: " + parent.getGame().getStore().getOreQuantity());
					
					if(parent.getGame().getCurrentPlayer().getOreQuantity() > 0){
						parent.getGame().getStore().sellResource(parent.getGame().getCurrentPlayer(), Resource.ORE, 1);
					}//quantity
					
					System.out.println(parent.getGame().getCurrentPlayer().getName() + "'s Ore after selling: " + parent.getGame().getCurrentPlayer().getOreQuantity());
					System.out.println(parent.getGame().getCurrentPlayer().getName() + "'s Money after selling: " + parent.getGame().getCurrentPlayer().getMoney());
					System.out.println("Store's Ore after selling: " + parent.getGame().getStore().getOreQuantity());
					
				} else {
					System.out.println("somehow you messed up selling a resource?");
				}
			} //listener
		});
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