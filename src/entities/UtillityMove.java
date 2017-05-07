package entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UtillityMove extends ChanceCard {

	protected int Multiplier;
	
	public UtillityMove(int ID, int Type, String Des, int Multi) {
		super(ID, Type, Des);
		Multiplier = Multi;
		try {
			connector.doUpdate("chance","INSERT into UtillityMove values(" + ID + "," + Multi + ");");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated constructor stub
	}

	public int getMultiplier(){
		return Multiplier;
	}
	
	public void setMutliplier(int ChanceMulti){
		Multiplier = ChanceMulti;
		connector.Connect("chance");
		try {
			connector.doUpdate("chance","UPDATE UtillityMove SET multiplier = " + ChanceMulti + " WHERE UtillityMove = " + ID + ";");
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
			connector.doUpdate("Chance","DELETE FROM utillitymove WHERE " + card.getChanceID() +  "= UtillityMoveID;");
				connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getdbMulti(){
		connector.Connect("chance");
		int multi = 0;
		try {
		ResultSet rs = connector.doQuery("chance","SELECT multiplier FROM UtillityMove WHERE UtillityMoveID = "+ ID +";");
		while(rs.next()){
		multi = rs.getInt("multiplier");
		}
		connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return multi;
	}
	
	public int getMultiFDB(int ChanceID){
		connector.Connect("chance");
		int M = 0;
		try {
		ResultSet rs = connector.doQuery("chance","SELECT multiplier FROM utillitymove WHERE utillitymoveID = "+ ChanceID +";");
		while(rs.next()){
		M = rs.getInt("chancetype");
		}
		connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return M;
	}
	
	@Override
	public void loadChance() {
		ID = getdbID();
		Type = getdbType();
		Multiplier = getdbMulti();
		
	}
}
