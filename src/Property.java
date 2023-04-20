import java.awt.*;

public class Property extends Space {
	private final int price;
	private final Color color;

	public Property(int spaceNumber, int price, Color color) {
		super(spaceNumber);
		this.price = price;
		this.color = color;
	}

	public int getPrice() {
		return price;
	}

	public Color getColor() {
		return color;
	}
}
