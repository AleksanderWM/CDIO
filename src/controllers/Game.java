package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Game {
static mGUI gui = new mGUI();

	public static void main(String[] args){
		gui.CreateBoard();
		gui.getUserString("test");
	}
	
	
}
