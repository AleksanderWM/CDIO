package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import entities.Player;
import language.Language;

public class Game {
static mGUI gui = new mGUI();
GameBoard board = new GameBoard();
DBcreator dbc = new DBcreator();
Scanner scan = new Scanner(System.in);
DBconnector connector = new DBconnector();

public ArrayList<Player> playerList = new ArrayList<Player>();

int numberOfPlayers = 3;
public volatile int id = 1;

	public void gameStart(){
		
		dbc.DeleteDBTemp("game", connector);
		if(dbc.checkDB("game") == false){
			dbc.CreateGame();
			dbc.tbCreatorGame();
		}
		if(dbc.checkDB("chance") == false){
			dbc.CreateChance();
		}
		System.out.println("Choose Language (Dansk/English)");
		Language.chooseLanguage(scan.nextLine());
		board.CreateBoard();
		gui.CreateBoard();

		enterPlayers();
		System.out.println(playerList.get(1).getName());
	}

	public void enterPlayers()
	{
		while (numberOfPlayers < 2 && numberOfPlayers > 6)
		{
			//Message shown to user, to clarify that he needs to put in the correct value of players between 2 and 6.
			numberOfPlayers = gui.getUserInt("Enter Ammount of Players between 2 and 6");
		}
		
		this.createPlayerThreads(numberOfPlayers);
		
	}
	/**
	 * Creates the different threads for the game.
	 * @param playersInGame
	 */
	public void createPlayerThreads(int playersInGame)
	{
		while (id != playersInGame+1)
		{
		PlayTurn thread = new PlayTurn(id, this);
		thread.run();
		id++;
		}

	}
	public int gameId(){
		return id;
	}

}
