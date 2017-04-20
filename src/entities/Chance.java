package entities;

public class Chance implements Field{

	private String Title = "Try Your Luck";
	private String Description = "Draw a 'Try Your Luck' card";
	
	public Chance(){

	}
	
	@Override
	public void landOnField() {
	}

	@Override
	public String getDescription() {
		return null;
	}

	@Override
	public void setDescription(String desc) {
	}

	@Override
	public String getTitle() {
		
		return null;
	}

	@Override
	public void setTitle(String titl) {
	}

	@Override
	public int getNumber() {
		
		return 0;
	}

	@Override
	public void setNumber(int numb) {
	}

}
