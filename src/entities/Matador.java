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


	public int getMaxNetworth(){
		return MaxNetworth;
	}

	public void setMaxNW(int max){
		MaxNetworth = max;
		connector.Connect("chance");
		try {
			connector.doUpdate("chance","UPDATE Matador SET max = " + max + " WHERE matadorID = " + ID + ";");
				connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getBonus(){
		return Bonus;
	}
	
	public void setBonus(int bonus){
		Bonus = bonus;
		connector.Connect("chance");
		try {
			connector.doUpdate("chance","UPDATE Matador SET bonus = " + bonus + " WHERE matadorID = " + ID + ";");
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
			connector.doUpdate("Chance","DELETE FROM matador WHERE " + card.getChanceID() +  "= MatadorID;");
				connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
