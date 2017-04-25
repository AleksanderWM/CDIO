package controllers;

import desktop_fields.Chance;
import desktop_fields.Field;
import desktop_fields.Start;
import desktop_fields.Street;
import desktop_resources.GUI;
import entities.Ownable;
import entities.TryYourLuck;

/**s
 * @author Emil Jørgensen
 *
 */
public class mGUI {

	GameBoard FieldList = new GameBoard();
	
	public void CreateBoard(){
		{
			FieldList.CreateBoard();
			Field[] Fields = new Field[3];
			
			Fields[0] = new Start.Builder().
					setBgColor(FieldList.getFieldList().get(0).getColour()).
					setTitle(FieldList.getFieldList().get(0).getTitle()).
					setSubText("").
					build();
			Fields[1] = new Street.Builder().setBgColor(FieldList.getFieldList().get(1).getColour()).
					setDescription(FieldList.getFieldList().get(1).getDescription()).
					setRent(((Ownable) FieldList.getFieldList().get(1)).toString(((Ownable) FieldList.getFieldList().get(1)).getRent())).
					setTitle(FieldList.getFieldList().get(1).getTitle()).
					setSubText(((Ownable) FieldList.getFieldList().get(1)).getSub()).
					build();
			Fields[2] = new Chance.Builder().setBgColor(FieldList.getFieldList().get(2).getColour()).
					setFgColor(((TryYourLuck) FieldList.getFieldList().get(2)).getTxColour()).
					build();
							
			GUI.create(Fields);
			}
	}
	/**
	 * Displays a message to the user and awaits a response
	 * @param msg The message shown to the user
	 * @return A string from the user
	 */
	public String getUserString(String msg)
	{
		return GUI.getUserString(msg);
	}
	
}
