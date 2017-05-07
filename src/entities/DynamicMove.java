package entities;

import java.sql.SQLException;

public class DynamicMove extends ChanceCard{
	
	private int Moves;

	public DynamicMove(int ID, int Type, String Des, int Moves) {
		super(ID, Type, Des);
	this.Moves = Moves;
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
}