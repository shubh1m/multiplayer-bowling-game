package com.cred.game.scoreboard;

import com.cred.game.Set;

import java.util.ArrayList;
import java.util.List;

public class PlayerReport {
	private String name;
	private Integer totalScore;
	private List<Set> sets;

	public PlayerReport(String name, int maxSets) {
		this.name = name;
		this.totalScore = 0;
		this.sets = new ArrayList<>(maxSets);
	}

	public String getName() {
		return name;
	}

	public Integer getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}

	public List<Set> getSets() {
		return sets;
	}

	@Override
	public String toString() {
		return "PlayerReport{" +
				"name='" + name + '\'' +
				", totalScore=" + totalScore +
				", sets=" + sets +
				'}';
	}
}
