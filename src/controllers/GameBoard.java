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
import language.Language;

/**
 * @author Emil Jørgensen
 */
public class GameBoard {
	public ArrayList<Field> FieldList = new ArrayList<Field>();
	private Text TxtFile = new Text("FieldsEN.txt");
	private String[] TxtList = null;
	private int noOwner = 0;

	
	public void CreateBoard(){
		try {
			TxtList = TxtFile.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		FieldList.add(new Start());
		FieldList.add(new Property(Language.toString(2),"1200",Color.CYAN,noOwner,1200,50));
		FieldList.add(new TryYourLuck(Language.toString(3)));
		FieldList.add(new Property(Language.toString(4),"1200",Color.CYAN,noOwner,1200,50));
		FieldList.add(new Tax());
		FieldList.add(new RailRoad(Language.toString(6),"4000",Color.BLUE,noOwner,4000,500));
		FieldList.add(new Property(Language.toString(7),"2000",Color.ORANGE,noOwner,2000,100));
		FieldList.add(new TryYourLuck(Language.toString(8)));
		FieldList.add(new Property(Language.toString(9),"2000",Color.ORANGE,noOwner,2000,100));
		FieldList.add(new Property(Language.toString(10),"2400",Color.ORANGE,noOwner,2400,150));
		FieldList.add(new Jail());
		FieldList.add(new Property(Language.toString(12),"2800",Color.GREEN,noOwner,2800,200));
		FieldList.add(new Utility(Language.toString(13),"3000",noOwner,3000,100));
		FieldList.add(new Property(Language.toString(14),"2800",Color.GREEN,noOwner,2800,200));
		FieldList.add(new Property(Language.toString(15),"3200",Color.GREEN,noOwner,3200,250));
		FieldList.add(new RailRoad(Language.toString(16),"4000",Color.BLUE,noOwner,4000,500));
		FieldList.add(new Property(Language.toString(17),"3600",Color.LIGHT_GRAY,noOwner,3600,300));
		FieldList.add(new TryYourLuck(Language.toString(18)));
		FieldList.add(new Property(Language.toString(19),"3600",Color.LIGHT_GRAY,noOwner,3600,300));
		FieldList.add(new Property(Language.toString(20),"4000",Color.LIGHT_GRAY,noOwner,4000,350));
		FieldList.add(new Parking(Language.toString(21)));
		FieldList.add(new Property(Language.toString(22),"4400",Color.RED,noOwner,4400,350));
		FieldList.add(new TryYourLuck(Language.toString(23)));
		FieldList.add(new Property(Language.toString(24),"4400",Color.RED,noOwner,4400,350));
		FieldList.add(new Property(Language.toString(25),"4800",Color.RED,noOwner,4800,400));
		FieldList.add(new RailRoad(Language.toString(26),"4000",Color.BLUE,noOwner,4000,500));
		FieldList.add(new Property(Language.toString(27),"5200",Color.WHITE,noOwner,5200,450));
		FieldList.add(new Property(Language.toString(28),"5200",Color.WHITE,noOwner,5200,450));
		FieldList.add(new Utility(Language.toString(29),"3000",noOwner,3000,100));
		FieldList.add(new Property(Language.toString(30),"5600",Color.WHITE,noOwner,5600,500));
		FieldList.add(new GoToJail(Language.toString(31)));
		FieldList.add(new Property(Language.toString(32),"6000",Color.YELLOW,noOwner,6000,550));
		FieldList.add(new Property(Language.toString(33),"6000",Color.YELLOW,noOwner,6000,550));
		FieldList.add(new TryYourLuck(Language.toString(34)));
		FieldList.add(new Property(Language.toString(35),"6400",Color.YELLOW,noOwner,6400,600));
		FieldList.add(new RailRoad(Language.toString(36),"4000",Color.BLUE,noOwner,4000,500));
		FieldList.add(new TryYourLuck(Language.toString(37)));
		FieldList.add(new Property(Language.toString(38),"7000",new Color(150,53,150),noOwner,7000,700));
		FieldList.add(new PercentageTax());
		FieldList.add(new Property(Language.toString(40),"8000",new Color(150,53,150),noOwner,8000,1000));
	}
	
	public ArrayList<Field> getFieldList(){
		return FieldList;
	}
	
	public Field getField(int index){
		return FieldList.get(index);
	}
}
