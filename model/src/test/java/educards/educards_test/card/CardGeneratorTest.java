package educards.educards_test.card;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import educards.educards_model.card.CardGenerator;

public class CardGeneratorTest {

	CardGenerator cardGenerator;
	
	@Before
	public void setUp() {
		cardGenerator = new CardGenerator();
	}
	
	@Test
	public void getCardsTest() {
		assertTrue(cardGenerator.getCards().size()==5);
	}

}
