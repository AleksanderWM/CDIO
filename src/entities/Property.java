package entities;

import java.awt.Color;

import controllers.Game;
import controllers.GameBoard;
import controllers.mGUI;

public class Property extends Ownable {
	
	private int Houses = 0;
	private int Hotel = 0;
	
	public Property(String title, String subText, Color colour, int player,int cost,int rent) 
	{
		super(title, subText, colour, player, cost, rent);
	}
	@Override
	public void landOnField(Game game, GameBoard gameboard, int b, int p, mGUI mui, Shaker shake) {
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
	
	public int getHouses(){
		return Houses;
	}
	/**
	 * Only add 1 or -1 House at a time
	 * @param houses
	 */
	public void addHouses(int houses){
		this.Houses = this.Houses + houses;
		if(Houses > 4){
			Houses = 0;
			Hotel = 1;
		}
		if(Hotel == 1 && houses == -1){
			Hotel = 0;
			Houses = 4;
		}
	}
	
	public int getHotel(){
		return Hotel;
	}

}
