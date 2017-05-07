package entities;

public class ChanceFee extends ChanceCard{

	private int Fee;
	
	public ChanceFee(int ID, int Type, String Des, int Fee) {
		super(ID, Type, Des);
		
		this.Fee = Fee;
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

	public int getFee(){
		return Fee;
	}
	
	public void setFee(int fee){
		Fee = fee;
	}
}
