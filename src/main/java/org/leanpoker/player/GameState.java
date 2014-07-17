package org.leanpoker.player;

public class GameState {
	private static final String NEWLINE = "<br>";
	private static final String TAB = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	private Player[] players;
	private int small_blind;
	private int orbits;
	private int dealer;
	private Card[] community_cards;
	private int current_buy_in;
	private int pot;
	public Player[] getPlayers() {
		return players;
	}
	public void setPlayers(Player[] players) {
		this.players = players;
	}
	public int getSmall_blind() {
		return small_blind;
	}
	public void setSmall_blind(int small_blind) {
		this.small_blind = small_blind;
	}
	public int getOrbits() {
		return orbits;
	}
	public void setOrbits(int orbits) {
		this.orbits = orbits;
	}
	public int getDealer() {
		return dealer;
	}
	public void setDealer(int dealer) {
		this.dealer = dealer;
	}
	public Card[] getCommunity_cards() {
		return community_cards;
	}
	public void setCommunity_cards(Card[] community_cards) {
		this.community_cards = community_cards;
	}
	public int getCurrent_buy_in() {
		return current_buy_in;
	}
	public void setCurrent_buy_in(int current_buy_in) {
		this.current_buy_in = current_buy_in;
	}
	public int getPot() {
		return pot;
	}
	public void setPot(int pot) {
		this.pot = pot;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("PLAYERS:" + NEWLINE);
		for (Player player : players) {
			stringBuilder.append(TAB + player.toString() + NEWLINE);
		}
		stringBuilder.append("small_blind = " + small_blind + NEWLINE);
		stringBuilder.append("orbits = " + orbits + NEWLINE);
		stringBuilder.append("dealer = " + dealer + NEWLINE);
		stringBuilder.append("current_buy_in = " + current_buy_in + NEWLINE);
		stringBuilder.append("pot = " + pot + NEWLINE);
		stringBuilder.append("COMMUNITY_CARDS:" + NEWLINE);
		for (Card card : community_cards) {
			stringBuilder.append(TAB + card.toString() + NEWLINE);
		}
		return null;
	}
}
