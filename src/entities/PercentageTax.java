package entities;

import java.awt.Color;

import controllers.Game;
import controllers.GameBoard;
import controllers.mGUI;

public class PercentageTax extends Fee{

	private double Percentage;
	private Color Colour = Color.GRAY;
	
	public PercentageTax() {
		super();
		Title = "Luxary Tax";
		Fee = -1000;
		Percentage = 0.10;
		Description = "Betal " + Fee + ", eller " + Percentage + "% af din balance.";
	}
	
	@Override
	public void landOnField(Game game, GameBoard gameboard, int b, int p, mGUI mui, Shaker shake) {
		boolean taxChoice = mui.get2Buttons(Description, "4000", "10%");
		if (!taxChoice)
		{
			game.playerList.get(p).getAccount().addBalance((int) -(game.playerList.get(p).getAccount().getBalance()*Percentage));
		}
		else
		{
			game.playerList.get(p).getAccount().addBalance(Fee);
		}
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
