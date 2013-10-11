package edu.gatech.spamr.view;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import edu.gatech.spamr.model.Player;
import edu.gatech.spamr.model.Player.Difficulty;
import edu.gatech.spamr.model.Player.Race;

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

import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class PlayerConfigUI extends JPanel {
	private final ButtonGroup SelectPlayer = new ButtonGroup();
	private final ButtonGroup SelectRace = new ButtonGroup();
	private JTextField textField;
	private Player player1, player2, player3, player4;
	private Player selectedPlayer = null;
	
	private Player getSelectedPlayer(){
		return selectedPlayer;
	}

	/**
	 * Create the panel.
	 */
	public PlayerConfigUI() {
		setMinimumSize(new Dimension(309, 336));

		setPreferredSize(new Dimension(382, 369));

		setPreferredSize(new Dimension(309, 363));

		setBackground(Color.DARK_GRAY);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setName("Player Configuration");
		setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Verdana", Font.BOLD, 8));
		comboBox.setModel(new DefaultComboBoxModel(Difficulty.values()));
		comboBox.setBounds(203, 290, 76, 22);
		add(comboBox);
		
		JButton Mechtron = new JButton("");
		Mechtron.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/MULE_Mechtron.png")));
		SelectRace.add(Mechtron);
		Mechtron.setBackground(new Color(0, 0, 0));
		Mechtron.setActionCommand("");
		Mechtron.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getSelectedPlayer().setRace(Race.MECHTRON);
				System.out.println("Mechtron Selected");
			}
		});
		Mechtron.setBounds(30, 30, 76, 71);
		add(Mechtron);
		
		JToggleButton button = new JToggleButton("Color");
		button.setFont(new Font("Verdana", Font.BOLD, 11));
		button.setForeground(Color.BLUE);
		button.setBackground(Color.BLACK);
		button.setActionCommand("");
		button.setBounds(116, 112, 76, 71);
		add(button);
		
		JButton Spheroid = new JButton("");
		Spheroid.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/MULE_Spheroid.png")));
		SelectRace.add(Spheroid);
		Spheroid.setBackground(new Color(0, 0, 0));
		Spheroid.setActionCommand("");
		Spheroid.setBounds(202, 112, 76, 71);
		add(Spheroid);
		
		JButton Bonzoid = new JButton("");
		Bonzoid.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/MULE_Bonzoid.png")));
		SelectRace.add(Bonzoid);
		Bonzoid.setBackground(new Color(0, 0, 0));
		Bonzoid.setActionCommand("");
		Bonzoid.setBounds(30, 112, 76, 71);
		add(Bonzoid);
		
		JButton Gollumer = new JButton("");
		Gollumer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getSelectedPlayer().setRace(Race.GOLLUMER);
			}
		});
		Gollumer.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/MULE_Gollumer.png")));
		SelectRace.add(Gollumer);
		Gollumer.setBackground(new Color(0, 0, 0));
		Gollumer.setActionCommand("");
		Gollumer.setBounds(116, 30, 76, 71);
		add(Gollumer);
		
		JButton Packer = new JButton("");
		Packer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getSelectedPlayer().setRace(Race.PACKER);
			}
		});
		SelectRace.add(Packer);
		Packer.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/MULE_Packer.png")));
		Packer.setBackground(new Color(0, 0, 0));
		Packer.setActionCommand("");
		Packer.setBounds(202, 30, 76, 71);
		add(Packer);
		
		JButton Flapper = new JButton("");
		Flapper.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/MULE_Flapper.png")));
		SelectRace.add(Flapper);
		Flapper.setBackground(new Color(0, 0, 0));
		Flapper.setActionCommand("");
		Flapper.setBounds(30, 194, 76, 71);
		add(Flapper);
		
		JButton Leggite = new JButton("");
		SelectRace.add(Leggite);
		Leggite.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/MULE_Leggite.png")));
		Leggite.setBackground(new Color(0, 0, 0));
		Leggite.setActionCommand("");
		Leggite.setBounds(116, 194, 76, 71);
		add(Leggite);
		
		JButton Humanoid = new JButton("");
		Humanoid.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/MULE_Humanoid.png")));
		SelectRace.add(Humanoid);
		Humanoid.setBackground(new Color(0, 0, 0));
		Humanoid.setActionCommand("");
		Humanoid.setBounds(202, 194, 76, 71);
		add(Humanoid);
		
		final JRadioButton Player1 = new JRadioButton("1");
		Player1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Player1.isEnabled()){
					selectedPlayer = player1;
			}
		}});
		Player1.setForeground(Color.LIGHT_GRAY);
		Player1.setBackground(Color.DARK_GRAY);
		Player1.setFont(new Font("Verdana", Font.BOLD, 8));
		SelectPlayer.add(Player1);
		Player1.setBounds(18, 298, 43, 23);
		add(Player1);
		
		final JRadioButton Player2 = new JRadioButton("2");
		Player2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Player2.isEnabled()){
					selectedPlayer = player2;
				}
			}
		});
		Player2.setForeground(Color.LIGHT_GRAY);
		Player2.setBackground(Color.DARK_GRAY);
		Player2.setFont(new Font("Verdana", Font.BOLD, 8));
		SelectPlayer.add(Player2);
		Player2.setBounds(63, 298, 43, 23);
		add(Player2);
		
		final JRadioButton Player3 = new JRadioButton("3");
		Player3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Player3.isEnabled()){
					selectedPlayer = player3;
				}
				System.out.println(selectedPlayer.getName());
			}
		});
		Player3.setForeground(Color.LIGHT_GRAY);
		Player3.setBackground(Color.DARK_GRAY);
		Player3.setFont(new Font("Verdana", Font.BOLD, 8));
		SelectPlayer.add(Player3);
		Player3.setBounds(105, 298, 43, 23);
		add(Player3);
		
		final JRadioButton Player4 = new JRadioButton("4");
		Player4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Player4.isEnabled()){
					selectedPlayer = player4;
				}
			}
		});
		Player4.setForeground(Color.LIGHT_GRAY);
		Player4.setBackground(Color.DARK_GRAY);
		Player4.setFont(new Font("Verdana", Font.BOLD, 8));
		SelectPlayer.add(Player4);
		Player4.setBounds(148, 298, 43, 23);
		add(Player4);
		
		JButton btnNewButton_1 = new JButton("Confirm");
		btnNewButton_1.setFont(new Font("Verdana", Font.BOLD, 9));
		btnNewButton_1.setActionCommand("Confirm");
		btnNewButton_1.setBounds(203, 329, 76, 23);
		add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(104, 330, 88, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblPlayerName = new JLabel("Player Name:");
		lblPlayerName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPlayerName.setLabelFor(textField);
		lblPlayerName.setForeground(Color.LIGHT_GRAY);
		lblPlayerName.setFont(new Font("Verdana", Font.BOLD, 9));
		lblPlayerName.setBounds(18, 333, 76, 14);
		add(lblPlayerName);
		
		JLabel lblNewLabel = new JLabel("Choose Player number:\n");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 9));
		lblNewLabel.setBounds(18, 277, 133, 22);
		add(lblNewLabel);
		

	}
	
}
