package educards.educards_model.card;

import java.util.ArrayList;

public class CardGenerator {

	ArrayList<Card> cards = new ArrayList<Card>();
	
	public CardGenerator() {
		Card card1 = new Card(
				1,
				"Creación de la Mona Lisa",
				"'La Mona Lisa', cuadro pintado por Leonardo Da Vinci, es considerado el cuadro más famoso de la historia",
				1503);
		
		Card card2 = new Card(
				2,
				"Adolf Hittler asume la presidencia de Alemania",
				"Adolf Hittler fue el líder del partido Nazi, y quien dirigió a Alemania durante la segunda guerra mundial",
				1934);
		
		Card card3 = new Card(
				3,
				"Asesinato de Abraham Lincoln",
				"El decimosexto presidente de los Estados Unidos, fue asesinado en el teatro Ford a manos de John Booth",
				1865);
		
		Card card4 = new Card(
				4,
				"Nacimiento de LudWig Van Beethoven",
				"Es uno de los compositores más importantes de la historia de la música, su obra más famosa es 'Para Elisa'",
				1770);
		
		Card card5 = new Card(
				5,
				"Inauguracion de la Torre Eiffel",
				"La Torre Eiffel, ubicada en París, Francia, es uno de los monumentos más icónicos del mundo",
				1889);
		
		cards.add(card1);
		cards.add(card2);
		cards.add(card3);
		cards.add(card4);
		cards.add(card5);
	}
	
	public ArrayList<Card> getCards(){
		return cards;
	}
}
