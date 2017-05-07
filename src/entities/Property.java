package entities;

import java.awt.Color;

import controllers.Game;
import controllers.GameBoard;
import controllers.mGUI;

public class Property extends Ownable {
	
	private int Houses;
	private int Hotel;
	private int RENT1;
	private int RENT2;
	private int RENT3;
	private int RENT4;
	private int RENT5;
	private int Houseprice;
	
	public Property(String title, String description, String subText, Color colour, int player,int cost,int hprice,int rent0,int rent1, int rent2, int rent3, int rent4, int rent5, int house,int hotel) 
	{
		super(title, description, subText, colour, player, cost, rent0);
		Houses = house;
		Hotel = hotel;
		RENT1 = rent1;
		RENT2 = rent2;
		RENT3 = rent3;
		RENT4 = rent4;
		RENT5 = rent5;
		Houseprice = hprice;
	}
	@Override

	public int getRent(){
		return super.rent;
	}
	
	public void setHousePrice(int price){
		Houseprice = price;
	}
	
	public int getHousePrice(){
		return Houseprice;
	}
	
	public int getRent(int value){
		int ret = super.rent;
		switch(value){
		case 0: ret = super.rent;
		break;
		case 1: ret = RENT1;
		break;
		case 2: ret = RENT2;
		break;
		case 3: ret = RENT3;
		break;
		case 4: ret = RENT4;
		break;
		case 5: ret = RENT5;
		}
		return ret;
	}
	
	@Override
	public void landOnField(Game game, GameBoard gameboard, int boardValue, int playerID, mGUI mui, Shaker shake) {
		if(((Ownable)gameboard.FieldList.get(boardValue)).getOwner() == game.playerList.get(playerID).getID()){
			buyProperty(game, gameboard, mui, playerID, boardValue);
		}
		else if(((Ownable)gameboard.FieldList.get(boardValue)).getOwner() != owned && ((Ownable)gameboard.FieldList.get(boardValue)).getOwner() != playerID){
			if(((Property) gameboard.FieldList.get(boardValue)).getHotel() == 1){
				int rentToPay = getRent(5);
				payRent(game, playerID, gameboard, boardValue, rentToPay);
			}
			else {
				int rentToPay = getRent(((Property)gameboard.FieldList.get(boardValue)).getHouses());
				payRent(game, playerID, gameboard, boardValue, rentToPay);
			}
		}

	}

	@Override
	public String getDescription() {
		return super.Description;
	}

	@Override
	public void setDescription(String desc) {
		super.Description = desc;
	}

	@Override
	public String getTitle() {
		return super.Title;
	}

	@Override
	public void setTitle(String titl) {
		super.Title = titl;
	}

	@Override
	public int getNumber() {
		return 0;
	}

	@Override
	public void setNumber(int numb) {
	}
	
	@Override
	public void setColour(Color colour) {
		super.Colour = colour;
	}
	
	@Override
	public Color getColour() {
		return super.Colour;
	}
	
	public int getHouses(){
		return Houses;
	}
	
	public void setHouses(int house){
		Houses = house;
	}
	
	public int getHotel(){
		return Hotel;
	}
	
	public void setHotel(int hotel){
		Hotel = hotel;
	}
	/**
	 * Only add 1 or -1 House at a time
	 * @param houses
	 */
	public void addHouses(int houses){
		this.Houses = this.Houses + houses;
		if(Houses > 4){
			Houses = 0;
			Hotel = 1;
		}
		if(Hotel == 1 && houses == -1){
			Hotel = 0;
			Houses = 4;
		}
	}
	


}
