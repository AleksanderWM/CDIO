package entities;

import java.awt.Color;

public class Utility extends Ownable{

	private String Picture;
	
	public Utility(String title, String description, String subText, Color color, Player player, int cost, int rent, String picture) {
		super(title, description, subText, color, player, cost, rent);
		Picture = picture;
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
