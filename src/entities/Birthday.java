package entities;

import java.sql.SQLException;

public class Birthday extends ChanceCard{
	
	protected int Fee;

	public Birthday(int ID, int Type, String Des, int fee) {
		super(ID, Type, Des);
		this.Fee = fee;
		// TODO Auto-generated constructor stub
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

	public int getFee(){
		return Fee;
	}
	
	public void setFee(){
		
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
