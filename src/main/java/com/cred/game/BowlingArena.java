package com.cred.game;

import com.cred.game.lane.Lane;
import com.cred.game.utils.RandomIdGenerator;

import java.util.ArrayList;
import java.util.List;

public class BowlingArena {
	private String id;
	private List<Lane> lanes;

	public BowlingArena(int numberOfLanes) {
		this.id = RandomIdGenerator.getId();
		this.lanes = new ArrayList<>();
		for (int i = 0; i < numberOfLanes; i++) {
			this.lanes.add(new Lane());
		}
	}

	public List<Lane> getLanes() {
		return lanes;
	}
}
