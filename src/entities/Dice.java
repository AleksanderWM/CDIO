/**
 * @author Ana-Maria Fischer Zokalj, s165160
 * Gruppe 
 * 02362 Projekt i software-udvikling 
 * Reference: the dice class is from "indledende programmering(02314)"-
 * tavlenoter, lektion 4.
 * Some of the variable, method and object names have been changed. 
 */


package entities;

public class Dice {
	
	private final int MAX = 6;
	
	private int faceValue;
	
	public Dice (int value) {
		
		faceValue = value;
		
	}
	
	public int roll() {
		faceValue = (int)(Math.random() * MAX) + 1;
		return faceValue;
		
			
	}
	
	public void setRoll(int value) {
		faceValue = value;
		
	}
	
	
	public int getRoll() {
		return faceValue;
				
	}
	
		
}
