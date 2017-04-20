package controllers;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import entities.Chance;
import entities.Field;
import entities.GoToJail;
import entities.Jail;
import entities.Parking;
import entities.Property;
import entities.RailRoad;
import entities.Start;
import entities.Tax;
import entities.Text;
import entities.Utility;

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
		FieldList.add(new Start(TxtList[1], null));
		FieldList.add(new Property(TxtList[2],"desc","sub",Color.WHITE,null,4000,400));
		FieldList.add(new Chance());
		FieldList.add(new Property(TxtList[4],"desc","sub",Color.WHITE,null,4000,400));
		FieldList.add(new Tax(TxtList[5],"desc","sub",1000));
		FieldList.add(new RailRoad(TxtList[6],"desc","sub",Color.WHITE,null,4000,400, "url"));
		FieldList.add(new Property(TxtList[7],"desc","sub",Color.WHITE,null,4000,400));
		FieldList.add(new Chance());
		FieldList.add(new Property(TxtList[9],"desc","sub",Color.WHITE,null,4000,400));
		FieldList.add(new Property(TxtList[10],"desc","sub",Color.WHITE,null,4000,400));
		FieldList.add(new Jail());
		FieldList.add(new Property(TxtList[12],"desc","sub",Color.WHITE,null,4000,400));
		FieldList.add(new Utility(TxtList[13],"desc","sub",Color.WHITE,null,4000,400, "url"));
		FieldList.add(new Property(TxtList[14],"desc","sub",Color.WHITE,null,4000,400));
		FieldList.add(new Property(TxtList[15],"desc","sub",Color.WHITE,null,4000,400));
		FieldList.add(new RailRoad(TxtList[16],"desc","sub",Color.WHITE,null,4000,400, "url")));
		FieldList.add(new Property(TxtList[17],"desc","sub",Color.WHITE,null,4000,400));
		FieldList.add(new Chance());
		FieldList.add(new Property(TxtList[19],"desc","sub",Color.WHITE,null,4000,400));
		FieldList.add(new Property(TxtList[20],"desc","sub",Color.WHITE,null,4000,400));
		FieldList.add(new Parking());
		FieldList.add(new Property(TxtList[22],"desc","sub",Color.WHITE,null,4000,400));
		FieldList.add(new Chance());
		FieldList.add(new Property(TxtList[24],"desc","sub",Color.WHITE,null,4000,400));
		FieldList.add(new Property(TxtList[25],"desc","sub",Color.WHITE,null,4000,400));
		FieldList.add(new RailRoad(TxtList[26],"desc","sub",Color.WHITE,null,4000,400, "url")));
		FieldList.add(new Property(TxtList[27],"desc","sub",Color.WHITE,null,4000,400));
		FieldList.add(new Property(TxtList[28],"desc","sub",Color.WHITE,null,4000,400));
		FieldList.add(new Utility(TxtList[29],"desc","sub",Color.WHITE,null,4000,400, "url"));
		FieldList.add(new Property(TxtList[30],"desc","sub",Color.WHITE,null,4000,400));
		FieldList.add(new GoToJail());
		FieldList.add(new Property(TxtList[32],"desc","sub",Color.WHITE,null,4000,400));
		FieldList.add(new Property(TxtList[33],"desc","sub",Color.WHITE,null,4000,400));
		FieldList.add(new Chance());
		FieldList.add(new Property(TxtList[35],"desc","sub",Color.WHITE,null,4000,400));
		FieldList.add(new RailRoad(TxtList[36],"desc","sub",Color.WHITE,null,4000,400, "url")));
		FieldList.add(new Chance());
		FieldList.add(new Property(TxtList[38],"desc","sub",Color.WHITE,null,4000,400));
		FieldList.add(new Percentagetax("desc","sub",Color.WHITE,null,4000,400)));
		FieldList.add(new Property(TxtList[40],"desc","sub",Color.WHITE,null,4000,400));
	
	}
}
