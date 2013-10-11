package edu.gatech.spamr.view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		comboBox.setBounds(47, 117, 103, 20);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Verdana", Font.BOLD, 11));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"4 Human Players", "3 Human Players", "2 Human Players"}));
		comboBox_1.setBounds(47, 209, 156, 20);
		add(comboBox_1);
		
		//label
		JLabel lblMapSelection = new JLabel("Map Selection");
		lblMapSelection.setFont(new Font("Verdana", Font.BOLD, 11));
		lblMapSelection.setBounds(47, 92, 103, 14);
		add(lblMapSelection);
		
		JLabel lblPlayerCount = new JLabel("Player Count");
		lblPlayerCount.setFont(new Font("Verdana", Font.BOLD, 11));
		lblPlayerCount.setBounds(45, 184, 117, 14);
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
                System.out.println("You clicked the Continue button");
            }
        });
		
		
		
	}
}