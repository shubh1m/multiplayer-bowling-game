package com.cred.game.utils;

import java.util.UUID;

public class RandomIdGenerator {
	public static String getId() {
		return UUID.randomUUID().toString();
	}
}
