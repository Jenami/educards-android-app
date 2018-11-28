package educards.educards_model;

import java.util.ArrayList;
import java.util.List;


public class Educards {

	public Player player;
	public Board board;
	public PointsPlayer pointsPlayer;
	
	public Educards() {
		pointsPlayer = new PointsPlayer(new ArrayList<Integer>());
	}
	
	public void registerPlayer(Player player) {
		this.player = player;
	}
	
	public void setBoard(Board board) {
		this.board = board;
	}

	public Board getBoard(){return this.board;}
	
	public void setPointsPlayer(PointsPlayer pointsPlayer) {
		this.pointsPlayer = pointsPlayer;
	}

	public Integer finishGame(){
		Integer finalScore = this.calculateScore(board.checkPlayedCards());
		//pointsPlayer.getPoints().add(finalScore);
        //this.applyScore(id, finalScore);
        return finalScore;
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