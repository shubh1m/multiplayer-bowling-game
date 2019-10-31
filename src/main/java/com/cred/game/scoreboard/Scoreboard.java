package com.cred.game.scoreboard;

import com.cred.game.BowlingGame;
import com.cred.game.Chance;
import com.cred.game.Set;

import java.util.HashMap;
import java.util.Map;

public class Scoreboard {
	private Map<Long, PlayerReport> standings;

	public Scoreboard() {
		standings = new HashMap<>();
	}

	public Map<Long, PlayerReport> getStandings() {
		return standings;
	}

	public void addChanceForPlayer(Long playerId, int currentSet, int score) {
		if (standings.get(playerId).getSets().size() < currentSet) {
			standings.get(playerId).getSets().add(new Set());
		}
		standings.get(playerId).getSets().get(currentSet-1).addChance(new Chance(score));
	}

	public void calculateScoreForSet(Long playerId, int currentSet) {
		int score = standings.get(playerId).getTotalScore();
		int numberOfPinsDown = getNumberOfPinsDownForSet(playerId, currentSet);
		if (numberOfPinsDown == BowlingGame.MAX_PINS) {
			if (standings.get(playerId).getSets().get(currentSet-1).getChances().size() == 1) {
				score += 20;
			} else {
				score += 15;
			}
		} else {
			score += numberOfPinsDown;
		}
		standings.get(playerId).setTotalScore(score);
	}

	public int getNumberOfPinsDownForSet(Long playerId, int currentSet) {
		return standings.get(playerId).getSets().get(currentSet-1).getChances().stream()
				.map(Chance::getScore).mapToInt(Integer::intValue).sum();
	}

	public int getAvailablePinsForPlayer(Long playerId, int currentSet) {
		if (standings.get(playerId).getSets().size() < currentSet) {
			return BowlingGame.MAX_PINS;
		}
		return BowlingGame.MAX_PINS - standings.get(playerId).getSets().get(currentSet-1).getChances().stream()
				.map(Chance::getScore).mapToInt(Integer::intValue).sum();
	}

	@Override
	public String toString() {
		return "Scoreboard{" +
				"standings=" + standings +
				'}';
	}
}