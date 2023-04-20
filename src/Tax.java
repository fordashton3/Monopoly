public class Tax extends Space{
	private final int tax;

	public Tax(int space, int tax) {
		super(space);
		this.tax = tax;
	}

	public int getTax() {
		return tax;
	}
}
