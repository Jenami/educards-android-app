package educards.educards_model.game;

import educards.educards_model.card.CardAdministrator;
import educards.educards_model.player.Player;
import educards.educards_model.player.PlayerAdministrator;

public class Educards {

	PlayerAdministrator playerAdministrator = new PlayerAdministrator();
	CardAdministrator cardAdministrator = new CardAdministrator();
	Game currentGame;
	Integer nextID = 1;
	
	public Educards() {}
	
	public void registerPlayer(String username) {
		Player player = new Player(nextID,username);
		playerAdministrator.addPlayer(player);
		nextID ++;	
	}
	
	public void startGame(String username) {
		Player player = playerAdministrator.getPlayer(username);
		currentGame = new Game(player, cardAdministrator.getCards());
	}

	public PlayerAdministrator getPlayerAdministrator() {
		return playerAdministrator;
	}
	
	public Game getCurrentGame() {
		return currentGame;
	}
}
