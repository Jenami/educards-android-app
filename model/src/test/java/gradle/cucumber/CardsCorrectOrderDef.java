package gradle.cucumber;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import educards.educards_model.Board;
import educards.educards_model.Card;

import static org.junit.Assert.assertEquals;

public class CardsCorrectOrderDef {
    Card mockCard1,mockCard2,mockCard3,mockCard4,mockCard5;
    Board board;

    //Refactor : agregar los años con regex

    @Given("^Five cards$")
    public void fiveCardsWithYears() throws Throwable {
        mockCard1 = new Card(null, 1,"mc1","h1",1543, null);
        mockCard2 = new Card(null, 2,"mc2","h2",1852, null);
        mockCard3 = new Card(null, 3,"mc3","h3",-460, null);
        mockCard4 = new Card(null, 4,"mc4","h4",289, null);
        mockCard5 = new Card(null, 5,"mc5","h5",1950, null);
    }

    @When("^I create a board with these cards$")
    public void iCreateBoardWithCards() throws Throwable {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(mockCard1);
        cards.add(mockCard2);
        cards.add(mockCard3);
        cards.add(mockCard4);
        cards.add(mockCard5);

        board = new Board(cards);
    }

    @Then("^I should get cards years in correct order$")
    public void iShouldGetCardsYearsInCorrectOrder() throws Throwable {
        Assert.assertEquals(mockCard3.getYear(), board.getCorrectOrder().get(0));
        Assert.assertEquals(mockCard4.getYear(), board.getCorrectOrder().get(1));
        Assert.assertEquals(mockCard1.getYear(), board.getCorrectOrder().get(2));
        Assert.assertEquals(mockCard2.getYear(), board.getCorrectOrder().get(3));
        Assert.assertEquals(mockCard5.getYear(), board.getCorrectOrder().get(4));

    }

}
