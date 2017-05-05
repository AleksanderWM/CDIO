package controllers;

import entities.*;

public class PlayTurn implements Runnable{
	mGUI mGui = new mGUI();
	Shaker shake = new Shaker();
	GameBoard board = new GameBoard();
	DBcreator creator = new DBcreator();
	int playerID;
	Game thisgame;
	
	public PlayTurn(int id, Game game){
		playerID = id;
		thisgame = game;
		run();
		
	}
	@Override
	public void run() {
//		String name = mGui.getUserString("Enter a name");
		
		Player player = new Player("Adolf", playerID );
		thisgame.playerList.add(player);
		
		while(player.getAccount().getBalance()!=0){
			while(thisgame.id!=player.getID()){
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
				//gotofuckingjailbitch();
			}
			
			System.out.println("Boya");
			
			}
			
		}
//	public void interact(Player thisplayer){
//		if (mGui.get2Buttons("What would you like to do?","Action","End Turn") == true){
//			int currentField = mGui.getFieldChoice();
//
//				if (((Ownable) board.FieldList.get(currentField)).getOwner() == thisplayer.getID())
//					switch (mGui.get3Buttons("What do you want to do?","Housing","Sell","Mortgage")){
//					case "Housing": {
//						if (mGui.get2Buttons("Do you want to buy or sell?","Buy","Sell") == true){
//							
//						}
//						else{
//							
//						}
//					}
//					break;
//					
//					//Selling the field
//					case "Sell": {
//						/**
//						 * The player you want to sell too
//						 */
//						int sellToPlayer = mGui.getUserInt("What player (number) do you want to sell it to?");
//						
//						/**
//						 * The price you want to sell the field for
//						 */
//						int sellPrice = mGui.getUserInt("What price do you want to sell it for?");
//						
//						thisplayer.getID();
//						
//						//Balance check of recieving player
//						if (.getAccount().getBalance() - sellPrice << 0)
//							mGui.showMessage("The player doesn�t have enough money");
//						else
//						{
//						//Accept from recieving player if balance check passes
//						if (mGui.get2Buttons("Player " + sellToPlayer + ", do you accept this deal?","Yes","No") == true)
//							
//						//Transferral
//								((Ownable) board.FieldList.get(currentField)).setOwner(sellToPlayer);
//								thisplayer.addBalance(sellPrice);
//								sellToPlayer.getAccount().addBalance(-sellPrice);
//						}
//						}
//					break;
//					
//					//Mortgaging
//					case "Mortgage": {
//						//Recheck
//						if(mGui.get2Buttons("Do you want to change the mortgage status?","Yes","No") == true)
//							//Is the field mortgaged or unmortgaged
//							if (((Ownable) board.FieldList.get(currentField)).getMortgageState() == true){
//								//Balance check if the player wants to unmortgage
//								if ((thisplayer.getAccount().getBalance - ((Ownable) board.FieldList.get(currentField)).getPrice()/2)+(((Ownable) board.FieldList.get(currentField)).getPrice()*0.10) << 0)
//									mGui.showMessage("You don't have enough money");
//								else
//								{
//								//Mortgage state change and transferral
//									((Ownable) board.FieldList.get(currentField)).unmortgage();
//									thisplayer.getAccount().addBalance(-(((Ownable) board.FieldList.get(currentField)).getPrice()/2)+(((Ownable) board.FieldList.get(currentField)).getPrice()*0.10));
//								}
//							}
//							
//							else
//							{
//							//If the player wants to mortgage, state-change and transferral
//								((Ownable) board.FieldList.get(currentField)).mortgage();
//								thisplayer.getAccount().addBalance(((Ownable) board.FieldList.get(currentField)).getPrice()/2);
//							}
//							}
//							
//					}
//					}
//					
//					
//					
//		}

	public void start() {
		// TODO Auto-generated method stub
		
	}
}
	
		
	


