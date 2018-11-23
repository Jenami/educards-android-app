package educards.educards_model;

public class Educards {

	public Player player;
	public Board board;
	public Ranking ranking;
	
	public Educards() {}
	
	public void registerPlayer(Player player) {
		this.player = player;
	}
	
	public void setBoard(Board board) {
		this.board = board;
	}
	
	public void setRanking(Ranking ranking) {
		this.ranking = ranking;
	}
	
	public Player getPlayer() {
		return player;
	}
}