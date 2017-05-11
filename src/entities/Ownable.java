/**
 * @author Aleksander & Emil
 * Gruppe 
 * 02362 Projekt i software-udvikling 
 */
package entities;

import java.awt.Color;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import controllers.DBconnector;
import controllers.Game;
import controllers.GameBoard;
import controllers.mGUI;

/**
 * @author Emil Jørgensen
 *
 */
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
	protected int FieldID;
	DBconnector connector = new DBconnector();
	
	/**
	 * Abstract constructor for an ownable field
	 * @param title
	 * @param description
	 * @param subText
	 * @param color
	 * @param playerID
	 * @param cost
	 * @param rent
	 */
	public Ownable(int fieldNumber,String title, String description, String subText, Color color, int playerID, int cost, int rent, boolean mortgageState)
	{
		FieldID = fieldNumber;
		Title = title;
		Description = description;
		SubText = subText;
		Colour = color;
		owner = playerID;
		price = cost;
		mortgage = mortgageState;
		this.rent = rent;
		
	}
	
	public void saveOwnableDB(int fieldNumber, int playerID, int cost, int mortgageState){
		try {
			connector.doUpdate("game","INSERT into OWNABLE values(" + fieldNumber + ", " + playerID + ", " + cost + ", " + mortgageState + " );");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void saveOwnerDB(){
		int own = getOwner();
		try {
			connector.doUpdate("game", "UPDATE Ownable SET Owner = " + own + " WHERE FieldID = " + FieldID + ";");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getOwnerFDB(){
		connector.Connect("game");
		int O = 0;
		try {
		ResultSet rs = connector.doQuery("game","SELECT owner FROM ownable WHERE fieldID = "+ FieldID +";");
		while(rs.next()){
		O = rs.getInt("owner");
		}
		connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return O;
	}
	
	public void savePriceDB(){
		int price = getPrice();
		try {
			connector.doUpdate("game", "UPDATE Ownable SET price = " + price + " WHERE FieldID = " + FieldID + ";");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getPriceFDB(){
		connector.Connect("game");
		int end = 0;
		try {
		ResultSet rs = connector.doQuery("game","SELECT price FROM ownable WHERE fieldID = "+ FieldID +";");
		while(rs.next()){
		end = rs.getInt("price");
		}
		connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return end;
	}
	
	public void saveMortgageStateDB(){
		boolean mort;
		int end;
		if(mort = getMortgageState()){
			end = 1;
		}else{
			end = 2;
		}
		try {
			connector.doUpdate("game", "UPDATE Ownable SET mortage = " + end + " WHERE FieldID = " + FieldID + ";");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean getMortgageStateFDB(){
		connector.Connect("game");
		boolean end = false;
		int mort = 0;
		try {
		ResultSet rs = connector.doQuery("game","SELECT mortgage FROM ownable WHERE fieldID = "+ FieldID +";");
		while(rs.next()){
		mort = rs.getInt("mortgage");
		}
		connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(mort == 1){
			end = true;
		}else if(mort == 0){
			end = false;
		}
		return end;
	}

	public void setRent(int RENT){
		rent = RENT;
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
	public void setPrice(int cost){
		price = cost;
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
	public void payRent(Game game, int p, GameBoard gameboard, int b, int rent, mGUI mui){
		game.playerList.get(p).getAccount().addBalance(-rent);
		mui.setBalance(game, p);
		game.playerList.get(((Ownable)gameboard.FieldList.get(b)).getOwner()).getAccount().addBalance(rent);
		mui.setBalance(game, ((Ownable)gameboard.FieldList.get(b)).getOwner());
	}
	
	/**
	 * Sets a field to a mortgaged state
	 */
	public void mortgage(){
		mortgage = true;
	}
	
	
	public int setMortgageDB(boolean mortgage){
		if(mortgage){
			return 1;
		}
		else{
			return 0;
		}
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
	public boolean getMortgageStateDB(int b){
		if(b == 1){
			return true;
		}
		else{
			return false;
		}
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
	
	/**
	 * Handles buying the property
	 * @param game
	 * @param gameboard
	 * @param mui
	 * @param playerID
	 * @param boardValue
	 */
	public	void buyProperty(Game game, GameBoard gameboard, mGUI mui, int playerID, int boardValue)
	{
		boolean buyPropperty = mui.get2Buttons("Do you want to buy this property?", "Buy", "Do nothing");
		if (buyPropperty){
	
			game.playerList.get(playerID).getAccount().addBalance(-(((Ownable) gameboard.FieldList.get(boardValue)).getPrice()));
			((Ownable) gameboard.FieldList.get(boardValue)).setOwner(playerID);
			mui.setOwner(boardValue, game.playerList.get(playerID).getName());
		}
	}
	
	public abstract void loadfield();

	public boolean getMortgageState() {
		return mortgage;
	}
	

	public int getFieldID(){
		return FieldID;
		
	}
	
}
