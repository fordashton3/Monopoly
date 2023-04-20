import java.awt.*;

public class Property extends Space {
	private final int price;
	private int rent;
	private final Color color;
	private final int mortgage;


	public Property(int spaceNumber, int price, int rent, Color color, int mortgage) {
		super(spaceNumber);
		this.price = price;
		this.rent = rent;
		this.color = color;
		this.mortgage = mortgage;
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

	public void setRent(int rent) {
		this.rent = rent;
	}
}
