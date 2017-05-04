/**
 * @author Ana-Maria Fischer Zokalj, s165160
 * Gruppe 
 * 02362 Projekt i software-udvikling 
 */


package entities;

public class Shaker {

	//attributes
	private Dice dice1;
	private Dice dice2;
	private int shakerValue;

	
	//constructor
	public Shaker() {

	dice1 = new Dice(6);
	dice2 = new Dice(6);

	}
	
	//Methods 
	
	public void shakeShaker() {
	dice1.roll();
	dice2.roll();


	}
	
	
	public int getDice1Value() {

	return dice1.getRoll();

	}
	
	public int getDice2Value() {

	return dice2.getRoll();

	}
	
	public int getShake() {

	int shakerValue = dice1.getRoll() + dice2.getRoll();
	return shakerValue;

	}
	
	public void setShake() {


	}

	}
	
	
