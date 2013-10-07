package mule_game_design_1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import java.awt.Panel;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JButton;

public class StartPanel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartPanel frame = new StartPanel();
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
	public StartPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 255));
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMule = DefaultComponentFactory.getInstance().createTitle("M.U.L.E");
		lblMule.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblMule.setBounds(154, 26, 102, 37);
		contentPane.add(lblMule);
		
		JPanel panel = new JPanel();
		panel.setBounds(113, 75, 188, 115);
		contentPane.add(panel);
		
		JLabel lblThisWillContain = new JLabel("this will contain some type of picture");
		panel.add(lblThisWillContain);
		
		JButton btnStart = new JButton("Start");
		btnStart.setBounds(167, 214, 89, 23);
		contentPane.add(btnStart);
	}
}
