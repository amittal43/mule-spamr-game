package mule_game_design_1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Scrollbar;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import java.awt.Panel;
import java.awt.Label;
import java.awt.Font;

public class ResourcesPanel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResourcesPanel frame = new ResourcesPanel();
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
	public ResourcesPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 242);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblPlayer = new JLabel("Player");
		lblPlayer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPlayer.setBounds(10, 11, 47, 22);
		panel.add(lblPlayer);
		
		JLabel lblMoney = new JLabel("Money");
		lblMoney.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMoney.setBounds(90, 11, 52, 22);
		panel.add(lblMoney);
		
		JLabel lblResources = new JLabel("Resources");
		lblResources.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblResources.setBounds(183, 11, 221, 22);
		panel.add(lblResources);
	}
}
