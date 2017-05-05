package entities;

import java.awt.Color;

public class GoToJail implements Field {

	private String Title = "Go to Jail";
	private String Description = "Move to Jail";
	private String Picture = "";
	
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
	public void setNumber(int numb) {
		
	}

	@Override
	public void setColour(Color colour) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Color getColour() {
		// TODO Auto-generated method stub
		return null;
	}

}
