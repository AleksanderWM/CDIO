package entities;

import java.awt.Color;

public class TryYourLuck implements Field{

	private String Title = "Try Your Luck";
	private String Description = "Draw a 'Try Your Luck' card";
	private Color Colour = Color.BLACK;
	private Color TxColour = Color.WHITE;
	
	public TryYourLuck(){

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
