package entities;

import java.awt.Color;

import controllers.Game;
import controllers.GameBoard;
import controllers.mGUI;

/**
 * @author Emil Jørgensen
 *
 */
public class PercentageTax extends Fee{

	private double Percentage;
	private Color Colour = Color.GRAY;
	
	/**
	 * Constructor for a PercentageTax field
	 * @param title
	 * @param description
	 * @param subtext
	 */
	public PercentageTax(String title,String description, String subtext) {
		super();
		Title = title;
		Fee = 4000;
		super.Subtext = subtext;
		Percentage = 0.10;
		Description = description;
		Colour = Color.GRAY;
		
	}
	
	/**
	 * 	 * Defines what happens when a player lands on this field
	 */
	@Override
	public void landOnField(Game game, GameBoard gameboard, int b, int p, mGUI mui, Shaker shake) {
		boolean taxChoice = mui.get2Buttons(Description, "4000", "10%");
		if (!taxChoice)
		{
			game.playerList.get(p).getAccount().addBalance((int) -(game.playerList.get(p).getAccount().getBalance()*Percentage));
			mui.setBalance(game, p);
		}
		else
		{
			game.playerList.get(p).getAccount().addBalance(-Fee);
			mui.setBalance(game, p);
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
	
	public String getSubtext(){
		return Subtext;
	}
}
