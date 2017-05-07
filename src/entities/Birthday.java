package entities;

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
}
