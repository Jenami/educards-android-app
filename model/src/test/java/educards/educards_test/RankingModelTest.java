package educards.educards_test;

import org.junit.Before;
import org.junit.Test;

import educards.educards_model.RankingModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RankingModelTest {

    RankingModel rankingModel;

    @Before
    public void setUp() {
         rankingModel = new RankingModel("name", 1);
    }

    @Test
    public void rankingModelBuilderTest() {
        assertEquals("name", rankingModel.getName());
        assertTrue(1 == rankingModel.getRank());

    }
}
