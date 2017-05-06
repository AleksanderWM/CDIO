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
public final Object lock = new Object();
public ArrayList<Player> playerList = new ArrayList<Player>();
public int numberOfPlayers = 20;
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
		System.out.println("emil er dum");
		enterPlayers();
	}

	public void enterPlayers()
	{
		while (numberOfPlayers < 2 || numberOfPlayers > 6)
		{
			System.out.println("emil er dum");
			//Message shown to user, to clarify that he needs to put in the correct value of players between 2 and 6.
			numberOfPlayers = gui.getUserInt("Enter Ammount of Players between 2 and 6");
		}
		
		for(int x = 0; x < numberOfPlayers; x++){
			String name = gui.getUserString("Enter a name");
			Player player = new Player(name, id);
			playerList.add(player);
			System.out.println(id);
			id++;

		}
		id = 0;
				this.createPlayerThreads(numberOfPlayers);
	}
	/**
	 * Creates the different threads for the game.
	 * @param playersInGame
	 */
	public void createPlayerThreads(int playersInGame)
	{
			for(int x = 0; x < playersInGame; x++){
		synchronized(lock){
			
		}
		PlayTurn thread = new PlayTurn("x", playerList.get(x).getID(), this);
		thread.start();
		System.out.println("started thread" + x);
			}
			synchronized(lock){
			
			id = 1;
			lock.notifyAll();
			}
		}

	
	

	
	public int gameId(){
		if(id == numberOfPlayers){
			id = 1;
		}
		else id++;
		return id;
	}

}
