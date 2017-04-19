package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Emil Jørgensen
 */
public class DBconnector extends aDB {
	    
			//Connection attributes, defined in the constructor
	    private Connection connection;
	    
	    /**
	     * Sets the current Database
	     * @param Database name of current Database
	     */
	    public void setCurrentDB(String Database){
	    	super.setDATABASE(Database);
	    }
	    /**
	     * The connector method. Connects to a SQL Dataase
	     * @param host The host name, "Localhost" if run locally
	     * @param port The port ID, "3306" if run locally
	     * @param database The name of the database you want to connect to
	     * @param user The username to the server
	     * @param pass The password to the server
	     */
	    public DBconnector() {
	        try {
	        	//TEMP Connection attempt validation
	        		System.out.println("Connecting to Database " + DATABASE);
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + "?useSSL=false";
				connection = DriverManager.getConnection(url, USER, PASS);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				System.exit(1);
			}
	        //TEMP Connection validation
	        	if(connection!=null)System.out.println("Connected successfully to " + DATABASE);
	    }
	    
	    /**
	     * @return connection
	     */
	    public Connection getConnection(){
	    	return connection;
	    }
	    
	    /**
	     * Method for SQL Data Querys (NOT DATA MANIPULATION)
	     * @return Returns the data as a ResultSet
	     */
	    public ResultSet doQuery(String query) throws SQLException{
	        Statement stmt = connection.createStatement();
	        ResultSet res = stmt.executeQuery(query);
	        return res;
	    }
	    
	    /**
	     * Method for SQL Data Manipulation
	     */
	    public void doUpdate(String query) throws SQLException{
	        Statement stmt = connection.createStatement();
	        stmt.executeUpdate(query);
	    }
	    
	    /**
	     * Method for closing the connection after use
	     */
	    public void close() throws SQLException{
	    	if(connection!=null){
	    		connection.close();
	    		//TEMP Closing validation
	    			System.out.println("Connection closed successfully \n");
	    	}
	    	else{
	    		System.out.println("You are not connected to a Database");
	    	}
	    }
	}
