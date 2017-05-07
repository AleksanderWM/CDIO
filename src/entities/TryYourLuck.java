package entities;

import java.awt.Color;

import controllers.Game;
import controllers.GameBoard;
import controllers.mGUI;
import controllers.Chance;

public class TryYourLuck implements Field{

	private String Title;
	private String Description = "Draw a 'Try Your Luck' card";
	private Color Colour = Color.BLACK;
	private Color TxColour = Color.WHITE;
	
	private Chance Chance;
	
	public TryYourLuck(String name){
		Title = name;
	}
	
	@Override
	public void landOnField(Game game, GameBoard gameboard, int b, int p, mGUI mui, Shaker shake) {
		Chance.DrawChance(p);
	
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
		return Title;
	}

	@Override
	public void setTitle(String titl) {
		Title = titl;
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
		Colour = colour;
	}

	@Override
	public Color getColour() {
		return Colour;
	}
	
	public Color getTxColour(){
		return TxColour;
	}
	
	public void setTxColour(Color colour){
		TxColour = colour;
	}

}
