package Objects;

import java.awt.*;

public class Railroad extends Property{
	Direction direction;

	public Railroad(int spaceNumber, int price, int rent, Direction direction) {
		super(spaceNumber, price, rent, Color.white, 0);
		this.direction = direction;
	}

	public Direction getDirection() {
		return direction;
	}
}
