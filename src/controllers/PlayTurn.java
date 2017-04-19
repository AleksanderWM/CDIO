package controllers;

import entities.Player;

public class PlayTurn implements Runnable{
	Player player = new Player();
	int count;
	@Override
	public void run() {
		while(player.getAccount().getBalance()!=0){
			while(count==player.getNumber()); //Waiting for number to be changed to their turn.
				
			//this is where the code goes for the game.
			System.out.println("Boya");
			
			}
			
		}
	
		
	

}
