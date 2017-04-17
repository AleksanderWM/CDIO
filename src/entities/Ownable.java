/**
 * @author Aleksander & Emil
 * Gruppe 
 * 02362 Projekt i software-udvikling 
 */
package entities;

public abstract class Ownable implements Field {
	//ATTRIBUTES
	
	int price;
	int rent;
	Player owner;
	boolean mortgage;
	int number;
	String description;
	String title;
	
	//METHODS
	
	@Override
	public void landOnField() {
		
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String desc) {
		description = desc;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(String titl) {
		title = titl;
	}

	@Override
	public int getNumber() {
		return number;
	}

	@Override
	public void setNumber(int numb) {
		number = numb;
	}

	/**
	 * Lets a player buy a field, deducting price and changing owner
	 */
	public void buyField() {
	}
	
	/**
	 * Lets a player unown a Field
	 */
	public void sellField(){
		
	}
	
	/**
	 * The action when a player lands on a specific field
	 */
	public void actionField(){
		
	}
	
	/**
	 * Sets the rent of a field
	 */
	public void setRent(int ren){
		rent = ren;
	}
	
	/**
	 * Gets the rent of a field
	 * @return The rent of the field
	 */
	public int getRent(){
		return rent;
		
	}

	/**
	 * Sets the price of the field
	 */
	public void setPrice(int pri){
		price = pri;
	}
	
	/**
	 * Gets the price of the field
	 * @return The price of the field
	 */
	public int getPrice(){
		return price;
		
	}
	
	/**
	 * Sets the owner of the field to an integer, corresponding to the player number (int) of the player owning the field
	 */
	public void setOwner(Player own){
		owner = own;
	}
	
	/**
	 * Returns the owner (integer?) of the field, corresponding to the player number (int) of the player owning the field
	 */
	public Player getOwner(){
		return owner;
	}
	
	/**
	 * Handles the action if a player lands on a field that is owned by another player and need to pay rent
	 */
	public void payRent(int own, int rent){
		
	}
	
	/**
	 * Tages senere
	 * @return
	 */
	public int playerOwned(){
		return (tages senere) ;


	/**
	 * Sets a field to a mortgaged state
	 */
	public void mortgage(){
		mortgage = true;
	}
	
	/**
	 * Sets a field to an unmortgaged state
	 */
	public void unmortgage(){
		mortgage = false;
	}
	
	/**
	 * Gets the current mortgage state of a field
	 * @return The mortgage state of the field (boolean)
	 */
	public boolean getMortgageState(){
		return mortgage;
		
	}
}
