package com.cred.game.utils;

import java.util.Date;

public class RandomIdGenerator {
	// Implementation of randomId generator without using any external library
	public static long getId() {
		return new Date().getTime();
	}
}
