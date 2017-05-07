/**
 * @author Simon
 * Gruppe 
 * 02362 Projekt i software-udvikling 
 */
package entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FixedMove extends ChanceCard{
	
	private int Move;

	public FixedMove(int ID, int Type, String Des, int Move) {
		super(ID, Type, Des);
		this.Move = Move;
		try {
			connector.doUpdate("chance","INSERT into FixedMove values(" + ID + "," + Move + ");");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getMove(){
		return Move;
	}
	
	public void setMove(int ChanceMove){
		Move = ChanceMove;
		connector.Connect("chance");
		try {
			connector.doUpdate("chance","UPDATE FixedMove SET move = " + ChanceMove + " WHERE FixedMoveID = " + ID + ";");
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
			connector.doUpdate("Chance","DELETE FROM fixedmove WHERE " + card.getChanceID() +  "= FixedMoveID;");
				connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getdbMove(){
		connector.Connect("chance");
		int M = 0;
		try {
		ResultSet rs = connector.doQuery("chance","SELECT move FROM fixedmove WHERE fixedmoveid = "+ ID +";");
		while(rs.next()){
		M = rs.getInt("Move");
		}
		connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return M;
	}
	
	public int getMoveFDB(int ChanceID){
		connector.Connect("chance");
		int M = 0;
		try {
		ResultSet rs = connector.doQuery("chance","SELECT Fixedmove FROM fixedmove WHERE fixedmoveID = "+ ChanceID +";");
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
		Move = getdbMove();
		
	}
}