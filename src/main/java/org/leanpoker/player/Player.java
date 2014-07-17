package org.leanpoker.player;

public class Player {
	private String name;
	private int stack;
	private String status;
	private int bet;
	private Card[] hole_cards = new Card[0];
	private String version;
	private int id;
	private int amount_won;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStack() {
		return stack;
	}
	public void setStack(int stack) {
		this.stack = stack;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getBet() {
		return bet;
	}
	public void setBet(int bet) {
		this.bet = bet;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Card[] getHole_cards() {
		return hole_cards;
	}
	public void setHole_cards(Card[] hole_cards) {
		this.hole_cards = hole_cards;
	}
	public String toString(String prefix) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(prefix + "name = " + name + Constants.NEWLINE);
		stringBuilder.append(prefix + "stack = " + stack + Constants.NEWLINE);
		stringBuilder.append(prefix + "status = " + status + Constants.NEWLINE);
		stringBuilder.append(prefix + "bet = " + bet + Constants.NEWLINE);
		stringBuilder.append(prefix + "version = " + version + Constants.NEWLINE);
		stringBuilder.append(prefix + "id = " + id + Constants.NEWLINE);
		stringBuilder.append(prefix + "HOLE_CARDS:" + hole_cards.length + Constants.NEWLINE);
		for (Card card : hole_cards) {
			stringBuilder.append(card.toString(prefix + Constants.TAB) + Constants.NEWLINE);
		}
		
		return stringBuilder.toString();
	}
	public int getAmount_won() {
		return amount_won;
	}
	public void setAmount_won(int amount_won) {
		this.amount_won = amount_won;
	}
}
