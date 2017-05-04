package entities;

import java.awt.Color;

/**
 * @author EmilJorgensen
 */
public class Start implements Field {

	private String Title = "START";
	private Color Colour = Color.RED;
	private String Description = "";

	public Start(){
		
	}
	
	@Override
	public void landOnField() {
	}

	@Override
	public String getDescription(){
		return "";
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
		Colour = colour;
	}

	@Override
	public Color getColour() {
		return Colour;
	}

}
