package edu.gatech.spamr.view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;

public class GameConfigUI extends JPanel {

	/**
	 * Create the panel.
	 */
	public GameConfigUI() {
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Default Map", "Other Map"}));
		comboBox.setFont(new Font("Verdana", Font.BOLD, 11));
		comboBox.setBounds(73, 153, 103, 20);
		add(comboBox);

	}

}
