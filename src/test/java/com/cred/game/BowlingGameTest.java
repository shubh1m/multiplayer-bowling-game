package com.cred.game;

import com.cred.game.exception.LaneNotAvailableException;
import com.cred.game.player.AbstractPlayer;
import com.cred.game.player.Player;

import java.util.ArrayList;
import java.util.List;

public class BowlingGameTest {
	public static void main(String[] args) {
		try {
			List<AbstractPlayer> players = new ArrayList<>();
			players.add(new Player("Shubham"));
			Thread.sleep(1);
			players.add(new Player("Vikas"));
			Thread.sleep(1);
			players.add(new Player("Monga"));
			Thread.sleep(1);
			BowlingGame bowlingGame1 = BowlingGameFactory.createGame(players);
			BowlingGame bowlingGame2 = BowlingGameFactory.createGame(players);
			while (!bowlingGame1.isOver()) {
				bowlingGame1.play();
			}
			bowlingGame2.getScorecard();
			while (!bowlingGame2.isOver()) {
				bowlingGame2.play();
			}
			bowlingGame2.getScorecard();
		} catch (InterruptedException e) {
			System.out.println("Exception while sleep");
		} catch (LaneNotAvailableException e) {
			System.out.println("No vacant lanes present");
		}
	}

}
