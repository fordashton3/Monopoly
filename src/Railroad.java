import java.awt.*;

public class Railroad extends Property{
	Direction direction;

	public Railroad(int spaceNumber, int price, Direction direction) {
		super(spaceNumber, price, Color.white);
		this.direction = direction;
	}

}
