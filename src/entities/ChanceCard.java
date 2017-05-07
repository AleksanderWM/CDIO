package entities;

public abstract class ChanceCard {
	
	protected int ID;
	protected int Type;
	protected String Description;
	
	public ChanceCard(int ID, int Type, String Des){
		this.ID = ID;
		this.Type = Type;
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
