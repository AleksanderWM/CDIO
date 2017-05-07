package entities;

import java.sql.SQLException;

public class UtillityMove extends ChanceCard {

	protected int Multiplier;
	
	public UtillityMove(int ID, int Type, String Des, int Multi) {
		super(ID, Type, Des);
		Multiplier = Multi;
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
}
