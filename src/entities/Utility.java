package entities;

import java.awt.Color;

import controllers.Game;
import controllers.GameBoard;
import controllers.mGUI;

/**
 * 
 * @author Aleksander and Emil Jørgensen
 *
 */
public class Utility extends Ownable{
	
	private Color TxColour = Color.WHITE;
	
	/**
	 * The constructor for a Utility field
	 * @param title
	 * @param description
	 * @param subText
	 * @param player
	 * @param cost
	 * @param rent
	 */
	public Utility(String title,String description, String subText, int player, int cost, int rent) {
		super(title,description, subText, new Color(6,76,30), player, cost, rent);
	}

	/**
	 *Defines what happens when a player lands on this field
	 */
	@Override
	public void landOnField(Game game, GameBoard gameboard, int boardValue, int playerID, mGUI mui, Shaker shake) {
		if(((Ownable)gameboard.FieldList.get(boardValue)).getOwner() == 0){
			buyProperty(game, gameboard, mui, playerID, boardValue);
		}
		else if(((Ownable)gameboard.FieldList.get(boardValue)).getOwner() != 0 && ((Ownable)gameboard.FieldList.get(boardValue)).getOwner() != playerID)
		{
			mui.getButton("Press to shake the dice", "Shake");
			shake.setShake();
			mui.setDice(shake);
			int ownedUtility = 0;
			for(Field item : gameboard.FieldList)
			{
				if((item instanceof Utility) && (((Ownable)item).getOwner() == game.playerList.get(((Ownable)gameboard.FieldList.get(boardValue)).getOwner()).getID()))
				{
				ownedUtility++;
				}
			}
			payRent(game, playerID, gameboard, boardValue, rent*shake.getShake()*ownedUtility);
			}		
		}

	

	@Override
	public String getDescription() {
		return super.Description;
	}

	@Override
	public void setDescription(String desc) {
		super.Description = desc;
	}

	@Override
	public String getTitle() {
		return super.Title;
	}

	@Override
	public void setTitle(String titl) {
		super.Title = titl;
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
		super.Colour = colour;
	}

	@Override
	public Color getColour() {
		return super.Colour;
	}

	
	public Color getTxColour(){
		return TxColour;
	}
	
	public void setTxColour(Color colour){
		TxColour = colour;
	}

}
