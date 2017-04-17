package entities;

public class Property extends Ownable{

	@Override
	public void landOnField() {
		
		super.landOnField();
	}

	@Override
	public String getDescription() {
		
		return super.getDescription();
	}

	@Override
	public void setDescription(String desc) {
		
		super.setDescription(desc);
	}

	@Override
	public String getTitle() {
		
		return super.getTitle();
	}

	@Override
	public void setTitle(String titl) {
		
		super.setTitle(titl);
	}

	@Override
	public int getNumber() {
		
		return super.getNumber();
	}

	@Override
	public void setNumber(int numb) {
		
		super.setNumber(numb);
	}

	@Override
	public void buyField() {
		
		super.buyField();
	}

	@Override
	public void sellField() {
		
		super.sellField();
	}

	@Override
	public void actionField() {
		
		super.actionField();
	}

	@Override
	public void setRent(int ren) {
		
		super.setRent(ren);
	}

	@Override
	public int getRent() {
		
		return super.getRent();
	}

	@Override
	public void setPrice(int pri) {
		
		super.setPrice(pri);
	}

	@Override
	public int getPrice() {
		
		return super.getPrice();
	}

	@Override
	public void setOwner(Player own) {
		
		super.setOwner(own);
	}

	@Override
	public Player getOwner() {
		
		return super.getOwner();
	}

	@Override
	public void payRent(int own, int rent) {
		
		super.payRent(own, rent);
	}

	@Override
	public int playerOwned() {
		
		return super.playerOwned();
	}

	@Override
	public void mortgage() {
		
		super.mortgage();
	}

	@Override
	public void unmortgage() {
		
		super.unmortgage();
	}

	@Override
	public boolean getMortgageState() {
		
		return super.getMortgageState();
	}



}
