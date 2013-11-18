package edu.gatech.spamr.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoadDialog extends JDialog {

	private MainAppView parent;
	private final JPanel contentPanel = new JPanel();
	private JTextField fileNameField;

	/**
	 * Create the dialog.
	 */
	public LoadDialog(MainAppView m) {
		parent = m;
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 448, 236);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel LoadLabel = new JLabel("Load");
			LoadLabel.setBounds(39, 12, 42, 19);
			LoadLabel.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
			contentPanel.add(LoadLabel);
		}
		{
			fileNameField = new JTextField();
			fileNameField.setBounds(230, 122, 114, 19);
			contentPanel.add(fileNameField);
			fileNameField.setColumns(10);
		}
		{
			JLabel lblFilename = new JLabel("Filename:");
			lblFilename.setBounds(128, 122, 70, 15);
			contentPanel.add(lblFilename);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 236, 448, 35);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton LoadButton = new JButton("Load");
				LoadButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						parent.setGame(parent.getGame().load(fileNameField.getText()));
						parent.getMainFrame().setContentPane(parent.getGameScreenUI());
						parent.getMainFrame().validate();
						parent.getMainFrame().repaint();
						System.out.println("Current Round is " + parent.getGame().getCurrentRound().getRoundNumber());
						System.out.println("Player 1: " + parent.getGame().getPlayer1().getName());
						System.out.println("Score: " + parent.getGame().getPlayer1().calcScore());
						System.out.println("Player 2: " + parent.getGame().getPlayer2().getName());
						System.out.println("Score: " + parent.getGame().getPlayer2().calcScore());
						System.out.println("Player 3: " + parent.getGame().getPlayer3().getName());
						System.out.println("Score: " + parent.getGame().getPlayer3().calcScore());
						System.out.println("Player 4: " + parent.getGame().getPlayer4().getName());
						System.out.println("Score: " + parent.getGame().getPlayer4().calcScore());
						parent.getGameScreenUI().getTurnScreenUI().setMapUI(new MapUI(parent.getGame().getMap()));
						parent.getGameScreenUI().cardChangeTo("TurnScreen");
						parent.getGameScreenUI().getTurnScreenUI().getTurnDialog().setCurrentPlayerText(parent.getGame().getCurrentPlayer().getName());
						parent.getGameScreenUI().getTurnScreenUI().getTurnDialog().setVisible(true);
						dispose();
					}
				});
				LoadButton.setBounds(276, 5, 81, 25);
				LoadButton.setActionCommand("Load");
				buttonPane.add(LoadButton);
				getRootPane().setDefaultButton(LoadButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setBounds(362, 5, 81, 25);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}