package educards.educards_model.test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import educards.educards_model.player.Player;

public class PlayerTest {
 	Player player;
	
	@Before
	public void setUp() {
		player = new Player(1,"pepe");
	}
	
	@Test
	public void testGetId() {
		assertTrue(1 == player.getId());
	}
 	@Test 
	public void testGetUsername() {
		assertTrue("pepe" == player.getUsername());
	}
	
	@Test
	public void testGetHiScore() {
		assertTrue(0 == player.getHiScore());
	}
	
	@Test
	public void saveHiScore() {
		player.saveHiScore(40);
		assertTrue(40 == player.getHiScore());
	}
}
