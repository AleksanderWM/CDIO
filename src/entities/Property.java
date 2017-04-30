package entities;

import java.awt.Color;

public class Property extends Ownable {
	
	public Property(String title, String subText, Color colour, Player player,int cost,int rent) 
	{
		super(title, subText, colour, player, cost, rent);
	}
	@Override
	public void landOnField() {
	}

	@Override
	public String getDescription() {
		return super.Description;
	}

	@Override
	public void setDescription(String desc) {
		super.Description = desc;
	}

	@Override
	public String getTitle() {
		return super.Title;
	}

	@Override
	public void setTitle(String titl) {
		super.Title = titl;
	}

	@Override
	public int getNumber() {
		return 0;
	}

	@Override
	public void setNumber(int numb) {
	}
	
	@Override
	public void setColour(Color colour) {
		super.Colour = colour;
	}
	
	@Override
	public Color getColour() {
		return super.Colour;
	}
	

}
