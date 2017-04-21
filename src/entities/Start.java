package entities;

public class Start implements Field {


	public Start(String tit, String desc){
		setTitle(tit);
		setDescription(desc);
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
