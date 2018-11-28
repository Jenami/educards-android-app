package educards.educards_test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import educards.educards_model.Board;
import educards.educards_model.Card;
import educards.educards_model.Educards;
import educards.educards_model.Player;

public class EducardsTest {

	Educards educards;
	Player mockPlayer;
	Card card1, card2, card3, card4, card5;

	@Before
	public void setUp() {
		educards = new Educards();
		mockPlayer = new Player(0,null,null,null,null);

	}
	
	@Test
	public void registerPlayer() {
		educards.registerPlayer(mockPlayer);
		assertFalse(educards.getPlayer()==null);
	}

	@Test
	public void finishGame(){
	    //finish game with correct order , 100 points
			card1 = new Card(null, 1,"mc1","h1",1543, null);
			card2 = new Card(null, 2,"mc2","h2",1852, null);
			card3 = new Card(null, 3,"mc3","h3",-460, null);
			card4 = new Card(null, 4,"mc4","h4",289, null);
			card5 = new Card(null, 5,"mc5","h5",1950, null);

			ArrayList<Card> cards = new ArrayList<Card>();
			cards.add(card1);cards.add(card2);cards.add(card3);cards.add(card4);cards.add(card5);

			Board board = new Board(cards);
            educards.setBoard(board);

			board.playCard(1, card3);
			board.playCard(2, card4);
			board.playCard(3, card1);
			board.playCard(4, card2);
			board.playCard(5, card5);

			int result = educards.finishGame();

		assertEquals(result , 100);
	}

	@Test
    public void calculateScore(){
	    ArrayList<Boolean> res = new ArrayList<>();
	    res.add(true); res.add(true); res.add(true); res.add(false); res.add(false);
        int result = educards.calculateScore(res);

        assertEquals(60, result);
    }
}
