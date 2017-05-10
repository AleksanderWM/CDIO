package controllers;

import java.awt.Color;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.TryYourLuck;
import entities.Field;
import entities.GoToJail;
import entities.Jail;
import entities.Parking;
import entities.PercentageTax;
import entities.Player;
import entities.Property;
import entities.RailRoad;
import entities.Start;
import entities.FixedTax;
import entities.Text;
import entities.Utility;
import entities.Ownable;

/**
 * @author Emil Jørgensen
 */
public class GameBoard {
	public ArrayList<Field> FieldList = new ArrayList<Field>();
	private Text TitleFile = new Text("FieldTitles.txt");
	private Text DescriptionFile = new Text("FieldDescription.txt");
	private Text SubtextFile = new Text("FieldSubtext.txt");
	private String[] TitleList = null;
	private String[] DescriptionList = null;
	private String[] SubtextList = null;
	private int noOwner = 0;
	private DBconnector connector;
	private Ownable OwnableType;
	private Property PropertyType;

	
	public GameBoard(){
		
	}
	/**
	 * Creates the Array of boards
	 */
	public void CreateBoardFromTextFile(){
		try {
			TitleList = TitleFile.OpenFile();
			DescriptionList = DescriptionFile.OpenFile();
			SubtextList = SubtextFile.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		FieldList.add(null);
		FieldList.add(new Start());
		FieldList.add(new Property(2,TitleList[2],DescriptionList[2],SubtextList[2],Color.CYAN,noOwner,1200,1000,50,250,750, 2250, 4000, 6000,0,0, false));
		FieldList.add(new TryYourLuck(TitleList[3],DescriptionList[3]));
		FieldList.add(new Property(4,TitleList[4],DescriptionList[4],SubtextList[4],Color.CYAN,noOwner,1200,1000,50, 250, 750, 2250, 4000, 6000, 0, 0, false));
		FieldList.add(new FixedTax(TitleList[5],DescriptionList[5],SubtextList[5]));
		FieldList.add(new RailRoad(6,TitleList[6],DescriptionList[6],SubtextList[6],Color.BLUE,noOwner,4000,500, false));
		FieldList.add(new Property(7,TitleList[7],DescriptionList[7],SubtextList[7],Color.ORANGE,noOwner,2000,100,100, 600, 1800, 5400, 8000, 11000, 0, 0, false));
		FieldList.add(new TryYourLuck(TitleList[8],DescriptionList[8]));
		FieldList.add(new Property(8,TitleList[9],DescriptionList[9],SubtextList[9],Color.ORANGE,noOwner,2000,1000,100, 600, 1800, 5400, 8000, 11000, 0, 0, false));
		FieldList.add(new Property(9,TitleList[10],DescriptionList[10],SubtextList[10],Color.ORANGE,noOwner,2400,1000,150, 800, 2000, 6000, 9000, 12000, 0, 0, false));
		FieldList.add(new Jail(TitleList[11],DescriptionList[11],SubtextList[11]));
		FieldList.add(new Property(12,TitleList[12],DescriptionList[12],SubtextList[12],Color.GREEN,noOwner,2800,2000,200, 1000, 3000, 9000, 12500, 15000, 0, 0, false));
		FieldList.add(new Utility(13,TitleList[13],DescriptionList[13],SubtextList[13],noOwner,3000,100, false));
		FieldList.add(new Property(14,TitleList[14],DescriptionList[14],SubtextList[14],Color.GREEN,noOwner,2800,2000,200, 1000, 3000, 9000, 12500, 15000, 0, 0, false));
		FieldList.add(new Property(15,TitleList[15],DescriptionList[15],SubtextList[15],Color.GREEN,noOwner,3200,2000,250, 1250, 3750, 10000, 14000, 18000, 0, 0, false));
		FieldList.add(new RailRoad(16,TitleList[16],DescriptionList[16],SubtextList[16],Color.BLUE,noOwner,4000,500, false));
		FieldList.add(new Property(17,TitleList[17],DescriptionList[17],SubtextList[17],Color.LIGHT_GRAY,noOwner,3600,2000,300, 1400, 4000, 11000, 15000, 19000, 0, 0, false));
		FieldList.add(new TryYourLuck(TitleList[18],DescriptionList[18]));
		FieldList.add(new Property(19,TitleList[19],DescriptionList[19],SubtextList[19],Color.LIGHT_GRAY,noOwner,3600,2000,300, 1400, 4000, 11000, 15000, 19000, 0, 0, false));
		FieldList.add(new Property(20,TitleList[20],DescriptionList[20],SubtextList[20],Color.LIGHT_GRAY,noOwner,4000,2000,350, 1600, 4400, 12000, 16000, 20000, 0, 0, false));
		FieldList.add(new Parking(TitleList[21],DescriptionList[21],SubtextList[21]));
		FieldList.add(new Property(22,TitleList[22],DescriptionList[22],SubtextList[22],Color.RED,noOwner,4400,3000,350, 1800, 5000, 14000, 17500, 21000, 0, 0, false));
		FieldList.add(new TryYourLuck(TitleList[23],DescriptionList[23]));
		FieldList.add(new Property(24,TitleList[24],DescriptionList[24],SubtextList[24],Color.RED,noOwner,4400,3000,350, 1800, 5000, 14000, 17500, 21000, 0, 0, false));
		FieldList.add(new Property(25,TitleList[25],DescriptionList[25],SubtextList[25],Color.RED,noOwner,4800,3000,400, 2000, 6000, 15000, 18500, 22000, 0, 0, false));
		FieldList.add(new RailRoad(26,TitleList[26],DescriptionList[26],SubtextList[26],Color.BLUE,noOwner,4000,500, false));
		FieldList.add(new Property(27,TitleList[27],DescriptionList[27],SubtextList[27],Color.WHITE,noOwner,5200,3000,450, 2200, 6600, 16000, 19500, 23000, 0, 0, false));
		FieldList.add(new Property(28,TitleList[28],DescriptionList[28],SubtextList[28],Color.WHITE,noOwner,5200,3000,450, 2200, 6600, 16000, 19500, 23000, 0, 0, false));
		FieldList.add(new Utility(29,TitleList[29],DescriptionList[29],SubtextList[29],noOwner,3000,100, false));
		FieldList.add(new Property(30,TitleList[30],DescriptionList[30],SubtextList[30],Color.WHITE,noOwner,5600,3000,500, 2400, 7200, 17000, 20500, 24000, 0, 0, false));
		FieldList.add(new GoToJail(TitleList[31],DescriptionList[31],SubtextList[31]));
		FieldList.add(new Property(32,TitleList[32],DescriptionList[32],SubtextList[32],Color.YELLOW,noOwner,6000,4000,550, 2600, 7800, 18000, 22000, 25000, 0, 0, false));
		FieldList.add(new Property(33,TitleList[33],DescriptionList[33],SubtextList[33],Color.YELLOW,noOwner,6000,4000,550, 2600, 7800, 18000, 22000, 25000, 0, 0, false));
		FieldList.add(new TryYourLuck(TitleList[34],DescriptionList[34]));
		FieldList.add(new Property(35,TitleList[35],DescriptionList[35],SubtextList[35],Color.YELLOW,noOwner,6400,4000,600, 3000, 9000, 20000, 24000, 28000, 0, 0, false));
		FieldList.add(new RailRoad(36,TitleList[36],DescriptionList[36],SubtextList[36],Color.BLUE,noOwner,4000,500, false));
		FieldList.add(new TryYourLuck(TitleList[37],DescriptionList[37]));
		FieldList.add(new Property(38,TitleList[38],DescriptionList[38],SubtextList[38],new Color(150,53,150),noOwner,7000,4000,700, 3500, 10000, 22000, 26000, 30000, 0, 0, false));
		FieldList.add(new PercentageTax(TitleList[39],DescriptionList[39],SubtextList[39]));
		FieldList.add(new Property(40,TitleList[40],DescriptionList[40],SubtextList[40],new Color(150,53,150),noOwner,8000,4000,1000, 4000, 12000, 28000, 34000, 40000, 0, 0, false));
	}
	
	
	public void saveBoardDB(int fieldNumber, int playerID, int cost, int mortgageState){
		System.out.println(fieldNumber);
		System.out.println(playerID);
		System.out.println(cost);
		System.out.println(mortgageState);
		OwnableType.saveOwnableDB(fieldNumber, playerID, cost, mortgageState);
		PropertyType.savePropertyDB(fieldNumber);
	}
	
	
	/**
	 * Returns the array of board. CreateBoard must be called before this
	 * @return the arraylist of fields
	 */
	public ArrayList<Field> getFieldList(){
		return FieldList;
	}
	/**
	 * Gets a single field from the arraylist, createBoard must be called before this
	 * @param index the number of the field
	 * @return
	 */
	public Field getField(int index){
		return FieldList.get(index);
	}
	
//	public void CreateBoardFromDB(){
//		try {
//			connector.Connect("Field");
//		try {
//			connector.Connect("Field");
//			TitleList = TitleFile.OpenFile();
//			DescriptionList = DescriptionFile.OpenFile();
//			SubtextList = SubtextFile.OpenFile();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		FieldList.add(null);
//		FieldList.add(new Start());
//		FieldList.add(new Property(2,TitleList[2],DescriptionList[2],SubtextList[2],Color.CYAN,OwnableType.getOwnerFDB(),1200,1000,50,250,750, 2250, 4000, 6000,PropertyType.gethouseFDB(), PropertyType.gethotelFDB(), PropertyType.getMortgageStateFDB()));
//		FieldList.add(new TryYourLuck(TitleList[3],DescriptionList[3]));
//		FieldList.add(new Property(4,TitleList[4],DescriptionList[4],SubtextList[4],Color.CYAN,OwnableType.getOwnerFDB(),1200,1000,50, 250, 750, 2250, 4000, 6000, PropertyType.gethouseFDB(), PropertyType.gethotelFDB(), PropertyType.getMortgageStateFDB()));
//		FieldList.add(new FixedTax(TitleList[5],DescriptionList[5],SubtextList[5]));
//		FieldList.add(new RailRoad(6,TitleList[6],DescriptionList[6],SubtextList[6],Color.BLUE,OwnableType.getOwnerFDB(),4000,500, PropertyType.getMortgageStateFDB()));
//		FieldList.add(new Property(7,TitleList[7],DescriptionList[7],SubtextList[7],Color.ORANGE,OwnableType.getOwnerFDB(),2000,100,100, 600, 1800, 5400, 8000, 11000, PropertyType.gethouseFDB(), PropertyType.gethotelFDB(), PropertyType.getMortgageStateFDB()));
//		FieldList.add(new TryYourLuck(TitleList[8],DescriptionList[8]));
//		FieldList.add(new Property(8,TitleList[9],DescriptionList[9],SubtextList[9],Color.ORANGE,OwnableType.getOwnerFDB(),2000,1000,100, 600, 1800, 5400, 8000, 11000, PropertyType.gethouseFDB(), PropertyType.gethotelFDB(), PropertyType.getMortgageStateFDB()));
//		FieldList.add(new Property(9,TitleList[10],DescriptionList[10],SubtextList[10],Color.ORANGE,OwnableType.getOwnerFDB(),2400,1000,150, 800, 2000, 6000, 9000, 12000, PropertyType.gethouseFDB(), PropertyType.gethotelFDB(), PropertyType.getMortgageStateFDB()));
//		FieldList.add(new Jail(TitleList[11],DescriptionList[11],SubtextList[11]));
//		FieldList.add(new Property(12,TitleList[12],DescriptionList[12],SubtextList[12],Color.GREEN,OwnableType.getOwnerFDB(),2800,2000,200, 1000, 3000, 9000, 12500, 15000, PropertyType.gethouseFDB(), PropertyType.gethotelFDB(), PropertyType.getMortgageStateFDB()));
//		FieldList.add(new Utility(13,TitleList[13],DescriptionList[13],SubtextList[13],OwnableType.getOwnerFDB(),3000,100, PropertyType.getMortgageStateFDB()));
//		FieldList.add(new Property(14,TitleList[14],DescriptionList[14],SubtextList[14],Color.GREEN,OwnableType.getOwnerFDB(),2800,2000,200, 1000, 3000, 9000, 12500, 15000, PropertyType.gethouseFDB(), PropertyType.gethotelFDB(), PropertyType.getMortgageStateFDB()));
//		FieldList.add(new Property(15,TitleList[15],DescriptionList[15],SubtextList[15],Color.GREEN,OwnableType.getOwnerFDB(),3200,2000,250, 1250, 3750, 10000, 14000, 18000, PropertyType.gethouseFDB(), PropertyType.gethotelFDB(), PropertyType.getMortgageStateFDB()));
//		FieldList.add(new RailRoad(16,TitleList[16],DescriptionList[16],SubtextList[16],Color.BLUE,OwnableType.getOwnerFDB(),4000,500, PropertyType.getMortgageStateFDB()));
//		FieldList.add(new Property(17,TitleList[17],DescriptionList[17],SubtextList[17],Color.LIGHT_GRAY,OwnableType.getOwnerFDB(),3600,2000,300, 1400, 4000, 11000, 15000, 19000, PropertyType.gethouseFDB(), PropertyType.gethotelFDB(), PropertyType.getMortgageStateFDB()));
//		FieldList.add(new TryYourLuck(TitleList[18],DescriptionList[18]));
//		FieldList.add(new Property(19,TitleList[19],DescriptionList[19],SubtextList[19],Color.LIGHT_GRAY,OwnableType.getOwnerFDB(),3600,2000,300, 1400, 4000, 11000, 15000, 19000, PropertyType.gethouseFDB(), PropertyType.gethotelFDB(), PropertyType.getMortgageStateFDB()));
//		FieldList.add(new Property(20,TitleList[20],DescriptionList[20],SubtextList[20],Color.LIGHT_GRAY,OwnableType.getOwnerFDB(),4000,2000,350, 1600, 4400, 12000, 16000, 20000, PropertyType.gethouseFDB(), PropertyType.gethotelFDB(), PropertyType.getMortgageStateFDB()));
//		FieldList.add(new Parking(TitleList[21],DescriptionList[21],SubtextList[21]));
//		FieldList.add(new Property(22,TitleList[22],DescriptionList[22],SubtextList[22],Color.RED,OwnableType.getOwnerFDB(),4400,3000,350, 1800, 5000, 14000, 17500, 21000, PropertyType.gethouseFDB(), PropertyType.gethotelFDB(), PropertyType.getMortgageStateFDB()));
//		FieldList.add(new TryYourLuck(TitleList[23],DescriptionList[23]));
//		FieldList.add(new Property(24,TitleList[24],DescriptionList[24],SubtextList[24],Color.RED,OwnableType.getOwnerFDB(),4400,3000,350, 1800, 5000, 14000, 17500, 21000, PropertyType.gethouseFDB(), PropertyType.gethotelFDB(), PropertyType.getMortgageStateFDB()));
//		FieldList.add(new Property(25,TitleList[25],DescriptionList[25],SubtextList[25],Color.RED,OwnableType.getOwnerFDB(),4800,3000,400, 2000, 6000, 15000, 18500, 22000, PropertyType.gethouseFDB(), PropertyType.gethotelFDB(), PropertyType.getMortgageStateFDB()));
//		FieldList.add(new RailRoad(26,TitleList[26],DescriptionList[26],SubtextList[26],Color.BLUE,OwnableType.getOwnerFDB(),4000,500, PropertyType.getMortgageStateFDB()));
//		FieldList.add(new Property(27,TitleList[27],DescriptionList[27],SubtextList[27],Color.WHITE,OwnableType.getOwnerFDB(),5200,3000,450, 2200, 6600, 16000, 19500, 23000, PropertyType.gethouseFDB(), PropertyType.gethotelFDB(), PropertyType.getMortgageStateFDB()));
//		FieldList.add(new Property(28,TitleList[28],DescriptionList[28],SubtextList[28],Color.WHITE,OwnableType.getOwnerFDB(),5200,3000,450, 2200, 6600, 16000, 19500, 23000, PropertyType.gethouseFDB(), PropertyType.gethotelFDB(), PropertyType.getMortgageStateFDB()));
//		FieldList.add(new Utility(29,TitleList[29],DescriptionList[29],SubtextList[29],OwnableType.getOwnerFDB(),3000,100, PropertyType.getMortgageStateFDB()));
//		FieldList.add(new Property(30,TitleList[30],DescriptionList[30],SubtextList[30],Color.WHITE,OwnableType.getOwnerFDB(),5600,3000,500, 2400, 7200, 17000, 20500, 24000, PropertyType.gethouseFDB(), PropertyType.gethotelFDB(), PropertyType.getMortgageStateFDB()));
//		FieldList.add(new GoToJail(TitleList[31],DescriptionList[31],SubtextList[31]));
//		FieldList.add(new Property(32,TitleList[32],DescriptionList[32],SubtextList[32],Color.YELLOW,OwnableType.getOwnerFDB(),6000,4000,550, 2600, 7800, 18000, 22000, 25000, PropertyType.gethouseFDB(), PropertyType.gethotelFDB(), PropertyType.getMortgageStateFDB()));
//		FieldList.add(new Property(33,TitleList[33],DescriptionList[33],SubtextList[33],Color.YELLOW,OwnableType.getOwnerFDB(),6000,4000,550, 2600, 7800, 18000, 22000, 25000, PropertyType.gethouseFDB(), PropertyType.gethotelFDB(), PropertyType.getMortgageStateFDB()));
//		FieldList.add(new TryYourLuck(TitleList[34],DescriptionList[34]));
//		FieldList.add(new Property(35,TitleList[35],DescriptionList[35],SubtextList[35],Color.YELLOW,OwnableType.getOwnerFDB(),6400,4000,600, 3000, 9000, 20000, 24000, 28000, PropertyType.gethouseFDB(), PropertyType.gethotelFDB(), PropertyType.getMortgageStateFDB()));
//		FieldList.add(new RailRoad(36,TitleList[36],DescriptionList[36],SubtextList[36],Color.BLUE,OwnableType.getOwnerFDB(),4000,500, PropertyType.getMortgageStateFDB()));
//		FieldList.add(new TryYourLuck(TitleList[37],DescriptionList[37]));
//		FieldList.add(new Property(38,TitleList[38],DescriptionList[38],SubtextList[38],new Color(150,53,150),OwnableType.getOwnerFDB(),7000,4000,700, 3500, 10000, 22000, 26000, 30000, PropertyType.gethouseFDB(), PropertyType.gethotelFDB(), PropertyType.getMortgageStateFDB()));
//		FieldList.add(new PercentageTax(TitleList[39],DescriptionList[39],SubtextList[39]));
//		FieldList.add(new Property(40,TitleList[40],DescriptionList[40],SubtextList[40],new Color(150,53,150),OwnableType.getOwnerFDB(),8000,4000,1000, 4000, 12000, 28000, 34000, 40000, PropertyType.gethouseFDB(), PropertyType.gethotelFDB(), PropertyType.getMortgageStateFDB()));
//		connector.close();
//		} catch (SQLException e) {
//		e.printStackTrace();
//		}
//	}
	
}
