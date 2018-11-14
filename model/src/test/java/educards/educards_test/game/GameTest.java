package educards.educards_test.game;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import educards.educards_model.card.Card;
import educards.educards_model.card.CardAdministrator;
import educards.educards_model.game.Game;
import educards.educards_model.player.Player;
 
public class GameTest {
 	
	Game game;
	Player mockPlayer;
	CardAdministrator cardAdmin;
	ArrayList<Card> cards;
	
	@Before
	public void setUp() {
		mockPlayer = new Player(1,"mock");
		cardAdmin = new CardAdministrator();
		ArrayList<Card> cardsForBoard = cardAdmin.getCards();
		cards = new ArrayList<Card>(cardAdmin.getCards());
		game = new Game(mockPlayer,cardsForBoard);
	}
	
	@Test
	public void finishGameTest() {		
		game.getBoard().playCard(1, cards.get(4));
		game.getBoard().playCard(2, cards.get(3));
		game.getBoard().playCard(3, cards.get(2));
		game.getBoard().playCard(4, cards.get(1));
		game.getBoard().playCard(5, cards.get(0));
		
		game.finishGame();
		assertTrue(game.getFinalScore() == 40);
		assertTrue(game.getPlayer().getHiScore() == 40);
	}
 }