package entities;

public class GoToJail implements Field {

	private String Title = "Go to Jail";
	private String Description = "Move to Jail";
	private String Picture = "";
	
	public GoToJail(){
		
	}
	
	@Override
	public void landOnField() {
	}

	@Override
	public String getDescription() {
		return Description;
	}

	@Override
	public void setDescription(String desc) {
	Description = desc;
	}

	@Override
	public String getTitle() {
		return Title;
	}

	@Override
	public void setTitle(String titl) {
		Title = titl;
	}

	@Override
	public int getNumber() {
		return 0;
	}

	@Override
	public void setNumber(int numb) {
		
	}

}
