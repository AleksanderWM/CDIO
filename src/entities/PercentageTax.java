package entities;

import java.awt.Color;

public class PercentageTax extends Fee{

	private int Percentage;
	private Color Colour = Color.GRAY;
	
	public PercentageTax() {
		super();
		Title = "Luxary Tax";
		Fee = 1000;
		Percentage = 10;
		Description = "Betal " + Fee + ", eller " + Percentage + "% af din balance.";
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
		Colour = colour;
	}

	@Override
	public Color getColour() {
		return Colour;
	}
}
