package entities;

import java.sql.ResultSet;
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
		try {
			connector.doUpdate("chance","INSERT into Chance values(" + ID + "," + Type + ", '" + Des + "');");
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	
	public void setDescription(String des){
		Description = des;
		connector.Connect("chance");
		try {
			connector.doUpdate("chance","UPDATE chance SET chancetype = " + des + " WHERE ChanceID = " + ID + ";");
				connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String getDescription(){
		return Description;
	}
	
	public int getdbType(){
		connector.Connect("chance");
		int ChanceType = 0;
		try {
		ResultSet rs = connector.doQuery("chance","SELECT ChanceType FROM Chance WHERE ChanceID = "+ ID +";");
		while(rs.next()){
		ChanceType = rs.getInt("chancetype");
		}
		connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ChanceType;
	}
	
	public int getdbID(){
		connector.Connect("chance");
		int ChanceID = 0;
		try {
		ResultSet rs = connector.doQuery("chance","SELECT ChanceID FROM Chance WHERE ChanceID = "+ ID +";");
		while(rs.next()){
		ChanceID = rs.getInt("chanceID");
		}
		connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ChanceID;
	}
	
	public String getDescriptionFdb(int ChanceID){
		connector.Connect("chance");
		String des = null;
		try {
		ResultSet rs = connector.doQuery("chance","SELECT ChanceType FROM Chance WHERE ChanceID = "+ ChanceID +";");
		while(rs.next()){
		des = rs.getString("Description");
		}
		connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return des;
	}
	
	public int getTypeFDB(int ChanceID){
		connector.Connect("chance");
		int ChanceType = 0;
		try {
		ResultSet rs = connector.doQuery("chance","SELECT ChanceType FROM Chance WHERE ChanceID = "+ ChanceID +";");
		while(rs.next()){
		ChanceType = rs.getInt("chancetype");
		}
		connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ChanceType;
	}

	
	
	public abstract void removeChance(ChanceCard card);
	
	public abstract void loadChance();
		
}
