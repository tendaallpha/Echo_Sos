package cm.genie6.echosos.model;

public enum Sex {

	Male("Male"), Femal("Femal");
	
	private final String option;

	private Sex(String name) {
		this.option = name;
	}

	public String getOption() {
		return option;
	}
	
}
