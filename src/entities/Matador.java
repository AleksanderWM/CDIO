package entities;

import java.sql.SQLException;

public class Matador extends ChanceCard{
	
	protected int MaxNetworth;
	protected int Bonus;

	public Matador(int ID, int Type, String Des, int Max, int Bonus) {
		super(ID, Type, Des);
		this.Bonus = Bonus;
		this.MaxNetworth = Max;
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
	
	public int getMaxNetworth(){
		return MaxNetworth;
	}

	public void setMaxNetworth(){
		
	}
	
	public int getBonus(){
		return Bonus;
	}
	
	public void setBonus(){
		
	}

	@Override
	public void removeChance(ChanceCard card) {
		connector.Connect("chance");
		try {
			connector.doUpdate("Chance","DELETE FROM chance WHERE " + card.getChanceID() +  "= ChanceID;");
			connector.doUpdate("Chance","DELETE FROM matador WHERE " + card.getChanceID() +  "= MatadorID;");
				connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
