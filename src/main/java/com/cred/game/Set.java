package com.cred.game;

import java.util.ArrayList;
import java.util.List;

public class Set {
	private List<Chance> chances;

	public Set() {
		this.chances = new ArrayList<>();
	}

	public List<Chance> getChances() {
		return chances;
	}

	public void addChance(Chance chance) {
		// calculate score
		this.chances.add(chance);
	}

	@Override
	public String toString() {
		return "Set{" +
				"chances=" + chances +
				'}';
	}
}
