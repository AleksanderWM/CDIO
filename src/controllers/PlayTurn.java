package controllers;

import entities.Player;

public class PlayTurn implements Runnable{
	Game game = new Game();
	
	@Override
	public void run() {
		String name = mGui.getUserString();
		Player player = new Player(name, game.id );
		
		
		while(player.getAccount().getBalance()!=0){
			while(game.id!=player.getID()){
				//Waiting for number to be changed to their turn.
				
			}
				
			//this is where the code goes for the game.
			System.out.println("Boya");
			
			}
			
		}
	
		
	

}
