package com.cred.game;

import com.cred.game.player.AbstractPlayer;
import com.cred.game.scoreboard.PlayerReport;
import com.cred.game.scoreboard.Scoreboard;
import com.cred.game.utils.RandomIdGenerator;

import java.util.List;

public class BowlingGame {
	private Long id;
	private Long laneId;
	private int currentSet;
	private int currentPlayerIndex;
	private List<AbstractPlayer> players;
	private Scoreboard scoreboard;
	public static final int MAX_SETS = 10;

	private BowlingGame() {
		this.id = RandomIdGenerator.getId();
		this.currentSet = 1;
		this.currentPlayerIndex = 0;
		this.scoreboard = new Scoreboard();
	}

	public BowlingGame(Long laneId, List<AbstractPlayer> players) {
		this();
		this.laneId = laneId;
		this.players = players;
		for (AbstractPlayer player : players) {
			this.scoreboard.getStandings().putIfAbsent(player.getId(), new PlayerReport(player.getName(), MAX_SETS));
		}
	}

	public Long getId() {
		return id;
	}

	public Long getLaneId() {
		return laneId;
	}

	public void play() {
		if (currentSet > MAX_SETS) {
			// end game
			return;
		}
		AbstractPlayer currentPlayer = players.get(currentPlayerIndex);
		int availablePins = scoreboard.getAvailablePinsForPlayer(currentPlayer.getId(), currentSet);
		int noOfPins = currentPlayer.rollInRange(0, availablePins);
		scoreboard.addChanceForPlayer(currentPlayer.getId(), currentSet, noOfPins);
		int nextPlayerIndex = getNextPlayerIndex(currentPlayer, currentPlayerIndex, currentSet, players.size());
		if (nextPlayerIndex != currentPlayerIndex) {
			scoreboard.calculateScoreForSet(currentPlayer.getId(), currentSet);
		}
		System.out.println("currentPlayer: " + currentPlayer.getName() + ", currentSet: " + currentSet + ", score: " + noOfPins);
		currentPlayerIndex = nextPlayerIndex;
		currentSet = getNextSet(players.get(currentPlayerIndex).getId(), players.get(players.size()-1).getId(), currentSet);
	}

	public boolean isOver() {
		if (currentSet <= MAX_SETS) return Boolean.FALSE;
		BowlingGameFactory.removeGame(id);
		return Boolean.TRUE;
	}

	public void getScorecard() {
		System.out.println(scoreboard.getStandings().toString());
	}

	private int getNextPlayerIndex(AbstractPlayer currentPlayer, int currentPlayerIndex, int currentSet, int totalPlayers) {
		int nextPlayerIndex = currentPlayerIndex;
		if (currentSet < MAX_SETS) {
			if (scoreboard.getNumberOfPinsDownForSet(currentPlayer.getId(), currentSet) == 10
					|| scoreboard.getChancesForPlayerAndSet(currentPlayer.getId(), currentSet) >= 2) {
				nextPlayerIndex = (currentPlayerIndex + 1)%totalPlayers;
			}
		} else if (currentSet == MAX_SETS) {
			if (scoreboard.getNumberOfPinsDownForSet(currentPlayer.getId(), currentSet) == 20
					|| scoreboard.getChancesForPlayerAndSet(currentPlayer.getId(), currentSet) >= 3) {
				nextPlayerIndex = (currentPlayerIndex + 1)%totalPlayers;
			}
		}
		return nextPlayerIndex;
	}

	private int getNextSet(Long playerId, Long lastPlayerId, int currentSet) {
		int nextSet = currentSet;
		if (playerId == players.get(0).getId() && scoreboard.getStandings().get(lastPlayerId).getSets().size() == currentSet) {
			nextSet = currentSet + 1;
		}
		return nextSet;
	}

}
