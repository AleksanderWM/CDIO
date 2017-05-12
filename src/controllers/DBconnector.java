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
	    public Connection connection;
	    
	    public DBconnector() {
		}

		/**
	     * The connector method. Connects to a SQL Dataase
	     * @param host The host name, "Localhost" if run locally
	     * @param port The port ID, "3306" if run locally
	     * @param database The name of the database you want to connect to
	     * @param user The username to the server
	     * @param pass The password to the server
	     */
	    public void Connect(String DB) {
	        try {
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB + "?useSSL=false";
				connection = DriverManager.getConnection(url, USER, PASS);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				System.exit(1);
			}
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
	    public ResultSet doQuery(String DB,String query) throws SQLException{
	    	Connect(DB);
	        Statement stmt = connection.createStatement();
	        ResultSet res = stmt.executeQuery(query);
	        return res;

	    }
	    
	    /**
	     * Method for SQL Data Manipulation
	     */
	    public void doUpdate(String DB, String query) throws SQLException{
	    	Connect(DB);
	        Statement stmt = connection.createStatement();
	        stmt.executeUpdate(query);
	        connection.close();
	    }
	    
	    /**
	     * Method for closing the connection after use
	     */
	    public void close() throws SQLException{
	    	if(connection!=null){
	    		connection.close();
	    	}
	    }
	}
