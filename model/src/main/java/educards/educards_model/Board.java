package educards.educards_model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Board {
	
	private ArrayList<Card> cardsToPlay;
	private HashMap<Integer,Card> playedCards = new HashMap<Integer,Card>();
	private ArrayList<Integer> correctOrder;

	public Board(ArrayList<Card> cardsToPlay) {
		this.cardsToPlay = cardsToPlay;
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
	
	public ArrayList<Integer> getCorrectOrder(){
		return correctOrder;
	}
	
	public void generateCorrectOrder() {
		correctOrder = new ArrayList<Integer>();
		for(int i=0; i<5; i++) {
			correctOrder.add(cardsToPlay.get(i).getYear());
		}
		Collections.sort(correctOrder, (y1,y2) -> y1.compareTo(y2));
	}
	
	public ArrayList<Boolean> checkPlayedCards(){
		ArrayList<Boolean> results = new ArrayList<Boolean>();
		for(int i=1; i<6; i++) {
			results.add(correctOrder.get(i-1).equals(playedCards.get(i).getYear()));
		}
		return results;
	}
}