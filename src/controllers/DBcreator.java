package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/** @author Emil Jørgensen */
public class DBcreator extends aDB {
	   DBconnector GameConnector = new DBconnector();
	/**
	 * Checks if a database exists
	 * @param dbName The name of the database
	 * @return True if the database exists, false if not
	 */
public boolean checkDB(String dbName){
		Connection conn = null;
		
		try{
	       Class.forName("com.mysql.jdbc.Driver"); //Register JDBC Driver
	       
	       System.out.println("Creating a connection...");
	       conn = DriverManager.getConnection(DB_URL, USER, PASS); //Open a connection

	       ResultSet resultSet = conn.getMetaData().getCatalogs();

	        while (resultSet.next()) {

	          String databaseName = resultSet.getString(1);
	            if(databaseName.equals(dbName)){
	                return true;
	            }
	        }
	        resultSet.close();

	    }
	    catch(Exception e){
	        e.printStackTrace();
	    }

	    return false;
	}
	   /**
	    * Creation of database GAME
	    */
	   public void CreateGame() {
	   Connection conn = null;
	   Statement stmt = null;
	   try{
		   //Registration and connecting
	      Class.forName("com.mysql.jdbc.Driver");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);

	      		//CREATION
	      			stmt = conn.createStatement();
	      			String sql = "CREATE DATABASE game";
	      			stmt.executeUpdate(sql);
	      			System.out.println("Database Game created successfully...");
	      					
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
	    * Creation of database CHANCE
	    */
	   public void CreateChance() {
	   Connection conn = null;
	   Statement stmt = null;
	   try{
		   //Registration and connecting
	      Class.forName("com.mysql.jdbc.Driver");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      
	      		//CREATION
	      			stmt = conn.createStatement();
	      			String sql = "CREATE DATABASE chance";
	      			stmt.executeUpdate(sql);
	      			System.out.println("Database chance created successfully...");
		
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
		    * Creation of database Game's Tables
		    * @param connector the GameConnector
		    */
		   public void tbCreatorGame(){
			   //CREATION of tables
			   try {
				GameConnector.doUpdate("Game","CREATE TABLE Player(PlayerID INTEGER(1), Name VARCHAR(20), Position INTEGER(2), GetOutOfJail INTEGER(1), Jailtries INTEGER(1), PRIMARY KEY ( PlayerID ));");
				GameConnector.doUpdate("Game","CREATE TABLE Account(PlayerID INTEGER(1), Money INTEGER(10), Networth INTEGER(10), PRIMARY KEY ( PlayerID ));");
				GameConnector.doUpdate("Game","CREATE TABLE Field(FieldID INTEGER(2), Name VARCHAR(20), Description VARCHAR(140), PRIMARY KEY ( FieldID ));");
				GameConnector.doUpdate("Game","CREATE TABLE Ownable(FieldID INTEGER(2), Owner INTEGER(2), Price INTEGER(2), Mortgage INTEGER(4), PRIMARY KEY( FieldID ), FOREIGN KEY ( Owner ) REFERENCES Player( PlayerID ));");
				GameConnector.doUpdate("Game","CREATE TABLE Property(FieldID INTEGER(2), Rent INTEGER(4), Rent1 INTEGER(4), Rent2 INTEGER(4), Rent3 INTEGER(4), Rent4 INTEGER(4), HotelRent INTEGER(5), HousePrice INTEGER(4), House INTEGER(1), Hotel INTEGER(1), PRIMARY KEY ( FieldID ));");
				GameConnector.doUpdate("Game","CREATE TABLE Utility(FieldID INTEGER(2), StartFee INTEGER(5), PRIMARY KEY ( FieldID ));");
				GameConnector.doUpdate("Game","CREATE TABLE Railroad(FieldID INTEGER(2), Rent1 INTEGER(4), Rent2 INTEGER(4), Rent3 INTEGER(4), Rent4 INTEGER(4), PRIMARY KEY ( FieldID ));");
				GameConnector.doUpdate("Game","CREATE TABLE Jail(FieldID INTEGER(2), Player INTEGER(2), Turns INTEGER(2), PRIMARY KEY ( FieldID ), FOREIGN KEY ( Player ) REFERENCES Player( PlayerID ));");
				GameConnector.doUpdate("Game","CREATE TABLE Tax(FieldID INTEGER(2), TaxType INTEGER(1), Tax INTEGER (4), PRIMARY KEY ( FieldID ));");
				GameConnector.doUpdate("Game","CREATE TABLE ProcentageTax(TaxID INTEGER(1), procentageTax INTEGER(2), PRIMARY KEY ( TaxID ));");
				System.out.println("Tables in Game created successfully...");
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
			   
		   /**
		    * Creation of Chance database's table
		    */
		   public void tbCreatorChance(){
			   //CREATION of tables
			   try {
				GameConnector.doUpdate("Chance","CREATE TABLE UtillityMove(UtillityMoveID INTEGER(1), Multiplier INTEGER(2), PRIMARY KEY ( UtillityMoveID ));");
				GameConnector.doUpdate("Chance","CREATE TABLE PropertyTax(PropertyTaxID INTEGER(1), HouseTax INTEGER(5), HotelTax INTEGER(5), PRIMARY KEY ( PropertyTaxID ));");
				GameConnector.doUpdate("Chance","CREATE TABLE FixedMove(FixedMoveID INTEGER(2), Move INTEGER(2), PRIMARY KEY ( FixedMoveID ));");
				GameConnector.doUpdate("Chance","CREATE TABLE DynamicMove(DynamicMoveID INTEGER(2), moves INTEGER(2), PRIMARY KEY( DynamicMoveID ));");
				GameConnector.doUpdate("Chance","CREATE TABLE Matador(MatadorID INTEGER(2), Max INTEGER(5), Bonus INTEGER(5), PRIMARY KEY ( MatadorID ));");
				GameConnector.doUpdate("Chance","CREATE TABLE Fee(FeeID INTEGER(2), Fee INTEGER(5), PRIMARY KEY ( FeeID ));");
				GameConnector.doUpdate("Chance","CREATE TABLE Birthday(BirthdayID INTEGER(2), Fee INTEGER(5), PRIMARY KEY ( BirthdayID ));");
				GameConnector.doUpdate("Chance","CREATE TABLE Chance(ChanceID INTEGER(2), ChanceTypr INTEGER(2), Description VARCHAR(100), PRIMARY KEY ( ChanceID ));");
				System.out.println("Tables in Chance created successfully...");
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
	   
		   /**
		    * Deletes a database
		    * @param DB The name of the databse
		    * @param Connector
		    */
	   public void DeleteDBTemp(String DB, DBconnector Connector) {
			   try {
				Connector.doUpdate(DB,"DROP DATABASE " + DB +";");
				//TEMP Deletion Validation
					System.out.println("Database " + DB +  " deleted successfully");
			   }catch (SQLException e) {
					e.printStackTrace();
			   }
	   }


	}
		   
