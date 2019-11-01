package com.cred.game.player;

import com.cred.game.utils.RandomIdGenerator;

public abstract class AbstractPlayer {
	private long id;
	private String name;

	public AbstractPlayer(String name) {
		this.id = RandomIdGenerator.getId();
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public abstract int rollInRange(int lowerBound, int upperBound);

}
