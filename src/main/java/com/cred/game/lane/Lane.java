package com.cred.game.lane;

import com.cred.game.utils.RandomIdGenerator;

public class Lane {
	private Long id;
	private LaneStatus status;

	public Lane() {
		this.id = RandomIdGenerator.getId();
		this.status = LaneStatus.AVAILABLE;
	}

	public Long getId() {
		return id;
	}

	public LaneStatus getStatus() {
		return status;
	}

	public void setStatus(LaneStatus status) {
		this.status = status;
	}
}
