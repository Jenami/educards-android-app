package educards.educards_model;

public class Player {
	
	private Integer id;
	private String image;
	private String name;
	private Integer age;
	private String password;

	public Player (){}

	public Player(Integer id, String image, String name, Integer age, String password) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.image = image;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public String getImage() {
		return image;
	}
	
	public String getUsername() {
		return name;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public String getPassword() {
		return password;
	}
}