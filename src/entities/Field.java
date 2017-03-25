/**
 * @author Aleksander & Emil
 * Gruppe 
 * 02362 Projekt i software-udvikling 
 */
package entities;

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
	public void setDescription();
	
	/**
	 * Method for getting title
	 * @return Title on the field
	 */
	public String getTitle();
	/**
	 * Method for setting title
	 */
	public void setTitle();
	
	/**
	 * Method for getting number
	 * @return Number of the field
	 */
	public int getNumber();
	/**
	 * Method for setting number
	 */
	public void setNumber();
	
}
