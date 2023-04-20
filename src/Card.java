public class Card {
	private final String description;
	private final CardType type;

	public Card(String description, CardType type) {
		this.description = description;
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public CardType getType() {
		return type;
	}
}
