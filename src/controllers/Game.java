package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Game {
static mGUI gui = new mGUI();

int numberOfPlayers = 0;
PlayTurn thread = new PlayTurn();
public volatile int id;

	public void enterPlayers()
	{
		while (numberOfPlayers < 2 && numberOfPlayers > 6)
		{
			//Message shown to user, to clarify that he needs to put in the correct value of players between 2 and 6.
			
			//code to mgui for entering an INT ammount
		}
		
		this.createPlayerThreads(numberOfPlayers);
		
	}
	/**
	 * Creates the different threads for the game.
	 * @param playersInGame
	 */
	public void createPlayerThreads(int playersInGame)
	{
		while (id != numberOfPlayers)
		{
		PlayTurn thread = new PlayTurn();
		thread.run();
		
		id++;
		}

	}
	
	
}
