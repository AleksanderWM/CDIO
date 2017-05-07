/**
 * @author Simon
 * Gruppe 
 * 02362 Projekt i software-udvikling 
 */
package entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Matador extends ChanceCard{
	
	protected int MaxNetworth;
	protected int Bonus;

	public Matador(int ID, int Type, String Des, int Max, int Bonus) {
		super(ID, Type, Des);
		this.Bonus = Bonus;
		this.MaxNetworth = Max;
		try {
			connector.doUpdate("chance","INSERT into Matador values(" + ID + "," + Max + "," + Bonus + ");");
			connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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

	public int getdbMax(){
		connector.Connect("chance");
		int Max = 0;
		try {
		ResultSet rs = connector.doQuery("chance","SELECT max FROM Matador WHERE MatadorID = "+ ID +";");
		while(rs.next()){
		Max = rs.getInt("Max");
		}
		connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Max;
	}
	
	public int getdbBonus(){
		connector.Connect("chance");
		int B = 0;
		try {
		ResultSet rs = connector.doQuery("chance","SELECT bonus FROM Matador WHERE MatadorID = "+ ID +";");
		while(rs.next()){
		B = rs.getInt("bonus");
		}
		connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return B;
	}

	@Override
	public void loadChance() {
		MaxNetworth = getdbMax();
		Bonus = getdbBonus();
		ID = getdbID();
		Type = getdbType();
	}
	
	public int getMaxFDB(int ChanceID){
		connector.Connect("chance");
		int Max = 0;
		try {
		ResultSet rs = connector.doQuery("chance","SELECT max FROM matador WHERE matadorid = "+ ChanceID +";");
		while(rs.next()){
		Max = rs.getInt("chancetype");
		}
		connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Max;
	}
	
	public int getBonusFDB(int ChanceID){
		connector.Connect("chance");
		int B = 0;
		try {
		ResultSet rs = connector.doQuery("chance","SELECT bonus FROM Matador WHERE matadorid = "+ ChanceID +";");
		while(rs.next()){
		B = rs.getInt("chancetype");
		}
		connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return B;
	}
}
