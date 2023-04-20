package Objects;

import java.awt.*;

public class Utilities extends Property{
	private final Utility utility;
	private final int houses;
	public Utilities(String name, int spaceNumber, int price, int rent, boolean isElectric, Utility utility) {
		super(name, spaceNumber, price, rent, Color.white, 0);
		this.utility = utility;
		houses = 0;
	}

	public Utility getUtility() {
		return utility;
	}
}
