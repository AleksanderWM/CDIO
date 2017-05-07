package entities;

import java.sql.SQLException;

public class FixedMove extends ChanceCard{
	
	private int Move;

	public FixedMove(int ID, int Type, String Des, int Move) {
		super(ID, Type, Des);
		this.Move = Move;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getChanceID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setChanceID() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getChanceType() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setChanceType() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDescription() {
		// TODO Auto-generated method stub
		
	}
	
	public int getMove(){
		return Move;
	}
	
	public void setMove(int move){
		Move = move;
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