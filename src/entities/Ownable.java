/**
 * @author Aleksander & Emil
 * Gruppe 
 * 02362 Projekt i software-udvikling 
 */
package entities;

import java.awt.Color;
import java.io.IOException;

import controllers.Game;
import controllers.GameBoard;
import controllers.mGUI;

public abstract class Ownable implements Field {
	//ATTRIBUTES
	protected String Title;
	protected String Description = "";
	protected String SubText;
	protected String Picture;
	protected Color bgColor;
	protected Text file = new Text("BuyProperty.txt");
	protected String[] TxtList = null;
	protected int owned = 0;
	protected int price;
	protected int rent;
	protected int owner;
	protected Color Colour;
	protected boolean mortgage = false;
	
	
	public Ownable(String title, String description, String subText, Color color, int playerID, int cost, int rent)
	{
		Title = title;
		Description = description;
		SubText = subText;
		Colour = color;
		owner = playerID;
		price = cost;
		
	}
	//METHODS
	
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
	public void setRent(){
		
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
	public void setPrice(){
		
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
	public void setOwner(int ID){
		owner = ID;
	}
	
	/**
	 * Returns the owner (integer?) of the field, corresponding to the player number (int) of the player owning the field
	 */
	public int getOwner(){
		
		return owner;
		
	}
	
	/**
	 * Handles the action if a player lands on a field that is owned by another player and need to pay rent
	 */
	public void payRent(Game game, int p, GameBoard gameboard, int b, int rent){
		game.playerList.get(p).getAccount().addBalance(-rent);
		game.playerList.get(((Ownable)gameboard.FieldList.get(b)).getOwner()).getAccount().addBalance(rent);

	}
	
	/**
	 * Tages senere
	 * @return
	 */
//	public int playerOwned(){
//		return (tages senere) ;
//		
//	}
	
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
	
	/**
	 * Gets the subtext of a  field
	 * @return Subtext
	 */
	public String getSub(){
		return SubText;
	
	}

	/**
	 * Sets the subtext ofa field
	 */
	public void setSub(String sub){
		SubText = sub;
	}
	
	/**
	 * 
	 */
	public String toString(int value)
	{
		String ret = "" + value;
		return ret;
	}
	
	public	void buyProperty(Game game, GameBoard gameboard, mGUI mui, int playerID, int boardValue)
	{
		boolean buyPropperty = mui.get2Buttons("Do you want to buy this propperty?", "Buy", "Do nothing");
		if (buyPropperty){
	
			game.playerList.get(playerID).getAccount().addBalance(-(((Ownable) gameboard.FieldList.get(boardValue)).getPrice()));
			((Ownable) gameboard.FieldList.get(boardValue)).setOwner(playerID);
			mui.setOwner(boardValue, game.playerList.get(playerID).getName());
		}
	}
	
}
