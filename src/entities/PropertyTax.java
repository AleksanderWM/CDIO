package entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PropertyTax extends ChanceCard{
	
	protected int HouseTax;
	protected int HotelTax;

	public PropertyTax(int ID, int Type, String Des, int House, int Hotel) {
		super(ID, Type, Des);
		HouseTax = House;
		HotelTax = Hotel;
		// TODO Auto-generated constructor stub
	}
	
	public int getHouseTax(){
		return HouseTax;
	}
	
	public void setHoteltax(int ChanceHoteltax){
		HotelTax = ChanceHoteltax;
		connector.Connect("chance");
		try {
			connector.doUpdate("chance","UPDATE PropertyTax SET hoteltax = " + ChanceHoteltax + " WHERE PropertytaxID = " + ID + ";");
				connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getHotelTax(){
		return HotelTax;
	}
	
	public void setHouseTax(int ChanceHousetax){
		HouseTax = ChanceHousetax;
		connector.Connect("chance");
		try {
			connector.doUpdate("chance","UPDATE PropertyTax SET housetax = " + ChanceHousetax + " WHERE PropertytaxID = " + ID + ";");
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
			connector.doUpdate("Chance","DELETE FROM propertytax WHERE " + card.getChanceID() +  "= propertytaxID;");
				connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getdbHouseTax(){
		connector.Connect("chance");
		int HT = 0;
		try {
		ResultSet rs = connector.doQuery("chance","SELECT housetax FROM propertytax WHERE propertytaxID = "+ ID +";");
		while(rs.next()){
		HT = rs.getInt("housetax");
		}
		connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return HT;
	}
	
	public int getdbHotelTax(){
		connector.Connect("chance");
		int HT = 0;
		try {
		ResultSet rs = connector.doQuery("chance","SELECT hoteltax FROM propertytax WHERE propertytaxID = "+ ID +";");
		while(rs.next()){
		HT = rs.getInt("hoteltax");
		}
		connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return HT;
	}
	@Override
	public void loadChance() {
		// TODO Auto-generated method stub
		ID = getdbID();
		Type = getdbType();
		HotelTax = getdbHotelTax();
		HouseTax = getdbHouseTax();
	}
}