package entities;

import java.awt.Color;

public class Property extends Ownable {

	
	public Property(String title, String description, String subText, Color color, Player player,int cost,int rent) 
	{
		super(title, description, subText, color, player, cost, rent);
	}
	@Override
	public void landOnField() {
	}

	@Override
	public String getDescription() {
		
		return null;
	}

	@Override
	public void setDescription(String desc) {
	}

	@Override
	public String getTitle() {
		
		return null;
	}

	@Override
	public void setTitle(String titl) {
	}

	@Override
	public int getNumber() {
		
		return 0;
	}

	@Override
	public void setNumber(int numb) {
	}

}
