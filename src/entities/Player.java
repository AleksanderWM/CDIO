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
	
	private int maxfields;
	DBconnector connector = new DBconnector();
	
	public Player(String name, int ID){
		try {
			connector.doUpdate("game","INSERT into PLAYER values(" + ID + ",'" + name +"', " + position + ", " + getOutOfJail +");");
			new Account(ID);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public String getName(int ID){
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
		return playername;
	}
	
	public int getOutOfJail(int ID){
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
		return amountOfFreecards;
	}
	
	public int getPosition(int ID){
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
		return playerPosition;
	}
	
	public void setPosition(int ID, int newPosition){
		connector.Connect("game");
		try {
			connector.doUpdate("Game","UPDATE Player SET Position = " + newPosition + " WHERE PlayerID EQUALS " + ID + ");");
				connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void movePosition(int ID, int moves){
		connector.Connect("game");
		int newPosition = moves + getPosition(ID);
		if(newPosition > maxfields){
			newPosition = newPosition % maxfields;
			Account.addBalance(ID, 4000);
		}
		try {
			connector.doUpdate("Game","UPDATE Player SET Position = " + newPosition + " WHERE PlayerID EQUALS " + ID + ");");
				connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Account getAccount(int ID){
		return Account;
	}
	
}

