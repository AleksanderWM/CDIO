package controllers;

import java.awt.Color;
import java.io.IOException;
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

	/**
	 * Creates the Array of boards
	 */
	public void CreateBoard(){
		try {
			TitleList = TitleFile.OpenFile();
			DescriptionList = DescriptionFile.OpenFile();
			SubtextList = SubtextFile.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		FieldList.add(null);
		FieldList.add(new Start());
		FieldList.add(new Property(TitleList[2],DescriptionList[2],SubtextList[2],Color.CYAN,noOwner,1200,1000,50,250,750, 2250, 4000, 6000,0,0));
		FieldList.add(new TryYourLuck(TitleList[3],DescriptionList[3]));
		FieldList.add(new Property(TitleList[4],DescriptionList[4],SubtextList[4],Color.CYAN,noOwner,1200,1000,50, 250, 750, 2250, 4000, 6000, 0, 0));
		FieldList.add(new FixedTax(TitleList[5],DescriptionList[5],SubtextList[5]));
		FieldList.add(new RailRoad(TitleList[6],DescriptionList[6],SubtextList[6],Color.BLUE,noOwner,4000,500));
		FieldList.add(new Property(TitleList[7],DescriptionList[7],SubtextList[7],Color.ORANGE,noOwner,2000,100,100, 600, 1800, 5400, 8000, 11000, 0, 0));
		FieldList.add(new TryYourLuck(TitleList[8],DescriptionList[8]));
		FieldList.add(new Property(TitleList[9],DescriptionList[9],SubtextList[9],Color.ORANGE,noOwner,2000,1000,100, 600, 1800, 5400, 8000, 11000, 0, 0));
		FieldList.add(new Property(TitleList[10],DescriptionList[10],SubtextList[10],Color.ORANGE,noOwner,2400,1000,150, 800, 2000, 6000, 9000, 12000, 0, 0));
		FieldList.add(new Jail(TitleList[11],DescriptionList[11],SubtextList[11]));
		FieldList.add(new Property(TitleList[12],DescriptionList[12],SubtextList[12],Color.GREEN,noOwner,2800,2000,200, 1000, 3000, 9000, 12500, 15000, 0, 0));
		FieldList.add(new Utility(TitleList[13],DescriptionList[13],SubtextList[13],noOwner,3000,100));
		FieldList.add(new Property(TitleList[14],DescriptionList[14],SubtextList[14],Color.GREEN,noOwner,2800,2000,200, 1000, 3000, 9000, 12500, 15000, 0, 0));
		FieldList.add(new Property(TitleList[15],DescriptionList[15],SubtextList[15],Color.GREEN,noOwner,3200,2000,250, 1250, 3750, 10000, 14000, 18000, 0, 0));
		FieldList.add(new RailRoad(TitleList[16],DescriptionList[16],SubtextList[16],Color.BLUE,noOwner,4000,500));
		FieldList.add(new Property(TitleList[17],DescriptionList[17],SubtextList[17],Color.LIGHT_GRAY,noOwner,3600,2000,300, 1400, 4000, 11000, 15000, 19000, 0, 0));
		FieldList.add(new TryYourLuck(TitleList[18],DescriptionList[18]));
		FieldList.add(new Property(TitleList[19],DescriptionList[19],SubtextList[19],Color.LIGHT_GRAY,noOwner,3600,2000,300, 1400, 4000, 11000, 15000, 19000, 0, 0));
		FieldList.add(new Property(TitleList[20],DescriptionList[20],SubtextList[20],Color.LIGHT_GRAY,noOwner,4000,2000,350, 1600, 4400, 12000, 16000, 20000, 0, 0));
		FieldList.add(new Parking(TitleList[21],DescriptionList[21],SubtextList[21]));
		FieldList.add(new Property(TitleList[22],DescriptionList[22],SubtextList[22],Color.RED,noOwner,4400,3000,350, 1800, 5000, 14000, 17500, 21000, 0, 0));
		FieldList.add(new TryYourLuck(TitleList[23],DescriptionList[23]));
		FieldList.add(new Property(TitleList[24],DescriptionList[24],SubtextList[24],Color.RED,noOwner,4400,3000,350, 1800, 5000, 14000, 17500, 21000, 0, 0));
		FieldList.add(new Property(TitleList[25],DescriptionList[25],SubtextList[25],Color.RED,noOwner,4800,3000,400, 2000, 6000, 15000, 18500, 22000, 0, 0));
		FieldList.add(new RailRoad(TitleList[26],DescriptionList[26],SubtextList[26],Color.BLUE,noOwner,4000,500));
		FieldList.add(new Property(TitleList[27],DescriptionList[27],SubtextList[27],Color.WHITE,noOwner,5200,3000,450, 2200, 6600, 16000, 19500, 23000, 0, 0));
		FieldList.add(new Property(TitleList[28],DescriptionList[28],SubtextList[28],Color.WHITE,noOwner,5200,3000,450, 2200, 6600, 16000, 19500, 23000, 0, 0));
		FieldList.add(new Utility(TitleList[29],DescriptionList[29],SubtextList[29],noOwner,3000,100));
		FieldList.add(new Property(TitleList[30],DescriptionList[30],SubtextList[30],Color.WHITE,noOwner,5600,3000,500, 2400, 7200, 17000, 20500, 24000, 0, 0));
		FieldList.add(new GoToJail(TitleList[31],DescriptionList[31],SubtextList[31]));
		FieldList.add(new Property(TitleList[32],DescriptionList[32],SubtextList[32],Color.YELLOW,noOwner,6000,4000,550, 2600, 7800, 18000, 22000, 25000, 0, 0));
		FieldList.add(new Property(TitleList[33],DescriptionList[33],SubtextList[33],Color.YELLOW,noOwner,6000,4000,550, 2600, 7800, 18000, 22000, 25000, 0, 0));
		FieldList.add(new TryYourLuck(TitleList[34],DescriptionList[34]));
		FieldList.add(new Property(TitleList[35],DescriptionList[35],SubtextList[35],Color.YELLOW,noOwner,6400,4000,600, 3000, 9000, 20000, 24000, 28000, 0, 0));
		FieldList.add(new RailRoad(TitleList[36],DescriptionList[36],SubtextList[36],Color.BLUE,noOwner,4000,500));
		FieldList.add(new TryYourLuck(TitleList[37],DescriptionList[37]));
		FieldList.add(new Property(TitleList[38],DescriptionList[38],SubtextList[38],new Color(150,53,150),noOwner,7000,4000,700, 3500, 10000, 22000, 26000, 30000, 0, 0));
		FieldList.add(new PercentageTax(TitleList[39],DescriptionList[39],SubtextList[39]));
		FieldList.add(new Property(TitleList[40],DescriptionList[40],SubtextList[40],new Color(150,53,150),noOwner,8000,4000,1000, 4000, 12000, 28000, 34000, 40000, 0, 0));
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
}
