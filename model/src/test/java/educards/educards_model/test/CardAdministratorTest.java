package educards.educards_model.test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import educards.educards_model.card.Card;
import educards.educards_model.card.CardAdministrator;

public class CardAdministratorTest {
 	
	CardAdministrator cardAdministrator;
	Card mockCard;
	Card mockCard2;
	Card mockCard3;
	
	@Before
	public void setUp() {
		cardAdministrator = new CardAdministrator();
		mockCard = mock(Card.class);
		mockCard2 = mock(Card.class);
		mockCard3 = mock(Card.class);
	}
	
	@Test
	public void addCard() {
		cardAdministrator.addCard(mockCard);
		assertEquals(1,cardAdministrator.getCards().size());
	}
	
}