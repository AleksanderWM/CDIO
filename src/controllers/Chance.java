/**
 * @author Simon
 * Gruppe 
 * 02362 Projekt i software-udvikling 
 */
package controllers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import entities.Text;
import entities.Utility;
import entities.UtillityMove;
import controllers.mGUI;
import entities.Text;

public class Chance {

		private static ArrayList<ChanceCard> ChanceList = new ArrayList<ChanceCard>();
		private Game game;
		private mGUI gui;
		private Shaker shake;
		private Text ChanceFile = new Text("ChanceDescription.txt");
		private String[] ChanceDes = null;


		private DBconnector connector;
		
		public void createChance(){
			try {
				ChanceDes = ChanceFile.OpenFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			ChanceList.add(new ChanceFee(1, 6, ChanceDes[2], -1000));
			ChanceList.add(new FixedMove(2, 3, ChanceDes[5], 0));
			ChanceList.add(new FixedMove(3, 3, ChanceDes[3], 11));
			ChanceList.add(new FixedMove(4, 3, ChanceDes[3], 11));
			ChanceList.add(new ChanceFee(5, 6, ChanceDes[4], -200));
			ChanceList.add(new ChanceFee(6, 6, ChanceDes[6], -2000));
			ChanceList.add(new ChanceFee(7, 6, ChanceDes[7], 1000));
			ChanceList.add(new ChanceFee(8, 6, ChanceDes[8], 1000));
			ChanceList.add(new Birthday(9, 7, ChanceDes[9], 200));
			ChanceList.add(new ChanceFee(10, 6, ChanceDes[10], 200));
			ChanceList.add(new ChanceFee(11, 6, ChanceDes[11], -1000));
			ChanceList.add(new PropertyTax(12, 2, ChanceDes[12], 800, 2300));
			ChanceList.add(new FixedMove(13, 3, ChanceDes[13], 25));
			ChanceList.add(new UtillityMove(14, 1, ChanceDes[14], 2));
			ChanceList.add(new UtillityMove(15, 1, ChanceDes[14], 2));
			ChanceList.add(new RailroadMove(16, 9, ChanceDes[15]));
			ChanceList.add(new GetOutOfJail(17, 8, ChanceDes[16]));
			ChanceList.add(new GetOutOfJail(18, 8, ChanceDes[16]));
			ChanceList.add(new ChanceFee(19, 6, ChanceDes[17], 1000));
			ChanceList.add(new FixedMove(20, 3, ChanceDes[18], 12));
			ChanceList.add(new ChanceFee(21, 6, ChanceDes[19], 500));
			ChanceList.add(new FixedMove(22, 3, ChanceDes[20], 40));
			ChanceList.add(new DynamicMove(23, 4, ChanceDes[21], -3));
			ChanceList.add(new PropertyTax(24, 2, ChanceDes[22], 500, 2000));
			ChanceList.add(new ChanceFee(25, 6, ChanceDes[23], -3000));
			ChanceList.add(new ChanceFee(26, 6, ChanceDes[23], -3000));
			ChanceList.add(new Matador(27, 5, ChanceDes[24], 15000, 40000));
			ChanceList.add(new ChanceFee(28, 6, ChanceDes[25], 3000));
			ChanceList.add(new ChanceFee(29, 6, ChanceDes[25], 1000));
			ChanceList.add(new ChanceFee(30, 6, ChanceDes[26], 1000));
			ChanceList.add(new ChanceFee(31, 6, ChanceDes[27], -1000));
			ChanceList.add(new ChanceFee(32, 6, ChanceDes[28], 200));
			ShuffleCards();
		}
		
		public void ShuffleCards(){			
			Collections.shuffle(ChanceList);				
		}
		
		public int ListLength(){
			return ChanceList.size();
		}
		
		public void DrawChance(int PlayerID,Game game, mGUI gui){
		if(ChanceList.size() == 0){
			createChance();
		}
		
		ChanceCard Card = ChanceList.get(ChanceList.size()-1);
		System.out.println("" + Card.getDescription());
		Player Player = game.playerList.get(PlayerID);
		gui.displayMidDescription(Card.getDescription());
		gui.getButton(Card.getDescription(), "Move on");
			switch(Card.getChanceType()){
			
//			UtillityMove
				case 1 : 
					int pos;
					if(Player.getPosition() < 13 && Player.getPosition() > 29){
						pos = 29;
					}
					else{
						pos = 13;
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
			ChanceList.remove(ChanceList.size()-1);
		}
			
		@SuppressWarnings("null")
		public void LoadChance(){
			connector.Connect("chance");
			int count = 0;
			for(int i = 0; i <= 32 ; i++){
			boolean exist = false;
			try {
			ResultSet rs = connector.doQuery("chance","SELECT ChanceID FROM Chance WHERE EXISTS (SELECT ChanceID FROM chance WHERE ChanceID = "+ i +";");
			while(rs.next()){
			exist = rs.getBoolean("chanceID");
			}
			connector.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ChanceCard Card = null;
				if(exist){
					switch(Card.getTypeFDB(i)){
						case 1: 
							UtillityMove UM = (UtillityMove)Card;
							ChanceList.add(new UtillityMove(count++, 1, Card.getDescriptionFdb(i),UM.getdbMulti() ));
							break;
						case 2:
							PropertyTax PT = (PropertyTax)Card;
							ChanceList.add(new PropertyTax(count++, 2, Card.getDescriptionFdb(i),PT.getHouseTaxFDB(i), PT.getHoteltaxFDB(i)));
							break;
						case 3:
							FixedMove FM = (FixedMove)Card;
							ChanceList.add(new ChanceFee(count++, 3, Card.getDescriptionFdb(i), FM.getMoveFDB(i)));
							break;
						case 4:
							DynamicMove DM = (DynamicMove)Card;
							ChanceList.add(new DynamicMove(count++, 4, Card.getDescriptionFdb(i),DM.getMovesFDB(i)));
							break;
						case 5:
							Matador M = (Matador)Card;
							ChanceList.add(new Matador(count++, 5, Card.getDescriptionFdb(i),M.getMaxFDB(i),M.getBonusFDB(i)));
							break;
						case 6:
							ChanceFee F = (ChanceFee)Card;
							ChanceList.add(new ChanceFee(count++, 6, Card.getDescriptionFdb(i), F.getFeeFDB(i)));
							break;
						case 7:
							Birthday B = (Birthday)Card;
							ChanceList.add(new Birthday(count++, 7, Card.getDescriptionFdb(i), B.getFeeFDB(i)));
							break;
						case 8:
							ChanceList.add(new GetOutOfJail(count++, 8, Card.getDescriptionFdb(i)));
							break;
						case 9:
							ChanceList.add(new RailroadMove(count++, 9, Card.getDescriptionFdb(i)));
							break;
					}
				}
			}
			ShuffleCards();	
		}

	}	
		