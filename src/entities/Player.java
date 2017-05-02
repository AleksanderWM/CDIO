/**
 * @author Simon
 * Gruppe 
 * 02362 Projekt i software-udvikling 
 */

package entities;

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
		return name;
	}
	
	public int getOutOfJail(){
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


