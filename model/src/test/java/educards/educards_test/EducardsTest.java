package educards.educards_test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import educards.educards_model.Educards;
import educards.educards_model.Player;

public class EducardsTest {

	Educards educards;
	Player mockPlayer;
	
	@Before
	public void setUp() {
		educards = new Educards();
		mockPlayer = new Player(null,null,null,null,null);
	}
	
	@Test
	public void registerPlayer() {
		educards.registerPlayer(mockPlayer);
		assertFalse(educards.getPlayer()==null);
	}
}