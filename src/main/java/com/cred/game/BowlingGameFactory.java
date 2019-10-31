package com.cred.game;

import com.cred.game.exception.LaneNotAvailableException;
import com.cred.game.lane.Lane;
import com.cred.game.lane.LaneStatus;
import com.cred.game.player.AbstractPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BowlingGameFactory {

	private static BowlingArena bowlingArena;
	private static List<BowlingGame> bowlingGames;
	private static final int MAX_LANES = 1;

	static {
		if (Objects.isNull(bowlingArena)) {
			bowlingArena = new BowlingArena(MAX_LANES);
		}
		if (Objects.isNull(bowlingGames)) {
			bowlingGames = new ArrayList<>();
		}
	}

	public static BowlingGame createGame(List<AbstractPlayer> players) throws LaneNotAvailableException {
		BowlingGame bowlingGame = new BowlingGame(getValidLaneId(), players);
		bowlingGames.add(bowlingGame);
		return bowlingGame;
	}

	public static void removeGame(long bowlingGameId) {
		for (int i=0; i<bowlingGames.size(); i++) {
			if (bowlingGames.get(i).getId() == bowlingGameId) {
				synchronized (bowlingGames) {
					Long laneId = bowlingGames.get(i).getLaneId();
					for (Lane lane : bowlingArena.getLanes()) {
						if (lane.getId() == laneId) {
							lane.setStatus(LaneStatus.AVAILABLE);
						}
					}
					bowlingGames.remove(i);
				}
			}
		}
	}

	private static Long getValidLaneId() {
		for (Lane lane : bowlingArena.getLanes()) {
			if (lane.getStatus().equals(LaneStatus.AVAILABLE)) {
				lane.setStatus(LaneStatus.IN_USE);
				return lane.getId();
			}
		}
		throw new LaneNotAvailableException();
	}
}
