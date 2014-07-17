package org.leanpoker.player;

public class Card {
	private Rank rank;
	private Suit suit;
	public Rank getRank() {
		return rank;
	}
	public void setRank(Rank rank) {
		this.rank = rank;
	}
	public Suit getSuit() {
		return suit;
	}
	public void setSuit(Suit suit) {
		this.suit = suit;
	}
	
	public String toString(String prefix) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(prefix + "rank = " + rank + Constants.NEWLINE);
		stringBuilder.append(prefix + "suit = " + suit + Constants.NEWLINE);
		return stringBuilder.toString();
	}
}
