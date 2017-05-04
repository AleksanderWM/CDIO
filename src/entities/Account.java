/**
 * @author Simon
 * Gruppe 
 * 02362 Projekt i software-udvikling 
 */

package entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import controllers.DBconnector;

public class Account {
	
	DBconnector connector = new DBconnector();

	/**
	 * Account attributes
	 */
	int ID;
	int money;
	int networth;
	
	/**
	 * Account constructor
	 * @param Money and net worth predefined as 30000
	 */
	public Account(int ID){
		this.ID = ID;
		this.money = 30000;
		this.networth = 30000;
		try{
		connector.doUpdate("game","INSERT into ACCOUNT values(" + ID + "," + 30000 + "," + 30000 + ");");
		}
		 catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	/**
	 * @return money
	 */
	public int getMoney(){
		return money;
	}
	
	/**
	 * add a given amount of money to the balance and net worth
	 */
	public void addBalance(int money){
		connector.Connect("game");
		int newBalance = this.money + money;
		int newNetworth = networth + money;
		money = newBalance;
		networth = newNetworth;
		try {
			connector.doUpdate("Game","UPDATE ACCOUNT SET Money = " + newBalance + " WHERE PlayerID EQUALS " + ID + ");");
			connector.doUpdate("Game","UPDATE ACCOUNT SET networth = " + newNetworth + " WHERE PlayerID EQUALS " + ID + ");");
				connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * sets the balance to a specific amount
	 * adds the difference to net worth
	 */
	public void setBalance(int balance){
		int dif = balance - money;
		networth = networth + dif;
		money = balance;
		connector.Connect("game");
		try {
			connector.doUpdate("Game","UPDATE ACCOUNT SET Money = " + balance + " WHERE PlayerID EQUALS " + ID + ");");
			connector.doUpdate("Game","UPDATE ACCOUNT SET networth = " + networth + " WHERE PlayerID EQUALS " + ID + ");");
				connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @param Checks if the player has enough money to purchase something at a given price
	 * @return boolean,  false if the player can't pay the price
	 */
	public boolean enoughMoney(int price){
			return money > price;
		
	}
}