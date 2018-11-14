package educards.educards_test.card;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import educards.educards_model.card.Card;

public class CardTest {

	Card card;
	
	@Before
	public void setUp() {
		card = new Card(0,"card name", "card history", 1600);
	}
	
	@Test
	public void builderTest() {
		assertTrue(0 == card.getId());
		assertEquals("card name",card.getName());
		assertEquals("card history",card.getHistory());
		assertTrue(1600 == card.getYear());
	}

}
