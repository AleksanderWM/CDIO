package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;

import controllers.dbCreator.tbCreator;

public class Game {

	public static void main(String[] argm){
		dbCreator Creator = new dbCreator();
			Creator.DeleteGameTemp();
			
			//CREATION
			Creator.CreateGame();
			tbCreator.tbCreatorGame();
			
			//CONNECTION
		dbConnector Connector = new dbConnector("Localhost", 3306, "game", "root", "sql123");
			if(Connector!=null)System.out.println("Connection sucessful...");
			
			//INSERTION
			try {
				Connector.doUpdate("INSERT into PLAYER values(1, 'Simon', 'Red', 11, 0);");
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			//VIEWING
			try {
				ResultSet rs = Connector.doQuery("SELECT * FROM player");
				while(rs.next()){
					String n = rs.getString("name");
					int j = rs.getInt("GetOutOfJail");
					System.out.println(n + "\t" + j);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			//CLOSURE
			try {
				Connector.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
	}
}
