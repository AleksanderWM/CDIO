package entities;

public class Parking implements Field {

	private String Title = "Free Parking";
	private String Description = "Take a break for free";
//	private String Picture = "";
	
	public Parking(){
		
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
