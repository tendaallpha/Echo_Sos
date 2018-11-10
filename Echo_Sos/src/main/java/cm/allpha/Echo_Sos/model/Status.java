package cm.allpha.Echo_Sos.model;

public enum Status {
	Admin("Admin"), Orphan("orphan"), Parrain("Parrain"), Child("Child"), Ong("Ong");

	private final String option;

	private Status(String name) {
		this.option = name;
	}

	public String getOption() {
		return option;
	}

}
