package edu.gatech.spamr.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import edu.gatech.spamr.model.Game;
import edu.gatech.spamr.model.Player;
import edu.gatech.spamr.model.Timer;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Dialog.ModalityType;

public class StartTurnDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JLabel lblPlayer = new JLabel();
	private TurnScreenUI parent;

	/**
	 * Launch the application. Never runs in normal application
	 */
	public static void main(String[] args) {
		try {
			StartTurnDialog dialog = new StartTurnDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setCurrentPlayerText(Game.getCurrentPlayer().getName()); //updating string to print
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public StartTurnDialog() {
		
		//dialog box basics
		setMinimumSize(new Dimension(420, 260));
		setSize(new Dimension(420, 260));
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setName("Player Turn");
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		//Current Player label
		JLabel lblCurrentPlayer = new JLabel("Current Player:");
		lblCurrentPlayer.setFont(new Font("Verdana", Font.BOLD, 18));
		lblCurrentPlayer.setBounds(123, 11, 198, 40);
		contentPanel.add(lblCurrentPlayer);
		
		//player name label
		lblPlayer.setFont(new Font("Verdana", Font.BOLD, 18));
		lblPlayer.setBounds(123, 56, 198, 47);
		contentPanel.add(lblPlayer);
		
		//go button
		JButton btnNewButton = new JButton("GO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Pressed GO");
				Game.setTurnTimer(new Thread(new Timer()));
				Game.getTurnTimer().start(); //starts timer
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 16));
		btnNewButton.setBounds(123, 146, 198, 80); //(168, 142, 101, 82);
		contentPanel.add(btnNewButton);
	}
	
	public void setCurrentPlayerText(String current){
		lblPlayer.setText(current);
	}
	
	public void setParent(TurnScreenUI turnui){
		parent = turnui;
	}
}
