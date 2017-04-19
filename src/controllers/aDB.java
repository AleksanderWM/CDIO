package controllers;

/**
 * @author Emil Jørgensen
 */
public abstract class aDB {

	//ATTRIBUTES
	   public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   public static final String DB_URL = "jdbc:mysql://localhost?useSSL=false";
	   public static final String USER = "root";
	   public static String DATABASE = "";
	   public static final String PASS = "sql123";
	   public static final String HOST = "Localhost";
	   public static final int PORT = 3306;

	/**
	 * Get the current Database
	 * @return the Database
	 */
	protected static String getDATABASE() {
		return DATABASE;
	}

	/**
	 * Sets the name of the current Database
	 * @param Database the name of the current Database
	 */
	protected static void setDATABASE(String Database) {
		DATABASE = Database;
	}
	   
	   
}
