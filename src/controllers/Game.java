package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Game {

		public int playerCounter = 1;
		int numberOfPlayers;
		
			public void createPlayerThreads(){
				while(numberOfPlayers < 2 || numberOfPlayers > 6)
				{
					for(int i = 0; i < numberOfPlayers; i++){
					PlayTurn player = new PlayTurn();
					player.run();
					i++;
					}
				}
				game.createPlayerList(numOfPlayers, mui);
			}
			
			
			
	}
}
