package edu.gatech.spamr.view;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.border.BevelBorder;

import java.awt.Component;

import javax.swing.border.MatteBorder;

import edu.gatech.spamr.model.Map;
import edu.gatech.spamr.model.Map.MapType;
import edu.gatech.spamr.model.Tile;

import java.awt.Color;

public class MapUI extends JPanel {
	private Map map = new Map(MapType.DEFAULT);
	private Tile[] mapArray = map.getMapArray();

	/**
	 * Create the panel.
	 */
	public MapUI() {
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
		
		JButton button = new JButton("0");
		button.setContentAreaFilled(false);
		button.setBorder(null);
		button.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[0].getTileType().getIcon())));
		button.setMaximumSize(new Dimension(88, 120));
		button.setMinimumSize(new Dimension(88, 120));
		button.setPreferredSize(new Dimension(88, 120));
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 0;
		gbc_button.gridy = 0;
		add(button, gbc_button);
		
		JButton button_1 = new JButton("0");
		button_1.setPreferredSize(new Dimension(88, 120));
		button_1.setMinimumSize(new Dimension(88, 120));
		button_1.setMaximumSize(new Dimension(88, 120));
		button_1.setContentAreaFilled(false);
		button_1.setBorder(null);
		button_1.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[1].getTileType().getIcon())));
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 1;
		gbc_button_1.gridy = 0;
		add(button_1, gbc_button_1);
		
		JButton button_2 = new JButton("0");
		button_2.setPreferredSize(new Dimension(88, 120));
		button_2.setMinimumSize(new Dimension(88, 120));
		button_2.setMaximumSize(new Dimension(88, 120));
		button_2.setContentAreaFilled(false);
		button_2.setBorder(null);
		button_2.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[2].getTileType().getIcon())));
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.insets = new Insets(0, 0, 5, 5);
		gbc_button_2.gridx = 2;
		gbc_button_2.gridy = 0;
		add(button_2, gbc_button_2);
		
		JButton button_3 = new JButton("0");
		button_3.setPreferredSize(new Dimension(88, 120));
		button_3.setMinimumSize(new Dimension(88, 120));
		button_3.setMaximumSize(new Dimension(88, 120));
		button_3.setContentAreaFilled(false);
		button_3.setBorder(null);
		button_3.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[3].getTileType().getIcon())));
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.insets = new Insets(0, 0, 5, 5);
		gbc_button_3.gridx = 3;
		gbc_button_3.gridy = 0;
		add(button_3, gbc_button_3);
		
		JButton button_4 = new JButton("0");
		button_4.setPreferredSize(new Dimension(88, 120));
		button_4.setMinimumSize(new Dimension(88, 120));
		button_4.setMaximumSize(new Dimension(88, 120));
		button_4.setContentAreaFilled(false);
		button_4.setBorder(null);
		button_4.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[4].getTileType().getIcon())));
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.insets = new Insets(0, 0, 5, 5);
		gbc_button_4.gridx = 4;
		gbc_button_4.gridy = 0;
		add(button_4, gbc_button_4);
		
		JButton button_5 = new JButton("0");
		button_5.setPreferredSize(new Dimension(88, 120));
		button_5.setMinimumSize(new Dimension(88, 120));
		button_5.setMaximumSize(new Dimension(88, 120));
		button_5.setContentAreaFilled(false);
		button_5.setBorder(null);
		button_5.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[5].getTileType().getIcon())));
		GridBagConstraints gbc_button_5 = new GridBagConstraints();
		gbc_button_5.insets = new Insets(0, 0, 5, 5);
		gbc_button_5.gridx = 5;
		gbc_button_5.gridy = 0;
		add(button_5, gbc_button_5);
		
		JButton button_6 = new JButton("0");
		button_6.setPreferredSize(new Dimension(88, 120));
		button_6.setMinimumSize(new Dimension(88, 120));
		button_6.setMaximumSize(new Dimension(88, 120));
		button_6.setContentAreaFilled(false);
		button_6.setBorder(null);
		button_6.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[6].getTileType().getIcon())));
		GridBagConstraints gbc_button_6 = new GridBagConstraints();
		gbc_button_6.insets = new Insets(0, 0, 5, 5);
		gbc_button_6.gridx = 6;
		gbc_button_6.gridy = 0;
		add(button_6, gbc_button_6);
		
		JButton button_7 = new JButton("0");
		button_7.setPreferredSize(new Dimension(88, 120));
		button_7.setMinimumSize(new Dimension(88, 120));
		button_7.setMaximumSize(new Dimension(88, 120));
		button_7.setContentAreaFilled(false);
		button_7.setBorder(null);
		button_7.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[7].getTileType().getIcon())));
		GridBagConstraints gbc_button_7 = new GridBagConstraints();
		gbc_button_7.insets = new Insets(0, 0, 5, 5);
		gbc_button_7.gridx = 7;
		gbc_button_7.gridy = 0;
		add(button_7, gbc_button_7);
		
		JButton button_8 = new JButton("0");
		button_8.setPreferredSize(new Dimension(88, 120));
		button_8.setMinimumSize(new Dimension(88, 120));
		button_8.setMaximumSize(new Dimension(88, 120));
		button_8.setContentAreaFilled(false);
		button_8.setBorder(null);
		button_8.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[8].getTileType().getIcon())));
		GridBagConstraints gbc_button_8 = new GridBagConstraints();
		gbc_button_8.insets = new Insets(0, 0, 5, 0);
		gbc_button_8.gridx = 8;
		gbc_button_8.gridy = 0;
		add(button_8, gbc_button_8);
		
		JButton button_9 = new JButton("0");
		button_9.setPreferredSize(new Dimension(88, 120));
		button_9.setMinimumSize(new Dimension(88, 120));
		button_9.setMaximumSize(new Dimension(88, 120));
		button_9.setContentAreaFilled(false);
		button_9.setBorder(null);
		button_9.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[9].getTileType().getIcon())));
		GridBagConstraints gbc_button_9 = new GridBagConstraints();
		gbc_button_9.insets = new Insets(0, 0, 5, 5);
		gbc_button_9.gridx = 0;
		gbc_button_9.gridy = 1;
		add(button_9, gbc_button_9);
		
		JButton button_10 = new JButton("0");
		button_10.setPreferredSize(new Dimension(88, 120));
		button_10.setMinimumSize(new Dimension(88, 120));
		button_10.setMaximumSize(new Dimension(88, 120));
		button_10.setContentAreaFilled(false);
		button_10.setBorder(null);
		button_10.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[10].getTileType().getIcon())));
		GridBagConstraints gbc_button_10 = new GridBagConstraints();
		gbc_button_10.insets = new Insets(0, 0, 5, 5);
		gbc_button_10.gridx = 1;
		gbc_button_10.gridy = 1;
		add(button_10, gbc_button_10);
		
		JButton button_11 = new JButton("0");
		button_11.setPreferredSize(new Dimension(88, 120));
		button_11.setMinimumSize(new Dimension(88, 120));
		button_11.setMaximumSize(new Dimension(88, 120));
		button_11.setContentAreaFilled(false);
		button_11.setBorder(null);
		button_11.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[11].getTileType().getIcon())));
		GridBagConstraints gbc_button_11 = new GridBagConstraints();
		gbc_button_11.insets = new Insets(0, 0, 5, 5);
		gbc_button_11.gridx = 2;
		gbc_button_11.gridy = 1;
		add(button_11, gbc_button_11);
		
		JButton button_12 = new JButton("0");
		button_12.setPreferredSize(new Dimension(88, 120));
		button_12.setMinimumSize(new Dimension(88, 120));
		button_12.setMaximumSize(new Dimension(88, 120));
		button_12.setContentAreaFilled(false);
		button_12.setBorder(null);
		button_12.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[12].getTileType().getIcon())));
		GridBagConstraints gbc_button_12 = new GridBagConstraints();
		gbc_button_12.insets = new Insets(0, 0, 5, 5);
		gbc_button_12.gridx = 3;
		gbc_button_12.gridy = 1;
		add(button_12, gbc_button_12);
		
		JButton button_13 = new JButton("0");
		button_13.setPreferredSize(new Dimension(88, 120));
		button_13.setMinimumSize(new Dimension(88, 120));
		button_13.setMaximumSize(new Dimension(88, 120));
		button_13.setContentAreaFilled(false);
		button_13.setBorder(null);
		button_13.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[13].getTileType().getIcon())));
		GridBagConstraints gbc_button_13 = new GridBagConstraints();
		gbc_button_13.insets = new Insets(0, 0, 5, 5);
		gbc_button_13.gridx = 4;
		gbc_button_13.gridy = 1;
		add(button_13, gbc_button_13);
		
		JButton button_14 = new JButton("0");
		button_14.setPreferredSize(new Dimension(88, 120));
		button_14.setMinimumSize(new Dimension(88, 120));
		button_14.setMaximumSize(new Dimension(88, 120));
		button_14.setContentAreaFilled(false);
		button_14.setBorder(null);
		button_14.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[14].getTileType().getIcon())));
		GridBagConstraints gbc_button_14 = new GridBagConstraints();
		gbc_button_14.insets = new Insets(0, 0, 5, 5);
		gbc_button_14.gridx = 5;
		gbc_button_14.gridy = 1;
		add(button_14, gbc_button_14);
		
		JButton button_15 = new JButton("0");
		button_15.setPreferredSize(new Dimension(88, 120));
		button_15.setMinimumSize(new Dimension(88, 120));
		button_15.setMaximumSize(new Dimension(88, 120));
		button_15.setContentAreaFilled(false);
		button_15.setBorder(null);
		button_15.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[15].getTileType().getIcon())));
		GridBagConstraints gbc_button_15 = new GridBagConstraints();
		gbc_button_15.insets = new Insets(0, 0, 5, 5);
		gbc_button_15.gridx = 6;
		gbc_button_15.gridy = 1;
		add(button_15, gbc_button_15);
		
		JButton button_16 = new JButton("0");
		button_16.setPreferredSize(new Dimension(88, 120));
		button_16.setMinimumSize(new Dimension(88, 120));
		button_16.setMaximumSize(new Dimension(88, 120));
		button_16.setContentAreaFilled(false);
		button_16.setBorder(null);
		button_16.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[16].getTileType().getIcon())));
		GridBagConstraints gbc_button_16 = new GridBagConstraints();
		gbc_button_16.insets = new Insets(0, 0, 5, 5);
		gbc_button_16.gridx = 7;
		gbc_button_16.gridy = 1;
		add(button_16, gbc_button_16);
		
		JButton button_17 = new JButton("0");
		button_17.setPreferredSize(new Dimension(88, 120));
		button_17.setMinimumSize(new Dimension(88, 120));
		button_17.setMaximumSize(new Dimension(88, 120));
		button_17.setContentAreaFilled(false);
		button_17.setBorder(null);
		button_17.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[17].getTileType().getIcon())));
		GridBagConstraints gbc_button_17 = new GridBagConstraints();
		gbc_button_17.insets = new Insets(0, 0, 5, 0);
		gbc_button_17.gridx = 8;
		gbc_button_17.gridy = 1;
		add(button_17, gbc_button_17);
		
		JButton button_18 = new JButton("0");
		button_18.setPreferredSize(new Dimension(88, 120));
		button_18.setMinimumSize(new Dimension(88, 120));
		button_18.setMaximumSize(new Dimension(88, 120));
		button_18.setContentAreaFilled(false);
		button_18.setBorder(null);
		button_18.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[18].getTileType().getIcon())));
		GridBagConstraints gbc_button_18 = new GridBagConstraints();
		gbc_button_18.insets = new Insets(0, 0, 5, 5);
		gbc_button_18.gridx = 0;
		gbc_button_18.gridy = 2;
		add(button_18, gbc_button_18);
		
		JButton button_19 = new JButton("0");
		button_19.setPreferredSize(new Dimension(88, 120));
		button_19.setMinimumSize(new Dimension(88, 120));
		button_19.setMaximumSize(new Dimension(88, 120));
		button_19.setContentAreaFilled(false);
		button_19.setBorder(null);
		button_19.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[19].getTileType().getIcon())));
		GridBagConstraints gbc_button_19 = new GridBagConstraints();
		gbc_button_19.insets = new Insets(0, 0, 5, 5);
		gbc_button_19.gridx = 1;
		gbc_button_19.gridy = 2;
		add(button_19, gbc_button_19);
		
		JButton button_20 = new JButton("0");
		button_20.setPreferredSize(new Dimension(88, 120));
		button_20.setMinimumSize(new Dimension(88, 120));
		button_20.setMaximumSize(new Dimension(88, 120));
		button_20.setContentAreaFilled(false);
		button_20.setBorder(null);
		button_20.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[20].getTileType().getIcon())));
		GridBagConstraints gbc_button_20 = new GridBagConstraints();
		gbc_button_20.insets = new Insets(0, 0, 5, 5);
		gbc_button_20.gridx = 2;
		gbc_button_20.gridy = 2;
		add(button_20, gbc_button_20);
		
		JButton button_21 = new JButton("0");
		button_21.setPreferredSize(new Dimension(88, 120));
		button_21.setMinimumSize(new Dimension(88, 120));
		button_21.setMaximumSize(new Dimension(88, 120));
		button_21.setContentAreaFilled(false);
		button_21.setBorder(null);
		button_21.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[21].getTileType().getIcon())));
		GridBagConstraints gbc_button_21 = new GridBagConstraints();
		gbc_button_21.insets = new Insets(0, 0, 5, 5);
		gbc_button_21.gridx = 3;
		gbc_button_21.gridy = 2;
		add(button_21, gbc_button_21);
		
		JButton button_22 = new JButton("0");
		button_22.setPreferredSize(new Dimension(88, 120));
		button_22.setMinimumSize(new Dimension(88, 120));
		button_22.setMaximumSize(new Dimension(88, 120));
		button_22.setContentAreaFilled(false);
		button_22.setBorder(null);
		button_22.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[22].getTileType().getIcon())));
		GridBagConstraints gbc_button_22 = new GridBagConstraints();
		gbc_button_22.insets = new Insets(0, 0, 5, 5);
		gbc_button_22.gridx = 4;
		gbc_button_22.gridy = 2;
		add(button_22, gbc_button_22);
		
		JButton button_23 = new JButton("0");
		button_23.setPreferredSize(new Dimension(88, 120));
		button_23.setMinimumSize(new Dimension(88, 120));
		button_23.setMaximumSize(new Dimension(88, 120));
		button_23.setContentAreaFilled(false);
		button_23.setBorder(null);
		button_23.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[23].getTileType().getIcon())));
		GridBagConstraints gbc_button_23 = new GridBagConstraints();
		gbc_button_23.insets = new Insets(0, 0, 5, 5);
		gbc_button_23.gridx = 5;
		gbc_button_23.gridy = 2;
		add(button_23, gbc_button_23);
		
		JButton button_24 = new JButton("0");
		button_24.setPreferredSize(new Dimension(88, 120));
		button_24.setMinimumSize(new Dimension(88, 120));
		button_24.setMaximumSize(new Dimension(88, 120));
		button_24.setContentAreaFilled(false);
		button_24.setBorder(null);
		button_24.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[24].getTileType().getIcon())));
		GridBagConstraints gbc_button_24 = new GridBagConstraints();
		gbc_button_24.insets = new Insets(0, 0, 5, 5);
		gbc_button_24.gridx = 6;
		gbc_button_24.gridy = 2;
		add(button_24, gbc_button_24);
		
		JButton button_25 = new JButton("0");
		button_25.setPreferredSize(new Dimension(88, 120));
		button_25.setMinimumSize(new Dimension(88, 120));
		button_25.setMaximumSize(new Dimension(88, 120));
		button_25.setContentAreaFilled(false);
		button_25.setBorder(null);
		button_25.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[25].getTileType().getIcon())));
		GridBagConstraints gbc_button_25 = new GridBagConstraints();
		gbc_button_25.insets = new Insets(0, 0, 5, 5);
		gbc_button_25.gridx = 7;
		gbc_button_25.gridy = 2;
		add(button_25, gbc_button_25);
		
		JButton button_26 = new JButton("0");
		button_26.setPreferredSize(new Dimension(88, 120));
		button_26.setMinimumSize(new Dimension(88, 120));
		button_26.setMaximumSize(new Dimension(88, 120));
		button_26.setContentAreaFilled(false);
		button_26.setBorder(null);
		button_26.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[26].getTileType().getIcon())));
		GridBagConstraints gbc_button_26 = new GridBagConstraints();
		gbc_button_26.insets = new Insets(0, 0, 5, 0);
		gbc_button_26.gridx = 8;
		gbc_button_26.gridy = 2;
		add(button_26, gbc_button_26);
		
		JButton button_27 = new JButton("0");
		button_27.setPreferredSize(new Dimension(88, 120));
		button_27.setMinimumSize(new Dimension(88, 120));
		button_27.setMaximumSize(new Dimension(88, 120));
		button_27.setContentAreaFilled(false);
		button_27.setBorder(null);
		button_27.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[27].getTileType().getIcon())));
		GridBagConstraints gbc_button_27 = new GridBagConstraints();
		gbc_button_27.insets = new Insets(0, 0, 5, 5);
		gbc_button_27.gridx = 0;
		gbc_button_27.gridy = 3;
		add(button_27, gbc_button_27);
		
		JButton button_28 = new JButton("0");
		button_28.setPreferredSize(new Dimension(88, 120));
		button_28.setMinimumSize(new Dimension(88, 120));
		button_28.setMaximumSize(new Dimension(88, 120));
		button_28.setContentAreaFilled(false);
		button_28.setBorder(null);
		button_28.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[28].getTileType().getIcon())));
		GridBagConstraints gbc_button_28 = new GridBagConstraints();
		gbc_button_28.insets = new Insets(0, 0, 5, 5);
		gbc_button_28.gridx = 1;
		gbc_button_28.gridy = 3;
		add(button_28, gbc_button_28);
		
		JButton button_29 = new JButton("0");
		button_29.setPreferredSize(new Dimension(88, 120));
		button_29.setMinimumSize(new Dimension(88, 120));
		button_29.setMaximumSize(new Dimension(88, 120));
		button_29.setContentAreaFilled(false);
		button_29.setBorder(null);
		button_29.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[29].getTileType().getIcon())));
		GridBagConstraints gbc_button_29 = new GridBagConstraints();
		gbc_button_29.insets = new Insets(0, 0, 5, 5);
		gbc_button_29.gridx = 2;
		gbc_button_29.gridy = 3;
		add(button_29, gbc_button_29);
		
		JButton button_30 = new JButton("0");
		button_30.setPreferredSize(new Dimension(88, 120));
		button_30.setMinimumSize(new Dimension(88, 120));
		button_30.setMaximumSize(new Dimension(88, 120));
		button_30.setContentAreaFilled(false);
		button_30.setBorder(null);
		button_30.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[30].getTileType().getIcon())));
		GridBagConstraints gbc_button_30 = new GridBagConstraints();
		gbc_button_30.insets = new Insets(0, 0, 5, 5);
		gbc_button_30.gridx = 3;
		gbc_button_30.gridy = 3;
		add(button_30, gbc_button_30);
		
		JButton button_31 = new JButton("0");
		button_31.setPreferredSize(new Dimension(88, 120));
		button_31.setMinimumSize(new Dimension(88, 120));
		button_31.setMaximumSize(new Dimension(88, 120));
		button_31.setContentAreaFilled(false);
		button_31.setBorder(null);
		button_31.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[31].getTileType().getIcon())));
		GridBagConstraints gbc_button_31 = new GridBagConstraints();
		gbc_button_31.insets = new Insets(0, 0, 5, 5);
		gbc_button_31.gridx = 4;
		gbc_button_31.gridy = 3;
		add(button_31, gbc_button_31);
		
		JButton button_32 = new JButton("0");
		button_32.setPreferredSize(new Dimension(88, 120));
		button_32.setMinimumSize(new Dimension(88, 120));
		button_32.setMaximumSize(new Dimension(88, 120));
		button_32.setContentAreaFilled(false);
		button_32.setBorder(null);
		button_32.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[32].getTileType().getIcon())));
		GridBagConstraints gbc_button_32 = new GridBagConstraints();
		gbc_button_32.insets = new Insets(0, 0, 5, 5);
		gbc_button_32.gridx = 5;
		gbc_button_32.gridy = 3;
		add(button_32, gbc_button_32);
		
		JButton button_33 = new JButton("0");
		button_33.setPreferredSize(new Dimension(88, 120));
		button_33.setMinimumSize(new Dimension(88, 120));
		button_33.setMaximumSize(new Dimension(88, 120));
		button_33.setContentAreaFilled(false);
		button_33.setBorder(null);
		button_33.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[33].getTileType().getIcon())));
		GridBagConstraints gbc_button_33 = new GridBagConstraints();
		gbc_button_33.insets = new Insets(0, 0, 5, 5);
		gbc_button_33.gridx = 6;
		gbc_button_33.gridy = 3;
		add(button_33, gbc_button_33);
		
		JButton button_34 = new JButton("0");
		button_34.setPreferredSize(new Dimension(88, 120));
		button_34.setMinimumSize(new Dimension(88, 120));
		button_34.setMaximumSize(new Dimension(88, 120));
		button_34.setContentAreaFilled(false);
		button_34.setBorder(null);
		button_34.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[34].getTileType().getIcon())));
		GridBagConstraints gbc_button_34 = new GridBagConstraints();
		gbc_button_34.insets = new Insets(0, 0, 5, 5);
		gbc_button_34.gridx = 7;
		gbc_button_34.gridy = 3;
		add(button_34, gbc_button_34);
		
		JButton button_35 = new JButton("0");
		button_35.setPreferredSize(new Dimension(88, 120));
		button_35.setMinimumSize(new Dimension(88, 120));
		button_35.setMaximumSize(new Dimension(88, 120));
		button_35.setContentAreaFilled(false);
		button_35.setBorder(null);
		button_35.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[35].getTileType().getIcon())));
		GridBagConstraints gbc_button_35 = new GridBagConstraints();
		gbc_button_35.insets = new Insets(0, 0, 5, 0);
		gbc_button_35.gridx = 8;
		gbc_button_35.gridy = 3;
		add(button_35, gbc_button_35);
		
		JButton button_36 = new JButton("0");
		button_36.setPreferredSize(new Dimension(88, 120));
		button_36.setMinimumSize(new Dimension(88, 120));
		button_36.setMaximumSize(new Dimension(88, 120));
		button_36.setContentAreaFilled(false);
		button_36.setBorder(null);
		button_36.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[36].getTileType().getIcon())));
		GridBagConstraints gbc_button_36 = new GridBagConstraints();
		gbc_button_36.insets = new Insets(0, 0, 0, 5);
		gbc_button_36.gridx = 0;
		gbc_button_36.gridy = 4;
		add(button_36, gbc_button_36);
		
		JButton button_37 = new JButton("0");
		button_37.setPreferredSize(new Dimension(88, 120));
		button_37.setMinimumSize(new Dimension(88, 120));
		button_37.setMaximumSize(new Dimension(88, 120));
		button_37.setContentAreaFilled(false);
		button_37.setBorder(null);
		button_37.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[37].getTileType().getIcon())));
		GridBagConstraints gbc_button_37 = new GridBagConstraints();
		gbc_button_37.insets = new Insets(0, 0, 0, 5);
		gbc_button_37.gridx = 1;
		gbc_button_37.gridy = 4;
		add(button_37, gbc_button_37);
		
		JButton button_38 = new JButton("0");
		button_38.setPreferredSize(new Dimension(88, 120));
		button_38.setMinimumSize(new Dimension(88, 120));
		button_38.setMaximumSize(new Dimension(88, 120));
		button_38.setContentAreaFilled(false);
		button_38.setBorder(null);
		button_38.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[38].getTileType().getIcon())));
		GridBagConstraints gbc_button_38 = new GridBagConstraints();
		gbc_button_38.insets = new Insets(0, 0, 0, 5);
		gbc_button_38.gridx = 2;
		gbc_button_38.gridy = 4;
		add(button_38, gbc_button_38);
		
		JButton button_39 = new JButton("0");
		button_39.setPreferredSize(new Dimension(88, 120));
		button_39.setMinimumSize(new Dimension(88, 120));
		button_39.setMaximumSize(new Dimension(88, 120));
		button_39.setContentAreaFilled(false);
		button_39.setBorder(null);
		button_39.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[39].getTileType().getIcon())));
		GridBagConstraints gbc_button_39 = new GridBagConstraints();
		gbc_button_39.insets = new Insets(0, 0, 0, 5);
		gbc_button_39.gridx = 3;
		gbc_button_39.gridy = 4;
		add(button_39, gbc_button_39);
		
		JButton button_40 = new JButton("0");
		button_40.setPreferredSize(new Dimension(88, 120));
		button_40.setMinimumSize(new Dimension(88, 120));
		button_40.setMaximumSize(new Dimension(88, 120));
		button_40.setContentAreaFilled(false);
		button_40.setBorder(null);
		button_40.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[40].getTileType().getIcon())));
		GridBagConstraints gbc_button_40 = new GridBagConstraints();
		gbc_button_40.insets = new Insets(0, 0, 0, 5);
		gbc_button_40.gridx = 4;
		gbc_button_40.gridy = 4;
		add(button_40, gbc_button_40);
		
		JButton button_41 = new JButton("0");
		button_41.setPreferredSize(new Dimension(88, 120));
		button_41.setMinimumSize(new Dimension(88, 120));
		button_41.setMaximumSize(new Dimension(88, 120));
		button_41.setContentAreaFilled(false);
		button_41.setBorder(null);
		button_41.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[41].getTileType().getIcon())));
		GridBagConstraints gbc_button_41 = new GridBagConstraints();
		gbc_button_41.insets = new Insets(0, 0, 0, 5);
		gbc_button_41.gridx = 5;
		gbc_button_41.gridy = 4;
		add(button_41, gbc_button_41);
		
		JButton button_42 = new JButton("0");
		button_42.setPreferredSize(new Dimension(88, 120));
		button_42.setMinimumSize(new Dimension(88, 120));
		button_42.setMaximumSize(new Dimension(88, 120));
		button_42.setContentAreaFilled(false);
		button_42.setBorder(null);
		button_42.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[42].getTileType().getIcon())));
		GridBagConstraints gbc_button_42 = new GridBagConstraints();
		gbc_button_42.insets = new Insets(0, 0, 0, 5);
		gbc_button_42.gridx = 6;
		gbc_button_42.gridy = 4;
		add(button_42, gbc_button_42);
		
		JButton button_43 = new JButton("0");
		button_43.setPreferredSize(new Dimension(88, 120));
		button_43.setMinimumSize(new Dimension(88, 120));
		button_43.setMaximumSize(new Dimension(88, 120));
		button_43.setContentAreaFilled(false);
		button_43.setBorder(null);
		button_43.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[43].getTileType().getIcon())));
		GridBagConstraints gbc_button_43 = new GridBagConstraints();
		gbc_button_43.insets = new Insets(0, 0, 0, 5);
		gbc_button_43.gridx = 7;
		gbc_button_43.gridy = 4;
		add(button_43, gbc_button_43);
		
		JButton button_44 = new JButton("0");
		button_44.setPreferredSize(new Dimension(88, 120));
		button_44.setMinimumSize(new Dimension(88, 120));
		button_44.setMaximumSize(new Dimension(88, 120));
		button_44.setContentAreaFilled(false);
		button_44.setBorder(null);
		button_44.setIcon(new ImageIcon(MapUI.class.getResource(mapArray[44].getTileType().getIcon())));
		GridBagConstraints gbc_button_44 = new GridBagConstraints();
		gbc_button_44.gridx = 8;
		gbc_button_44.gridy = 4;
		add(button_44, gbc_button_44);

	}

}
