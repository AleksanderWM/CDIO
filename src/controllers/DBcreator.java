package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/** @author Emil Jørgensen */
public class DBcreator extends aDB {
	   
	   /**
	    * Creation of database GAME
	    */
	   public void CreateGame() {
	   Connection connector = null;
	   Statement stmt = null;
	   try{
		   //Registration and connecting
	      Class.forName("com.mysql.jdbc.Driver");
	      System.out.println("Connecting to database...");
	      connector = DriverManager.getConnection(DB_URL, USER, PASS);

	      	//Database Creation
	      		//TEMP Initiation Validation
	      			System.out.println("Creating database...");
	      
	      		//CREATION
	      			stmt = connector.createStatement();
	      			String sql = "CREATE DATABASE Game";
	      			stmt.executeUpdate(sql);
	      			
	      		//TEMP console validation
	      			System.out.println("Database created successfully...");  			
	   }catch(SQLException se){
	      //Creation errors
	      se.printStackTrace();
	   }catch(Exception e){
	      //Registration errors
	      e.printStackTrace();
	   }finally{
		  //CLOSURE
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }
	      try{
	         if(connector!=null)
	            connector.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }
	   }
	}
	   
	   /**
	    * Creation of database CHANCE
	    */
	   public static void CreateChance() {
	   Connection conn = null;
	   Statement stmt = null;
	   try{
		   //Registration and connecting
	      Class.forName("com.mysql.jdbc.Driver");
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);

	      	//Database Creation
	      		//TEMP Initiation Validation
	      			System.out.println("Creating database...");
	      
	      		//CREATION
	      			stmt = conn.createStatement();
	      			String sql = "CREATE DATABASE Chance";
	      			stmt.executeUpdate(sql);
	      			
	      		//TEMP console validation
	      			System.out.println("Database created successfully...");  			
	   }catch(SQLException se){
	      //Creation errors
	      se.printStackTrace();
	   }catch(Exception e){
	      //Registration errors
	      e.printStackTrace();
	   }finally{
		  //CLOSURE
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }
	   }
	}
	   /**
	    * @author Emil Jørgensen
	    */
	   public static class tbCreator {
		   
		   /**
		    * Creation of database Game's Tables
		    */
		   public static void tbCreatorGame(){
			   //Connection to Database
			   DBconnector GameConnector = new DBconnector("Game");
			   //CREATION of tables
			   try {
				GameConnector.doUpdate("CREATE TABLE Player(PlayerID INTEGER(1), Name VARCHAR(20), Colour VARCHAR(10), Position INTEGER(2), GetOutOfJail INTEGER(1), PRIMARY KEY ( PlayerID ));");
				GameConnector.doUpdate("CREATE TABLE Account(PlayerID INTEGER(1), Money INTEGER(1), Networth INTEGER(10), PRIMARY KEY ( PlayerID ));");
				GameConnector.doUpdate("CREATE TABLE Field(FieldID INTEGER(2), Name VARCHAR(20), Description VARCHAR(140), PRIMARY KEY ( FieldID ));");
				GameConnector.doUpdate("CREATE TABLE Ownable(FieldID INTEGER(2), Owner INTEGER(2), Price INTEGER(2), Mortgage INTEGER(4), PRIMARY KEY( FieldID ), FOREIGN KEY ( Owner ) REFERENCES Player( PlayerID ));");
				GameConnector.doUpdate("CREATE TABLE Property(FieldID INTEGER(2), Rent INTEGER(4), Rent1 INTEGER(4), Rent2 INTEGER(4), Rent3 INTEGER(4), Rent4 INTEGER(4), HotelRent INTEGER(5), HousePrice INTEGER(4), House INTEGER(1), Hotel INTEGER(1), PRIMARY KEY ( FieldID ));");
				GameConnector.doUpdate("CREATE TABLE Utility(FieldID INTEGER(2), StartFee INTEGER(5), PRIMARY KEY ( FieldID ));");
				GameConnector.doUpdate("CREATE TABLE Railroad(FieldID INTEGER(2), Rent1 INTEGER(4), Rent2 INTEGER(4), Rent3 INTEGER(4), Rent4 INTEGER(4), PRIMARY KEY ( FieldID ));");
				GameConnector.doUpdate("CREATE TABLE Jail(FieldID INTEGER(2), Player INTEGER(2), Turns INTEGER(2), PRIMARY KEY ( FieldID ), FOREIGN KEY ( Player ) REFERENCES Player( PlayerID ));");
				GameConnector.doUpdate("CREATE TABLE Tax(FieldID INTEGER(2), TaxType INTEGER(1), Tax INTEGER (4), PRIMARY KEY ( FieldID ));");
				GameConnector.doUpdate("CREATE TABLE ProcentageTax(TaxID INTEGER(1), procentageTax INTEGER(2), PRIMARY KEY ( TaxID ));");
				//TEMP validation
					System.out.println("Tables created successfully");
			   		}catch (SQLException e) {
			   			e.printStackTrace();
			   		}
			  //CLOSURE
			   try{
			         if(GameConnector!=null)
			            GameConnector.close();;
			      }catch(SQLException se){
			         se.printStackTrace();
			      }
		   }
	   }   
	   
	   /**
	    * Creation of database CHANCE
	    */
	   public void DeleteGameTemp() {
			   DBconnector GameConnector = new DBconnector("Game");
			   try {
				GameConnector.doUpdate("DROP DATABASE Game;");
				//TEMP Deletion Validation
					System.out.println("Database Game deleted successfully");
			   }catch (SQLException e) {
					e.printStackTrace();
			   } 
			   try{
			         if(GameConnector!=null)
			            GameConnector.close();;
			      }catch(SQLException se){
			         se.printStackTrace();
			      }
		   
	}
		   }
