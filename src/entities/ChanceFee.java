/**
 * @author Simon
 * Gruppe 
 * 02362 Projekt i software-udvikling 
 */
package entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChanceFee extends ChanceCard{

	private int Fee;
	
	public ChanceFee(int ID, int Type, String Des, int Fee) {
		super(ID, Type, Des);
		this.Fee = Fee;
	}
	
	public void addToDB(){
		try {
			connector.doUpdate("chance","INSERT into Chance values(" + ID + "," + Type + ", '" + Description + "');");
			connector.doUpdate("chance","INSERT into Fee values(" + ID + "," + Fee + ");");
			connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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

	public int getdbFee(){
		connector.Connect("chance");
		int fee = 0;
		try {
		ResultSet rs = connector.doQuery("chance","SELECT fee FROM fee WHERE feeID = "+ ID +";");
		while(rs.next()){
		fee = rs.getInt("Fee");
		}
		connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fee;
	}
	
	public int getFeeFDB(int ChanceID){
		connector.Connect("chance");
		int Fee = 0;
		try {
		ResultSet rs = connector.doQuery("chance","SELECT Fee FROM birthday WHERE birthdayID = "+ ChanceID +";");
		while(rs.next()){
		Fee = rs.getInt("chancetype");
		}
		connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Fee;
	}
	
	@Override
	public void loadChance() {
		// TODO Auto-generated method stub
		ID = getdbID();
		Type = getdbType();
		Fee = getdbFee();
		
	}
}
