package Objects;

public class Tax extends Space{
	private final int tax;

	public Tax(String name, int space, int tax) {
		super(name, space);
		this.tax = tax;
	}

	public int getTax() {
		return tax;
	}
}
