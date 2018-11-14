package educards.educards_model.card;

import java.util.ArrayList;

public class CardAdministrator {

	private ArrayList<Card> cards = new ArrayList<Card>();
	
	public CardAdministrator() {
		CardGenerator generator = new CardGenerator();
		ArrayList<Card> cards = generator.getCards();
		this.cards = cards;
	}	
	
	public ArrayList<Card> getCards(){
		return cards;
	}
	
	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
}