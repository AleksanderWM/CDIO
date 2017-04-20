package controllers;

import java.util.ArrayList;
import entities.Field;
import entities.Text;

public class GameBoard {
	public ArrayList<Field> boardFields = new ArrayList<Field>();
	private Text file = new Text("FieldInfo.txt");
	private String[] textList = null;
}
