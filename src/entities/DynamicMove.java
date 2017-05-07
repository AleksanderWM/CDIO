/**
 * @author Simon
 * Gruppe 
 * 02362 Projekt i software-udvikling 
 */
package entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DynamicMove extends ChanceCard{
	
	private int Moves;

	public DynamicMove(int ID, int Type, String Des, int Moves) {
		super(ID, Type, Des);
		this.Moves = Moves;
		try {
			connector.doUpdate("chance","INSERT into Dynamicmove values(" + ID + "," + Moves + ");");
			connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated constructor stub
	}

	public int getMoves(){
		return Moves;
	}
	
	public void setMoves(int ChanceMove){
		Moves = ChanceMove;
		connector.Connect("chance");
		try {
			connector.doUpdate("chance","UPDATE dynamicMove SET moves = " + ChanceMove + " WHERE DynamicMoveID = " + ID + ";");
				connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeChance(ChanceCard card) {
		connector.Connect("chance");
		try {
			connector.doUpdate("Chance","DELETE FROM chance WHERE " + card.getChanceID() +  "= ChanceID;");
			connector.doUpdate("Chance","DELETE FROM dynamicMove WHERE " + card.getChanceID() +  "= dynamicmoveID;");
				connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getdbMoves(){
		connector.Connect("chance");
		int M = 0;
		try {
		ResultSet rs = connector.doQuery("chance","SELECT moves FROM dynamicmove WHERE dynamicmoveID = "+ ID +";");
		while(rs.next()){
		M = rs.getInt("moves");
		}
		connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return M;
	}
	
	public int getMovesFDB(int ChanceID){
		connector.Connect("chance");
		int M = 0;
		try {
		ResultSet rs = connector.doQuery("chance","SELECT moves FROM dynamicmove WHERE DynamicmoveID = "+ ChanceID +";");
		while(rs.next()){
		M = rs.getInt("chancetype");
		}
		connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return M;
	}
	@Override
	public void loadChance() {
		// TODO Auto-generated method stub
		ID = getdbID();
		Type = getdbType();
		Moves = getdbMoves();
		
	}
}