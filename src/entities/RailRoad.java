package entities;

import java.awt.Color;

import controllers.Game;
import controllers.GameBoard;
import controllers.mGUI;


public class RailRoad extends Ownable{

	private Color TxColour = Color.BLACK;
	private int ownedRailRoads = 0;
	private int RENT_1 = 500;
	private int RENT_2 = 1000;
	private int RENT_3 = 2000;
	private int RENT_4 = 4000;
	
	public RailRoad(String title, String description, String subText, Color color, int player, int cost, int rent) {
		super(title,description, subText, color, player, cost, rent);
		super.Colour = Color.WHITE;
	}

	@Override
	public void landOnField(Game game, GameBoard gameboard, int b, int p, mGUI mui, Shaker shake) {
		if(((Ownable)gameboard.FieldList.get(b)).getOwner() != owned && ((Ownable)gameboard.FieldList.get(b)).getOwner() != p){
			for(Field item : gameboard.FieldList)
			{
				if((item instanceof RailRoad) && (((Ownable)item).getOwner() == game.playerList.get(((Ownable)gameboard.FieldList.get(b)).getOwner()).getID()))
				{
				ownedRailRoads++;
				}
			}
			payRent(game, p, gameboard, b, rent);
		}
	}
	
	public int getRent() 
	{
		int rent = 0;
		switch(ownedRailRoads)
		{
		case 1: rent = RENT_1;
		break;
		case 2: rent = RENT_2;
		break;
		case 3: rent = RENT_3;
		break;
		case 4: rent = RENT_4;
		break;
		}
		return rent;
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
	
	public String getPicture() {
		return Picture;
	}

	public void setPicture(String url){
		Picture = url;
	}
	
	public Color getTxColour(){
		return TxColour;
	}
	
	public void setTxColour(Color colour){
		TxColour = colour;
	}
}
