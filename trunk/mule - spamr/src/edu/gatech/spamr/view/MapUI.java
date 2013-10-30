package edu.gatech.spamr.view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import java.awt.Component;

import javax.swing.border.MatteBorder;

import edu.gatech.spamr.model.Game;
import edu.gatech.spamr.model.Map;
import edu.gatech.spamr.model.Map.MapType;
import edu.gatech.spamr.model.Player;
import edu.gatech.spamr.model.Tile;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/** 
 * The MapUI class represents the actual application of the game
 * 
 *  
 * @author Sean Lachenberg
 * @author Aditya Mittal
 * @author Mike Vail
 * @author Puja Sheth
 * @author Raj Prateek
 * @version 1.0 10/22/2013 
 */


public class MapUI extends JPanel {
	
	//mapUI variables
	private Map map = Game.getMap();
	private Tile[] mapArray = map.getMapArray();
	private JButton[] button = new JButton[45];
	private GameScreenUI parent;
	private Tile currentTile = mapArray[0];
	private JButton currentButton;
	int i;
	
	public void colorTile(Tile tile, JButton button){
		if (tile.isOwned()){
			if (tile.getOwner().getColor().name().equals("RED"))
				button.setBorder(new LineBorder(Color.RED, 2));
				else if (tile.getOwner().getColor().name().equals("GREEN"))
					button.setBorder(new LineBorder(Color.GREEN, 2));
				else if (tile.getOwner().getColor().name().equals("BLUE"))
					button.setBorder(new LineBorder(Color.BLUE, 2));
				else 
					button.setBorder(new LineBorder(Color.YELLOW, 2));
			}
		}
	
	//should be called whenver MapUI is switched to
	public void updateBorders(Tile[] tiles, JButton[] buts){
		for (int i = 0; i < tiles.length; i++) {	//tiles and buts should have the same length
			//System.out.println(i);
			//System.out.println(tiles[i]);
			//System.out.println(buts[i]);
			colorTile(tiles[i], buts[i]);
		}
	}

	/**
	 * MapUI creates the initial map
	 * 
	 * @return map with all tiles displayed
	 */
	public MapUI() {
		

		
		//UI preferences
		setBackground(new Color(151, 133, 31));
		setBorder(null);
		setMinimumSize(new Dimension(800, 600));
		setPreferredSize(new Dimension(800, 600));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {88, 88, 88, 88, 88, 88, 88, 88, 88};
		gridBagLayout.rowHeights = new int[] {120, 120, 120, 120, 120};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		
		/**
		 * The rest of this code goes through an algorithm that determines what type the tile is 
		 * from a mapArray and from that the image that needs to be at that position is put into currentTile.
		 * 
		 * The rest will consist of all the button info and listeners for each tile.
		 * The town will always be button 22.
		 */
		
		button[0] = new JButton("0");
		button[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				currentTile = mapArray[0];
				currentButton = button[0];
				System.out.println(mapArray[0].isOwned());
			}
		});
		button[0].setContentAreaFilled(false);
		button[0].setBorder(null);
		button[0].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[0].getTileType().getIcon())));
		button[0].setMaximumSize(new Dimension(88, 120));
		button[0].setMinimumSize(new Dimension(88, 120));
		button[0].setPreferredSize(new Dimension(88, 120));
		GridBagConstraints gbc_button_0 = new GridBagConstraints();
		gbc_button_0.insets = new Insets(0, 0, 5, 5);
		gbc_button_0.gridx = 0;
		gbc_button_0.gridy = 0;
		colorTile(mapArray[0], button[0]);
		add(button[0], gbc_button_0);
		
		
		
		
		
		button[1] = new JButton("0");
		button[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//colorTile(mapArray[0],button);
				currentTile = mapArray[1];
				currentButton = button[1];
			}
		});
		button[1].setPreferredSize(new Dimension(88, 120));
		button[1].setMinimumSize(new Dimension(88, 120));
		button[1].setMaximumSize(new Dimension(88, 120));
		button[1].setContentAreaFilled(false);
		button[1].setBorder(null);
		button[1].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[1].getTileType().getIcon())));
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 1;
		gbc_button_1.gridy = 0;
		colorTile(mapArray[1],button[1]);
		add(button[1], gbc_button_1);
		
		
		button[2] = new JButton("0");
		button[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentButton = button[2];
				currentTile = mapArray[2];
				
			}
		});
		button[2].setPreferredSize(new Dimension(88, 120));
		button[2].setMinimumSize(new Dimension(88, 120));
		button[2].setMaximumSize(new Dimension(88, 120));
		button[2].setContentAreaFilled(false);
		button[2].setBorder(null);
		button[2].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[2].getTileType().getIcon())));
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.insets = new Insets(0, 0, 5, 5);
		gbc_button_2.gridx = 2;
		gbc_button_2.gridy = 0;
		colorTile(mapArray[2],button[2]);
		add(button[2], gbc_button_2);
		
		button[3] = new JButton("0");
		button[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentButton = button[3];
				currentTile = mapArray[3];
			}
		});
		button[3].setPreferredSize(new Dimension(88, 120));
		button[3].setMinimumSize(new Dimension(88, 120));
		button[3].setMaximumSize(new Dimension(88, 120));
		button[3].setContentAreaFilled(false);
		button[3].setBorder(null);
		button[3].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[3].getTileType().getIcon())));
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.insets = new Insets(0, 0, 5, 5);
		gbc_button_3.gridx = 3;
		gbc_button_3.gridy = 0;
		colorTile(mapArray[3],button[3]);
		add(button[3], gbc_button_3);
		
		button[4] = new JButton("0");
		button[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentButton = button[4];
				currentTile = mapArray[4];
			}
		});
		button[4].setPreferredSize(new Dimension(88, 120));
		button[4].setMinimumSize(new Dimension(88, 120));
		button[4].setMaximumSize(new Dimension(88, 120));
		button[4].setContentAreaFilled(false);
		button[4].setBorder(null);
		button[4].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[4].getTileType().getIcon())));
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.insets = new Insets(0, 0, 5, 5);
		gbc_button_4.gridx = 4;
		gbc_button_4.gridy = 0;
		colorTile(mapArray[4],button[4]);
		add(button[4], gbc_button_4);
		
		button[5] = new JButton("0");
		button[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTile = mapArray[5];
				currentButton = button[5];
			}
		});
		button[5].setPreferredSize(new Dimension(88, 120));
		button[5].setMinimumSize(new Dimension(88, 120));
		button[5].setMaximumSize(new Dimension(88, 120));
		button[5].setContentAreaFilled(false);
		button[5].setBorder(null);
		button[5].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[5].getTileType().getIcon())));
		GridBagConstraints gbc_button_5 = new GridBagConstraints();
		gbc_button_5.insets = new Insets(0, 0, 5, 5);
		gbc_button_5.gridx = 5;
		gbc_button_5.gridy = 0;
		colorTile(mapArray[5],button[5]);
		add(button[5], gbc_button_5);
		
		button[6] = new JButton("0");
		button[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentButton = button[6];
				currentTile = mapArray[6];
			}
		});
		button[6].setPreferredSize(new Dimension(88, 120));
		button[6].setMinimumSize(new Dimension(88, 120));
		button[6].setMaximumSize(new Dimension(88, 120));
		button[6].setContentAreaFilled(false);
		button[6].setBorder(null);
		button[6].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[6].getTileType().getIcon())));
		GridBagConstraints gbc_button_6 = new GridBagConstraints();
		gbc_button_6.insets = new Insets(0, 0, 5, 5);
		gbc_button_6.gridx = 6;
		gbc_button_6.gridy = 0;
		colorTile(mapArray[6],button[6]);
		add(button[6], gbc_button_6);
		
		button[7] = new JButton("0");
		button[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentButton = button[7];
				currentTile = mapArray[7];
			}
		});
		button[7].setPreferredSize(new Dimension(88, 120));
		button[7].setMinimumSize(new Dimension(88, 120));
		button[7].setMaximumSize(new Dimension(88, 120));
		button[7].setContentAreaFilled(false);
		button[7].setBorder(null);
		button[7].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[7].getTileType().getIcon())));
		GridBagConstraints gbc_button_7 = new GridBagConstraints();
		gbc_button_7.insets = new Insets(0, 0, 5, 5);
		gbc_button_7.gridx = 7;
		gbc_button_7.gridy = 0;
		colorTile(mapArray[7],button[7]);
		add(button[7], gbc_button_7);
		
		button[8] = new JButton("0");
		button[8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentButton = button[8];
				currentTile = mapArray[8];
			}
		});
		
		button[8].setPreferredSize(new Dimension(88, 120));
		button[8].setMinimumSize(new Dimension(88, 120));
		button[8].setMaximumSize(new Dimension(88, 120));
		button[8].setContentAreaFilled(false);
		button[8].setBorder(null);
		button[8].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[8].getTileType().getIcon())));
		GridBagConstraints gbc_button_8 = new GridBagConstraints();
		gbc_button_8.insets = new Insets(0, 0, 5, 0);
		gbc_button_8.gridx = 8;
		gbc_button_8.gridy = 0;
		colorTile(mapArray[8],button[8]);
		add(button[8], gbc_button_8);
		
		
		button[9] = new JButton("0");
		button[9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentButton = button[9];
				currentTile = mapArray[9];
			}
		});
		button[9].setPreferredSize(new Dimension(88, 120));
		button[9].setMinimumSize(new Dimension(88, 120));
		button[9].setMaximumSize(new Dimension(88, 120));
		button[9].setContentAreaFilled(false);
		button[9].setBorder(null);
		button[9].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[9].getTileType().getIcon())));
		GridBagConstraints gbc_button_9 = new GridBagConstraints();
		gbc_button_9.insets = new Insets(0, 0, 5, 5);
		gbc_button_9.gridx = 0;
		gbc_button_9.gridy = 1;
		colorTile(mapArray[9],button[9]);
		add(button[9], gbc_button_9);
		
		
		button[10] = new JButton("0");
		button[10].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentButton = button[10];
				currentTile = mapArray[10];
			}
		});
		button[10].setPreferredSize(new Dimension(88, 120));
		button[10].setMinimumSize(new Dimension(88, 120));
		button[10].setMaximumSize(new Dimension(88, 120));
		button[10].setContentAreaFilled(false);
		button[10].setBorder(null);
		button[10].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[10].getTileType().getIcon())));
		GridBagConstraints gbc_button_10 = new GridBagConstraints();
		gbc_button_10.insets = new Insets(0, 0, 5, 5);
		gbc_button_10.gridx = 1;
		gbc_button_10.gridy = 1;
		colorTile(mapArray[10],button[10]);
		add(button[10], gbc_button_10);
		
		button[11] = new JButton("0");
		button[11].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentButton = button[11];
				currentTile = mapArray[11];
			}
		});
		button[11].setPreferredSize(new Dimension(88, 120));
		button[11].setMinimumSize(new Dimension(88, 120));
		button[11].setMaximumSize(new Dimension(88, 120));
		button[11].setContentAreaFilled(false);
		button[11].setBorder(null);
		button[11].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[11].getTileType().getIcon())));
		GridBagConstraints gbc_button_11 = new GridBagConstraints();
		gbc_button_11.insets = new Insets(0, 0, 5, 5);
		gbc_button_11.gridx = 2;
		gbc_button_11.gridy = 1;
		colorTile(mapArray[11],button[11]);
		add(button[11], gbc_button_11);
		
		button[12] = new JButton("0");
		button[12].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTile = mapArray[12];
				currentButton = button[12];
			}
		});
		button[12].setPreferredSize(new Dimension(88, 120));
		button[12].setMinimumSize(new Dimension(88, 120));
		button[12].setMaximumSize(new Dimension(88, 120));
		button[12].setContentAreaFilled(false);
		button[12].setBorder(null);
		button[12].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[12].getTileType().getIcon())));
		GridBagConstraints gbc_button_12 = new GridBagConstraints();
		gbc_button_12.insets = new Insets(0, 0, 5, 5);
		gbc_button_12.gridx = 3;
		gbc_button_12.gridy = 1;
		colorTile(mapArray[12],button[12]);
		add(button[12], gbc_button_12);
		
		button[13] = new JButton("0");
		button[13].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTile = mapArray[13];
				currentButton = button[13];
			}
		});
		button[13].setPreferredSize(new Dimension(88, 120));
		button[13].setMinimumSize(new Dimension(88, 120));
		button[13].setMaximumSize(new Dimension(88, 120));
		button[13].setContentAreaFilled(false);
		button[13].setBorder(null);
		button[13].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[13].getTileType().getIcon())));
		GridBagConstraints gbc_button_13 = new GridBagConstraints();
		gbc_button_13.insets = new Insets(0, 0, 5, 5);
		gbc_button_13.gridx = 4;
		gbc_button_13.gridy = 1;
		colorTile(mapArray[13],button[13]);
		add(button[13], gbc_button_13);
		
		button[14] = new JButton("0");
		button[14].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentButton = button[14];
				currentTile = mapArray[14];
			}
		});
		button[14].setPreferredSize(new Dimension(88, 120));
		button[14].setMinimumSize(new Dimension(88, 120));
		button[14].setMaximumSize(new Dimension(88, 120));
		button[14].setContentAreaFilled(false);
		button[14].setBorder(null);
		button[14].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[14].getTileType().getIcon())));
		GridBagConstraints gbc_button_14 = new GridBagConstraints();
		gbc_button_14.insets = new Insets(0, 0, 5, 5);
		gbc_button_14.gridx = 5;
		gbc_button_14.gridy = 1;
		colorTile(mapArray[14],button[14]);
		add(button[14], gbc_button_14);
		
		button[15] = new JButton("0");
		button[15].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentButton = button[15];
				currentTile = mapArray[15];
			}
		});
		button[15].setPreferredSize(new Dimension(88, 120));
		button[15].setMinimumSize(new Dimension(88, 120));
		button[15].setMaximumSize(new Dimension(88, 120));
		button[15].setContentAreaFilled(false);
		button[15].setBorder(null);
		button[15].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[15].getTileType().getIcon())));
		GridBagConstraints gbc_button_15 = new GridBagConstraints();
		gbc_button_15.insets = new Insets(0, 0, 5, 5);
		gbc_button_15.gridx = 6;
		gbc_button_15.gridy = 1;
		colorTile(mapArray[15],button[15]);
		add(button[15], gbc_button_15);
		
		button[16] = new JButton("0");
		button[16].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTile = mapArray[16];
				currentButton = button[16];
			}
		});
		button[16].setPreferredSize(new Dimension(88, 120));
		button[16].setMinimumSize(new Dimension(88, 120));
		button[16].setMaximumSize(new Dimension(88, 120));
		button[16].setContentAreaFilled(false);
		button[16].setBorder(null);
		button[16].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[16].getTileType().getIcon())));
		GridBagConstraints gbc_button_16 = new GridBagConstraints();
		gbc_button_16.insets = new Insets(0, 0, 5, 5);
		gbc_button_16.gridx = 7;
		gbc_button_16.gridy = 1;
		colorTile(mapArray[16],button[16]);
		add(button[16], gbc_button_16);
		
		button[17] = new JButton("0");
		button[17].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTile = mapArray[17];
				currentButton = button[17];
			}
		});
		button[17].setPreferredSize(new Dimension(88, 120));
		button[17].setMinimumSize(new Dimension(88, 120));
		button[17].setMaximumSize(new Dimension(88, 120));
		button[17].setContentAreaFilled(false);
		button[17].setBorder(null);
		button[17].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[17].getTileType().getIcon())));
		GridBagConstraints gbc_button_17 = new GridBagConstraints();
		gbc_button_17.insets = new Insets(0, 0, 5, 0);
		gbc_button_17.gridx = 8;
		gbc_button_17.gridy = 1;
		colorTile(mapArray[17],button[17]);
		add(button[17], gbc_button_17);
		
		button[18] = new JButton("0");
		button[18].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTile = mapArray[18];
				currentButton = button[18];
			}
		});
		button[18].setPreferredSize(new Dimension(88, 120));
		button[18].setMinimumSize(new Dimension(88, 120));
		button[18].setMaximumSize(new Dimension(88, 120));
		button[18].setContentAreaFilled(false);
		button[18].setBorder(null);
		button[18].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[18].getTileType().getIcon())));
		GridBagConstraints gbc_button_18 = new GridBagConstraints();
		gbc_button_18.insets = new Insets(0, 0, 5, 5);
		gbc_button_18.gridx = 0;
		gbc_button_18.gridy = 2;
		colorTile(mapArray[18],button[18]);
		add(button[18], gbc_button_18);
		
		button[19] = new JButton("0");
		button[19].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTile = mapArray[19];
				currentButton = button[19];
			}
		});
		button[19].setPreferredSize(new Dimension(88, 120));
		button[19].setMinimumSize(new Dimension(88, 120));
		button[19].setMaximumSize(new Dimension(88, 120));
		button[19].setContentAreaFilled(false);
		button[19].setBorder(null);
		button[19].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[19].getTileType().getIcon())));
		GridBagConstraints gbc_button_19 = new GridBagConstraints();
		gbc_button_19.insets = new Insets(0, 0, 5, 5);
		gbc_button_19.gridx = 1;
		gbc_button_19.gridy = 2;
		colorTile(mapArray[19],button[19]);
		add(button[19], gbc_button_19);
		
		button[20] = new JButton("0");
		button[20].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTile = mapArray[20];
				currentButton = button[20];
			}
		});
		button[20].setPreferredSize(new Dimension(88, 120));
		button[20].setMinimumSize(new Dimension(88, 120));
		button[20].setMaximumSize(new Dimension(88, 120));
		button[20].setContentAreaFilled(false);
		button[20].setBorder(null);
		button[20].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[20].getTileType().getIcon())));
		GridBagConstraints gbc_button_20 = new GridBagConstraints();
		gbc_button_20.insets = new Insets(0, 0, 5, 5);
		gbc_button_20.gridx = 2;
		gbc_button_20.gridy = 2;
		colorTile(mapArray[20],button[20]);
		add(button[20], gbc_button_20);
		
		button[21] = new JButton("0");
		button[21].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTile = mapArray[21];
				currentButton = button[21];
			}
		});
		button[21].setPreferredSize(new Dimension(88, 120));
		button[21].setMinimumSize(new Dimension(88, 120));
		button[21].setMaximumSize(new Dimension(88, 120));
		button[21].setContentAreaFilled(false);
		button[21].setBorder(null);
		button[21].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[21].getTileType().getIcon())));
		GridBagConstraints gbc_button_21 = new GridBagConstraints();
		gbc_button_21.insets = new Insets(0, 0, 5, 5);
		gbc_button_21.gridx = 3;
		gbc_button_21.gridy = 2;
		colorTile(mapArray[21],button[21]);
		add(button[21], gbc_button_21);
		
		//this is the town based off the land configuration given in M2
		button[22] = new JButton("0");
		button[22].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTile = mapArray[22];
				currentButton = button[22];
			}
		});
		button[22].setPreferredSize(new Dimension(88, 120));
		button[22].setMinimumSize(new Dimension(88, 120));
		button[22].setMaximumSize(new Dimension(88, 120));
		button[22].setContentAreaFilled(false);
		button[22].setBorder(null);
		button[22].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[22].getTileType().getIcon())));
		
		button[22].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if it is not the LandSelection Card go the the Town Card
				if(parent.getLandSelectionOver()){
					parent.cardChangeTo("Town");
					//System.out.println("Pushed");
				}
				
			}
		});
		
		
		GridBagConstraints gbc_button_22 = new GridBagConstraints(); //right before/after this step there should be an action listener that will take the player to the town if the button is clicked on
		gbc_button_22.insets = new Insets(0, 0, 5, 5);
		gbc_button_22.gridx = 4;
		gbc_button_22.gridy = 2;
		add(button[22], gbc_button_22);
			
		
		button[23] = new JButton("0");
		button[23].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTile = mapArray[23];
				currentButton = button[23];
			}
		});
		button[23].setPreferredSize(new Dimension(88, 120));
		button[23].setMinimumSize(new Dimension(88, 120));
		button[23].setMaximumSize(new Dimension(88, 120));
		button[23].setContentAreaFilled(false);
		button[23].setBorder(null);
		button[23].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[23].getTileType().getIcon())));
		GridBagConstraints gbc_button_23 = new GridBagConstraints();
		gbc_button_23.insets = new Insets(0, 0, 5, 5);
		gbc_button_23.gridx = 5;
		gbc_button_23.gridy = 2;
		colorTile(mapArray[23],button[23]);
		add(button[23], gbc_button_23);
		
		button[24] = new JButton("0");
		button[24].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTile = mapArray[24];
				currentButton = button[24];
			}
		});
		button[24].setPreferredSize(new Dimension(88, 120));
		button[24].setMinimumSize(new Dimension(88, 120));
		button[24].setMaximumSize(new Dimension(88, 120));
		button[24].setContentAreaFilled(false);
		button[24].setBorder(null);
		button[24].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[24].getTileType().getIcon())));
		GridBagConstraints gbc_button_24 = new GridBagConstraints();
		gbc_button_24.insets = new Insets(0, 0, 5, 5);
		gbc_button_24.gridx = 6;
		gbc_button_24.gridy = 2;
		colorTile(mapArray[24],button[24]);
		add(button[24], gbc_button_24);
		
		button[25] = new JButton("0");
		button[25].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTile = mapArray[25];
				currentButton = button[25];
			}
		});
		button[25].setPreferredSize(new Dimension(88, 120));
		button[25].setMinimumSize(new Dimension(88, 120));
		button[25].setMaximumSize(new Dimension(88, 120));
		button[25].setContentAreaFilled(false);
		button[25].setBorder(null);
		button[25].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[25].getTileType().getIcon())));
		GridBagConstraints gbc_button_25 = new GridBagConstraints();
		gbc_button_25.insets = new Insets(0, 0, 5, 5);
		gbc_button_25.gridx = 7;
		gbc_button_25.gridy = 2;
		colorTile(mapArray[25],button[25]);
		add(button[25], gbc_button_25);
		
		button[26] = new JButton("0");
		button[26].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTile = mapArray[26];
				currentButton = button[26];
			}
		});
		button[26].setPreferredSize(new Dimension(88, 120));
		button[26].setMinimumSize(new Dimension(88, 120));
		button[26].setMaximumSize(new Dimension(88, 120));
		button[26].setContentAreaFilled(false);
		button[26].setBorder(null);
		button[26].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[26].getTileType().getIcon())));
		GridBagConstraints gbc_button_26 = new GridBagConstraints();
		gbc_button_26.insets = new Insets(0, 0, 5, 0);
		gbc_button_26.gridx = 8;
		gbc_button_26.gridy = 2;
		colorTile(mapArray[26],button[26]);
		add(button[26], gbc_button_26);
		
		button[27] = new JButton("0");
		button[27].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTile = mapArray[27];
				currentButton = button[27];
			}
		});
		button[27].setPreferredSize(new Dimension(88, 120));
		button[27].setMinimumSize(new Dimension(88, 120));
		button[27].setMaximumSize(new Dimension(88, 120));
		button[27].setContentAreaFilled(false);
		button[27].setBorder(null);
		button[27].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[27].getTileType().getIcon())));
		GridBagConstraints gbc_button_27 = new GridBagConstraints();
		gbc_button_27.insets = new Insets(0, 0, 5, 5);
		gbc_button_27.gridx = 0;
		gbc_button_27.gridy = 3;
		colorTile(mapArray[27],button[27]);
		add(button[27], gbc_button_27);
		
		button[28] = new JButton("0");
		button[28].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTile = mapArray[28];
				currentButton = button[28];
			}
		});
		button[28].setPreferredSize(new Dimension(88, 120));
		button[28].setMinimumSize(new Dimension(88, 120));
		button[28].setMaximumSize(new Dimension(88, 120));
		button[28].setContentAreaFilled(false);
		button[28].setBorder(null);
		button[28].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[28].getTileType().getIcon())));
		GridBagConstraints gbc_button_28 = new GridBagConstraints();
		gbc_button_28.insets = new Insets(0, 0, 5, 5);
		gbc_button_28.gridx = 1;
		gbc_button_28.gridy = 3;
		colorTile(mapArray[28],button[28]);
		add(button[28], gbc_button_28);
		
		button[29] = new JButton("0");
		button[29].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTile = mapArray[29];
				currentButton = button[29];
			}
		});
		button[29].setPreferredSize(new Dimension(88, 120));
		button[29].setMinimumSize(new Dimension(88, 120));
		button[29].setMaximumSize(new Dimension(88, 120));
		button[29].setContentAreaFilled(false);
		button[29].setBorder(null);
		button[29].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[29].getTileType().getIcon())));
		GridBagConstraints gbc_button_29 = new GridBagConstraints();
		gbc_button_29.insets = new Insets(0, 0, 5, 5);
		gbc_button_29.gridx = 2;
		gbc_button_29.gridy = 3;
		colorTile(mapArray[29],button[29]);
		add(button[29], gbc_button_29);
		
		button[30] = new JButton("0");
		button[30].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTile = mapArray[30];
				currentButton = button[30];
			}
		});
		button[30].setPreferredSize(new Dimension(88, 120));
		button[30].setMinimumSize(new Dimension(88, 120));
		button[30].setMaximumSize(new Dimension(88, 120));
		button[30].setContentAreaFilled(false);
		button[30].setBorder(null);
		button[30].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[30].getTileType().getIcon())));
		GridBagConstraints gbc_button_30 = new GridBagConstraints();
		gbc_button_30.insets = new Insets(0, 0, 5, 5);
		gbc_button_30.gridx = 3;
		gbc_button_30.gridy = 3;
		colorTile(mapArray[30],button[30]);
		add(button[30], gbc_button_30);
		
		button[31] = new JButton("0");
		button[31].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTile = mapArray[31];
				currentButton = button[31];
			}
		});


		button[31].setPreferredSize(new Dimension(88, 120));
		button[31].setMinimumSize(new Dimension(88, 120));
		button[31].setMaximumSize(new Dimension(88, 120));
		button[31].setContentAreaFilled(false);
		button[31].setBorder(null);
		button[31].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[31].getTileType().getIcon())));
		GridBagConstraints gbc_button_31 = new GridBagConstraints();
		gbc_button_31.insets = new Insets(0, 0, 5, 5);
		gbc_button_31.gridx = 4;
		gbc_button_31.gridy = 3;
		colorTile(mapArray[31],button[31]);
		add(button[31], gbc_button_31);
		
		button[32] = new JButton("0");
		button[32].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTile = mapArray[32];
				currentButton = button[32];
			}
		});
		button[32].setPreferredSize(new Dimension(88, 120));
		button[32].setMinimumSize(new Dimension(88, 120));
		button[32].setMaximumSize(new Dimension(88, 120));
		button[32].setContentAreaFilled(false);
		button[32].setBorder(null);
		button[32].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[32].getTileType().getIcon())));
		GridBagConstraints gbc_button_32 = new GridBagConstraints();
		gbc_button_32.insets = new Insets(0, 0, 5, 5);
		gbc_button_32.gridx = 5;
		gbc_button_32.gridy = 3;
		colorTile(mapArray[32],button[32]);
		add(button[32], gbc_button_32);
		
		button[33] = new JButton("0");
		button[33].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTile = mapArray[33];
				currentButton = button[33];
			}
		});
		button[33].setPreferredSize(new Dimension(88, 120));
		button[33].setMinimumSize(new Dimension(88, 120));
		button[33].setMaximumSize(new Dimension(88, 120));
		button[33].setContentAreaFilled(false);
		button[33].setBorder(null);
		button[33].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[33].getTileType().getIcon())));
		GridBagConstraints gbc_button_33 = new GridBagConstraints();
		gbc_button_33.insets = new Insets(0, 0, 5, 5);
		gbc_button_33.gridx = 6;
		gbc_button_33.gridy = 3;
		colorTile(mapArray[33],button[33]);
		add(button[33], gbc_button_33);
		
		button[34] = new JButton("0");
		button[34].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTile = mapArray[34];
				currentButton = button[34];
			}
		});
		button[34].setPreferredSize(new Dimension(88, 120));
		button[34].setMinimumSize(new Dimension(88, 120));
		button[34].setMaximumSize(new Dimension(88, 120));
		button[34].setContentAreaFilled(false);
		button[34].setBorder(null);
		button[34].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[34].getTileType().getIcon())));
		GridBagConstraints gbc_button_34 = new GridBagConstraints();
		gbc_button_34.insets = new Insets(0, 0, 5, 5);
		gbc_button_34.gridx = 7;
		gbc_button_34.gridy = 3;
		colorTile(mapArray[34],button[34]);
		add(button[34], gbc_button_34);
		
		button[35] = new JButton("0");
		button[35].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTile = mapArray[35];
				currentButton = button[35];
			}
		});
		button[35].setPreferredSize(new Dimension(88, 120));
		button[35].setMinimumSize(new Dimension(88, 120));
		button[35].setMaximumSize(new Dimension(88, 120));
		button[35].setContentAreaFilled(false);
		button[35].setBorder(null);
		button[35].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[35].getTileType().getIcon())));
		GridBagConstraints gbc_button_35 = new GridBagConstraints();
		gbc_button_35.insets = new Insets(0, 0, 5, 0);
		gbc_button_35.gridx = 8;
		gbc_button_35.gridy = 3;
		colorTile(mapArray[35],button[35]);
		add(button[35], gbc_button_35);
		
		button[36] = new JButton("0");
		button[36].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTile = mapArray[36];
				currentButton = button[36];
			}
		});
		button[36].setPreferredSize(new Dimension(88, 120));
		button[36].setMinimumSize(new Dimension(88, 120));
		button[36].setMaximumSize(new Dimension(88, 120));
		button[36].setContentAreaFilled(false);
		button[36].setBorder(null);
		button[36].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[36].getTileType().getIcon())));
		GridBagConstraints gbc_button_36 = new GridBagConstraints();
		gbc_button_36.insets = new Insets(0, 0, 0, 5);
		gbc_button_36.gridx = 0;
		gbc_button_36.gridy = 4;
		colorTile(mapArray[36],button[36]);
		add(button[36], gbc_button_36);
		
		button[37] = new JButton("0");
		button[37].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTile = mapArray[37];
				currentButton = button[37];
			}
		});
		button[37].setPreferredSize(new Dimension(88, 120));
		button[37].setMinimumSize(new Dimension(88, 120));
		button[37].setMaximumSize(new Dimension(88, 120));
		button[37].setContentAreaFilled(false);
		button[37].setBorder(null);
		button[37].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[37].getTileType().getIcon())));
		GridBagConstraints gbc_button_37 = new GridBagConstraints();
		gbc_button_37.insets = new Insets(0, 0, 0, 5);
		gbc_button_37.gridx = 1;
		gbc_button_37.gridy = 4;
		colorTile(mapArray[37],button[37]);
		add(button[37], gbc_button_37);
		
		button[38] = new JButton("0");
		button[38].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTile = mapArray[38];
				currentButton = button[38];
			}
		});
		button[38].setPreferredSize(new Dimension(88, 120));
		button[38].setMinimumSize(new Dimension(88, 120));
		button[38].setMaximumSize(new Dimension(88, 120));
		button[38].setContentAreaFilled(false);
		button[38].setBorder(null);
		button[38].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[38].getTileType().getIcon())));
		GridBagConstraints gbc_button_38 = new GridBagConstraints();
		gbc_button_38.insets = new Insets(0, 0, 0, 5);
		gbc_button_38.gridx = 2;
		gbc_button_38.gridy = 4;
		colorTile(mapArray[38],button[38]);
		add(button[38], gbc_button_38);
		
		button[39] = new JButton("0");
		button[39].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTile = mapArray[39];
				currentButton = button[39];
			}
		});
		button[39].setPreferredSize(new Dimension(88, 120));
		button[39].setMinimumSize(new Dimension(88, 120));
		button[39].setMaximumSize(new Dimension(88, 120));
		button[39].setContentAreaFilled(false);
		button[39].setBorder(null);
		button[39].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[39].getTileType().getIcon())));
		GridBagConstraints gbc_button_39 = new GridBagConstraints();
		gbc_button_39.insets = new Insets(0, 0, 0, 5);
		gbc_button_39.gridx = 3;
		gbc_button_39.gridy = 4;
		colorTile(mapArray[39],button[39]);
		add(button[39], gbc_button_39);
		
		button[40] = new JButton("0");
		button[40].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTile = mapArray[40];
				currentButton = button[40];
			}
		});
		button[40].setPreferredSize(new Dimension(88, 120));
		button[40].setMinimumSize(new Dimension(88, 120));
		button[40].setMaximumSize(new Dimension(88, 120));
		button[40].setContentAreaFilled(false);
		button[40].setBorder(null);
		button[40].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[40].getTileType().getIcon())));
		GridBagConstraints gbc_button_40 = new GridBagConstraints();
		gbc_button_40.insets = new Insets(0, 0, 0, 5);
		gbc_button_40.gridx = 4;
		gbc_button_40.gridy = 4;
		colorTile(mapArray[40],button[40]);
		add(button[40], gbc_button_40);
		
		button[41] = new JButton("0");
		button[41].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTile = mapArray[41];
				currentButton = button[41];
			}
		});
		button[41].setPreferredSize(new Dimension(88, 120));
		button[41].setMinimumSize(new Dimension(88, 120));
		button[41].setMaximumSize(new Dimension(88, 120));
		button[41].setContentAreaFilled(false);
		button[41].setBorder(null);
		button[41].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[41].getTileType().getIcon())));
		GridBagConstraints gbc_button_41 = new GridBagConstraints();
		gbc_button_41.insets = new Insets(0, 0, 0, 5);
		gbc_button_41.gridx = 5;
		gbc_button_41.gridy = 4;
		colorTile(mapArray[41],button[41]);
		add(button[41], gbc_button_41);
		
		button[42] = new JButton("0");
		button[42].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTile = mapArray[42];
				currentButton = button[42];
			}
		});
		button[42].setPreferredSize(new Dimension(88, 120));
		button[42].setMinimumSize(new Dimension(88, 120));
		button[42].setMaximumSize(new Dimension(88, 120));
		button[42].setContentAreaFilled(false);
		button[42].setBorder(null);
		button[42].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[42].getTileType().getIcon())));
		GridBagConstraints gbc_button_42 = new GridBagConstraints();
		gbc_button_42.insets = new Insets(0, 0, 0, 5);
		gbc_button_42.gridx = 6;
		gbc_button_42.gridy = 4;
		colorTile(mapArray[42],button[42]);
		add(button[42], gbc_button_42);
		
		button[43] = new JButton("0");
		button[43].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTile = mapArray[43];
				currentButton = button[43];
			}
		});
		button[43].setPreferredSize(new Dimension(88, 120));
		button[43].setMinimumSize(new Dimension(88, 120));
		button[43].setMaximumSize(new Dimension(88, 120));
		button[43].setContentAreaFilled(false);
		button[43].setBorder(null);
		button[43].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[43].getTileType().getIcon())));
		GridBagConstraints gbc_button_43 = new GridBagConstraints();
		gbc_button_43.insets = new Insets(0, 0, 0, 5);
		gbc_button_43.gridx = 7;
		gbc_button_43.gridy = 4;
		colorTile(mapArray[43],button[43]);
		add(button[43], gbc_button_43);
		
		button[44] = new JButton("0");
		button[44].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTile = mapArray[44];
				currentButton = button[44];
			}
		});
		button[44].setPreferredSize(new Dimension(88, 120));
		button[44].setMinimumSize(new Dimension(88, 120));
		button[44].setMaximumSize(new Dimension(88, 120));
		button[44].setContentAreaFilled(false);
		button[44].setBorder(null);
		button[44].setIcon(new ImageIcon(MapUI.class.getResource(mapArray[44].getTileType().getIcon())));
		GridBagConstraints gbc_button_44 = new GridBagConstraints();
		gbc_button_44.gridx = 8;
		gbc_button_44.gridy = 4;
		colorTile(mapArray[44],button[44]);
		add(button[44], gbc_button_44);
		
	}
	
	//getters and setters
	public void setParent(GameScreenUI gcui){
		parent = gcui;
	}
	
	public Tile getCurrentTile(){
		return currentTile;
	}
	public JButton getCurrentButton(){
		return currentButton;
	}
	
	public JButton[] getButtons(){
		return button;
	}
	
	public Tile[] getTiles(){
		return mapArray;
	}
	
}
