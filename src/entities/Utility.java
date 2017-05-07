package entities;

import java.awt.Color;

import controllers.Game;
import controllers.GameBoard;
import controllers.mGUI;

public class Utility extends Ownable{
	
	private Color TxColour = Color.WHITE;
	
	public Utility(String title, String subText, int player, int cost, int rent) {
		super(title, subText, new Color(6,76,30), player, cost, rent);
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
