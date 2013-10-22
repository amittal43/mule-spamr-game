package edu.gatech.spamr.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PersonInfo extends JPanel {

	/**
	 * Create the panel.
	 */
	public PersonInfo() {
		LayoutManager people = null;
		this.setLayout(people);
	    ((FlowLayout) people).setAlignment(FlowLayout.TRAILING);
	    this.setLayout(new FlowLayout());
	    
	  //Add person info as labels to the experiment layout
	    this.add(new JLabel("Person 1"));
	    this.add(new JLabel("Person 2"));
	    this.add(new JLabel("Person 3"));
	    this.add(new JLabel("Person 4"));
	}

}