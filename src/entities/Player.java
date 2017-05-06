/**
 * @author Simon
 * Gruppe 
 * 02362 Projekt i software-udvikling 
 */

package entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import controllers.DBconnector;
import entities.Account;
import javafx.scene.paint.Color;

public class Player {

	/**	
	 * The Players attributes
	 * @param position and getOutOfJail start values predefined
	 */
	private int position = 0;
	private Account Account;
	private int getOutOfJail = 0;
	private int ID;
	private String name;
	
	private int maxfields = 40;
	DBconnector connector = new DBconnector();
	
	
	/**
	 * Player constructor
	 * @param Inserts player into the game database
	 */
	public Player(String name, int ID){
			this.Account = new Account(ID);
			this.ID = ID;
			this.name = name;
		try {
			connector.doUpdate("game","INSERT into PLAYER values(" + ID + ",'" + name + "', " + position + ", " + getOutOfJail +");");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @return name
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * @param sets the name to a given string
	 * @param change the name attribute in both java and the database
	 */
	public void setName(String name){
		this.name = name;
		connector.Connect("game");
		try {
			connector.doUpdate("Game","UPDATE Player SET name = " + name + " WHERE PlayerID = " + ID + ";");
				connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * return the amount of getOutOfJail free cards
	 * @return getOutOfJail 
	 */
	public int getOutOfJail(){
	return getOutOfJail;
	}
	
	/**
	 * @param change the amount of getOutOfJail cards by the Amount
	 * @param Can be used when the player gets a new getOutOfJail free card
	 * @param or when one is used
	 */	
	public void setOutOfJail(int Amount){
		connector.Connect("game");
		int goojNow = getOutOfJail + Amount;
		getOutOfJail = goojNow;
		try {
			connector.doUpdate("Game","UPDATE Player SET GetOutOfJail = " + goojNow + " WHERE PlayerID = " + ID + ";");
				connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @return position
	 */
	public int getPosition(){
		return position;
	}
	
	/**
	 * sets the position to a given specific position
	 * @param attribute changed in both java and the database
	 */
	public void setPosition(int newPosition){
		connector.Connect("game");
		position = newPosition;
		try {
			connector.doUpdate("Game","UPDATE Player SET Position = " + newPosition + " WHERE PlayerID = " + ID + ";");
				connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Moves the player a given amounts of position forward
	 * @param attributes changed in both java and the database
	 * @param if the player lands on or pass by the Go field 4000 is added to the players account
	 */
	public void movePosition(int moves){
		connector.Connect("game");
		int newPosition = moves + position;
		if(newPosition > maxfields){
			newPosition = newPosition % maxfields;
			Account.addBalance(4000);
		}
		position = newPosition;
		try {
			connector.doUpdate("game","UPDATE Player SET Position = " + newPosition + " WHERE PlayerID = " + ID + ";");
				connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @return Account
	 */
	public Account getAccount(){
		return Account;
	}
	
	/**
	 * Change the player account to a new account
	 */
	public void setAccount(Account Account){
		this.Account = Account;
	}
	
	/**
	 * @return ID
	 */
	public int getID(){
		return ID;
	}
	
	/**
	 * Change the players ID to a new ID
	 */
	public void setID(int ID){
		this.ID = ID;
		connector.Connect("game");
		try {
			connector.doUpdate("Game","UPDATE Player SET PlayerID = " + ID + " WHERE PlayerID EQUALS " + this.ID + ";");
				connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * updatePlayer takes the name, position and getOutOfJail attributes from the database
	 * and checks if the attributes are the same as the java attributes
	 * if not, the java attributes are set to match the database attributes
	 * And call the updateAccount method
	 */
	public void updatePlayer(){
		connector.Connect("game");
	
		try {
			ResultSet rs = connector.doQuery("Game","SELECT name, position, getoutofjail FROM PLAYER WHERE PlayerID = "+ ID +";");
			while(rs.next()){
				String names = rs.getString("Name");
				int pos = rs.getInt("position");
				int gooj = rs.getInt("getoutofjail");
				connector.close();
				if(name != names){
					name = names;
				}
				if(position != pos){
					position = pos;
				}
				if(getOutOfJail != gooj){
					getOutOfJail = gooj;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Account.updateAccount();
		
	}
}


