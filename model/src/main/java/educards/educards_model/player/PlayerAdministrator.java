package educards.educards_model.player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PlayerAdministrator {

	private ArrayList<Player> players = new ArrayList<Player>();
	
	public void addPlayer(Player player) {
		players.add(player);
	}
	
	public int getNumberOfPlayers(){
		return players.size();
	}

	public ArrayList<Player> getRanking() {
		ArrayList<Player> ranking = new ArrayList<Player>(players);
		Collections.sort(ranking, Comparator.comparing(Player::getHiScore));
		Collections.reverse(ranking);
		return ranking;
	}
	
}
