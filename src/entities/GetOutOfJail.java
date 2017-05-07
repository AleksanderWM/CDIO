package entities;

import java.sql.SQLException;

public class GetOutOfJail extends ChanceCard{

	public GetOutOfJail(int ID, int Type, String Des) {
		super(ID, Type, Des);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void removeChance(ChanceCard card) {
		connector.Connect("chance");
		try {
			connector.doUpdate("Chance","DELETE FROM chance WHERE " + card.getChanceID() +  "= ChanceID;");
				connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}