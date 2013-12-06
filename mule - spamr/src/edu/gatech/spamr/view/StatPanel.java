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

	Player currentPlayer;
	JLabel playerLabel;
	String player;
	JLabel lblNewLabel_1;
	JLabel lblNewLabel_2;
	String money;
	JLabel lblNewLabel_3;
	JLabel lblNewLabel_4;
	String energy;
	JLabel lblNewLabel_5;
	JLabel lblNewLabel_6;
	String ore;
	JLabel lblNewLabel_7;
	JLabel lblNewLabel_8;
	String food;
	JLabel lblNewLabel_9;
	
	JLabel lblNewLabel_14;
	
	
	/**
	 * Create the panel.
	 */
	private StatPanel() {
		setMinimumSize(new Dimension(300, 800));
		setMaximumSize(new Dimension(300, 800));
		setPreferredSize(new Dimension(300, 684));
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Player Info");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel.setBounds(93, 5, 95, 33);
		add(lblNewLabel);
		
		
		JLabel messages = new JLabel("Messages");
		messages.setFont(new Font("Verdana", Font.PLAIN, 13));
		messages.setBounds(103, 207, 85, 34);
		add(messages);
		
		msg1 = new JLabel("Message 1");
		msg1.setFont(new Font("Verdana", Font.PLAIN, 13));
		msg1.setBounds(12, 246, 276, 22);
		add(msg1);
		
		msg2 = new JLabel("Message 2");
		msg2.setFont(new Font("Verdana", Font.PLAIN, 13));
		msg2.setBounds(12, 275, 276, 22);
		add(msg2);
		
		msg3 = new JLabel("Message 3");
		msg3.setFont(new Font("Verdana", Font.PLAIN, 13));
		msg3.setBounds(12, 304, 276, 22);
		add(msg3);
		
		msg4 = new JLabel("Message 4");
		msg4.setFont(new Font("Verdana", Font.PLAIN, 13));
		msg4.setBounds(12, 333, 276, 22);
		add(msg4);
		
		msg5 = new JLabel("Message 5");
		msg5.setFont(new Font("Verdana", Font.PLAIN, 13));
		msg5.setBounds(12, 363, 276, 22);
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
/*	public void updateStats(){
		money= Integer.toString(currentPlayer.getMoney());
		lblNewLabel_3 = new JLabel(money);
		energy= Integer.toString(currentPlayer.getEnergyQuantity());
		lblNewLabel_5 = new JLabel(energy);
		ore= Integer.toString(currentPlayer.getOreQuantity());
		lblNewLabel_7 = new JLabel(ore);
		food= Integer.toString(currentPlayer.getFoodQuantity());
		lblNewLabel_9 = new JLabel(food);		
	}*/
	public void queueMsg(String msg){
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
