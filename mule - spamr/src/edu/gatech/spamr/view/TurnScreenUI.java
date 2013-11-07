package edu.gatech.spamr.view;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;

import edu.gatech.spamr.model.Game;
import edu.gatech.spamr.model.Player;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;

public class TurnScreenUI extends JPanel {

	
	private GameScreenUI parent;
	private MapUI mapui = new MapUI();
	private Player currentPlayer = Game.getPlayer1();
	private JDialog dialog;
	private StartTurnDialog turndialog = new StartTurnDialog(Game.getCurrentPlayer());
	
	/**
	 * Create the panel.
	 */
	public TurnScreenUI(GameScreenUI gcui) {
		parent = gcui;
		
		setBackground(Color.DARK_GRAY);
		setMinimumSize(new Dimension(1280, 800));
		setPreferredSize(new Dimension(1280, 800));
		mapui.setLocation(104, 108);
		
		mapui.setParent(parent);
		mapui.updateBorders();
		setLayout(null);
		mapui.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		mapui.setMinimumSize(new Dimension(820, 600));
		mapui.setSize(new Dimension(820, 600));
		mapui.setPreferredSize(new Dimension(820, 600));
		add(mapui);				//adds the panel
		
		JLabel playerTurnLabel = new JLabel("Player Turn");
		playerTurnLabel.setFont(new Font("Verdana", Font.BOLD, 25));
		playerTurnLabel.setForeground(Color.LIGHT_GRAY);
		playerTurnLabel.setBounds(104, 45, 163, 32);
		add(playerTurnLabel);
		
		dialog = new JDialog(SwingUtilities.getWindowAncestor(parent));
		dialog.setSize(new Dimension(420,260));
		dialog.setVisible(false);
		turndialog.setParent(this);
		if(!SwingUtilities.isEventDispatchThread())
			dialog.setContentPane(turndialog.getContentPane());
		//add(currentTurn);

	}
	
	public void setParent(GameScreenUI p){
		parent = p;
	}
	
	public StartTurnDialog getTurnDialog(){
		return turndialog;
	}


}