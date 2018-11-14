package educards.educards_model.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import educards.educards_model.card.Card;

public class Board {
	
	private ArrayList<Card> cardsToPlay;
	private HashMap<Integer,Card> playedCards = new HashMap<Integer,Card>();
	private ArrayList<Card> correctOrder;

	public Board(ArrayList<Card> cards) {
		cardsToPlay = cards;
		this.generateCorrectOrder();
	}
	
	public void playCard(Integer position, Card card) {
		if(playedCards.containsKey(position)) {
			cardsToPlay.add(playedCards.get(position));
		}
		playedCards.put(position, card);
		cardsToPlay.remove(card);
	}
	
	public ArrayList<Card> getCardsToPlay(){
		return cardsToPlay;
	}
	
	public HashMap<Integer,Card> getPlayedCards(){
		return playedCards;
	}
	
	public ArrayList<Card> getCorrectOrder(){
		return correctOrder;
	}
	
	public void generateCorrectOrder() {
		correctOrder = new ArrayList<Card>(cardsToPlay);
		Collections.sort(correctOrder, (c1,c2) -> c1.getYear().compareTo(c2.getYear()));
	}
	
	public ArrayList<Boolean> checkPlayedCards(){
		ArrayList<Boolean> results = new ArrayList<Boolean>();
		for(int i=1; i<6; i++) {
			results.add(correctOrder.get(i-1).equals(playedCards.get(i)));
		}
		return results;
	}
}