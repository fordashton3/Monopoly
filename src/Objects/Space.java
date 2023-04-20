package Objects;

public abstract class Space {
	private final String name;
	private final int spaceNum;

	protected Space(String name, int spaceNum) {
		this.name = name;
		this.spaceNum = spaceNum;
	}

	public String getName() {
		return name;
	}

	public int getSpaceNum() {
		return spaceNum;
	}
}
