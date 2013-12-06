package edu.gatech.spamr.view;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JLabel;

import edu.gatech.spamr.model.Game;
import edu.gatech.spamr.model.Player;

import java.awt.Font;

public class StatPanel extends JPanel {
	
	private static StatPanel instance = null;

	GameScreenUI parent;
	
	private LinkedList<String> msgQueue = new LinkedList<String>();
	
	//Messages
	JLabel msg1;
	JLabel msg2;
	JLabel msg3;
	JLabel msg4;
	JLabel msg5;

	JLabel playerLabel;
	JLabel playerMoney;
	JLabel playerFood;
	JLabel playerEnergy;
	JLabel playerOre;

	
	
	/**
	 * Create the panel.
	 */
	private StatPanel() {
		setMinimumSize(new Dimension(300, 800));
		setMaximumSize(new Dimension(300, 800));
		setPreferredSize(new Dimension(300, 684));
		setLayout(null);

		JLabel playerInfo = new JLabel("Player Info");
		playerInfo.setFont(new Font("Verdana", Font.BOLD, 13));
		playerInfo.setBounds(93, 5, 95, 33);
		add(playerInfo);
		
		playerLabel = new JLabel("Player");
		playerLabel.setFont(new Font("Verdana", Font.PLAIN, 13));
		playerLabel.setBounds(12, 40, 276, 22);
		add(playerLabel);
		
		playerMoney = new JLabel("Player Money");
		playerMoney.setFont(new Font("Verdana", Font.PLAIN, 13));
		playerMoney.setBounds(12, 65, 276, 22);
		add(playerMoney);
		
		playerFood = new JLabel("Player Food");
		playerFood.setFont(new Font("Verdana", Font.PLAIN, 13));
		playerFood.setBounds(12, 90, 276, 22);
		add(playerFood);
		
		playerEnergy = new JLabel("Player Energy");
		playerEnergy.setFont(new Font("Verdana", Font.PLAIN, 13));
		playerEnergy.setBounds(12, 115, 276, 22);
		add(playerEnergy);
		
		playerOre = new JLabel("Player Ore");
		playerOre.setFont(new Font("Verdana", Font.PLAIN, 13));
		playerOre.setBounds(12, 140, 276, 22);
		add(playerOre);
		
		JLabel messages = new JLabel("Messages");
		messages.setFont(new Font("Verdana", Font.PLAIN, 13));
		messages.setBounds(103, 207, 85, 34);
		add(messages);
		
		msg1 = new JLabel("Message 1");
		msg1.setFont(new Font("Verdana", Font.PLAIN, 13));
		msg1.setBounds(12, 246, 276, 47);
		add(msg1);
		
		msg2 = new JLabel("Message 2");
		msg2.setFont(new Font("Verdana", Font.PLAIN, 13));
		msg2.setBounds(12, 304, 276, 47);
		add(msg2);
		
		msg3 = new JLabel("Message 3");
		msg3.setFont(new Font("Verdana", Font.PLAIN, 13));
		msg3.setBounds(12, 362, 276, 47);
		add(msg3);
		
		msg4 = new JLabel("Message 4");
		msg4.setFont(new Font("Verdana", Font.PLAIN, 13));
		msg4.setBounds(12, 420, 276, 47);
		add(msg4);
		
		msg5 = new JLabel("Message 5");
		msg5.setFont(new Font("Verdana", Font.PLAIN, 13));
		msg5.setBounds(12, 478, 276, 47);
		add(msg5);
		
	}
	
	public static StatPanel getInstance(){
		if(instance == null)
			instance = new StatPanel();
		return instance;
	}
	
	public void setParent(GameScreenUI gcui){
		parent=gcui;
	}
	public void updateStats(Player p){
		playerLabel.setText(p.getName());	
		playerMoney.setText("$" + p.getMoney());
		playerFood.setText("Food: " + p.getFoodQuantity());
		playerEnergy.setText("Energy: " + p.getEnergyQuantity());
		playerOre.setText("Ore: " + p.getOreQuantity());
	}
	
	public void queueMsg(String msg){
		
		msg = "<html>" + msg + "<html>";
		
		msgQueue.addFirst(msg);
		
		msg1.setText(msgQueue.get(0));
		
		if(msgQueue.size()>=2)
			msg2.setText(msgQueue.get(1));
		
		if(msgQueue.size()>=3)
			msg3.setText(msgQueue.get(2));
		
		if(msgQueue.size()>=4)
			msg4.setText(msgQueue.get(3));
		
		if(msgQueue.size()>=5)
			msg5.setText(msgQueue.get(4));
	}
	
}
