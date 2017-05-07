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

	public abstract int getChanceID();
	
	public abstract void setChanceID();
	
	public abstract int getChanceType();
	
	public abstract void setChanceType();
	
	public abstract String getDescription();
	
	public abstract void setDescription();
	
	public abstract void removeChance(ChanceCard card);
		
}
