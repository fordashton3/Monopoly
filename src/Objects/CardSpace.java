package Objects;

public class CardSpace extends Space{
private final CardType type;
	protected CardSpace(String name, int spaceNum, CardType cardType) {
		super(name, spaceNum);
		this.type = cardType;
	}

	public CardType getType() {
		return type;
	}
}
