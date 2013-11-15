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

public class SaveDialog extends JDialog {

	private GameScreenUI parent;
	private final JPanel contentPanel = new JPanel();
	private JTextField fileNameField;

	/**
	 * Create the dialog.
	 */
	public SaveDialog(GameScreenUI gcui) {
		parent = gcui;
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 448, 236);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel saveLabel = new JLabel("Save");
			saveLabel.setBounds(39, 12, 42, 19);
			saveLabel.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
			contentPanel.add(saveLabel);
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
				JButton saveButton = new JButton("Save");
				saveButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						parent.getGame().save(fileNameField.getText());
						dispose();
					}
				});
				saveButton.setBounds(276, 5, 81, 25);
				saveButton.setActionCommand("Save");
				buttonPane.add(saveButton);
				getRootPane().setDefaultButton(saveButton);
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
