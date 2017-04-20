package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Game {

	public static void main(String[] argm){
			DBcreator Creator = new DBcreator();
			DBconnector Connector = new DBconnector();
			Creator.DeleteDBTemp("Game",Connector);
			Creator.DeleteDBTemp("Chance", Connector);
			
			//CREATION
			Creator.CreateGame();
			Creator.CreateChance();
			Creator.tbCreatorGame();
			
			//INSERTION
			try {
				Connector.doUpdate("Game","INSERT into PLAYER values(1, 'Simon', 'Red', 11, 2);");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			//VIEWING
			try {
				ResultSet rs = Connector.doQuery("Game","SELECT * FROM PLAYER");
				while(rs.next()){
					int id = rs.getInt("PlayerID");
					String n = rs.getString("Name");
					String c = rs.getString("Colour");
					int p = rs.getInt("Position");
					int j = rs.getInt("GetOutOfJail");
					System.out.println("\tPlayer " + id + ":\n\t\tName: " + n + "\n\t\tColour: " + c + "\n\t\tPosition: " + p + "\n\t\tGet Out Of Jail Cards: " + j);

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
