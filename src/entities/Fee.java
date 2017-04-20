package entities;

public abstract class Fee implements Field {
	//ATTRIBUTES
	
	int Fee;
	String Description;
	String Title;
	int Number;
	String Subtext;

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
		return Number;
	}

	@Override
	public void setNumber(int numb) {
		Number = numb;
	}

}
