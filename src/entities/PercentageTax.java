package entities;

import java.awt.Color;

public class PercentageTax extends Fee{

	private int Percentage;
	
	public PercentageTax() {
		super();
		Title = "Luxary Tax";
		Fee = 1000;
		Percentage = 10;
		Description = "Pay " + Fee + ", or pay " + Percentage + "% of your balance.";
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
