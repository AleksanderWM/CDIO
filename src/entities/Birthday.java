package entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Birthday extends ChanceCard{
	
	protected int Fee;

	public Birthday(int ID, int Type, String Des, int fee) {
		super(ID, Type, Des);
		this.Fee = fee;
		// TODO Auto-generated constructor stub
	}
	
	public int getFee(){
		return Fee;
	}
	
	public void setFee(int ChanceFee){
		Fee = ChanceFee;
		connector.Connect("chance");
		try {
			connector.doUpdate("chance","UPDATE birthday SET Fee = " + ChanceFee + " WHERE BirthdayID = " + ID + ";");
				connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeChance(ChanceCard card) {
		connector.Connect("chance");
		try {
			connector.doUpdate("Chance","DELETE FROM chance WHERE " + card.getChanceID() +  "= ChanceID;");
			connector.doUpdate("Chance","DELETE FROM birthday WHERE " + card.getChanceID() +  "= birthdayID;");
				connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getdbFee(){
		connector.Connect("chance");
		int fee = 0;
		try {
		ResultSet rs = connector.doQuery("chance","SELECT fee FROM birthday WHERE birthdayID = "+ ID +";");
		while(rs.next()){
		fee = rs.getInt("fee");
		}
		connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fee;
	}
	
	@Override
	public void loadChance() {
		// TODO Auto-generated method stub
		ID = getdbID();
		Type = getdbType();
		Fee = getdbFee();
		
	}
}
