package controllers;

import java.util.ArrayList;
import java.util.Collections;

import entities.Birthday;
import entities.ChanceCard;
import entities.ChanceFee;
import entities.DynamicMove;
import entities.Field;
import entities.FixedMove;
import entities.GetOutOfJail;
import entities.Matador;
import entities.Ownable;
import entities.Player;
import entities.Property;
import entities.PropertyTax;
import entities.RailRoad;
import entities.RailroadMove;
import entities.Shaker;
import entities.Utility;
import entities.UtillityMove;
import language.Language;
import controllers.mGUI;

public class Chance {

		private ArrayList<ChanceCard> ChanceList = new ArrayList<ChanceCard>();
		private Game game;
		private mGUI gui;
		private Shaker shake;
		
		public Chance(){
			
		}
		
		public void createChance(){
			ChanceList.add(new ChanceFee(1, 6, Language.toString(2), -1000));
			ChanceList.add(new FixedMove(2, 3, Language.toString(5), 0));
			ChanceList.add(new FixedMove(3, 3, Language.toString(3), 10));
			ChanceList.add(new FixedMove(4, 3, Language.toString(3), 10));
			ChanceList.add(new ChanceFee(5, 6, Language.toString(4), -200));
			ChanceList.add(new ChanceFee(6, 6, Language.toString(6), -2000));
			ChanceList.add(new ChanceFee(7, 6, Language.toString(7), 1000));
			ChanceList.add(new ChanceFee(8, 6, Language.toString(8), 1000));
			ChanceList.add(new Birthday(9, 7, Language.toString(9), 200));
			ChanceList.add(new ChanceFee(10, 6, Language.toString(10), 200));
			ChanceList.add(new ChanceFee(11, 6, Language.toString(11), -1000));
			ChanceList.add(new PropertyTax(12, 2, Language.toString(12), 800, 2300));
			ChanceList.add(new FixedMove(13, 3, Language.toString(13), 24));
			ChanceList.add(new UtillityMove(14, 1, Language.toString(14), 2));
			ChanceList.add(new UtillityMove(15, 1, Language.toString(14), 2));
			ChanceList.add(new RailroadMove(16, 9, Language.toString(15)));
			ChanceList.add(new GetOutOfJail(17, 8, Language.toString(16)));
			ChanceList.add(new GetOutOfJail(18, 8, Language.toString(16)));
			ChanceList.add(new ChanceFee(19, 6, Language.toString(17), 1000));
			ChanceList.add(new FixedMove(20, 3, Language.toString(18), 11));
			ChanceList.add(new ChanceFee(21, 6, Language.toString(19), 500));
			ChanceList.add(new FixedMove(22, 3, Language.toString(20), 39));
			ChanceList.add(new DynamicMove(23, 4, Language.toString(21), -3));
			ChanceList.add(new PropertyTax(24, 2, Language.toString(22), 500, 2000));
			ChanceList.add(new ChanceFee(25, 6, Language.toString(23), -3000));
			ChanceList.add(new ChanceFee(26, 6, Language.toString(23), -3000));
			ChanceList.add(new Matador(27, 5, Language.toString(24), 15000, 40000));
			ChanceList.add(new ChanceFee(28, 6, Language.toString(25), 3000));
			ChanceList.add(new ChanceFee(29, 6, Language.toString(26), 1000));
			ChanceList.add(new ChanceFee(30, 6, Language.toString(26), 1000));
			ChanceList.add(new ChanceFee(31, 6, Language.toString(27), -1000));
			ChanceList.add(new ChanceFee(32, 6, Language.toString(28), 200));
			ShuffleCards();
		}
		
		public void ShuffleCards(){			
			Collections.shuffle(ChanceList);				
		}
		
		public int ListLength(){
			return ChanceList.size() - 1;
		}
		
		public void DrawChance(int PlayerID){
		if(ChanceList.size() == 0){
			createChance();
		}
		ChanceCard Card = ChanceList.get(ChanceList.size()-1);
		Player Player = game.playerList.get(PlayerID);
		gui.displayMidDescription(Card.getDescription());
		
			switch(Card.getChanceType()){
			
//			UtillityMove
				case 1 : 
					int pos;
					if(Player.getPosition() < 12 && Player.getPosition() > 28){
						pos = 28;
					}
					else{
						pos = 12;
					}
					Utility Utility = (Utility)game.board.getField(pos);
					UtillityMove UtillityMove = (UtillityMove)Card;
					if(Utility.getOwner() != Player.getID()){
						{
							gui.getButton("Press to shake the dice", "Shake");
							shake.setShake();
							gui.setDice(shake);
							int ownedUtility = 0;
							for(Field item : game.board.FieldList)
							{
								if((item instanceof Utility) && (((Ownable)item).getOwner() == game.playerList.get(((Ownable)game.board.FieldList.get(pos)).getOwner()).getID()))
								{
								ownedUtility++;
								}
							}
							Utility.payRent(game, Player.getID(), game.board, pos, Utility.getRent()*shake.getShake()*ownedUtility*UtillityMove.getdbMulti());
							}	
					}
					else{
						Player.setPosition(pos);
					}
					break;
					
//			PropertyTax
				case 2 : 
					PropertyTax Chance = (PropertyTax)Card;
					int HouseTax = Chance.getHouseTax();
					int HotelTax = Chance.getHotelTax();
					int HouseCount = 0;
					int HotelCount = 0;
					for(int i = 0; i <= 40 ; i++){
						if(game.board.getField(i) instanceof Property){
							Property Property = (Property)game.board.getField(i);
							if(Property.getOwner() == Player.getID()){
								HouseCount = HouseCount + Property.getHouses();
								HotelCount = HotelCount + Property.getHotel();								
							}
						}
					}
					int Totaltax = (HouseTax * HouseCount) + (HotelTax * HotelCount);
					Player.getAccount().addBalance(-Totaltax);										
					break;
//			FixedMove
				case 3 : 
					FixedMove Fixed = (FixedMove)Card;
					Player.setPosition(Fixed.getMove());
					break;
//			DynamicMove
				case 4 : 
					DynamicMove Dyn = (DynamicMove)Card;
					Player.movePosition(Dyn.getMoves());
					break;
//			Matador
				case 5 : 
					int NetWorth = Player.getAccount().getNetworth();
					Matador Matador = (Matador)Card;
					if(NetWorth < Matador.getMaxNetworth()){
						Player.getAccount().addBalance(Matador.getBonus());						
					}
					break;
//			Fee
				case 6 : 
					ChanceFee Fee = (ChanceFee)Card;
					Player.getAccount().addBalance(Fee.getFee());
					break;
//			Birthday
				case 7 : 
					Birthday Birthday = (Birthday)Card;
					int Count = 0;
					for(int i = 0 ; i <= 6 ; i++){
						if (game.playerList.get(i) != Player || game.playerList.get(i) != null){
							i++;
							game.playerList.get(i).getAccount().addBalance(-Birthday.getFee());
						}
					int present = Birthday.getFee() * Count;
					Player.getAccount().addBalance(present);
					}
					break;
//			GetOutOfJail
				case 8 : 
					Player.setOutOfJail(1);
					break;
//			RailRoad
				case 9 : 
					for(int i = Player.getPosition() ; i <= game.board.getFieldList().size() ; i++){
						if(game.board.getField(i) instanceof RailRoad){
							Player.setPosition(i);
							return;
						}
						else{
							for(int z = 0 ; z <= game.board.getFieldList().size() ; z++){
								if(game.board.getField(i) instanceof RailRoad){
									Player.setPosition(i);
									return;
								}
							}
						}
					}
					break;
					

					
			}
			Card.removeChance(Card);
			ChanceList.remove(ChanceList.size());
		}
			
		public void LoadChance(){
			for(ChanceCard Card : ChanceList){
				
				Card.loadChance();

			}
		}
		
			
	}	
		