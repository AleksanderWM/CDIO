package entities;

public class FixedMove extends ChanceCard {
	
	protected int Moves;

	public FixedMove(int ID, int Type, String Des, int moves) {
		super(ID, Type, Des);
		this.Moves = moves;
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
	
	public int getMoves(){
		return Moves;
	}
	
	public void setMoves(){
		
	}

}
