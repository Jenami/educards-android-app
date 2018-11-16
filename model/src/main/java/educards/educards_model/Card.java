package educards.educards_model;

public class Card {

	private String title;
	private Integer idCard;
	private String name;
	private String history;
	private Integer year;
	private String image;
	
	public Card(String cardTitle, Integer id, String cardName, String cardHistory, Integer cardYear, String cardImage) {
		title = cardTitle;
		idCard = id;
		name = cardName;
		history = cardHistory;
		year = cardYear;
		image = cardImage;
	}
	
	public String getTitle() {
		return title;
	}
	
	public Integer getId() {
		return idCard;
	}
	
	public String getName() {
		return name;
	}
	
	public String getHistory() {
		return history;
	}
	
	public Integer getYear() {
		return year;
	}
	
	public String getImage() {
		return image;
	}
}