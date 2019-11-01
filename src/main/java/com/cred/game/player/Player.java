package com.cred.game.player;

import com.cred.game.utils.RandomNumberGenerator;

public class Player extends AbstractPlayer {
	public Player(String name) {
		super(name);
	}

	@Override
	public int rollInRange(int lowerBound, int upperBound) {
		return RandomNumberGenerator.generateRandomNumberInRange(lowerBound, upperBound);
	}
}
