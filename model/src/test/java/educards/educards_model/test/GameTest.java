package educards.educards_model.test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

import educards.educards_model.game.Board;
import educards.educards_model.game.Game;
import educards.educards_model.player.Player;
import educards.educards_model.card.Card;
 
public class GameTest {
 	Game game;
	Player mockPlayer;
	Board mockBoard;
	ArrayList<Boolean> results;
	
	@Before
	public void setUp() {
		mockPlayer = mock(Player.class);
		mockBoard = mock(Board.class);
		
		ArrayList<Card> mockList = new ArrayList<Card>();
		results = new ArrayList<Boolean>();
		results.add(true); results.add(false); results.add(true);
		results.add(true); results.add(false);
				
		game = new Game(mockPlayer, mockList);
		game.setBoard(mockBoard);
	}
	
	@Test
	public void finishGame() {
		when(mockBoard.checkPlayedCards()).thenReturn(results);
		
		game.finishGame();
		
		assertTrue(60 == game.getFinalScore());
		verify(mockPlayer).saveHiScore(60);
	}
 }