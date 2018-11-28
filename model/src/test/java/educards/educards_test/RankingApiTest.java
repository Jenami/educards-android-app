package educards.educards_test;

import org.junit.Before;
import org.junit.Test;

import educards.educards_model.RankingAPI;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RankingApiTest {

    RankingAPI rankingAPI;

    @Before
    public void setUp() {
        rankingAPI = new RankingAPI(0, 1);
    }

    @Test
    public void rankingAPIBuilderTest() {
        assertTrue(0 == rankingAPI.getIdPlayer());
        assertTrue(1 == rankingAPI.getRank());

    }
}
