package com.cred.game;

import com.cred.game.utils.RandomIdGenerator;

public class Lane {
	private long id;

	public Lane() {
		this.id = RandomIdGenerator.getId();
	}
}
