package edu.gatech.spamr.view;

import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Dimension;

public class GameScreenUI extends JPanel {

	/**
	 * Create the panel.
	 */
	public GameScreenUI() {
		setPreferredSize(new Dimension(800, 600));
		setMinimumSize(new Dimension(800, 600));
		setBackground(Color.DARK_GRAY);
		setLayout(new CardLayout(0, 0));
		
		JLabel lblReadyToPlay = new JLabel("Ready To Play!");
		lblReadyToPlay.setHorizontalAlignment(SwingConstants.CENTER);
		lblReadyToPlay.setForeground(Color.LIGHT_GRAY);
		lblReadyToPlay.setFont(new Font("Verdana", Font.BOLD, 24));
		add(lblReadyToPlay, "name_679395047145474");

	}

}
