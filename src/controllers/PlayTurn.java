/**
 * @author Aleksander
 * Gruppe 
 * 02362 Projekt i software-udvikling 
 */
package controllers;

import desktop_resources.GUI;
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
						mGui.setBalance(thisgame, playerID);
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
			//executes the method landOnField method
			thisgame.board.FieldList.get(thisgame.playerList.get(playerID).getPosition()).landOnField(thisgame, thisboard, thisgame.playerList.get(playerID).getPosition(), playerID, mGui, shake);
			//Initiates the Interaction that gives the player choices over what he wants to do.
			interact(thisgame.playerList.get(playerID));
			//Sets the balance
			mGui.setBalance(thisgame, playerID);
			//Check to make sure if the player rolls equals 3 times in a row, that he is put in jail
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
				thisgame.board.FieldList.get(31).landOnField(thisgame, thisboard, 0, playerID, mGui, shake);
			}
			
			
			if(thisgame.playerList.get(playerID).getAccount().getBalance() < 0){
				sellOfStuff();
			}
			if(thisgame.playerList.get(playerID).getAccount().getBalance() < 0){
				changeAllOwner();
			}
			//Updates the player and account values for this player in the database,
			//Changes the gameID with + 1, to make it the next players turn. 
			//Sends a notify to stop the wait() on all threads.
			thisgame.updateDB();
			thisgame.gameWinner();
			synchronized(thisgame.lock) {
				thisgame.gameId();
				thisgame.lock.notifyAll();
			}
			}
			
		}
	//Checks if the player is in jail, and if he is gives him choices wether to roll or pay to get out.
	//If he has a get out of jail free card, that will be used instantly and he will be placed out of jail.
	public void amIInJail(){
	if(thisgame.playerList.get(playerID).getPosition() == jailed){
		if(thisgame.playerList.get(playerID).getOutOfJail() == 0){
			if(thisgame.playerList.get(playerID).getJailTries() < 3){
				if (mGui.get2Buttons("What would you like to do?","Pay fine","Try Luck") == true){
					payOutOfJail();
				}
				else{
					rollOutOfJail();
				}
			}
			else if(thisgame.playerList.get(playerID).getJailTries() == 3) {
				if (mGui.get2Buttons("What would you like to do?","Pay fine","Try Luck") == true){
					payOutOfJail();
				}
			}
		}
		else {
			thisgame.playerList.get(playerID).setOutOfJail(-1);
			wasIJustReleasedFromJail = true;
		}
	}
	}
	//Changes all the players owned properties back to the bank
	public void changeAllOwner(){
		for(Field item : thisboard.FieldList){
			while((item instanceof Ownable) && ((Ownable)item).getOwner() == thisgame.playerList.get(playerID).getID()){
				((Ownable)item).unmortgage();
				((Ownable)item).setOwner(0);
			}
		}
	}
	
	public void haveIWon(){
		int remainingPlayers = 0;
			for(Player item : thisgame.playerList){
				while(item.getAccount().getBalance() <= 0){
					remainingPlayers++;
				}
			}
			if(remainingPlayers == 1){
				for(Player item : thisgame.playerList){
					if(item.getAccount().getBalance() > 0){
						
						mGui.displayMidDescription("Player" + item.getName() + "Won the game!!");
						mGui.getButton("Player" + item.getName() + "Won", "Exit");
						System.exit(0);
					}
				}
			}
		
			
	}
	
	//If the player, after his turn is still below 0, this will sell off his stuff automaticly, untill the value is again higher than 0.
	public void sellOfStuff(){
		
		while(thisgame.playerList.get(playerID).getAccount().getBalance() < 0){
			
			for(Field item : thisboard.FieldList)
			{
				while((item instanceof Property) && (((Property)item).getOwner() == thisgame.playerList.get(playerID).getID()) &&
						(((Property)item).getHotel() == 1) &&
						thisgame.playerList.get(playerID).getAccount().getBalance() < 0){
					((Property)item).setHotel(-1);
					((Property)item).setHouses(4);
					thisgame.playerList.get(playerID).getAccount().addBalance((((Property)thisboard.FieldList.get(item.getNumber())).getHousePrice()/2));
					mGui.setBalance(thisgame, playerID);
					mGui.setHouse(item.getNumber(), ((Property)thisboard.FieldList.get(item.getNumber())).getHouses());
					mGui.setHotel(item.getNumber(), ((Property)thisboard.FieldList.get(item.getNumber())).getHotel());
					
				}
				while((item instanceof Property) && (((Property)item).getOwner() == thisgame.playerList.get(playerID).getID()) &&
						(((Property)item).getHouses() <= 4) &&
						(((Property)item).getHouses() != 0) &&
						thisgame.playerList.get(playerID).getAccount().getBalance() < 0){
					((Property)item).setHouses(-1);
					thisgame.playerList.get(playerID).getAccount().addBalance((((Property)thisboard.FieldList.get(item.getNumber())).getHousePrice()/2));
					mGui.setBalance(thisgame, playerID);
					mGui.setHouse(item.getNumber(), ((Property)thisboard.FieldList.get(item.getNumber())).getHouses());
				}
				while((item instanceof Ownable) && (((Ownable)item).getOwner() == thisgame.playerList.get(playerID).getID()) &&
						(((Ownable)item).getMortgageState() == false) &&
						thisgame.playerList.get(playerID).getAccount().getBalance() < 0){
					((Ownable) thisboard.FieldList.get(item.getNumber())).mortgage();
					thisgame.playerList.get(playerID).getAccount().addBalance(((Ownable) thisboard.FieldList.get(item.getNumber())).getPrice()/2);
				}
			}
		}
	}
	//Method to try and roll out of jail.
	private void rollOutOfJail(){
		mGui.getButton("Press the Button to shake the dies", "Shake");
		shake.shakeShaker();
		int shakeValue = shake.getShake();
		mGui.setDice(shake);
		int turnsTried = 2;
		while(shake.getDice1Value() != shake.getDice2Value() && turnsTried != 0){
			mGui.getButton("Press the Button to shake the dies", "Shake");
			shake.shakeShaker();
			mGui.setDice(shake);
			turnsTried--;
			
		}
		if(shake.getDice1Value() == shake.getDice2Value()){
			thisgame.playerList.get(playerID).setPosition(11);
			thisgame.playerList.get(playerID).movePosition(shakeValue);
			mGui.setCar(thisgame, thisgame.playerList.get(playerID).getID());
			wasIJustReleasedFromJail = true;
			thisgame.playerList.get(playerID).resetJailTries();
		}
	}
	//Method to pay out of jail.
	private void payOutOfJail(){
		thisgame.playerList.get(playerID).getAccount().setBalance(-1000);
		wasIJustReleasedFromJail = true;
		thisgame.playerList.get(playerID).setPosition(11);
		shakeAndMove();
		thisgame.playerList.get(playerID).resetJailTries();
	}
	//Method for the different options a player can do after he rolls the dices.
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
				if (((Ownable) thisboard.FieldList.get(currentField)).getOwner() == 0){
					mGui.showMessage("This Field has no actions yet");
					mGui.displayMidDescription("This Field has no actions yet");
				}
				else if(((Ownable) thisboard.FieldList.get(currentField)).getOwner() != thisplayer.getID()){
					if (mGui.get2Buttons("What would you like to do?","Make Offer","Abort") == true){
						/**
						 * The price you want to pay for the field
						 */
						int buyPrice = mGui.getUserInt("What price do you want to buy it for?");
						int owner = ((Ownable)thisboard.FieldList.get(currentField)).getOwner();
						
						//Balance check of recieving player
						if (thisgame.playerList.get(playerID).getAccount().getBalance() - buyPrice < 0)
							mGui.showMessage("You don't have enough money");
						else{
							int propertyInSeries = 0;
							int propertyWithoutHouses = 0;
							for(Field item : thisboard.FieldList)
								{
							if((item instanceof Property) && 
											(((Property)item).getColour() == thisboard.FieldList.get(currentField).getColour())){
												propertyInSeries++;
									}
							if((item instanceof Property) && 
									(((Property)item).getColour()) == thisboard.FieldList.get(currentField).getColour() && 
									(((((Property)item).getHouses()) == 0) ||
									((((Property)item).getHotel()) == 0))){
										propertyWithoutHouses++;
							}
								}
							if(propertyWithoutHouses == propertyInSeries && ((Ownable)thisboard.FieldList.get(currentField)).getMortgageState() == false){
								//Accept from recieving player if balance check passes
								if (mGui.get2Buttons("Player " + owner + ", do you accept this deal?","Yes","No") == true)
								{
									
								//Transferral
										((Ownable) thisboard.FieldList.get(currentField)).setOwner(playerID);
										thisgame.playerList.get(playerID).getAccount().addBalance(buyPrice);
										thisgame.playerList.get(owner).getAccount().addBalance(-buyPrice);
										mGui.setOwner(currentField, thisgame.playerList.get(playerID).getName());
								}
								else{
									mGui.showMessage("The player rejected the offer");
								}
								}
								else{
									mGui.showMessage("There is either houses/hotel or the property is mortgaged");
								}
						}
					}			
				}
		}
	}
	//If he chooses Housing this is the method responsible to see if he wants to buy or sell houses/hotels
	//it ensures that he has enough houses on each property before being able to buy a new one.
	//He must buy each house, one by one going into every different property each time, and the same with selling.
	private void caseHousing(int currentField){
		int propertyInSeries = 0;
		int ownedPropertyInSeries = 0;	
		if(mGui.get2Buttons("Do you want to buy or sell?","Buy","Sell") == true){
				for(Field item : thisboard.FieldList)
				{
							if((item instanceof Property) && 
									(((Property)item).getColor() == ((Ownable)thisboard.FieldList.get(currentField)).getColor())){
										propertyInSeries++;
							}
							System.out.println(propertyInSeries);
							if((item instanceof Property) && 
									(((Property)item).getColor() == ((Ownable)thisboard.FieldList.get(currentField)).getColor()) && 
									(((Property)item).getOwner()) == ((Ownable)thisboard.FieldList.get(currentField)).getOwner()){
										ownedPropertyInSeries++;
							}
							System.out.println(ownedPropertyInSeries);
							
				}
					if(propertyInSeries == ownedPropertyInSeries){
						int propertyWithHouses = 0;
						if (mGui.get2Buttons("Do you want to buy a House or Hotel?","House","Hotel") == true){
							for(Field item : thisboard.FieldList){
								
								if((item instanceof Property) && 
										(((Property)item).getColor()) == ((Ownable)thisboard.FieldList.get(currentField)).getColor() && 
										((Property)item).getHouses() < 5 &&
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
										(((Property)item).getColor()) == ((Ownable)thisboard.FieldList.get(currentField)).getColor() && 
										((((Property)item).getHouses()) == 4 ||
										(((Property)item).getHotel()) == 1)){
											propertyWithHotel++;
								}
						}
							if(ownedPropertyInSeries == propertyWithHotel && (((Property)thisboard.FieldList.get(currentField)).getHotel()) == 0){
								((Property)thisboard.FieldList.get(currentField)).setHotel(1);
								((Property)thisboard.FieldList.get(currentField)).setHouses(-4);
								thisgame.playerList.get(playerID).getAccount().addBalance(-((Property)thisboard.FieldList.get(currentField)).getHousePrice());
								mGui.setBalance(thisgame, playerID);
								mGui.setHouse(currentField, ((Property)thisboard.FieldList.get(currentField)).getHouses());
								mGui.setHotel(currentField, ((Property)thisboard.FieldList.get(currentField)).getHotel());
							}
					}
				}
			else{
				mGui.showMessage("You do not own all properties in this range");
				mGui.displayMidDescription("You do not own all properties in this range");
				
			}
					interact(thisgame.playerList.get(playerID));
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
		interact(thisgame.playerList.get(playerID));
	}
			
	//Method for selling a property to another player.
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
		else{
			int propertyInSeries = 0;
			int propertyWithoutHouses = 0;
			for(Field item : thisboard.FieldList)
				{
			if((item instanceof Property) && 
							(((Property)item).getColour() == thisboard.FieldList.get(currentField).getColour())){
								propertyInSeries++;
					}
			if((item instanceof Property) && 
					(((Property)item).getColour()) == thisboard.FieldList.get(currentField).getColour() && 
					(((((Property)item).getHouses()) == 0) ||
					((((Property)item).getHotel()) == 0))){
						propertyWithoutHouses++;
			}
		}
		if(propertyWithoutHouses == propertyInSeries){
		//Accept from recieving player if balance check passes
		if (mGui.get2Buttons("Player " + sellToPlayer + ", do you accept this deal?","Yes","No") == true)
		{
			
		//Transferral
				((Ownable) thisboard.FieldList.get(currentField)).setOwner(sellToPlayer);
				thisgame.playerList.get(playerID).getAccount().addBalance(sellPrice);
				thisgame.playerList.get(sellToPlayer).getAccount().addBalance(-sellPrice);
				mGui.setOwner(currentField, thisgame.playerList.get(sellToPlayer).getName());
		}
		else{
			mGui.showMessage("The player rejected the offer");
		}
		}
		else{
			mGui.showMessage("You need to sell Houses/Hotels before selling a property");
		}
	}
	}
	//Method for mortgaging property or unmortgaging.
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
				int propertyInSeries = 0;
				int propertyWithoutHouses = 0;
				for(Field item : thisboard.FieldList)
				{
					if((item instanceof Property) && 
									(((Property)item).getColour() == thisboard.FieldList.get(currentField).getColour())){
										propertyInSeries++;
							}
					if((item instanceof Property) && 
							(((Property)item).getColour()) == thisboard.FieldList.get(currentField).getColour() && 
							(((((Property)item).getHouses()) == 0) ||
							((((Property)item).getHotel()) == 0))){
								propertyWithoutHouses++;
					}
				}
				if(propertyWithoutHouses == propertyInSeries){
				((Ownable) thisboard.FieldList.get(currentField)).mortgage();
				thisgame.playerList.get(playerID).getAccount().addBalance(((Ownable) thisboard.FieldList.get(currentField)).getPrice()/2);
				}
				else{
					mGui.showMessage("You need to sell Houses/Hotels before mortgaging");
				}
			}
	}
	//Method for shaking the dice and moving on the board
	private void shakeAndMove(){
		mGui.getButton("Press the Button to shake the dies", "Shake");
		shake.shakeShaker();
		int shakeValue = shake.getShake();
		mGui.setDice(shake);
		thisgame.playerList.get(playerID).movePosition(shakeValue);
		mGui.setCar(thisgame, thisgame.playerList.get(playerID).getID());
		
	}
	//Method that starts the Thread
	public void start() {
		// TODO Auto-generated method stub
		if (t == null){
			t = new Thread(this, thread);
			t.start();
		}
	}
}
	
		
	


