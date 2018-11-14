package educards.educards_test.player;

import static org.junit.Assert.*;
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
		mockPlayer = new Player(1,"Pepe");
		mockPlayer2 = new Player(2,"Pipo");
		mockPlayer3 = new Player(3,"Pepa");
	}
	
	@Test
	public void addPlayerTest() {
		playerAdministrator.addPlayer(mockPlayer);
		assertEquals(1,playerAdministrator.getNumberOfPlayers());
	}
	
	@Test
	public void generateRanking() {
		mockPlayer.saveHiScore(20);
		mockPlayer2.saveHiScore(15);
		mockPlayer3.saveHiScore(40);
		
		playerAdministrator.addPlayer(mockPlayer);
		playerAdministrator.addPlayer(mockPlayer2);
		playerAdministrator.addPlayer(mockPlayer3);
		
		ArrayList<Player> ranking = playerAdministrator.getRanking();
		assertEquals(mockPlayer3, ranking.get(0));
		assertEquals(mockPlayer, ranking.get(1));
		assertEquals(mockPlayer2, ranking.get(2));
	}
	
	@Test
	public void getPlayerTest() {
		playerAdministrator.addPlayer(mockPlayer);
		Player myPlayer = playerAdministrator.getPlayer("Pepe");
		assertEquals(myPlayer,mockPlayer);
	}
	
} 