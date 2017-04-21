package entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import controllers.DBconnector;

public class Account {
	
	DBconnector connector = new DBconnector();

	public Account(int ID){
		try{
		connector.doUpdate("game","INSERT into ACCOUNT values(" + ID + "," + 30000 + "," + 30000 + ");");
		}
		 catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public int getMoney(int ID){
		connector.Connect("game");
		int Moneys = 0;
		try {
			ResultSet rs = connector.doQuery("Game","SELECT Money FROM ACCOUNT WHERE "+ ID +"EQUALS PlayerID");
			while(rs.next()){
				int Money = rs.getInt("Money");
				connector.close();
				Moneys = Money;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Moneys;
	}
	
	public void addBalance(int ID, int money){
		connector.Connect("game");
		int newBalance = money + getMoney(ID);
		try {
			connector.doUpdate("Game","UPDATE ACCOUNT SET Money = " + newBalance + " WHERE PlayerID EQUALS " + ID + ");");
				connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void setBalance(int ID, int balance){
		connector.Connect("game");
		try {
			connector.doUpdate("Game","UPDATE ACCOUNT SET Money = " + balance + " WHERE PlayerID EQUALS " + ID + ");");
				connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean enoughMoney(int ID, int price){
			connector.Connect("game");
			int Moneys = 0;
			try {
				ResultSet rs = connector.doQuery("Game","SELECT Money FROM ACCOUNT WHERE "+ ID +"EQUALS PlayerID");
				while(rs.next()){
					int Money = rs.getInt("Money");
					connector.close();
					Moneys = Money;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return Moneys > price;
		
	}
}