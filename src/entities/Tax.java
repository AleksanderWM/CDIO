package entities;

import java.awt.Color;

public class Tax extends Fee {
	
	public Tax() {
		super();
		Title = "Income Tax";
		Fee = 1000;
		Description = "Pay " + Fee;
		
	}

	@Override
	public void landOnField() {
		super.landOnField();
	}

	@Override
	public String getDescription() {
		return super.getDescription();
	}

	@Override
	public void setDescription(String desc) {
		super.setDescription(desc);
	}

	@Override
	public String getTitle() {
		return super.getTitle();
	}

	@Override
	public void setTitle(String titl) {
		super.setTitle(titl);
	}

	@Override
	public int getNumber() {
		return super.getNumber();
	}

	@Override
	public void setNumber(int numb) {
		super.setNumber(numb);
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

