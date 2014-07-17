package org.leanpoker.player;

public class GameState {
	private Player[] players;
	private int small_blind;
	private int orbits;
	private int dealer;
	private Card[] community_cards;
	private int current_buy_in;
	private int pot;
	private int in_action;
	private int minimum_raise;
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
	public int getIn_action() {
		return in_action;
	}
	public void setIn_action(int in_action) {
		this.in_action = in_action;
	}
	public int getMinimum_raise() {
		return minimum_raise;
	}
	public void setMinimum_raise(int minimum_raise) {
		this.minimum_raise = minimum_raise;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("PLAYERS:" + Constants.NEWLINE);
		for (Player player : players) {
			stringBuilder.append(player.toString(Constants.TAB) + Constants.NEWLINE);
		}
		stringBuilder.append("small_blind = " + small_blind + Constants.NEWLINE);
		stringBuilder.append("orbits = " + orbits + Constants.NEWLINE);
		stringBuilder.append("dealer = " + dealer + Constants.NEWLINE);
		stringBuilder.append("current_buy_in = " + current_buy_in + Constants.NEWLINE);
		stringBuilder.append("pot = " + pot + Constants.NEWLINE);
		stringBuilder.append("COMMUNITY_CARDS:" + Constants.NEWLINE);
		for (Card card : community_cards) {
			stringBuilder.append(card.toString(Constants.TAB) + Constants.NEWLINE);
		}
		return stringBuilder.toString();
	}

}
