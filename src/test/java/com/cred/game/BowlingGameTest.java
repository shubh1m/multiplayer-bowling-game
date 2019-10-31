package com.cred.game;

import com.cred.game.player.AbstractPlayer;
import com.cred.game.player.Player;

import java.util.ArrayList;
import java.util.List;

public class BowlingGameTest {
	public static void main(String[] args) {
		try {
			BowlingArena bowlingArena = new BowlingArena(10);
			List<AbstractPlayer> players = new ArrayList<>();
			players.add(new Player("Shubham"));
			Thread.sleep(1);
			players.add(new Player("Vikas"));
			Thread.sleep(1);
			players.add(new Player("Monga"));
			Thread.sleep(1);
			BowlingGame bowlingGame = BowlingGameFactory.createGame(players);
			while (!bowlingGame.isOver()) {
				bowlingGame.play();
			}
			bowlingGame.getScorecard();
		} catch (InterruptedException e) {
			System.out.println("Exception while sleep");
		}
	}

}
