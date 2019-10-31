package com.cred.game.player;

import com.cred.game.utils.RandomNumberGenerator;

public class Player extends AbstractPlayer implements IPlayer  {
	public Player(String name) {
		super(name);
	}
	// create PlayerId class

	@Override
	public int rollInRange(int lowerBound, int upperBound) {
		return RandomNumberGenerator.generateRandomNumberInRange(lowerBound, upperBound);
	}
}
