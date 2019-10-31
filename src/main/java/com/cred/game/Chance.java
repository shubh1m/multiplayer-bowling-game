package com.cred.game;

public class Chance {
	private int score;

	public Chance(int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}

	@Override
	public String toString() {
		return "Chance{" +
				"score=" + score +
				'}';
	}
}
