package org.leanpoker.player;

public class Card {
	private String rank;
	private String suit;
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	
	public String toString(String prefix) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(prefix + "rank = " + rank + Constants.NEWLINE);
		stringBuilder.append(prefix + "suit = " + suit + Constants.NEWLINE);
		return stringBuilder.toString();
	}
}
