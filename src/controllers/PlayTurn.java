package controllers;

import entities.*;



public class PlayTurn implements Runnable{
	mGUI mGui = new mGUI();
	Shaker shake = new Shaker();
	DBcreator creator = new DBcreator();
	int playerID;
	GameBoard thisboard;
	Game thisgame;
	private Thread t;
	private String thread;
	
	public PlayTurn(String name, int playid, Game game, GameBoard board){
		thread = name;
		playerID = playid;
		thisgame = game;
		thisboard = board;
		

	}
	@Override
	public void run() {
		

		while(thisgame.playerList.get(playerID).getAccount().getBalance()!=0){
			synchronized(thisgame.lock){
				while(thisgame.id!=thisgame.playerList.get(playerID).getID()){
					try {
						thisgame.lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			shakeAndMove();
			thisgame.playerList.get(playerID).updatePlayer();
			interact(thisgame.playerList.get(playerID));
			
			int equalsCount = 1;
			while(shake.getDice1Value()==shake.getDice2Value() && equalsCount != 3){
				shakeAndMove();
				interact(thisgame.playerList.get(playerID));
				equalsCount++;
			}
			if(equalsCount == 3){
				//gotofuckingjailbitch();
			}
			
			
			
			
			
			synchronized(thisgame.lock) {
				thisgame.gameId();
				thisgame.lock.notifyAll();
			}
			}
			
		}
	

	public void interact(Player thisplayer){
		if (mGui.get2Buttons("What would you like to do?","Action","End Turn") == true){
			int currentField = mGui.getFieldChoice();

				if (((Ownable) thisboard.FieldList.get(currentField)).getOwner() == thisplayer.getID())
					switch (mGui.get3Buttons("What do you want to do?","Housing","Sell","Mortgage")){
					case "Housing": {
						if (mGui.get2Buttons("Do you want to buy or sell?","Buy","Sell") == true){
							
						}
						else{
							
						}
					}
					break;
					
					//Selling the field
					case "Sell": {
						/**
						 * The player you want to sell too
						 */
						int sellToPlayer = mGui.getUserInt("What player (number) do you want to sell it to?");
						
						/**
						 * The price you want to sell the field for
						 */
						int sellPrice = mGui.getUserInt("What price do you want to sell it for?");
						
						thisplayer.getID();
						
						//Balance check of recieving player
						if (thisgame.playerList.get(sellToPlayer).getAccount().getBalance() - sellPrice < 0)
							mGui.showMessage("The player doesn't have enough money");
						else
						{
						//Accept from recieving player if balance check passes
						if (mGui.get2Buttons("Player " + sellToPlayer + ", do you accept this deal?","Yes","No") == true)
							
						//Transferral
								((Ownable) thisboard.FieldList.get(currentField)).setOwner(sellToPlayer);
								thisgame.playerList.get(playerID).getAccount().addBalance(sellPrice);
								thisgame.playerList.get(sellToPlayer).getAccount().addBalance(-sellPrice);
						}
						}
					break;
					
					//Mortgaging
					case "Mortgage": {
						//Recheck
						if(mGui.get2Buttons("Do you want to change the mortgage status?","Yes","No") == true)
							//Is the field mortgaged or unmortgaged
							if (((Ownable) thisboard.FieldList.get(currentField)).getMortgageState() == true){
								//Balance check if the player wants to unmortgage
								if ((thisgame.playerList.get(playerID).getAccount().getBalance() - (((Ownable) thisboard.FieldList.get(currentField)).getPrice()/2) + (((Ownable) thisboard.FieldList.get(currentField)).getPrice()*0.10) < 0))
									mGui.showMessage("You don't have enough money");
								else
								{
								//Mortgage state change and transferral
									((Ownable) thisboard.FieldList.get(currentField)).unmortgage();
									thisgame.playerList.get(playerID).getAccount().addBalance((int) (-(((Ownable) thisboard.FieldList.get(currentField)).getPrice()/2)+(((Ownable) thisboard.FieldList.get(currentField)).getPrice()*0.10)));
								}
							}
							
							else
							{
							//If the player wants to mortgage, state-change and transferral
								((Ownable) thisboard.FieldList.get(currentField)).mortgage();
								thisplayer.getAccount().addBalance(((Ownable) thisboard.FieldList.get(currentField)).getPrice()/2);
							}
							}
							
					}
					}
					
					
					
		}
	
	private void shakeAndMove(){
		mGui.getButton("Press the Button to shake the dies", "Shake");
		shake.shakeShaker();
		int shakeValue = shake.getShake();
		mGui.setDice(shake);
		thisgame.playerList.get(playerID).movePosition(shakeValue);
		System.out.println(thisgame.playerList.get(playerID).getID());
		mGui.setCar(thisgame, thisgame.playerList.get(playerID).getID());
		
	}

	public void start() {
		// TODO Auto-generated method stub
		if (t == null){
			t = new Thread(this, thread);
			t.start();
		}
	}
}
	
		
	


