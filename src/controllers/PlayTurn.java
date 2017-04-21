package controllers;

import entities.Player;

public class PlayTurn implements Runnable{
	Game game = new Game();
	
	int count = game.playerCounter;
	@Override
	public void run() {
		String name = mui.getUserString();
		Player player = new Player(name, count, null );
		
		while(player.getAccount().getBalance()!=0){
			while(count==player.getID()){
				//Waiting for number to be changed to their turn.
				
			}
				
			//this is where the code goes for the game.
			System.out.println("Boya");
			
			}
			
		}
	
		
	

}
