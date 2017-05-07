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
import entities.Tax;
import entities.Text;
import entities.Utility;

/**
 * @author Emil Jørgensen
 */
public class GameBoard {
	public ArrayList<Field> FieldList = new ArrayList<Field>();
	private Text TitleFile = new Text("FieldTitles.txt");
	private String[] TitleList = null;
	private int noOwner = 0;

	
	public void CreateBoard(){
		try {
			TitleList = TitleFile.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		FieldList.add(null);
		FieldList.add(new Start());
		FieldList.add(new Property(TitleList[2],"1200",Color.CYAN,noOwner,1200,50));
		FieldList.add(new TryYourLuck(TitleList[3]));
		FieldList.add(new Property(TitleList[4],"1200",Color.CYAN,noOwner,1200,50));
		FieldList.add(new Tax());
		FieldList.add(new RailRoad(TitleList[6],"4000",Color.BLUE,noOwner,4000,500));
		FieldList.add(new Property(TitleList[7],"2000",Color.ORANGE,noOwner,2000,100));
		FieldList.add(new TryYourLuck(TitleList[8]));
		FieldList.add(new Property(TitleList[9],"2000",Color.ORANGE,noOwner,2000,100));
		FieldList.add(new Property(TitleList[10],"2400",Color.ORANGE,noOwner,2400,150));
		FieldList.add(new Jail());
		FieldList.add(new Property(TitleList[12],"2800",Color.GREEN,noOwner,2800,200));
		FieldList.add(new Utility(TitleList[13],"3000",noOwner,3000,100));
		FieldList.add(new Property(TitleList[14],"2800",Color.GREEN,noOwner,2800,200));
		FieldList.add(new Property(TitleList[15],"3200",Color.GREEN,noOwner,3200,250));
		FieldList.add(new RailRoad(TitleList[16],"4000",Color.BLUE,noOwner,4000,500));
		FieldList.add(new Property(TitleList[17],"3600",Color.LIGHT_GRAY,noOwner,3600,300));
		FieldList.add(new TryYourLuck(TitleList[18]));
		FieldList.add(new Property(TitleList[19],"3600",Color.LIGHT_GRAY,noOwner,3600,300));
		FieldList.add(new Property(TitleList[20],"4000",Color.LIGHT_GRAY,noOwner,4000,350));
		FieldList.add(new Parking(TitleList[21]));
		FieldList.add(new Property(TitleList[22],"4400",Color.RED,noOwner,4400,350));
		FieldList.add(new TryYourLuck(TitleList[23]));
		FieldList.add(new Property(TitleList[24],"4400",Color.RED,noOwner,4400,350));
		FieldList.add(new Property(TitleList[25],"4800",Color.RED,noOwner,4800,400));
		FieldList.add(new RailRoad(TitleList[26],"4000",Color.BLUE,noOwner,4000,500));
		FieldList.add(new Property(TitleList[27],"5200",Color.WHITE,noOwner,5200,450));
		FieldList.add(new Property(TitleList[28],"5200",Color.WHITE,noOwner,5200,450));
		FieldList.add(new Utility(TitleList[29],"3000",noOwner,3000,100));
		FieldList.add(new Property(TitleList[30],"5600",Color.WHITE,noOwner,5600,500));
		FieldList.add(new GoToJail(TitleList[31]));
		FieldList.add(new Property(TitleList[32],"6000",Color.YELLOW,noOwner,6000,550));
		FieldList.add(new Property(TitleList[33],"6000",Color.YELLOW,noOwner,6000,550));
		FieldList.add(new TryYourLuck(TitleList[34]));
		FieldList.add(new Property(TitleList[35],"6400",Color.YELLOW,noOwner,6400,600));
		FieldList.add(new RailRoad(TitleList[36],"4000",Color.BLUE,noOwner,4000,500));
		FieldList.add(new TryYourLuck(TitleList[37]));
		FieldList.add(new Property(TitleList[38],"7000",new Color(150,53,150),noOwner,7000,700));
		FieldList.add(new PercentageTax());
		FieldList.add(new Property(TitleList[40],"8000",new Color(150,53,150),noOwner,8000,1000));
	}
	
	public ArrayList<Field> getFieldList(){
		return FieldList;
	}
	
	public Field getField(int index){
		return FieldList.get(index);
	}
}
