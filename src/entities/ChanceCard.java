package entities;

import java.sql.SQLException;

import controllers.DBconnector;

public abstract class ChanceCard {
	
	protected int ID = 0;
	protected int Type;
	protected String Description;
	
	DBconnector connector = new DBconnector();
	
	public ChanceCard(int ID, int Type, String Des){
		this.ID = ID;
		this.Type = Type;
		Description = Des;
	}

	public int getChanceID(){
	return ID;
	}

	public void setChanceID(int ChanceID){
			connector.Connect("chance");
			try {
				connector.doUpdate("chance","UPDATE chance SET ChanceID = " + ChanceID + " WHERE ChanceID = " + ID + ";");
				ID = ChanceID;
					connector.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public int getChanceType(){
		return Type;
	}
	
	public void setChanceType(int ChanceType){
		Type = ChanceType;
		connector.Connect("chance");
		try {
			connector.doUpdate("chance","UPDATE chance SET chancetype = " + ChanceType + " WHERE ChanceID = " + ID + ";");
				connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String getDescription(){
		return Description;
	}
	
	public abstract void removeChance(ChanceCard card);
		
}
