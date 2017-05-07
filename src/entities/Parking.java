package entities;

import java.awt.Color;

import controllers.Game;
import controllers.GameBoard;
import controllers.mGUI;

public class Parking implements Field {

	private String Title = "Free Parking";
	private String Description = "Take a break for free";
	private String Picture = "";
	private Color TxColour = Color.BLACK;
	private String Subtext = "Parking";
	private Color Colour = Color.WHITE;
	
	public Parking(String sub){
		Subtext = sub;
	}
	
	@Override
	public void landOnField(Game game, GameBoard gameboard, int b, int p, mGUI mui, Shaker shake) {
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
	public void setNumber(int numb) {
		
	}

	@Override
	public void setColour(Color colour) {
		colour = Colour;
	}

	@Override
	public Color getColour() {
		return Colour;
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
	
	public void setSubtext(String sub){
		Subtext = sub;
	}
	
	public String getSubtext(){
		return Subtext;
	}
}
