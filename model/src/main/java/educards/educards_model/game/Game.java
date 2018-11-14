package educards.educards_model.game;

import java.util.ArrayList;

import educards.educards_model.card.Card;
import educards.educards_model.player.Player;

public class Game {

	private Player player;
	private Board board;
	private Integer finalScore;
	
	public Game(Player player, ArrayList<Card> playerCards) {
		this.player = player;
		this.board = new Board(playerCards);
	}
	
	public void finishGame() {
		finalScore = this.calculateScore(board.checkPlayedCards());
		player.saveHiScore(finalScore);
	}
	
	private int calculateScore(ArrayList<Boolean> result) {
		int score = 0;
		for(int i=0; i< result.size() ;i++) {
			if(result.get(i)) {
				score += 20;
			}
		}
		return score;
	}
	
	public Board getBoard() {
		return board;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public Integer getFinalScore() {
		return finalScore;
	}
}
