package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.sql.ResultSet;
import org.junit.Before;
import org.junit.Test;

import controllers.DBconnector;
import controllers.DBcreator;

public class LoadDB {

	DBconnector dbco = new DBconnector();
	DBcreator dbcr = new DBcreator();
	
	@Before
	public void setUp() throws Exception {
		dbcr.DeleteDBTemp("game", dbco);
		
	}

	@Test
	public void test() {
		//Tests if the database exists, faiils if it does
		assertFalse(dbcr.checkDB("game"));
			
		//Creates the Database and inserst a singular value for testing purporses
		dbcr.CreateGame();dbcr.tbCreatorGame();
		try {
			dbco.doUpdate("game","INSERT into property values(" + 1 + "," + 100 + ", " + 200 + "," + 300+ ", " + 400+ ", " + 500+ ", " + 100 + ", " + 100+ ", " + 2+ ", " + 0 + " );");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//Initiates the test value
		int test1 = 0;
		
		try {
			//Sets the test value to RENT from testing database
			ResultSet rs = dbco.doQuery("game", "SELECT Rent FROM PROPERTY WHERE FieldID = 1");
			while(rs.next()){
				test1 = rs.getInt("Rent");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//Tests if the test value is correctly altered by the database to 100
		assertEquals(100,test1);
	}
	
	
}
