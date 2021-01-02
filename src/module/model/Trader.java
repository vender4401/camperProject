package module.model;

public class Trader {
	private String id;
	private String name;
	
	public Trader(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
