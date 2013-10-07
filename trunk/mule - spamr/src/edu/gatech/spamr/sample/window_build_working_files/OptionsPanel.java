package mule_game_design_1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JToggleButton;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;

public class OptionsPanel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OptionsPanel frame = new OptionsPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OptionsPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToggleButton tglbtnPlayer = new JToggleButton("Player 1");
		tglbtnPlayer.setBounds(10, 139, 71, 23);
		tglbtnPlayer.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(tglbtnPlayer);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 170, 71, 83);
		contentPane.add(panel);
		
		JToggleButton tglbtnPlayer_1 = new JToggleButton("Player 2");
		tglbtnPlayer_1.setBounds(125, 139, 71, 23);
		contentPane.add(tglbtnPlayer_1);
		
		JToggleButton tglbtnPlayer_2 = new JToggleButton("Player 3");
		tglbtnPlayer_2.setBounds(241, 139, 71, 23);
		contentPane.add(tglbtnPlayer_2);
		
		JToggleButton tglbtnPlayer_3 = new JToggleButton("Player 4");
		tglbtnPlayer_3.setBounds(353, 139, 71, 23);
		contentPane.add(tglbtnPlayer_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(125, 170, 71, 83);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(241, 170, 71, 83);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(353, 170, 71, 83);
		contentPane.add(panel_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(309, 73, 115, 23);
		contentPane.add(comboBox);
		
		JLabel lblDifficultyLevel = new JLabel("Difficulty Level");
		lblDifficultyLevel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDifficultyLevel.setBounds(309, 39, 115, 22);
		contentPane.add(lblDifficultyLevel);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 34, 287, 94);
		contentPane.add(panel_4);
		
		JLabel lblThisIsWhere = new JLabel("This is where we will have the selection of species");
		panel_4.add(lblThisIsWhere);
	}
}
