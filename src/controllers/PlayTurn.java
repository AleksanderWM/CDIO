package controllers;

import entities.*;

public class PlayTurn implements Runnable{
	Game game = new Game();
	mGUI mGui = new mGUI();
	Shaker shake = new Shaker();
	GameBoard board = new GameBoard();
	
	@Override
	public void run() {
		String name = mGui.getUserString("Enter a name");
		Player player = new Player(name, game.id );
		
		while(player.getAccount().getBalance()!=0){
			while(game.id!=player.getID()){
				//Waiting for number to be changed to their turn.	possibly changing their  own values in the GUI if they are changed by other players.
			}
			
			mGui.getButton("Press the Button to shake the dies", "Shake");
			
			int shakeValue = shake.getShake();
			player.movePosition(shakeValue);
			int equalsCount = 1;
			while(shake.getDice1Value()==shake.getDice2Value() && equalsCount != 3){
				
				
				equalsCount++;
			}
			if(equalsCount == 3){
				gotofuckingjailbitch();
			}
			
			System.out.println("Boya");
			
			}
			
		}
	public void interact(Player thisplayer){
		if (mGui.get2Buttons("What would you like to do?","Action","End Turn") == true){
			int currentField = mGui.getFieldChoice();
				
			if (((Ownable) board.FieldList.get(currentField)) != Ownable)
				mGui.showMessage("No action can be performed on this field");
			
			if (((Ownable) board.FieldList.get(currentField)) == Ownable)
				if (((Ownable) board.FieldList.get(currentField)).getOwner() == thisplayer)
					switch (mGui.get3Buttons("Housing","Sell","Mortgage")){
					case 1: {
						if (mGui.get2Buttons("Buy","Sell") == true){
							
						}
						else{
							
						}
					}
					break;
					
					//Selling the field
					case 2: {
						/**
						 * The player you want to sell too
						 */
						int sellToPlayer = mGui.getUserInt("What player (number) do you want to sell it to?");
						
						/**
						 * The price you want to sell the field for
						 */
						int sellPrice = mGui.getUserint("What price do you want to sell it for?");
						
						//Balance check of recieving player
						if (sellToPlayer.getAccount().getBalance() - sellPrice << 0)
							mGui.showMessage("The player doesn´t have enough money");
						else
						{
						//Accept from recieving player if balance check passes
						if (mGui.get2Buttons("Player " + sellToPlayer + ", do you accept this deal?","Yes","No") == true)
							
						//Transferral
								((Ownable) board.FieldList.get(currentField)).setOwner(sellToPlayer);
								thisplayer.addBalance(sellPrice);
								sellToPlayer.addBalance(-sellPrice);
						}
						}
					break;
					
					//Mortgaging
					case 3: {
						//Recheck
						if(mGui.get2Buttons("Do you want to change the mortgage status?","Yes","No") == true)
							//Is the field mortgaged or unmortgaged
							if (((Ownable) board.FieldList.get(currentField)).getMortgageState() == true){
								//Balance check if the player wants to unmortgage
								if ((thisplayer.getAccount().getBalance - ((Ownable) board.FieldList.get(currentField)).getPrice()/2)+(((Ownable) board.FieldList.get(currentField)).getPrice()*0.10) << 0)
									mGui.showMessage("You don't have enough money");
								else
								{
								//Mortgage state change and transferral
									((Ownable) board.FieldList.get(currentField)).unmortgage();
									thisplayer.getAccount().addBalance(-(((Ownable) board.FieldList.get(currentField)).getPrice()/2)+(((Ownable) board.FieldList.get(currentField)).getPrice()*0.10));
								}
							}
							
							else
							{
							//If the player wants to mortgage, state-change and transferral
								((Ownable) board.FieldList.get(currentField)).mortgage();
								thisplayer.getAccount().addBalance(((Ownable) board.FieldList.get(currentField)).getPrice()/2);
							}
							}
							
					}
					}
					
					
					
		}
	}
	
		
	

}
