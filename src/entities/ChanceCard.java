package entities;

public abstract class ChanceCard {

	protected int ChanceID;
	protected int ChanceType;
	protected String Description = null;
	
	public ChanceCard (int ID, int Type, String Des){
		ChanceID = ID;
		ChanceType = Type;
		Description = Des;
	}
	
	public abstract void Chance();
	
	public abstract int getChanceID();
	
	public abstract void setChanceID();
	
	public abstract int getChanceType();
	
	public abstract void setChanceType();
	
	public abstract String getDescription();
	
	public abstract void setDescription();
}

