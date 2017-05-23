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
	private int position = 1;
	private Account Account;
	private int getOutOfJail = 0;
	private int ID;
	private int JailTries;
	private String name;
	
	private int maxfields = 40;
	DBconnector connector = new DBconnector();
	
	
	/**
	 * Player constructor
	 * @param Inserts player into the game database
	 */
	public Player(String name, int ID, int pos, int gooj, int jtries){
			this.Account = new Account(ID);
			this.ID = ID;
			this.name = name;
			getOutOfJail = gooj;
			JailTries = jtries;
			position = pos;
	}
	
	public void savePlayerDB(){
		try {
			connector.doUpdate("game","INSERT into PLAYER values(" + ID + ",'" + name + "', " + position + ", " + getOutOfJail +" , " + JailTries + ");");
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
	}
	
	public void saveNameDB(){
		String nameToSave = getName();
		try {
			connector.doUpdate("game", "UPDATE Player SET Name = " + nameToSave + " WHERE PlayerID = " + ID + ";");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String getNameFDB(int playerNumber){
		String playerFDB = null;
		try {
			ResultSet rs = connector.doQuery("game", "Select Name FROM Player WHERE PlayerID = " + playerNumber + ";");
			if(rs.next()){
			playerFDB = rs.getString("Name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return playerFDB;
	}
	
	public void savePositionDB(){
		int positionToSave = getPosition();
		try {
			connector.doUpdate("game", "UPDATE Player SET Position = " + positionToSave + " WHERE PlayerID = " + ID + ";");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getPositionFDB(int playerNumber){
		int positionFDB = 0;
		try {
			ResultSet rs = connector.doQuery("game", "Select Position FROM Player WHERE PlayerID = " + playerNumber + ";");
			if(rs.next()){
			positionFDB = rs.getInt("Position");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return positionFDB;
	}
	
	public void saveGOOJDB(){
		int GOOJToSave = getOutOfJail();
		try {
			connector.doUpdate("game", "UPDATE Player SET GetOutOfJail = " + GOOJToSave + " WHERE PlayerID = " + ID + ";");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getGOOJFDB(int playerNumber){
		int GOOJFDB = 0;
		try {
			ResultSet rs = connector.doQuery("game", "Select GetOutOfJail FROM Player WHERE PlayerID = " + playerNumber + ";");
			if(rs.next()){
			GOOJFDB = rs.getInt("GetOutOfJail");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return GOOJFDB;
	}
	
	public void savePlayerIDDB(){
		int playerIDToSave = getID();
		try {
			connector.doUpdate("game", "UPDATE Player SET PlayerID = " + playerIDToSave + " WHERE PlayerID = " + ID + ";");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getPlayerIDFDB(int playerNumber){
		int playerIDFDB = 0;
		try {
			ResultSet rs = connector.doQuery("game", "Select PlayerID FROM Player WHERE PlayerID = " + playerNumber + ";");
			if(rs.next()){
			playerIDFDB = rs.getInt("PlayerID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return playerIDFDB;
	}
	
	public void saveJailTriesDB(){
		int jailTriesToSave = getID();
		try {
			connector.doUpdate("game", "UPDATE Player SET Jailtries = " + jailTriesToSave + " WHERE PlayerID = " + ID + ";");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getJailTriesFDB(int playerNumber){
		int jailTriesFDB = 0;
		try {
			ResultSet rs = connector.doQuery("game", "Select Jailtries FROM Player WHERE PlayerID = " + playerNumber + ";");
			if(rs.next()){
			jailTriesFDB = rs.getInt("Jailtries");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jailTriesFDB;
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
	 * loadPlayer takes the name, position and getOutOfJail attributes from the database
	 * and checks if the attributes are the same as the java attributes
	 * if not, the java attributes are set to match the database attributes
	 * And call the updateAccount method
	 */
	public void updatePlayer(){
		connector.Connect("game");
	
		try {
			ResultSet rs = connector.doQuery("Game","SELECT position, getoutofjail, Jailtries FROM PLAYER WHERE PlayerID = "+ ID +";");
				int pos = 0;
				int gooj = 0;
				int Jailtried = 0;
				while(rs.next()){
				pos = rs.getInt("position");
				gooj = rs.getInt("getoutofjail");
				Jailtried = rs.getInt("jailtries");
				}
				connector.close();
				if(position != pos){
					setPosition(position);
				}
				if(getOutOfJail != gooj){
					setOutOfJail(getOutOfJail);
				}
				if(this.JailTries != Jailtried){
					setJailTries(this.JailTries);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Account.updateAccount();
		
		}
	
	
	public int getJailTries(){
		return JailTries;
	}
	public void resetJailTries(){
		JailTries = 0;
	}
	public void setJailTries(int trys){
		JailTries = JailTries + trys;
		connector.Connect("game");
		try {
			connector.doUpdate("Game","UPDATE Player SET jailtrys = " + JailTries + " WHERE PlayerID EQUALS " + ID + ";");
				connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int countplayerinDB(){
		connector.Connect("chance");
		int count = 0;
		try {
		ResultSet rs = connector.doQuery("game"," SELECT COUNT * FROM Player;");
		while(rs.next()){
		count = rs.getInt("chancetype");
		}
		connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	
	/**
	 * Loads the Player and Account tables from DB into java
	 */
	public void loadPlayer(){
		connector.Connect("game");
	
		try {
			ResultSet rs = connector.doQuery("Game","SELECT name, position, getoutofjail, Jailtries FROM PLAYER WHERE PlayerID = "+ ID +";");

				while(rs.next()){
				name = rs.getString("name");
				position = rs.getInt("position");
				getOutOfJail = rs.getInt("getoutofjail");
				JailTries = rs.getInt("jailtries");
				}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Account.loadAccount();
		
		}
}


