package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;

import controllers.DBcreator.tbCreator;

public class Game {

	public static void main(String[] argm){
		DBcreator Creator = new DBcreator();
			Creator.DeleteGameTemp();
			
			//CREATION
			Creator.CreateGame();
			tbCreator.tbCreatorGame();
			
			//CONNECTION
		DBconnector GameConnector = new DBconnector("Game");
			if(GameConnector!=null)System.out.println("Connection sucessful...");
			
			//INSERTION
			try {
				GameConnector.doUpdate("INSERT into PLAYER values(1, 'Simon', 'Red', 11, 2);");
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			//VIEWING
			try {
				ResultSet rs = GameConnector.doQuery("SELECT * FROM player");
				while(rs.next()){
					String n = rs.getString("name");
					int j = rs.getInt("GetOutOfJail");
					String c = rs.getString("Colour");
					System.out.println(n + "\t" + j + "\t" + c);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			//CLOSURE
			try {
				GameConnector.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
	}
}
