/**
 * @author Simon
 * Gruppe 
 * 02362 Projekt i software-udvikling 
 */

package entities;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;

import controllers.DBconnector;
import entities.Account;

public class Player {


	private int position = 0;
	private int ID = 1;
	private Account Account;
	
	private int maxfields;
	DBconnector connector = new DBconnector();
	
	public Player(String name, Color colour){
		try {
			connector.doUpdate("game","INSERT into PLAYER values(" + ID + ",'" + name +"', '" + colour +"', "+ position + ", " + 0 +");");
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
	
	
//	public void setName(String name){
//		this.name = name;
//	}
	
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
	
	public void setID(int number){
		this.ID = number;
	}
	

}