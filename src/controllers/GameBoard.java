package controllers;

import java.io.IOException;
import java.util.ArrayList;
import entities.Field;
import entities.Text;

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
		
		FieldList.add(new Start(TxtList[1],TxtList[X],));
		FieldList.add(new Property(TxtList[2],));
		FieldList.add(new Chance());
		FieldList.add(new Property(TxtList[4],));
		FieldList.add(new Tax());
		FieldList.add(new RailRoad(TxtList[6],));
		FieldList.add(new Property(TxtList[7],));
		FieldList.add(new Chance());
		FieldList.add(new Property(TxtList[9],));
		FieldList.add(new Property(TxtList[10],));
		FieldList.add(new Jail());
		FieldList.add(new Property[TxtList[12],));
		FieldList.add(new Utility(TxtList[13]));
		FieldList.add(new Property(TxtList[14],));
		FieldList.add(new Property(TxtList[15],));
		FieldList.add(new RailRoad(TxtList[16],));
		FieldList.add(new Property(TxtList[17],));
		FieldList.add(new Chance());
		FieldList.add(new Property(TxtList[19],));
		FieldList.add(new Property(TxtList[20],));
		FieldList.add(new Parking());
		FieldList.add(new Property(TxtList[22],));
		FieldList.add(new Chance());
		FieldList.add(new Property(TxtList[24],));
		FieldList.add(new Property(TxtList[25],));
		FieldList.add(new RailRoad(TxtList[26],));
		FieldList.add(new Property(TxtList[27],));
		FieldList.add(new Property(TxtList[28],));
		FieldList.add(new Utility(TxtList[29],));
		FieldList.add(new Property(TxtList[30],));
		FieldList.add(new GoToJail());
		FieldList.add(new Property(TxtList[32],));
		FieldList.add(new Property(TxtList[33],));
		FieldList.add(new Chance());
		FieldList.add(new Property(TxtList[35],));
		FieldList.add(new RailRoad(TxtList[36],));
		FieldList.add(new Chance());
		FieldList.add(new Property(TxtList[38],));
		FieldList.add(new Percentagetax());
		FieldList.add(new Property(TxtList[40],));
	
	}
}
