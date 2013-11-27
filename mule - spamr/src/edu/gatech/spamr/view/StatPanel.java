package edu.gatech.spamr.view;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JLabel;

import edu.gatech.spamr.model.Player;
import java.awt.Font;

public class StatPanel extends JPanel {

	GameScreenUI parent;
	Player currentp;
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
	//Messages
	JLabel lblNewLabel_10;
	JLabel lblNewLabel_11;
	JLabel lblNewLabel_12;
	JLabel lblNewLabel_13;
	JLabel lblNewLabel_14;
	ArrayList<String> messages = new ArrayList<String>();
	
	/**
	 * Create the panel.
	 */
	public StatPanel(GameScreenUI gcui) {
		parent=gcui;
		setMinimumSize(new Dimension(300, 800));
		setMaximumSize(new Dimension(300, 800));
		setPreferredSize(new Dimension(300, 753));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Player Info");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel.setBounds(93, 5, 95, 33);
		add(lblNewLabel);
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
		
		JLabel lblMessages = new JLabel("Messages");
		lblMessages.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblMessages.setBounds(103, 228, 85, 34);
		add(lblMessages);
		
		lblNewLabel_10 = new JLabel("Random");
		lblNewLabel_10.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_10.setBounds(12, 275, 276, 22);
		add(lblNewLabel_10);
		
		 lblNewLabel_11 = new JLabel("New label");
		 lblNewLabel_11.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_11.setBounds(12, 304, 276, 22);
		add(lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel("New label");
		lblNewLabel_12.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_12.setBounds(12, 333, 276, 22);
		add(lblNewLabel_12);
		
		 lblNewLabel_13 = new JLabel("New label");
		 lblNewLabel_13.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_13.setBounds(12, 363, 276, 22);
		add(lblNewLabel_13);
		
		*/
	}
	public void setParent(GameScreenUI gcui){
		parent=gcui;
	}
	public void updateStats(){
		money= Integer.toString(currentp.getMoney());
		lblNewLabel_3 = new JLabel(money);
		energy= Integer.toString(currentp.getMoney());
		lblNewLabel_5 = new JLabel(money);
		ore= Integer.toString(currentp.getMoney());
		lblNewLabel_7 = new JLabel(money);
		food= Integer.toString(currentp.getMoney());
		lblNewLabel_9 = new JLabel(money);
		
	}
	public void pushMsg(String msg){
		messages.add(msg);
		
	}
}
