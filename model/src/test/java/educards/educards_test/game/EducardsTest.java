package educards.educards_test.game;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import educards.educards_model.game.Educards;

public class EducardsTest {

	Educards educards;
	
	
	@Before
	public void setUp() {
		educards = new Educards();
	}
	
	@Test
	public void registerPlayer() {
		educards.registerPlayer("Pepa");
		assertEquals(1,educards.getPlayerAdministrator().getNumberOfPlayers());
		assertTrue(1 == educards.getPlayerAdministrator().getPlayer("Pepa").getId());
	}
	
	@Test
	public void startGame() {
		educards.registerPlayer("Pepa");
		educards.startGame("Pepa");
		assertFalse(educards.getCurrentGame()==null);
	}
}
