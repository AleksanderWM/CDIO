package entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import controllers.DBconnector;

public class Account {
	
	DBconnector connector = new DBconnector();

	int ID;
	int money;
	
	public Account(int ID){
		this.ID = ID;
		this.money = 30000;
		try{
		connector.doUpdate("game","INSERT into ACCOUNT values(" + ID + "," + 30000 + "," + 30000 + ");");
		}
		 catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public int getMoney(){
		return money;
	}
	
	public void addBalance(int money){
		connector.Connect("game");
		int newBalance = money + money;
		money = newBalance;
		try {
			connector.doUpdate("Game","UPDATE ACCOUNT SET Money = " + newBalance + " WHERE PlayerID EQUALS " + ID + ");");
				connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void setBalance(int balance){
		money = balance;
		connector.Connect("game");
		try {
			connector.doUpdate("Game","UPDATE ACCOUNT SET Money = " + balance + " WHERE PlayerID EQUALS " + ID + ");");
				connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean enoughMoney(int price){
			return money > price;
		
	}
}