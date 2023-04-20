import java.awt.*;

public class Property extends Space {
	private final int price;
	private int rent;
	private final Color color;
	private int houses;
	private final int mortgage;
	private boolean owned;


	public Property(String name, int spaceNumber, int price, int rent, Color color, int mortgage) {
		super(name, spaceNumber);
		this.price = price;
		this.rent = rent;
		this.color = color;
		this.mortgage = mortgage;
		owned = false;
		houses = 0;
	}

	public int getPrice() {
		return price;
	}

	public int getRent() {
		return rent;
	}

	public Color getColor() {
		return color;
	}

	public int getMortgage() {
		return mortgage;
	}

	public int getHouses() {
		return houses;
	}

	public boolean isOwned() {
		return owned;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}

	public void setOwned(boolean owned) {
		this.owned = owned;
	}

	public void setHouses(int houses) {
		this.houses = houses;
	}
}
