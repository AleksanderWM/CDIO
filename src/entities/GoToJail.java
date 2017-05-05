package entities;

import java.awt.Color;

public class GoToJail implements Field {

	private String Title = "Go to Jail";
	private String Description = "Move to Jail";
	private String Picture = "";
	private Color TxColour = Color.BLACK;
	private Color Colour = Color.GRAY;
	private String Subtext = "Gaa i faengsel";
	
	public GoToJail(){
		
	}
	
	@Override
	public void landOnField() {
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

}
