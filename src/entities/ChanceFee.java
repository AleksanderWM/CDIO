package entities;

import java.sql.SQLException;

public class ChanceFee extends ChanceCard{

	private int Fee;
	
	public ChanceFee(int ID, int Type, String Des, int Fee) {
		super(ID, Type, Des);
		
		this.Fee = Fee;
		// TODO Auto-generated constructor stub
	}

	public int getFee(){
		return Fee;
	}
	
	public void setFee(int ChanceFee){
		Fee = ChanceFee;
		connector.Connect("chance");
		try {
			connector.doUpdate("chance","UPDATE Fee SET Fee = " + ChanceFee + " WHERE FeeID = " + ID + ";");
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
			connector.doUpdate("Chance","DELETE FROM fee WHERE " + card.getChanceID() +  "= FeeID;");
				connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
