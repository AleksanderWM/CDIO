package entities;

import java.sql.SQLException;

public class UtillityMove extends ChanceCard {

	protected int Multiplier;
	
	public UtillityMove(int ID, int Type, String Des, int Multi) {
		super(ID, Type, Des);
		Multiplier = Multi;
	}

	@Override
	public int getChanceID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setChanceID() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getChanceType() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setChanceType() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDescription() {
		// TODO Auto-generated method stub
		
	}
	
	public int getMultiplier(){
		return Multiplier;
	}
	
	public void setMultiplier(){
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
