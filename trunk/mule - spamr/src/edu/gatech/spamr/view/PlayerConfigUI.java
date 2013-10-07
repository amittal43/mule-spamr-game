package edu.gatech.spamr.view;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import edu.gatech.spamr.model.Player.Difficulty;
import javax.swing.JTable;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class PlayerConfigUI extends JPanel {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public PlayerConfigUI() {
		setBackground(Color.DARK_GRAY);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setName("Player Configuration");
		setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(Difficulty.values()));
		comboBox.setBounds(203, 290, 76, 20);
		add(comboBox);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/MULE_Mechtron.png")));
		buttonGroup_1.add(btnNewButton);
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setActionCommand("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(30, 30, 76, 71);
		add(btnNewButton);
		
		JToggleButton button = new JToggleButton("Color");
		button.setBackground(new Color(0, 0, 0));
		button.setActionCommand("");
		button.setBounds(116, 112, 76, 71);
		add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/MULE_Spheroid.png")));
		buttonGroup_1.add(button_1);
		button_1.setBackground(new Color(0, 0, 0));
		button_1.setActionCommand("");
		button_1.setBounds(202, 112, 76, 71);
		add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/MULE_Bonzoid.png")));
		buttonGroup_1.add(button_2);
		button_2.setBackground(new Color(0, 0, 0));
		button_2.setActionCommand("");
		button_2.setBounds(30, 112, 76, 71);
		add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/MULE_Gollumer.png")));
		buttonGroup_1.add(button_3);
		button_3.setBackground(new Color(0, 0, 0));
		button_3.setActionCommand("");
		button_3.setBounds(116, 30, 76, 71);
		add(button_3);
		
		JButton button_4 = new JButton("");
		buttonGroup_1.add(button_4);
		button_4.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/MULE_Packer.png")));
		button_4.setBackground(new Color(0, 0, 0));
		button_4.setActionCommand("");
		button_4.setBounds(202, 30, 76, 71);
		add(button_4);
		
		JButton button_5 = new JButton("");
		button_5.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/MULE_Flapper.png")));
		buttonGroup_1.add(button_5);
		button_5.setBackground(new Color(0, 0, 0));
		button_5.setActionCommand("");
		button_5.setBounds(30, 194, 76, 71);
		add(button_5);
		
		JButton button_6 = new JButton("");
		buttonGroup_1.add(button_6);
		button_6.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/MULE_Leggite.png")));
		button_6.setBackground(new Color(0, 0, 0));
		button_6.setActionCommand("");
		button_6.setBounds(116, 194, 76, 71);
		add(button_6);
		
		JButton button_7 = new JButton("");
		button_7.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/MULE_Humanoid.png")));
		buttonGroup_1.add(button_7);
		button_7.setBackground(new Color(0, 0, 0));
		button_7.setActionCommand("");
		button_7.setBounds(202, 194, 76, 71);
		add(button_7);
		
		JRadioButton radioButton = new JRadioButton("1");
		buttonGroup.add(radioButton);
		radioButton.setBounds(30, 289, 31, 23);
		add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("2");
		buttonGroup.add(radioButton_1);
		radioButton_1.setBounds(75, 289, 31, 23);
		add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("3");
		buttonGroup.add(radioButton_2);
		radioButton_2.setBounds(116, 289, 31, 23);
		add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("4");
		buttonGroup.add(radioButton_3);
		radioButton_3.setBounds(161, 289, 31, 23);
		add(radioButton_3);

	}
}
