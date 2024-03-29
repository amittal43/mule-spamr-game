package edu.gatech.spamr.view;
//package edu.gatech.spamr.resources;


import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JDialog;
import javax.swing.JFrame;
import edu.gatech.spamr.*;

import edu.gatech.spamr.model.Game;

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
	private SplashScreen title;
	private GameConfigUI gcui;
	private PlayerConfigUI pcui ;
	private GameScreenUI gamescreen;
	private Game game;
	private LoadDialog ldialog;
	private  Thread turnTimer;
	
	//private TownScreenUI town = new TownScreenUI();
	
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
					window.mainFrame.setResizable(false);
					window.music();
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
		title = new SplashScreen();
		pcui = new PlayerConfigUI();
		//instantiate the frame and set preferences
		mainFrame = new JFrame();
		mainFrame.setBounds(100,100,1280,800);
		mainFrame.setTitle("MULE: SPAMR Edition");
		mainFrame.setContentPane(title);
		
		game = new Game();
		gamescreen = new GameScreenUI(this);
		gamescreen.setParent(this);
		game.setParent(gamescreen);
		
		ldialog = new LoadDialog(this);
		
		title.setParent(this);
		gcui = new GameConfigUI();
		gcui.setParent(this);
		pcui.setParent(this);
		
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
		return gamescreen;
	}
	
	public Game getGame(){
		return game;
	}
	
	public void setGame(Game g){
		game = g;
	}
	
	public LoadDialog getLoadDialog(){
		return ldialog;
	}

	public Thread getTurnTimer() {
		return turnTimer;
	}
	
	public void setTurnTimer(Thread t){
		turnTimer = t;
	}
	
	public void music(){
        URL url = null;
        try {
            url= getClass().getResource("/edu/gatech/spamr/resources/potter/hedwig.wav").toURI().toURL();
        } catch (MalformedURLException | URISyntaxException e) {
            e.printStackTrace();
        }
        Clip clip = null;
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        AudioInputStream ais = null;
        try {
            ais = AudioSystem.getAudioInputStream(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            clip.open(ais);
        } catch (Exception e) {
            e.printStackTrace();
        }
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}
