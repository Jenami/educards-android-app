package educards.educards_model.test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import educards.educards_model.card.Card;
import educards.educards_model.game.Board;

public class BoardTest {
 	Board board;
	Card mockCard;
	Card mockCard2;
	Card mockCard3;
	
	@Before
	public void setUp() {
		mockCard = mock(Card.class);
		mockCard2 = mock(Card.class);
		mockCard3 = mock(Card.class);
		
		when(mockCard.getYear()).thenReturn(1543);
		when(mockCard2.getYear()).thenReturn(1852);
		when(mockCard3.getYear()).thenReturn(-460);
		
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(mockCard);
		cards.add(mockCard2);
		cards.add(mockCard3);
		
		board = new Board(cards);
	}
	
	@Test
	public void generateCorrectOrder() {
		assertEquals(mockCard3, board.getCorrectOrder().get(0));
		assertEquals(mockCard, board.getCorrectOrder().get(1));
		assertEquals(mockCard2, board.getCorrectOrder().get(2));
	}
	
	@Test
	public void playACard() {
		board.playCard(0, mockCard);
		assertEquals(1, board.getPlayedCards().size());
	}
}
