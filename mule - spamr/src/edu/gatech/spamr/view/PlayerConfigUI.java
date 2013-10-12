package edu.gatech.spamr.view;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import edu.gatech.spamr.model.Player;
import edu.gatech.spamr.model.Player.Difficulty;
import edu.gatech.spamr.model.Player.PlayerColor;
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
	private JTextField PlayerName;
	private Player player1 = new Player();
	private Player player2 = new Player();
	private Player player3 = new Player();
	private Player player4 = new Player();
	private Player selectedPlayer = player1;
	private PlayerColor currentColor = PlayerColor.BLUE;
	private Race currentRace = Race.HUMANOID;
	
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
		
		JComboBox DifficultyComboBox = new JComboBox();
		DifficultyComboBox.setFont(new Font("Verdana", Font.BOLD, 8));
		DifficultyComboBox.setModel(new DefaultComboBoxModel(Difficulty.values()));
		DifficultyComboBox.setBounds(203, 290, 76, 22);
		add(DifficultyComboBox);
		
		final JButton Mechtron = new JButton("");
		Mechtron.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/MULE_Mechtron.png")));
		SelectRace.add(Mechtron);
		Mechtron.setBackground(new Color(0, 0, 0));
		Mechtron.setActionCommand("");
		Mechtron.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				currentRace = Race.MECHTRON;
			}
		});
		Mechtron.setBounds(30, 30, 76, 71);
		add(Mechtron);
		
		final JButton Spheroid = new JButton("");
		Spheroid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				currentRace = Race.SPHEROID;
			}
		});
		Spheroid.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/MULE_Spheroid.png")));
		SelectRace.add(Spheroid);
		Spheroid.setBackground(new Color(0, 0, 0));
		Spheroid.setActionCommand("");
		Spheroid.setBounds(202, 112, 76, 71);
		add(Spheroid);
		
		final JButton Bonzoid = new JButton("");
		Bonzoid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				currentRace = Race.BONZOID;
			}
		});
		Bonzoid.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/MULE_Bonzoid.png")));
		SelectRace.add(Bonzoid);
		Bonzoid.setBackground(new Color(0, 0, 0));
		Bonzoid.setActionCommand("");
		Bonzoid.setBounds(30, 112, 76, 71);
		add(Bonzoid);
		
		final JButton Gollumer = new JButton("");
		Gollumer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentRace = Race.GOLLUMER;
			}
		});
		Gollumer.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/MULE_Gollumer.png")));
		SelectRace.add(Gollumer);
		Gollumer.setBackground(new Color(0, 0, 0));
		Gollumer.setActionCommand("");
		Gollumer.setBounds(116, 30, 76, 71);
		add(Gollumer);
		
		final JButton Packer = new JButton("");
		Packer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentRace = Race.PACKER;
			}
		});
		SelectRace.add(Packer);
		Packer.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/MULE_Packer.png")));
		Packer.setBackground(new Color(0, 0, 0));
		Packer.setActionCommand("");
		Packer.setBounds(202, 30, 76, 71);
		add(Packer);
		
		final JButton Flapper = new JButton("");
		Flapper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				currentRace = Race.FLAPPER;
			}
		});
		Flapper.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/MULE_Flapper.png")));
		SelectRace.add(Flapper);
		Flapper.setBackground(new Color(0, 0, 0));
		Flapper.setActionCommand("");
		Flapper.setBounds(30, 194, 76, 71);
		add(Flapper);
		
		final JButton Leggite = new JButton("");
		Leggite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				currentRace = Race.LEGGITE;
			}
		});
		SelectRace.add(Leggite);
		Leggite.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/MULE_Leggite.png")));
		Leggite.setBackground(new Color(0, 0, 0));
		Leggite.setActionCommand("");
		Leggite.setBounds(116, 194, 76, 71);
		add(Leggite);
		
		final JButton Humanoid = new JButton("");
		Humanoid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				currentRace = Race.HUMANOID;
			}
		});
		Humanoid.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/MULE_Humanoid.png")));
		SelectRace.add(Humanoid);
		Humanoid.setBackground(new Color(0, 0, 0));
		Humanoid.setActionCommand("");
		Humanoid.setBounds(202, 194, 76, 71);
		add(Humanoid);
		
		final JButton button = new JButton("Color");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(currentColor == PlayerColor.BLUE){
					button.setBackground(Color.RED);
					currentColor = PlayerColor.RED;
					Bonzoid.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/RED/MULE_Bonzoid_Red.png")));
					Flapper.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/RED/MULE_Flapper_Red.png")));
					Gollumer.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/RED/MULE_Gollumer_Red.png")));
					Humanoid.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/RED/MULE_Humanoid_Red.png")));
					Leggite.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/RED/MULE_Leggite_Red.png")));
					Mechtron.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/RED/MULE_Mechtron_Red.png")));
					Packer.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/RED/MULE_Packer_Red.png")));
					Spheroid.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/RED/MULE_Spheroid_Red.png")));
					return;
				}
				if(currentColor == PlayerColor.RED){
					button.setBackground(Color.GREEN);
					currentColor = PlayerColor.GREEN;
					Bonzoid.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/GREEN/MULE_Bonzoid_Green.png")));
					Flapper.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/GREEN/MULE_Flapper_Green.png")));
					Gollumer.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/GREEN/MULE_Gollumer_Green.png")));
					Humanoid.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/GREEN/MULE_Humanoid_Green.png")));
					Leggite.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/GREEN/MULE_Leggite_Green.png")));
					Mechtron.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/GREEN/MULE_Mechtron_Green.png")));
					Packer.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/GREEN/MULE_Packer_Green.png")));
					Spheroid.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/GREEN/MULE_Spheroid_Green.png")));

					return;
				}
				if(currentColor == PlayerColor.GREEN){
					button.setBackground(Color.YELLOW);
					currentColor = PlayerColor.YELLOW;
					Bonzoid.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/YELLOW/MULE_Bonzoid_Yellow.png")));
					Flapper.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/YELLOW/MULE_Flapper_Yellow.png")));
					Gollumer.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/YELLOW/MULE_Gollumer_Yellow.png")));
					Humanoid.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/YELLOW/MULE_Humanoid_Yellow.png")));
					Leggite.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/YELLOW/MULE_Leggite_Yellow.png")));
					Mechtron.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/YELLOW/MULE_Mechtron_Yellow.png")));
					Packer.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/YELLOW/MULE_Packer_Yellow.png")));
					Spheroid.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/YELLOW/MULE_Spheroid_Yellow.png")));
					return;
				}
				if(currentColor == PlayerColor.YELLOW){
					button.setBackground(Color.BLUE);
					currentColor = PlayerColor.BLUE;
					Bonzoid.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/BLUE/MULE_Bonzoid_Blue.png")));
					Flapper.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/BLUE/MULE_Flapper_Blue.png")));
					Gollumer.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/BLUE/MULE_Gollumer_Blue.png")));
					Humanoid.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/BLUE/MULE_Humanoid_Blue.png")));
					Leggite.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/BLUE/MULE_Leggite_Blue.png")));
					Mechtron.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/BLUE/MULE_Mechtron_Blue.png")));
					Packer.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/BLUE/MULE_Packer_Blue.png")));
					Spheroid.setIcon(new ImageIcon(PlayerConfigUI.class.getResource("/edu/gatech/spamr/resources/BLUE/MULE_Spheroid_Blue.png")));
					return;
				}
			}
		});
		button.setFont(new Font("Verdana", Font.BOLD, 11));
		button.setForeground(Color.BLACK);
		button.setBackground(Color.BLUE);
		button.setActionCommand("");
		button.setBounds(116, 112, 76, 71);
		add(button);
		
		final JRadioButton Player1 = new JRadioButton("1");
		Player1.setSelected(true);
		Player1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					selectedPlayer = player1;
		}});
		Player1.setForeground(Color.LIGHT_GRAY);
		Player1.setBackground(Color.DARK_GRAY);
		Player1.setFont(new Font("Verdana", Font.BOLD, 8));
		SelectPlayer.add(Player1);
		Player1.setBounds(18, 298, 43, 23);
		add(Player1);
		
		final JRadioButton Player2 = new JRadioButton("2");
		Player2.setEnabled(false);
		Player2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					selectedPlayer = player2;
			}
		});
		Player2.setForeground(Color.LIGHT_GRAY);
		Player2.setBackground(Color.DARK_GRAY);
		Player2.setFont(new Font("Verdana", Font.BOLD, 8));
		SelectPlayer.add(Player2);
		Player2.setBounds(63, 298, 43, 23);
		add(Player2);
		
		final JRadioButton Player3 = new JRadioButton("3");
		Player3.setEnabled(false);
		Player3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					selectedPlayer = player3;
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
		Player4.setEnabled(false);
		Player4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					selectedPlayer = player4;
			}
		});
		Player4.setForeground(Color.LIGHT_GRAY);
		Player4.setBackground(Color.DARK_GRAY);
		Player4.setFont(new Font("Verdana", Font.BOLD, 8));
		SelectPlayer.add(Player4);
		Player4.setBounds(148, 298, 43, 23);
		add(Player4);
		
		final JButton Next = new JButton("Next");
		Next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(getSelectedPlayer().equals(player1)){
					player1.setName(PlayerName.getText());
					player1.setColor(currentColor);
					player1.setRace(currentRace);
					System.out.println("Player 1's Name: " + player1.getName());
					System.out.println("Player 1's Color: " + player1.getColor().toString());
					System.out.println("Player 1's Race: " + player1.getRace().toString());
					Player2.setEnabled(true);
					Player2.doClick();
					Player1.setEnabled(false);
					PlayerName.setText("");
					return;
				}
				if(getSelectedPlayer().equals(player2)){
					player2.setName(PlayerName.getText());
					player2.setColor(currentColor);
					player2.setRace(currentRace);
					System.out.println();
					System.out.println("Player 2's Name: " + player2.getName());
					System.out.println("Player 2's Color: " + player2.getColor().toString());
					System.out.println("Player 2's Race: " + player2.getRace().toString());
					Player3.setEnabled(true);
					Player3.doClick();
					Player2.setEnabled(false);
					PlayerName.setText("");
					return;
				}
				if(getSelectedPlayer().equals(player3)){
					player3.setName(PlayerName.getText());
					player3.setColor(currentColor);
					player3.setRace(currentRace);
					System.out.println();
					System.out.println("Player 3's Name: " + player3.getName());
					System.out.println("Player 3's Color: " + player3.getColor().toString());
					System.out.println("Player 3's Race: " + player3.getRace().toString());
					Player4.setEnabled(true);
					Player4.doClick();
					Player3.setEnabled(false);
					PlayerName.setText("");
					Next.setText("Confirm");
					return;
				}
				if(getSelectedPlayer().equals(player4)){
					player4.setName(PlayerName.getText());
					player4.setColor(currentColor);
					player4.setRace(currentRace);
					System.out.println();
					System.out.println("Player 4's Name: " + player4.getName());
					System.out.println("Player 4's Color: " + player4.getColor().toString());
					System.out.println("Player 4's Race: " + player4.getRace().toString());
				}
			}
		});
		Next.setFont(new Font("Verdana", Font.BOLD, 9));
		Next.setBounds(203, 329, 76, 23);
		add(Next);
		
		PlayerName = new JTextField();
		PlayerName.setBounds(104, 330, 88, 20);
		add(PlayerName);
		PlayerName.setColumns(10);
		
		JLabel lblPlayerName = new JLabel("Player Name:");
		lblPlayerName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPlayerName.setLabelFor(PlayerName);
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
