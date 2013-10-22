package edu.gatech.spamr.view;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JPanel;

public class MapCombinedUI extends JPanel {
	private MapUI map;
	private PersonInfo person;
	
	/**
	 * Create the panel.
	 */
	public MapCombinedUI() {
		map = new MapUI();
		person = new PersonInfo();	
	}
	
	public void makeSubPanel(Container pane){
		JPanel subPanel1 = new JPanel();
		subPanel1.add(map);
		JPanel subPanel2 = new JPanel();
		subPanel2.add(person);
		
		pane.add(subPanel1, BorderLayout.NORTH);
		pane.add(subPanel2, BorderLayout.SOUTH);
	}

}
