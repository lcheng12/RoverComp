package net.hsa.rover.comp.cheng.asst2;

public class User {

	private String name;
	private String description;
	private String url;
	
	//	private String assignment;
	
	public User(String name, String description, String url) {
		this.name = name;
		this.description = description;
		this.url = url;
		//		this.assignment = assignment;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getUrl() {
		return url;
	}

}
