package educards.educards_model.test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import educards.educards_model.player.Player;
import educards.educards_model.player.PlayerAdministrator;
import java.util.ArrayList;

public class PlayerAdministratorTest {
 	PlayerAdministrator playerAdministrator;
	Player mockPlayer;
	Player mockPlayer2;
	Player mockPlayer3;
	
	@Before
	public void setUp() {
		playerAdministrator = new PlayerAdministrator();
		mockPlayer = mock(Player.class);
		mockPlayer2 = mock(Player.class);
		mockPlayer3 = mock(Player.class);
	}
	
	@Test
	public void addPlayerToPlayerList() {
		playerAdministrator.addPlayer(mockPlayer);
		assertEquals(1,playerAdministrator.getNumberOfPlayers());
	}
	
	@Test
	public void generateRanking() {
		when(mockPlayer.getHiScore()).thenReturn(20);
		when(mockPlayer2.getHiScore()).thenReturn(15);
		when(mockPlayer3.getHiScore()).thenReturn(40);
		
		playerAdministrator.addPlayer(mockPlayer);
		playerAdministrator.addPlayer(mockPlayer2);
		playerAdministrator.addPlayer(mockPlayer3);
		
		ArrayList<Player> ranking = playerAdministrator.getRanking();
		assertEquals(mockPlayer3, ranking.get(0));
		assertEquals(mockPlayer, ranking.get(1));
		assertEquals(mockPlayer2, ranking.get(2));
	}
	
} 