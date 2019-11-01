package com.cred.game.player;

import com.cred.game.utils.RandomIdGenerator;

public abstract class AbstractPlayer {
	private String id;
	private String name;

	public AbstractPlayer(String name) {
		this.id = RandomIdGenerator.getId();
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public abstract int rollInRange(int lowerBound, int upperBound);

}
