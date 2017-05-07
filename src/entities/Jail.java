package entities;

import java.awt.Color;

import controllers.Game;
import controllers.GameBoard;
import controllers.mGUI;

/**
 * @author Emil Jørgensen
 *
 */
public class Jail implements Field {

	private String Title;
	private String Description;
	private Color TxColour = Color.BLACK;
	private Color Colour = Color.GRAY;
	private String Subtext;
	
	/**
	 * Constructor for a Jail field
	 * @param title
	 * @param desc
	 * @param subtext
	 */
	public Jail(String title,String desc,String subtext){
		Title = title;
		Description = desc;
		Subtext = subtext;
		
	}
	@Override
	public void landOnField(Game game, GameBoard gameboard, int b, int p, mGUI mui, Shaker shake) {
	
		
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
