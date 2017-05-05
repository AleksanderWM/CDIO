package controllers;

import desktop_fields.Chance;
import desktop_fields.Field;
import desktop_fields.Start;
import desktop_fields.Street;
import desktop_resources.GUI;
import entities.Ownable;
import entities.TryYourLuck;
import desktop_resources.GUI;
import java.awt.Color;
import desktop_codebehind.Car;
import desktop_fields.Shipping;
import desktop_fields.Field;
import desktop_fields.Start;

/**s
 * @author Emil Jørgensen
 *
 */
public class mGUI {

	GameBoard FieldList = new GameBoard();
	Game game;
	
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
	
	
	public void addPlayer(GameBoard game, int v,int c)
	{
		Car car = new Car.Builder().secondaryColor(getColor(c)).build();
		GUI.addPlayer(game.playerList.get(v).getPlayerName(), game.playerList.get(v).getAccount().getBalance(),car);
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
	
	/**
	 * Displays a single button on screen for the player to press
	 * @param msg1 The message prompt to the user
	 * @param msg2 The text on the button
	 */
	public void getButton(String msg1, String msg2){
		GUI.getUserButtonPressed(msg1, msg2);
	}
	
	/**
	 * Displays two buttons on screen for the player to press, one returning true, the other returning false.
	 * @param msg1 The message prompt to the user
	 * @param msg2 The text on the true-button
	 * @param msg3 The text on the false-button
	 * @return True or false
	 */
	public boolean get2Buttons(String msg1, String msg2, String msg3){
		return GUI.getUserLeftButtonPressed(msg1, msg2, msg3);
	}
	
	/**
	 * Gets a drop down menu of the 40 fields for the player to choose from 
	 * @return An int corresponding to the field number of the field chosen
	 */
	public int getFieldChoice(){
		int ret = 0;
		switch(GUI.getUserSelection("Choose a field", "Rodovrevej","Hvidovrevej","LB Ferries","Roskildevej","Valby Langgade","Allégade","Frederikberg Allé ","Carlsberg","Bülowsvej","Gl. Kongevej","M/S Danmark","Bernstorffsvej","Hellerupvej","Strandvej","Trianglen","Oesterbrogade","Groenningen","Mols-Linien A/S","Bredgade","Kgs. Nytorv","Coca-Cola","Oestergade","Amagertorv","Vimmelskaftet","Nygade","Scandlines","Frederiksberggade","Raadhuspladsen")){
		case "Rodovrevej":ret = 2;
		break;
		case "Hvidovrevej":ret =  4;
		break;
		case "LB Ferries":ret = 6;
		break;
		case "Roskildevej":ret = 7;
		break;
		case "Valby Langgade":ret = 9;
		break;
		case "Allégade":ret = 10;
		break;
		case "Frederiksberg Allé":ret = 12;
		break;
		case "Carlsberg":ret = 13;
		break;
		case "Bülowsgade":ret = 14;
		break;
		case "Gl. Kongevej":ret = 15;
		break;
		case "M/S Danmark":ret = 16;
		break;
		case "Bernstorffsvej":ret = 17;
		break;
		case "Hellerupvej":ret = 19;
		break;
		case "Strandvej":ret = 20;
		break;
		case "Trianglen":ret = 22;
		break;
		case "Oesterbrogade":ret = 24;
		break;
		case "Groenningen":ret = 25;
		break;
		case "Mols-Linien A/S":ret = 26;
		break;
		case "Bredgade":ret = 27;
		break;
		case "Kgs. Nytorv":ret = 28;
		break;
		case "Coca-Cola":ret = 29;
		break;
		case "Oestergade":ret = 30;
		break;
		case "Amagertorv":ret = 32;
		break;
		case "Vimmelskaftet":ret = 33;
		break;
		case "Nygade":ret = 35;
		break;
		case "Scandlines":ret = 36;
		break;
		case "Frederiksberggade":ret = 38;
		break;
		case "Raadhuspladsen":ret = 40;
		}
		return ret;
	}
	/**
	 * Shows a message prompt to the player
	 * @param msg The message
	 */
	public void showMessage(String msg){
		GUI.showMessage(msg);
	}
	
	public String get3Buttons(String msg, String bt1, String bt2, String bt3){
		return GUI.getUserButtonPressed(msg, bt1, bt2, bt3);
	}
	
	public int getUserInt(String msg){
		return GUI.getUserInteger(msg);
	}
}
