package educards.educards_model;

public class Player {
	
	private Integer idPlayer;
	private String image;
	private String username;
	private Integer age;
	private String password;
	
	public Player(Integer id, String image, String name, Integer age, String password) {
		this.idPlayer = id;
		this.image = image;
		this.username = name;
		this.age = age;
		this.password = password;
	}

	public Integer getId() {
		return idPlayer;
	}

	public String getImage() {
		return image;
	}
	
	public String getUsername() {
		return username;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public String getPassword() {
		return password;
	}
}