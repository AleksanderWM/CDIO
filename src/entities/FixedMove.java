package entities;

import java.sql.SQLException;

public class FixedMove extends ChanceCard{
	
	private int Move;

	public FixedMove(int ID, int Type, String Des, int Move) {
		super(ID, Type, Des);
		this.Move = Move;
		// TODO Auto-generated constructor stub
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
}