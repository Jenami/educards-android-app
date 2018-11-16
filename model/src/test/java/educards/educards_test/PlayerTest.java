package educards.educards_test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import educards.educards_model.Player;

public class PlayerTest {
 	Player player;
	
	@Before
	public void setUp() {
		player = new Player(1,"an image","pepe",52,"abc");
	}
	
	@Test
	public void builderTest() {
		assertTrue(1 == player.getId());
		assertTrue("an image" == player.getImage());
		assertTrue("pepe" == player.getUsername());
		assertTrue(52 == player.getAge());
		assertTrue("abc" == player.getPassword());
	}

}