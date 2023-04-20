package Objects;

import java.awt.*;

public class Railroad extends Property{
	Direction direction;

	public Railroad(String name, int spaceNumber, int price, int rent, Direction direction) {
		super(name, spaceNumber, price, rent, Color.white, 0);
		this.direction = direction;
	}

	public Direction getDirection() {
		return direction;
	}
}
