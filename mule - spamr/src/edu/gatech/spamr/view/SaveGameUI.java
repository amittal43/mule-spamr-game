package edu.gatech.spamr.view;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JPanel;

import edu.gatech.spamr.model.Player;

/** 
 * The SaveGameUI class represents a way for the player to save the game.
 *  
 * @author Sean Lachenberg
 * @author Aditya Mittal
 * @author Mike Vail
 * @author Puja Sheth
 * @author Raj Prateek
 * @version 1.0 10/22/2013 
 */

public class SaveGameUI implements Serializable {
	//create the variables; this should include information of all 4 players
	private Player person1;
	
	/**
	 * Create the panel.
	 */
	public SaveGameUI(String s) {
		//assuming that all the information is saved as a string
		String sav = s.concat(".dat");
	    try {
	        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(sav));
	        oos.writeObject(person1);
	        oos.close();
	    } 
	    catch(Exception ex) {
	        ex.printStackTrace();
	    }
	}

}

//public void Load(String s){
//    if(s.contains(".dat")){
//        try {
//            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(s));
//            person1 = (Player)ois.readObject();
//            ois.close();
//        } catch(Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//}
