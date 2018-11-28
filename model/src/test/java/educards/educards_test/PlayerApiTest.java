package educards.educards_test;

import org.junit.Before;
import org.junit.Test;

import educards.educards_model.PlayerApi;

import static org.junit.Assert.assertTrue;

public class PlayerApiTest {

    PlayerApi player;

    @Before
    public void setUp() {
        player = new PlayerApi("name",1,"image","abc");
    }

    @Test
    public void playerApiBuilderTest() {
        assertTrue("image" == player.getImage());
        assertTrue("name" == player.getName());
        assertTrue(1 == player.getAge());
        assertTrue("abc" == player.getPassword());
    }

}

