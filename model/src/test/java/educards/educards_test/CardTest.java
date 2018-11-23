package educards.educards_test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import educards.educards_model.Card;

public class CardTest {

	Card card;
	
	@Before
	public void setUp() {
		card = new Card("card title",0,"card name", "card history", 1600, "an image");
	}
	
	@Test
	public void builderTest() {
		assertEquals("card title", card.getTitle());
		assertTrue(0 == card.getId());
		assertEquals("card name",card.getName());
		assertEquals("card history",card.getHistory());
		assertTrue(1600 == card.getYear());
		assertEquals("an image", card.getImage());
	}

}