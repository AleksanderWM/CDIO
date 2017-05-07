package entities;

import java.awt.Color;

import controllers.*;
import controllers.mGUI;

public class Tax extends Fee {
	
	public Tax(String title,String description, String subtext) {
		super();
		Title = title;
		Fee = 4000;
		Description = description;
		Colour = Color.GRAY;
		
	}

	@Override
	public void landOnField(Game game, GameBoard gameboard, int b, int p, mGUI mui, Shaker shake) {
		game.playerList.get(p).getAccount().addBalance(Fee);
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

