package entities;

public class DynamicMove extends ChanceCard{
	
	private int Moves;

	public DynamicMove(int ID, int Type, String Des, int Moves) {
		super(ID, Type, Des);
	this.Moves = Moves;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Chance() {
		// TODO Auto-generated method stub
		
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

}
