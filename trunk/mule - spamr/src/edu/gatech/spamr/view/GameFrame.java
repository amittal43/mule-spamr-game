package edu.gatech.spamr.view;

import javax.swing.JFrame;

/** 
 * The GameFrame class creates a frame for our panels to run in.  
 * 
 * @author Sean Lachenberg
 * @author Aditya Mittal
 * @author Mike Vail
 * @author Puja Sheth
 * @author Raj Prateek
 * @version 1.0 10/07/2013 
 */

public class GameFrame {

	//creates a frame for our panels to run in
	
	

	//off java tutorial at http://docs.oracle.com/javase/tutorial/uiswing/components/frame.html
	//1. Create the frame.
	JFrame frame = new JFrame("SPAMR40-M.U.L.E.");

	//2. Optional: What happens when the frame closes?
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	//3. Create components and put them in the frame.
	//...create emptyLabel...
	frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

	//4. Size the frame.
	frame.pack();

	//5. Show it.
	frame.setVisible(true);
	
	
	
	
	
	
	
}
