package com.cred.game;

import java.util.ArrayList;
import java.util.List;

public class BowlingArena {
	private List<Lane> lanes;

	public BowlingArena(int numberOfLanes) {
		lanes = new ArrayList<>();
		try {
			for (int i = 0; i < numberOfLanes; i++) {
				lanes.add(new Lane());
				Thread.sleep(1);
			}
		} catch (InterruptedException e) {
			// Handle
		}
	}
}