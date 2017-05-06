package entities;

public class ChanceFee extends ChanceCard {
	
	protected int Fee;

	public ChanceFee(int ID, int Type, String Des, int fee) {
		super(ID, Type, Des);
		
		this.Fee = fee;
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

	public int getFee(){
		return Fee;
	}
	
	public void setFee(){
		
	}
}
