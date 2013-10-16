package edu.gatech.spamr.view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TitleScreenUI extends JPanel {

	private MainAppView parent;
	
	public void setParent(MainAppView main){
		parent = main;
	}
	
	/**
	 * Create the panel.
	 */
	public TitleScreenUI() {
		setPreferredSize(new Dimension(800, 600));
		setMinimumSize(new Dimension(800, 600));
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MULE: SPAMR Edition");
		lblNewLabel.setBounds(222, 209, 359, 38);
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 30));
		add(lblNewLabel);
		
		JButton btnStart = new JButton("START");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				parent.setUpConfigDialog();
			}
		});
		btnStart.setFont(new Font("Verdana", Font.BOLD, 18));
		btnStart.setBounds(338, 369, 132, 54);
		add(btnStart);

	}
}
