package controllers;

import entities.*;



public class PlayTurn implements Runnable{
	// Creates variables and objects for the class PlayTurn
	mGUI mGui = new mGUI();
	Shaker shake = new Shaker();
	DBcreator creator = new DBcreator();
	int playerID;
	GameBoard thisboard;
	Game thisgame;
	private Thread t;
	private String thread;
	private int jailed = 41;
	private boolean wasIJustReleasedFromJail = false;
	
	//Creates a constructor for the PlayTurn, giving instances of the current game and board, from game.
	public PlayTurn(String name, int playid, Game game, GameBoard board){
		thread = name;
		playerID = playid;
		thisgame = game;
		thisboard = board;
		

	}
	//The run method, is the method that is running, when the thread is active and alive.
	@Override
	public void run() {
		
		//Checks that the player has money left, otherwise he is out of the game.
		while(thisgame.playerList.get(playerID).getAccount().getBalance()!=0){
			//This is the code that has the thread either go to wait, if the thisgame.id is not matching theirs.
			//Before the thread waits, it updates its balance in gui.
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
			//checks if player is in jail, and if not, if he was just released from it. 
			//Was the player just released he sets the boolean wasIJustReleasedFromJail to false
			amIInJail();
			if(!wasIJustReleasedFromJail){
			shakeAndMove();
			}
			else{
				wasIJustReleasedFromJail = false;
			}
			thisgame.playerList.get(playerID).updatePlayer();			
			thisgame.board.FieldList.get(thisgame.playerList.get(playerID).getPosition()).landOnField(thisgame, thisboard, thisgame.playerList.get(playerID).getPosition(), playerID, mGui, shake);
			interact(thisgame.playerList.get(playerID));

			mGui.setBalance(thisgame, playerID);
			
			int equalsCount = 1;
			while(shake.getDice1Value()==shake.getDice2Value() && equalsCount != 3){
				amIInJail();
				if(!wasIJustReleasedFromJail){
				shakeAndMove();
				}
				else{
					wasIJustReleasedFromJail = false;
				}
				thisgame.board.FieldList.get(thisgame.playerList.get(playerID).getPosition()).landOnField(thisgame, thisboard, thisgame.playerList.get(playerID).getPosition(), playerID, mGui, shake);
				interact(thisgame.playerList.get(playerID));
				equalsCount++;
			}
			if(equalsCount == 3){
				thisgame.board.FieldList.get(jailed)
			}
			
			
			
			
			
			synchronized(thisgame.lock) {
				thisgame.gameId();
				thisgame.lock.notifyAll();
			}
			}
			
		}
	public void amIInJail(){
	if(thisgame.playerList.get(playerID).getPosition() == jailed){
		if(thisgame.playerList.get(playerID).getOutOfJail() == 0){
			if(thisgame.playerList.get(playerID).getJailTries() < 3){
				if (mGui.get2Buttons("What would you like to do?","Pay fine","Roll Dice") == true){
					payOutOfJail();
				}
				else{
					rollOutOfJail();
				}
			}
			else if(thisgame.playerList.get(playerID).getJailTries() == 3) {
				if (mGui.get2Buttons("What would you like to do?","Pay fine","Roll Dice") == true){
					payOutOfJail();
				}
				else{
					rollOutOfJail();
				}
				if(!wasIJustReleasedFromJail){
					payOutOfJail();
				}
			}
		}
		else {
			thisgame.playerList.get(playerID).setOutOfJail(-1);
			wasIJustReleasedFromJail = false;
		}
	}
	}
	
	
	public void sellOfStuff(){
		
		if(thisgame.playerList.get(playerID).getAccount().getBalance() < 0){
			
			for(Field item : thisboard.FieldList)
			{
				if((item instanceof Ownable) && (((Ownable)item).getOwner() == thisgame.playerList.get(playerID).getID()))
				{
				
				}
			}
		}
	}
	
	private void rollOutOfJail(){
		mGui.getButton("Press the Button to shake the dies", "Shake");
		shake.shakeShaker();
		int shakeValue = shake.getShake();
		mGui.setDice(shake);
		int turnsTried = 1;
		while(shake.getDice1Value()!=shake.getDice2Value() || turnsTried == 3){
			mGui.getButton("Press the Button to shake the dies", "Shake");
			shake.shakeShaker();
			int shakeValue1 = shake.getShake();
			mGui.setDice(shake);
			turnsTried++;
		}
		if(shake.getDice1Value()==shake.getDice2Value()){
			thisgame.playerList.get(playerID).setPosition(11);
			thisgame.playerList.get(playerID).movePosition(shakeValue);
			mGui.setCar(thisgame, thisgame.playerList.get(playerID).getID());
			wasIJustReleasedFromJail = true;
		}
	}
	
	private void payOutOfJail(){
		thisgame.playerList.get(playerID).getAccount().setBalance(-1000);
		wasIJustReleasedFromJail = true;
		thisgame.playerList.get(playerID).setPosition(11);
		shakeAndMove();
		thisgame.playerList.get(playerID).resetJailTries();
	}
	public void interact(Player thisplayer){
		if (mGui.get2Buttons("What would you like to do?","Action","End Turn") == true){
			int currentField = mGui.getFieldChoice();
				if (((Ownable) thisboard.FieldList.get(currentField)).getOwner() == thisplayer.getID()){
					switch (mGui.get3Buttons("What do you want to do?","Housing","Sell","Mortgage")){
					case "Housing": {
						caseHousing(currentField);
					}					
					break;
					
					//Selling the field
					case "Sell": {
						caseSell(currentField);
						}
					break;
					
					//Mortgaging
					case "Mortgage": {
						caseMortgage(currentField);
						}
					}
				}
			}			
		}
	
	private void caseHousing(int currentField){
		int propertyInSeries = 0;
		int ownedPropertyInSeries = 0;	
		if (mGui.get2Buttons("Do you want to buy or sell?","Buy","Sell") == true){
				for(Field item : thisboard.FieldList)
				{
							if((item instanceof Property) && 
									(((Property)item).getColour() == thisboard.FieldList.get(currentField).getColour())){
										propertyInSeries++;
							}
							if((item instanceof Property) && 
									(((Property)item).getColour() == thisboard.FieldList.get(currentField).getColour()) && 
									(((Property)item).getOwner()) == thisboard.FieldList.get(currentField).getNumber()){
										ownedPropertyInSeries++;
							}
							
				}
					if(propertyInSeries == ownedPropertyInSeries){
						int propertyWithHouses = 0;
						if (mGui.get2Buttons("Do you want to buy a House or Hotel?","House","Hotel") == true){
							for(Field item : thisboard.FieldList){
								
								if((item instanceof Property) && 
										(((Property)item).getColour()) == thisboard.FieldList.get(currentField).getColour() && 
										((((Property)item).getHouses()) == (((Property)thisboard.FieldList.get(currentField)).getHouses()) ||
										((((Property)item).getHouses())+1) > (((Property)thisboard.FieldList.get(currentField)).getHouses()))){
											propertyWithHouses++;
								}
							}
							if(ownedPropertyInSeries == propertyWithHouses){
									((Property)thisboard.FieldList.get(currentField)).setHouses(1);
									thisgame.playerList.get(playerID).getAccount().addBalance(-((Property)thisboard.FieldList.get(currentField)).getHousePrice());
									mGui.setBalance(thisgame, playerID);
									mGui.setHouse(currentField, ((Property)thisboard.FieldList.get(currentField)).getHouses());
									
							}
							else {
							mGui.showMessage("You are not permitted to buy houses on this lot. Check if you have maxed out houses, or if you have equal amount of houses on the coresponding Propperty");
							mGui.displayMidDescription("You are not permitted to buy houses on this lot. Check if you have maxed out houses, or if you have equal amount of houses on the coresponding Propperty");
							}
						}
						else {
							int propertyWithHotel = 0;
							for(Field item : thisboard.FieldList){
								if((item instanceof Property) && 
										(((Property)item).getColour()) == thisboard.FieldList.get(currentField).getColour() && 
										((((Property)item).getHouses()) == 4 ||
										(((Property)item).getHotel()) <= 1)){
											propertyWithHotel++;
								}
						}
							if(ownedPropertyInSeries == propertyWithHotel && (((Property)thisboard.FieldList.get(currentField)).getHotel()) == 0){
								((Property)thisboard.FieldList.get(currentField)).setHotel(1);
								thisgame.playerList.get(playerID).getAccount().addBalance(-((Property)thisboard.FieldList.get(currentField)).getHousePrice());
								mGui.setBalance(thisgame, playerID);
								mGui.setHouse(currentField, ((Property)thisboard.FieldList.get(currentField)).getHouses());
							}
					}
				}
			else{
				mGui.showMessage("You do not own all properties in this range");
				mGui.displayMidDescription("You do not own all properties in this range");
				
			}
			}
			else {
				if (mGui.get2Buttons("Do you want to sell a House or Hotel?","House","Hotel") == true){
				int propertyWithHouses = 0;
				for(Field item : thisboard.FieldList){
					
					if((item instanceof Property) && 
							(((Property)item).getColour()) == thisboard.FieldList.get(currentField).getColour() && 
							((((Property)item).getHouses()) == (((Property)thisboard.FieldList.get(currentField)).getHouses()) ||
							((((Property)item).getHouses())-1) > (((Property)thisboard.FieldList.get(currentField)).getHouses()))){
								propertyWithHouses++;
					}
				}
				
				if(propertyWithHouses == propertyInSeries){
					((Property)thisboard.FieldList.get(currentField)).setHouses(-1);
					thisgame.playerList.get(playerID).getAccount().addBalance(+(((Property)thisboard.FieldList.get(currentField)).getHousePrice()/2));
					mGui.setBalance(thisgame, playerID);
					mGui.setHouse(currentField, ((Property)thisboard.FieldList.get(currentField)).getHouses());
				}
				else{
					mGui.showMessage("You are not permitted to sell houses on this lot. Check if you have any out houses, or if you have equal amount of houses on the coresponding Propperty");
					mGui.displayMidDescription("You are not permitted to sell houses on this lot. Check if you have any out houses, or if you have equal amount of houses on the coresponding Propperty");
				}
				}
				else {
				int propertyWithHotel = 0;
				for(Field item : thisboard.FieldList){
					if((item instanceof Property) && 
							(((Property)item).getColour()) == thisboard.FieldList.get(currentField).getColour() && 
							((((Property)item).getHouses()) == 4 ||
							(((Property)item).getHotel()) <= 1)){
								propertyWithHotel++;
					}
				}
				if(ownedPropertyInSeries == propertyWithHotel && (((Property)thisboard.FieldList.get(currentField)).getHotel()) == 1){
					((Property)thisboard.FieldList.get(currentField)).setHotel(-1);
					thisgame.playerList.get(playerID).getAccount().addBalance(-(((Property)thisboard.FieldList.get(currentField)).getHousePrice()/2));
					mGui.setBalance(thisgame, playerID);
					mGui.setHouse(currentField, ((Property)thisboard.FieldList.get(currentField)).getHouses());
					}
				}
			}
	}
			
	
	private void caseSell(int currentField){
		/**
		 * The player you want to sell too
		 */
		int sellToPlayer = mGui.getUserInt("What player (number) do you want to sell it to?");
		
		/**
		 * The price you want to sell the field for
		 */
		int sellPrice = mGui.getUserInt("What price do you want to sell it for?");
		
		//Balance check of recieving player
		if (thisgame.playerList.get(sellToPlayer).getAccount().getBalance() - sellPrice < 0)
			mGui.showMessage("The player doesn't have enough money");
		else
		{
		//Accept from recieving player if balance check passes
		if (mGui.get2Buttons("Player " + sellToPlayer + ", do you accept this deal?","Yes","No") == true)
		{
			
		//Transferral
				((Ownable) thisboard.FieldList.get(currentField)).setOwner(sellToPlayer);
				thisgame.playerList.get(playerID).getAccount().addBalance(sellPrice);
				thisgame.playerList.get(sellToPlayer).getAccount().addBalance(-sellPrice);
				mGui.setOwner(currentField, thisgame.playerList.get(sellToPlayer).getName());
		}
	}
	}
	
	private void caseMortgage(int currentField){
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
				thisgame.playerList.get(playerID).getAccount().addBalance(((Ownable) thisboard.FieldList.get(currentField)).getPrice()/2);
			}
	}
	
	private void shakeAndMove(){
		mGui.getButton("Press the Button to shake the dies", "Shake");
		shake.shakeShaker();
		int shakeValue = shake.getShake();
		mGui.setDice(shake);
		thisgame.playerList.get(playerID).movePosition(shakeValue);
		System.out.println(thisgame.playerList.get(playerID).getID());
		System.out.println(thisgame.playerList.get(playerID).getPosition());
		mGui.removeCar(thisgame, playerID);
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
	
		
	


