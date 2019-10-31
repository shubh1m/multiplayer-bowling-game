package com.cred.game;

import com.cred.game.player.AbstractPlayer;

import java.util.ArrayList;
import java.util.List;

public class BowlingGameFactory {
	private static List<BowlingGame> bowlingGames = new ArrayList<>();

	public static BowlingGame createGame(List<AbstractPlayer> players) {
		BowlingGame bowlingGame = new BowlingGame(getValidLaneId(), players);
		bowlingGames.add(bowlingGame);
		return bowlingGame;
	}

	public static void removeGame(long bowlingGameId) {
		for (int i=0; i<bowlingGames.size(); i++) {
			if (bowlingGames.get(i).getId() == bowlingGameId) {
				bowlingGames.remove(i);
			}
		}
	}

	private static int getValidLaneId() {
		return 1;
	}
}
