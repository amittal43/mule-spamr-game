package edu.gatech.spamr.view;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;

/** 
 * The MainAppView class represents the actual application of the game
 * 
 *  
 * @author Sean Lachenberg
 * @author Aditya Mittal
 * @author Mike Vail
 * @author Puja Sheth
 * @author Raj Prateek
 * @version 1.0 10/03/2013 
 */

public class MainAppView {

	//MainAppView variables
	private JFrame mainFrame;
	private JDialog configDialog;
	private TitleScreenUI title = new TitleScreenUI();
	private GameConfigUI gcui = new GameConfigUI();
	private PlayerConfigUI pcui = new PlayerConfigUI();
	private GameScreenUI game = new GameScreenUI();
	
	//sets preferences for the window
	public void setUpConfigDialog(){
		configDialog = new JDialog(mainFrame,"Configure Game");
		configDialog.setSize(new Dimension(310,400));
		configDialog.setContentPane(gcui);
		configDialog.setVisible(true);
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainAppView window = new MainAppView();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainAppView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//instantiate the frame and set preferences
		mainFrame = new JFrame();
		mainFrame.setBounds(100,100,1280,800);
		mainFrame.setTitle("MULE: SPAMR Edition");
		mainFrame.setContentPane(title);
		
		//adds cards to the frame
		title.setParent(this);
		gcui.setParent(this);
		pcui.setParent(this);
		game.setParent(this);
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	//getters and setters
	public JFrame getMainFrame(){
		return mainFrame;
	}
	
	public JDialog getConfigDialog(){
		return configDialog;
	}
	
	public GameConfigUI getGameConfigUI(){
		return gcui;
	}
	
	public PlayerConfigUI getPlayerConfigUI(){
		return pcui;
	}
	
	public GameScreenUI getGameScreenUI(){
		return game;
	}
	
}
