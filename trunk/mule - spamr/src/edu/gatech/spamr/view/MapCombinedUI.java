package edu.gatech.spamr.view;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JPanel;

import edu.gatech.spamr.model.Map;

public class MapCombinedUI extends JPanel {
	private MapUI map;
	private PersonInfo person;
	
	/**
	 * Create the panel.
	 */
	public MapCombinedUI() {
		map = new MapUI(new Map(null));
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
