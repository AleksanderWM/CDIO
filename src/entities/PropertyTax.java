package entities;

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
	
	public int getHouseTax(){
		return HouseTax;
	}
	
	public void setHouseTax(){
	}
	
	public int getHotelTax(){
		return HotelTax;
	}
	
	public void setHotelTax(){
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
}