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
	
	public void CreateBoardFromDB(){
		try {
			TitleList = TitleFile.OpenFile();
			DescriptionList = DescriptionFile.OpenFile();
			SubtextList = SubtextFile.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		FieldList.add(null);
		FieldList.add(new Start());
		FieldList.add(new Property(2,TitleList[2],DescriptionList[2],SubtextList[2],Color.CYAN,OwnableType.getOwnerFDB(2),1200,1000,50,250,750, 2250, 4000, 6000,PropertyType.getHouseFDB(2), PropertyType.gethotelFDB(2), PropertyType.getMortgageStateFDB(2)));
		FieldList.add(new TryYourLuck(TitleList[3],DescriptionList[3]));
		FieldList.add(new Property(4,TitleList[4],DescriptionList[4],SubtextList[4],Color.CYAN,OwnableType.getOwnerFDB(4),1200,1000,50, 250, 750, 2250, 4000, 6000, PropertyType.getHouseFDB(4), PropertyType.gethotelFDB(4), PropertyType.getMortgageStateFDB(4)));
		FieldList.add(new FixedTax(TitleList[5],DescriptionList[5],SubtextList[5]));
		FieldList.add(new RailRoad(6,TitleList[6],DescriptionList[6],SubtextList[6],Color.BLUE,OwnableType.getOwnerFDB(6),4000,500, PropertyType.getMortgageStateFDB(6)));
		FieldList.add(new Property(7,TitleList[7],DescriptionList[7],SubtextList[7],Color.ORANGE,OwnableType.getOwnerFDB(7),2000,100,100, 600, 1800, 5400, 8000, 11000, PropertyType.getHouseFDB(7), PropertyType.gethotelFDB(7), PropertyType.getMortgageStateFDB(7)));
		FieldList.add(new TryYourLuck(TitleList[8],DescriptionList[8]));
		FieldList.add(new Property(9,TitleList[9],DescriptionList[9],SubtextList[9],Color.ORANGE,OwnableType.getOwnerFDB(9),2000,1000,100, 600, 1800, 5400, 8000, 11000, PropertyType.getHouseFDB(9), PropertyType.gethotelFDB(9), PropertyType.getMortgageStateFDB(9)));
		FieldList.add(new Property(10,TitleList[10],DescriptionList[10],SubtextList[10],Color.ORANGE,OwnableType.getOwnerFDB(10),2400,1000,150, 800, 2000, 6000, 9000, 12000, PropertyType.getHouseFDB(10), PropertyType.gethotelFDB(10), PropertyType.getMortgageStateFDB(10)));
		FieldList.add(new Jail(TitleList[11],DescriptionList[11],SubtextList[11]));
		FieldList.add(new Property(12,TitleList[12],DescriptionList[12],SubtextList[12],Color.GREEN,OwnableType.getOwnerFDB(12),2800,2000,200, 1000, 3000, 9000, 12500, 15000, PropertyType.getHouseFDB(12), PropertyType.gethotelFDB(12), PropertyType.getMortgageStateFDB(12)));
		FieldList.add(new Utility(13,TitleList[13],DescriptionList[13],SubtextList[13],OwnableType.getOwnerFDB(13),3000,100, PropertyType.getMortgageStateFDB(13)));
		FieldList.add(new Property(14,TitleList[14],DescriptionList[14],SubtextList[14],Color.GREEN,OwnableType.getOwnerFDB(14),2800,2000,200, 1000, 3000, 9000, 12500, 15000, PropertyType.getHouseFDB(14), PropertyType.gethotelFDB(14), PropertyType.getMortgageStateFDB(14)));
		FieldList.add(new Property(15,TitleList[15],DescriptionList[15],SubtextList[15],Color.GREEN,OwnableType.getOwnerFDB(15),3200,2000,250, 1250, 3750, 10000, 14000, 18000, PropertyType.getHouseFDB(15), PropertyType.gethotelFDB(15), PropertyType.getMortgageStateFDB(15)));
		FieldList.add(new RailRoad(16,TitleList[16],DescriptionList[16],SubtextList[16],Color.BLUE,OwnableType.getOwnerFDB(16),4000,500, PropertyType.getMortgageStateFDB(16)));
		FieldList.add(new Property(17,TitleList[17],DescriptionList[17],SubtextList[17],Color.LIGHT_GRAY,OwnableType.getOwnerFDB(17),3600,2000,300, 1400, 4000, 11000, 15000, 19000, PropertyType.getHouseFDB(17), PropertyType.gethotelFDB(17), PropertyType.getMortgageStateFDB(17)));
		FieldList.add(new TryYourLuck(TitleList[18],DescriptionList[18]));
		FieldList.add(new Property(19,TitleList[19],DescriptionList[19],SubtextList[19],Color.LIGHT_GRAY,OwnableType.getOwnerFDB(19),3600,2000,300, 1400, 4000, 11000, 15000, 19000, PropertyType.getHouseFDB(19), PropertyType.gethotelFDB(19), PropertyType.getMortgageStateFDB(19)));
		FieldList.add(new Property(20,TitleList[20],DescriptionList[20],SubtextList[20],Color.LIGHT_GRAY,OwnableType.getOwnerFDB(20),4000,2000,350, 1600, 4400, 12000, 16000, 20000, PropertyType.getHouseFDB(20), PropertyType.gethotelFDB(20), PropertyType.getMortgageStateFDB(20)));
		FieldList.add(new Parking(TitleList[21],DescriptionList[21],SubtextList[21]));
		FieldList.add(new Property(22,TitleList[22],DescriptionList[22],SubtextList[22],Color.RED,OwnableType.getOwnerFDB(22),4400,3000,350, 1800, 5000, 14000, 17500, 21000, PropertyType.getHouseFDB(22), PropertyType.gethotelFDB(22), PropertyType.getMortgageStateFDB(22)));
		FieldList.add(new TryYourLuck(TitleList[23],DescriptionList[23]));
		FieldList.add(new Property(24,TitleList[24],DescriptionList[24],SubtextList[24],Color.RED,OwnableType.getOwnerFDB(24),4400,3000,350, 1800, 5000, 14000, 17500, 21000, PropertyType.getHouseFDB(24), PropertyType.gethotelFDB(24), PropertyType.getMortgageStateFDB(24)));
		FieldList.add(new Property(25,TitleList[25],DescriptionList[25],SubtextList[25],Color.RED,OwnableType.getOwnerFDB(25),4800,3000,400, 2000, 6000, 15000, 18500, 22000, PropertyType.getHouseFDB(25), PropertyType.gethotelFDB(25), PropertyType.getMortgageStateFDB(25)));
		FieldList.add(new RailRoad(26,TitleList[26],DescriptionList[26],SubtextList[26],Color.BLUE,OwnableType.getOwnerFDB(26),4000,500, PropertyType.getMortgageStateFDB(26)));
		FieldList.add(new Property(27,TitleList[27],DescriptionList[27],SubtextList[27],Color.WHITE,OwnableType.getOwnerFDB(27),5200,3000,450, 2200, 6600, 16000, 19500, 23000, PropertyType.getHouseFDB(27), PropertyType.gethotelFDB(27), PropertyType.getMortgageStateFDB(27)));
		FieldList.add(new Property(28,TitleList[28],DescriptionList[28],SubtextList[28],Color.WHITE,OwnableType.getOwnerFDB(28),5200,3000,450, 2200, 6600, 16000, 19500, 23000, PropertyType.getHouseFDB(28), PropertyType.gethotelFDB(28), PropertyType.getMortgageStateFDB(28)));
		FieldList.add(new Utility(29,TitleList[29],DescriptionList[29],SubtextList[29],OwnableType.getOwnerFDB(29),3000,100, PropertyType.getMortgageStateFDB(29)));
		FieldList.add(new Property(30,TitleList[30],DescriptionList[30],SubtextList[30],Color.WHITE,OwnableType.getOwnerFDB(30),5600,3000,500, 2400, 7200, 17000, 20500, 24000, PropertyType.getHouseFDB(30), PropertyType.gethotelFDB(30), PropertyType.getMortgageStateFDB(30)));
		FieldList.add(new GoToJail(TitleList[31],DescriptionList[31],SubtextList[31]));
		FieldList.add(new Property(32,TitleList[32],DescriptionList[32],SubtextList[32],Color.YELLOW,OwnableType.getOwnerFDB(32),6000,4000,550, 2600, 7800, 18000, 22000, 25000, PropertyType.getHouseFDB(32), PropertyType.gethotelFDB(32), PropertyType.getMortgageStateFDB(32)));
		FieldList.add(new Property(33,TitleList[33],DescriptionList[33],SubtextList[33],Color.YELLOW,OwnableType.getOwnerFDB(33),6000,4000,550, 2600, 7800, 18000, 22000, 25000, PropertyType.getHouseFDB(33), PropertyType.gethotelFDB(33), PropertyType.getMortgageStateFDB(33)));
		FieldList.add(new TryYourLuck(TitleList[34],DescriptionList[34]));
		FieldList.add(new Property(35,TitleList[35],DescriptionList[35],SubtextList[35],Color.YELLOW,OwnableType.getOwnerFDB(35),6400,4000,600, 3000, 9000, 20000, 24000, 28000, PropertyType.getHouseFDB(35), PropertyType.gethotelFDB(35), PropertyType.getMortgageStateFDB(35)));
		FieldList.add(new RailRoad(36,TitleList[36],DescriptionList[36],SubtextList[36],Color.BLUE,OwnableType.getOwnerFDB(36),4000,500, PropertyType.getMortgageStateFDB(36)));
		FieldList.add(new TryYourLuck(TitleList[37],DescriptionList[37]));
		FieldList.add(new Property(38,TitleList[38],DescriptionList[38],SubtextList[38],new Color(150,53,150),OwnableType.getOwnerFDB(38),7000,4000,700, 3500, 10000, 22000, 26000, 30000, PropertyType.getHouseFDB(38), PropertyType.gethotelFDB(38), PropertyType.getMortgageStateFDB(38)));
		FieldList.add(new PercentageTax(TitleList[39],DescriptionList[39],SubtextList[39]));
		FieldList.add(new Property(40,TitleList[40],DescriptionList[40],SubtextList[40],new Color(150,53,150),OwnableType.getOwnerFDB(40),8000,4000,1000, 4000, 12000, 28000, 34000, 40000, PropertyType.getHouseFDB(40), PropertyType.gethotelFDB(40), PropertyType.getMortgageStateFDB(40)));
	}
	
}
