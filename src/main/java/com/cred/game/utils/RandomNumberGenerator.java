package com.cred.game.utils;

import java.util.Random;

public class RandomNumberGenerator {
	// TODO -> verify this
	public static int generateRandomNumberInRange(int lowerBound, int upperBound) {
		return new Random().nextInt((upperBound - lowerBound) + 1) + lowerBound;
	}
}
