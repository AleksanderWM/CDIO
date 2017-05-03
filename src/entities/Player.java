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

public class Player {


	private int position = 0;
	private Account Account;
	private int getOutOfJail = 0;
	private int ID = 0;
	private String name;
	
	private int maxfields;
	DBconnector connector = new DBconnector();
	
	public Player(String name, int ID){
			this.Account = new Account(ID);
			this.ID = ID;
			this.name = name;
		try {
			connector.doUpdate("game","INSERT into PLAYER values(" + ID + ",'" + name +"', " + position + ", " + getOutOfJail +");");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public String getName(){
		connector.Connect("game");
		String playername = null;
		try {
			ResultSet rs = connector.doQuery("Game","SELECT name FROM PLAYER WHERE "+ ID +"EQUALS PlayerID");
			while(rs.next()){
				String names = rs.getString("Name");
				connector.close();
				playername = names;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(name != playername){
			name = playername;
		}
		return name;
	}
	
	public void setName(String name){
		connector.Connect("game");
		try {
			connector.doUpdate("Game","UPDATE Player SET name = " + name + " WHERE PlayerID EQUALS " + ID + ");");
				connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getOutOfJail(){
		connector.Connect("game");
		int amountOfFreecards = 0;
		try {
			ResultSet rs = connector.doQuery("Game","SELECT name FROM PLAYER WHERE "+ ID +"EQUALS PlayerID");
			while(rs.next()){
				int freecards = rs.getInt("GetOutOfJail");
				connector.close();
				amountOfFreecards = freecards;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(amountOfFreecards != getOutOfJail){
			getOutOfJail = amountOfFreecards;
		}
	return getOutOfJail;
	}
	
	public void setOutOfJail(int Amount){
		connector.Connect("game");
		int goojNow = getOutOfJail + Amount;
		getOutOfJail = goojNow;
		try {
			connector.doUpdate("Game","UPDATE Player SET GetOutOfJail = " + goojNow + " WHERE PlayerID EQUALS " + ID + ");");
				connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getPosition(){
		connector.Connect("game");
		int playerPosition = 0;
		try {
			ResultSet rs = connector.doQuery("Game","SELECT position FROM PLAYER WHERE "+ ID +"EQUALS PlayerID");
			while(rs.next()){
				int position = rs.getInt("Position");
				connector.close();
				playerPosition = position;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(playerPosition != position){
			position = playerPosition;
		}
		return position;
	}
	
	public void setPosition(int newPosition){
		connector.Connect("game");
		position = newPosition;
		try {
			connector.doUpdate("Game","UPDATE Player SET Position = " + newPosition + " WHERE PlayerID EQUALS " + ID + ");");
				connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void movePosition(int moves){
		connector.Connect("game");
		int newPosition = moves + position;
		if(newPosition > maxfields){
			newPosition = newPosition % maxfields;
			Account.addBalance(ID, 4000);
		}
		position = newPosition;
		try {
			connector.doUpdate("Game","UPDATE Player SET Position = " + newPosition + " WHERE PlayerID EQUALS " + ID + ");");
				connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Account getAccount(){
		return Account;
	}
	
	public void setAccount(Account Account){
		this.Account = Account;
	}
	
	public int getID(){
		return ID;
	}
	
	public void setID(int ID){
		this.ID = ID;
		connector.Connect("game");
		try {
			connector.doUpdate("Game","UPDATE Player SET PlayerID = " + ID + " WHERE PlayerID EQUALS " + this.ID + ");");
				connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}


