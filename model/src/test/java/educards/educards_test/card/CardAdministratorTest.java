package educards.educards_test.card;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import educards.educards_model.card.Card;
import educards.educards_model.card.CardAdministrator;

public class CardAdministratorTest {
 	
	CardAdministrator cardAdministrator;
	ArrayList<Card> mockCards;
	Card mockCard;
	
	@Before
	public void setUp() {
		cardAdministrator = new CardAdministrator();
		mockCard = new Card(0,"mockName","mockHistory",1200);
		mockCards = new ArrayList<Card>();
		mockCards.add(mockCard);
	}
	
	@Test
	public void getCardsTest() {
		ArrayList<Card> cards = cardAdministrator.getCards();
		assertTrue(cards.size()==5);
	}
	
	@Test
	public void setCardsTest() {
		cardAdministrator.setCards(mockCards);
		assertTrue(cardAdministrator.getCards().size() == 1);
	}
	
}