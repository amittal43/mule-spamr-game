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

public class StoreUI extends JPanel{
	
	private GameScreenUI parent;
	private Resource selected = Resource.FOOD;
	
	
	
	public StoreUI(){
		setPreferredSize((new Dimension (1280,800)));
		setBackground(Color.LIGHT_GRAY);
		JPanel buttonPanel = new JPanel(new FlowLayout());
		buttonPanel.setBounds(1000, 0, 280, 800);
		setLayout(null);
		JLabel store =  new JLabel("STORE",JLabel.CENTER);	
		store.setBounds(125, 6, 845, 48);
		
		store.setFont(new Font("Serif", Font.BOLD, 48));
		
		add(store);
		add(buttonPanel);
		
//		JButton buyMule = new JButton("BUY MULE");
//		buttonPanel.add(buyMule);
		
		ImageIcon foodIcon = new ImageIcon(StoreUI.class.getResource("/edu/gatech/spamr/resources/food-05.jpg"));
		JButton foodButton = new JButton(foodIcon);
		foodButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selected = Resource.FOOD;
			}//actionPerformed
		});
		foodButton.setSize(200, 200);
		foodButton.setLocation(230, 116);
		add(foodButton);
		
		ImageIcon energyIcon = new ImageIcon(StoreUI.class.getResource("/edu/gatech/spamr/resources/energy-drinks.jpg"));
		JButton energyButton = new JButton(energyIcon);
		energyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selected = Resource.ENERGY;
			}
		});
		energyButton.setSize(200, 200);
		energyButton.setLocation(649, 116);
		add(energyButton);
		
		ImageIcon oreIcon = new ImageIcon(StoreUI.class.getResource("/edu/gatech/spamr/resources/stone_2120340.JPG"));
		JButton oreButton = new JButton(oreIcon);
		oreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selected = Resource.ORE;
			}
		});
		oreButton.setSize(200, 200);
		oreButton.setLocation(230, 343);
		add(oreButton);
		
		ImageIcon muleIcon = new ImageIcon(StoreUI.class.getResource("/edu/gatech/spamr/resources/DARPAs-robot-mule-in-field-test.jpg"));
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
		muleButton.setSize(200, 200);
		muleButton.setLocation(649, 343);
		add(muleButton);
		
		JButton buyButton = new JButton("BUY");
		buyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//looks at which resource is selected (defaulted at food normally)
				if(selected.equals(Resource.FOOD)) {
					
					if(Game.getStore().getFoodQuantity() > 0){
						if(Game.getCurrentPlayer().getMoney() >= Game.getStore().getFoodPrice()){
							Game.getStore().buyResource(Game.getCurrentPlayer(), Resource.FOOD, 1);
						}//money
					}//quantity	
					
				} else if(selected.equals(Resource.ENERGY)) {
					if(Game.getStore().getEnergyQuantity() > 0){
						if(Game.getCurrentPlayer().getMoney() >= Game.getStore().getEnergyPrice()){
							Game.getStore().buyResource(Game.getCurrentPlayer(), Resource.ENERGY, 1);
						}//money
					}//quantity
				
				} else if(selected.equals(Resource.ORE)) {
					if(Game.getStore().getOreQuantity() > 0){
						if(Game.getCurrentPlayer().getMoney() >= Game.getStore().getOrePrice()){
							Game.getStore().buyResource(Game.getCurrentPlayer(), Resource.ORE, 1);
						}//money
					}//quantity
				}
				else {
					System.out.println("Invalid Resource Selected?");
				}
			}
		});
		buttonPanel.add(buyButton);
		
		JButton sellButton = new JButton("SELL");
		sellButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//switches between what resource is being sold
				if(selected.equals(Resource.FOOD)) {
					if(Game.getCurrentPlayer().getFood() > 0){
						Game.getStore().sellResource(Game.getCurrentPlayer(), Resource.FOOD, 1);
					}//quantity
				} else if(selected.equals(Resource.ENERGY)) {
					if(Game.getCurrentPlayer().getEnergy() > 0){
						Game.getStore().sellResource(Game.getCurrentPlayer(), Resource.ENERGY, 1);
					}//quantity
				} else if(selected.equals(Resource.ORE)) {
					if(Game.getCurrentPlayer().getOre() > 0){
						Game.getStore().sellResource(Game.getCurrentPlayer(), Resource.ORE, 1);
					}//quantity
				} else {
					System.out.println("somehow you messed up selling a resource?");
				}
			} //listener
		});
		buttonPanel.add(sellButton);
		
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