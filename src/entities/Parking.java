package entities;

import java.awt.Color;

import controllers.Game;
import controllers.GameBoard;
import controllers.mGUI;

/**
 * 
 * @author Emil Jørgensen
 *
 */
public class Parking implements Field {

	private String Title;
	private String Description;
	private Color TxColour = Color.BLACK;
	private String Subtext;
	private Color Colour = Color.WHITE;
	
	/**
	 * The constructor for a Parking field
	 * @param title
	 * @param description
	 * @param sub
	 */
	public Parking(String title, String description,String sub){
		Title = title;
		Description = description;
		Subtext = sub;
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
	public void setColour(Color colour) {
		colour = Colour;
	}

	@Override
	public Color getColour() {
		return Colour;
	}
	
	public Color getTxColour(){
		return TxColour;
	}
	
	public void setTxColour(Color colour){
		TxColour = colour;
	}
	
	public void setSubtext(String sub){
		Subtext = sub;
	}
	
	public String getSubtext(){
		return Subtext;
	}
}
