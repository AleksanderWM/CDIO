/**
 * @author Aleksander & Emil
 * Gruppe 
 * 02362 Projekt i software-udvikling 
 */
package entities;

import java.awt.Color;

public interface Field {

//METHODS
	/**
	 * Method for the action landing on a field.
	 */
	public void landOnField();
	
	/**
	 * Method for getting description
	 * @return Description of the current field
	 */
	public String getDescription();
	/**
	 * Method for setting description
	 */
	public void setDescription(String desc);
	
	/**
	 * Method for getting title
	 * @return Title on the field
	 */
	public String getTitle();
	/**
	 * Method for setting title
	 */
	public void setTitle(String titl);
	
	/**
	 * Method for getting number
	 * @return Number of the field
	 */
	public int getNumber();
	/**
	 * Method for setting number
	 */
	public void setNumber(int numb);
	
	/**
	 * Method for setting the Colour of a field
	 * @param colour the Java.awt.Color
	 */
	public void setColour(Color colour);
	
	/**
	 * Method for getting the Colour of a field
	 */
	public Color getColour();
}
