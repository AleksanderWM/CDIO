package entities;

public abstract class Fee implements Field {
	//ATTRIBUTES
	
	int fee;
	String description;
	String title;
	int number;

	@Override
	public void landOnField() {

	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String desc) {
		description = desc;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(String titl) {
		title = titl;
	}

	@Override
	public int getNumber() {
		return number;
	}

	@Override
	public void setNumber(int numb) {
		number = numb;
	}

}
