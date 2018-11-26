Feature: Card correct order feature

  Scenario: Create a new board with 5 cards
    Given Five cards
    When I create a board with these cards
	Then I should get cards years in correct order

