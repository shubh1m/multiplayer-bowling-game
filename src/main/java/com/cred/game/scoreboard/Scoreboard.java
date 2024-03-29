package com.cred.game.scoreboard;

import com.cred.game.Chance;
import com.cred.game.Set;

import java.util.HashMap;
import java.util.Map;

public class Scoreboard {
	private Map<String, PlayerReport> standings;
	private static final int MAX_PINS = 10;

	public Scoreboard() {
		standings = new HashMap<String, PlayerReport>();
	}

	public Map<String, PlayerReport> getStandings() {
		return standings;
	}

	public void addChanceForPlayer(String playerId, int currentSet, int score) {
		if (standings.get(playerId).getSets().size() < currentSet) {
			standings.get(playerId).getSets().add(new Set());
		}
		standings.get(playerId).getSets().get(currentSet-1).addChance(new Chance(score));
	}

	public void calculateScoreForSet(String playerId, int currentSet) {
		int score = standings.get(playerId).getTotalScore();
		int numberOfPinsDown = getNumberOfPinsDownForSet(playerId, currentSet);
		if (numberOfPinsDown == MAX_PINS) {
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

	public int getNumberOfPinsDownForSet(String playerId, int currentSet) {
		return standings.get(playerId).getSets().get(currentSet-1).getChances().stream()
				.map(Chance::getScore).mapToInt(Integer::intValue).sum();
	}

	public int getAvailablePinsForPlayer(String playerId, int currentSet) {
		if (standings.get(playerId).getSets().size() < currentSet) {
			return MAX_PINS;
		}
		return MAX_PINS - standings.get(playerId).getSets().get(currentSet-1).getChances().stream()
				.map(Chance::getScore).mapToInt(Integer::intValue).sum();
	}

	public int getChancesForPlayerAndSet(String playerId, int setNo) {
		return standings.get(playerId).getSets().get(setNo-1).getChances().size();
	}

	@Override
	public String toString() {
		return "Scoreboard{" +
				"standings=" + standings +
				'}';
	}
}
