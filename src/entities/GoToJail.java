package entities;

import java.awt.Color;

import controllers.Game;
import controllers.GameBoard;
import controllers.mGUI;

public class GoToJail implements Field {

	private String Title;
	private String Description ;
	private Color TxColour = Color.BLACK;
	private Color Colour = Color.GRAY;
	private String Subtext;
	
	public GoToJail(String name,String description,String subtext){
		Description = description;
		Title = name;
		Subtext = subtext;
	}
	
	@Override
	public void landOnField(Game game, GameBoard gameboard, int b, int p, mGUI mui, Shaker shake) {
		game.playerList.get(p).setPosition(41);
		mui.removeCar(game,p);
		mui.setCar(10, p);
		
	}

	@Override
	public String getDescription() {
		return Description;
	}

	@Override
	public void setDescription(String desc) {
	Description = desc;
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
	public Color getColour() {
		return Colour;
	}
	
	@Override
	public void setColour(Color colour){
		Colour = colour;
	}
	
	public Color getTxColour() {
		return TxColour;}
		
	public void setTxColour(Color colour) {
		TxColour = colour;
	}
	
	public void setSubtext(String sub){
		Subtext = sub;
	}
	
	public String getSubtext(){
		return Subtext;
	}

	@Override
	public void setNumber(int numb) {
		// TODO Auto-generated method stub
		
	}

}
