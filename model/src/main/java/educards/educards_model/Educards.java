package educards.educards_model;

import java.util.ArrayList;

public class Educards {

	public Player player;
	public Board board;
	public RankingPlayer ranking;
	
	public Educards() {
		ranking = new RankingPlayer();
	}
	
	public void registerPlayer(Player player) {
		this.player = player;
	}
	
	public void setBoard(Board board) {
		this.board = board;
	}

	public Board getBoard(){return this.board;}
	
	public void setRanking(RankingPlayer ranking) {
		this.ranking = ranking;
	}

	public void finishGame(Player p){
		Integer finalScore = this.calculateScore(board.checkPlayedCards());
		ranking.getRanking().add(finalScore);
	}

	public int calculateScore(ArrayList<Boolean> result){
		int score = 0;
		for (int i = 0; i<result.size(); i++){
			if (result.get(i)){
				score += 20;
			}
		}
		return score;
	}
	public Player getPlayer() {
		return player;
	}
}