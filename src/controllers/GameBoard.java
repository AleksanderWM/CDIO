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
	private Text TxtFile = new Text("FieldsEN.txt");
	private String[] TxtList = null;
	
	public void CreateBoard(){
		try {
			TxtList = TxtFile.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		FieldList.add(new Start());
		FieldList.add(new Property(TxtList[1],"1200",Color.CYAN,null,1200,50));
		FieldList.add(new TryYourLuck());
		FieldList.add(new Property(TxtList[3],"1200",Color.CYAN,null,1200,50));
		FieldList.add(new Tax());
		FieldList.add(new RailRoad(TxtList[5],"4000",Color.BLUE,null,4000,500, "url"));
		FieldList.add(new Property(TxtList[6],"2000",Color.ORANGE,null,2000,100));
		FieldList.add(new TryYourLuck());
		FieldList.add(new Property(TxtList[8],"2000",Color.ORANGE,null,2000,100));
		FieldList.add(new Property(TxtList[9],"2400",Color.ORANGE,null,2400,150));
		FieldList.add(new Jail());
		FieldList.add(new Property(TxtList[11],"2800",Color.GREEN,null,2800,200));
		FieldList.add(new Utility(TxtList[12],"3000",Color.RED,null,3000,100, "url"));
		FieldList.add(new Property(TxtList[13],"2800",Color.GREEN,null,2800,200));
		FieldList.add(new Property(TxtList[14],"3200",Color.GREEN,null,3200,250));
		FieldList.add(new RailRoad(TxtList[15],"4000",Color.BLUE,null,4000,500, "url"));
		FieldList.add(new Property(TxtList[16],"3600",Color.LIGHT_GRAY,null,3600,300));
		FieldList.add(new TryYourLuck());
		FieldList.add(new Property(TxtList[18],"3600",Color.LIGHT_GRAY,null,3600,300));
		FieldList.add(new Property(TxtList[19],"4000",Color.LIGHT_GRAY,null,4000,350));
		FieldList.add(new Parking());
		FieldList.add(new Property(TxtList[21],"4400",Color.RED,null,4400,350));
		FieldList.add(new TryYourLuck());
		FieldList.add(new Property(TxtList[23],"4400",Color.RED,null,4400,350));
		FieldList.add(new Property(TxtList[24],"4800",Color.RED,null,4800,400));
		FieldList.add(new RailRoad(TxtList[25],"4000",Color.BLUE,null,4000,500, "url"));
		FieldList.add(new Property(TxtList[26],"5200",Color.WHITE,null,5200,450));
		FieldList.add(new Property(TxtList[27],"5200",Color.WHITE,null,5200,450));
		FieldList.add(new Utility(TxtList[28],"3000",Color.RED,null,3000,100, "url"));
		FieldList.add(new Property(TxtList[29],"5600",Color.WHITE,null,5600,500));
		FieldList.add(new GoToJail());
		FieldList.add(new Property(TxtList[31],"6000",Color.YELLOW,null,6000,550));
		FieldList.add(new Property(TxtList[32],"6000",Color.YELLOW,null,6000,550));
		FieldList.add(new TryYourLuck());
		FieldList.add(new Property(TxtList[34],"6400",Color.YELLOW,null,6400,600));
		FieldList.add(new RailRoad(TxtList[35],"4000",Color.BLUE,null,4000,500, "url"));
		FieldList.add(new TryYourLuck());
		FieldList.add(new Property(TxtList[37],"7000",Color.MAGENTA,null,7000,700));
		FieldList.add(new PercentageTax());
		FieldList.add(new Property(TxtList[39],"8000",Color.MAGENTA,null,8000,1000));
	}
	
	public ArrayList<Field> getFieldList(){
		return FieldList;
	}
}
