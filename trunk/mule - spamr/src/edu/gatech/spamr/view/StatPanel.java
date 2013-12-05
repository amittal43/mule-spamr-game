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
		//parent=gcui;
		setMinimumSize(new Dimension(300, 800));
		setMaximumSize(new Dimension(300, 800));
		setPreferredSize(new Dimension(300, 684));
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Player Info");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel.setBounds(93, 5, 95, 33);
		add(lblNewLabel);
		/*
		playerLabel = new JLabel("Current Player: " + currentPlayer);
		playerLabel.setFont(new Font("Verdana", Font.PLAIN, 13));
		playerLabel.setBounds(12, 51, 198, 33);
		if(currentPlayer.equals(parent.getGame().getPlayer1())){
			currentPlayer = parent.getGame().getPlayer2();
			playerLabel.setText("Current Player: " + currentPlayer.getName());
			add(playerLabel);
		}
		else if(currentPlayer.equals(parent.getGame().getPlayer2())){
			currentPlayer = parent.getGame().getPlayer3();
			playerLabel.setText("Current Player: " +currentPlayer.getName());
			add(playerLabel);
		}
		else if(currentPlayer.equals(parent.getGame().getPlayer3())){
			currentPlayer = parent.getGame().getPlayer4();
			playerLabel.setText("Current Player: " +currentPlayer.getName());
			add(playerLabel);
		}
		

		currentPlayer = parent.getGame().getPlayer1();
		String name = currentPlayer.getName();
		JLabel playerLabel = new JLabel(parent.getGame().getPlayer1().getName());
		lblNewLabel_1 = new JLabel("Current Player :"+name);
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(12, 51, 198, 33);
		add(lblNewLabel_1);
		add(playerLabel);
		
		int money = currentPlayer.getMoney();
		lblNewLabel_2 = new JLabel("Money :" + money);
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(12, 85, 95, 27);
		add(lblNewLabel_2);
		*/
		
	/*	//currentp=parent.getGame().getCurrentPlayer();
		// player = currentp.getName();
//		String p2 = parent.getGame().p2.getName();
//		String p3 = parent.getGame().p3.getName();
//		String p4 = parent.getGame().p4.getName();
		 lblNewLabel_1 = new JLabel("Current Player :"+player);
		 lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(12, 51, 191, 22);
		add(lblNewLabel_1);
		
		 lblNewLabel_2 = new JLabel("Money :");
		 lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(22, 86, 66, 16);
		add(lblNewLabel_2);
		 money= Integer.toString(currentp.getMoney());
		 lblNewLabel_3 = new JLabel(money);
		 lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(189, 86, 56, 16);
		add(lblNewLabel_3);
		
		 lblNewLabel_4 = new JLabel("Energy :");
		 lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(21, 109, 67, 16);
		add(lblNewLabel_4);
		 energy= Integer.toString(currentp.getEnergy());
		 lblNewLabel_5 = new JLabel(energy);
		 lblNewLabel_5.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(189, 106, 56, 22);
		add(lblNewLabel_5);

		 lblNewLabel_6 = new JLabel("Ore :");
		 lblNewLabel_6.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(22, 129, 66, 16);
		add(lblNewLabel_6);
		ore= Integer.toString(currentp.getOre());
		lblNewLabel_7 = new JLabel(ore);
		lblNewLabel_7.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(189, 129, 56, 16);
		add(lblNewLabel_7);
		
		 lblNewLabel_8 = new JLabel("Food :");
		 lblNewLabel_8.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_8.setBounds(22, 151, 56, 16);
		add(lblNewLabel_8);
		 food= Integer.toString(currentp.getFood());
		lblNewLabel_9 = new JLabel(food);
		lblNewLabel_9.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_9.setBounds(189, 148, 56, 22);
		add(lblNewLabel_9);
		
		*/
		
		
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
	public void updateStats(){
		money= Integer.toString(currentPlayer.getMoney());
		lblNewLabel_3 = new JLabel(money);
		energy= Integer.toString(currentPlayer.getEnergy());
		lblNewLabel_5 = new JLabel(energy);
		ore= Integer.toString(currentPlayer.getOre());
		lblNewLabel_7 = new JLabel(ore);
		food= Integer.toString(currentPlayer.getFood());
		lblNewLabel_9 = new JLabel(food);		
	}
	public void queueMsg(String msg){
		msgQueue.addFirst(msg);
		msg1.setText(msgQueue.getFirst());
		msg2.setText(msgQueue.get(1));
		msg3.setText(msgQueue.get(2));
		msg4.setText(msgQueue.get(3));
		msg5.setText(msgQueue.get(4));
	}
	
	
}
