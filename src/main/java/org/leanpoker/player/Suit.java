package org.leanpoker.player;

import org.codehaus.jackson.annotate.JsonCreator;

public enum Suit {
	SPADES, HEARTS, CLUBS, DIAMONDS;
	
	@JsonCreator
	public static Suit forValue(String v) {
		switch (v) {
		case "spades":
			return SPADES;
		case "hearts":
			return HEARTS;
		case "clubs":
			return CLUBS;
		case "diamonds":
			return DIAMONDS;
		default:
			throw new RuntimeException("Could not parse value " + v);
		}
	}
}
