package org.leanpoker.player;

import java.util.ArrayList;
import java.util.Collection;

public class PlayerStrategy {
	
    static final String VERSION = "Always calling player";

    public static int betRequest(GameState gameState) {
    	System.out.println("betRequest");
    	//System.out.println("Parsed Gamestate: " + gameState.toString());
    	
        int bet = gameState.getCurrent_buy_in() - gameState.getPlayers()[gameState.getIn_action()].getBet();
    	
        if (gameState.getCommunity_cards().length == 0) {
    		bet = preFlopStrategy(gameState);
    	} else {
    		bet = postFlopStrategy(gameState);
    	}

        System.out.println("Betting: " + bet);
        
		return bet;
    }

    private static int postFlopStrategy(GameState gameState) {
    	System.out.println("Determined we are currently in the postFlop. Cards: ");
    	Player player = gameState.getPlayers()[gameState.getIn_action()];
    	Card[] hole_cards = player.getHole_cards();
		
    	Card[] community_cards = gameState.getCommunity_cards();
    	
    	Collection<Card> allCards = new ArrayList<Card>();
    	for (Card card: hole_cards) {
        	allCards.add(card);
        	System.out.println(card);
    	}
    	for (Card card: community_cards) {
        	allCards.add(card);
        	System.out.println(card);
    	}
    	    	
		int strength = computeTotalCardStrength(allCards, gameState.getSmall_blind());
		int call = gameState.getCurrent_buy_in() - player.getBet();
		int raise = strength;
		
    	System.out.println("Card Strength is: " + strength);

    	if (call <= strength * 2) {
	    	return Math.max(raise, call);
		} else {
			return 0;
		}
		
	}

	private static int computeTotalCardStrength(Collection<Card> allCards, int smallBlind) {
		if (isStraightFlush(allCards)) {
			return smallBlind*1000;
		} else if (isFourOfAKind(allCards)) {
			return smallBlind*100;
		} else if (isFullHouse(allCards)) {
			return smallBlind*50;
		} else if (isFlush(allCards)) {
			return smallBlind*35;
		} else if (isStraight(allCards)) {
			return smallBlind*25;
		} else if (isThreeOfAKind(allCards)) {
			return smallBlind*15;
		} else if (isTwoPair(allCards)) {
			return smallBlind*8;
		} else if (isPair(allCards)) {
			return smallBlind*4;
		} else {
			return smallBlind*2;
		}
	}

	private static boolean isPair(Collection<Card> allCards) {
		for (Card first : allCards) {
			for (Card second : allCards) {
				if (first != second && first.getRank() == second.getRank()) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean isTwoPair(Collection<Card> allCards) {
		int pairs = 0;
		for (Card first : allCards) {
			for (Card second : allCards) {
				if (first != second && first.getRank() == second.getRank()) {
					pairs++;
				}
			}
		}
		return pairs >= 4;
	}

	private static boolean isThreeOfAKind(Collection<Card> allCards) {
		for (Card first : allCards) {
			for (Card second : allCards) {
				for (Card third : allCards) {
					if (first != second && second != third && first != third && first.getRank() == second.getRank() && second.getRank() == third.getRank()) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private static boolean isStraight(Collection<Card> allCards) {
		if (allCards.size() < 5) {
			return false;
		}
		
		
		return false;
	}

	private static boolean isFlush(Collection<Card> allCards) {
		if (allCards.size() < 5) {
			return false;
		}
		for (Suit suit : Suit.values()) {
			int count = 0;
			for (Card card : allCards) {
				if (card.getSuit().equals(suit)) {
					count++;
				}
			}
			if (count >= 5) {
				return true;
			}
		}
		
		return false;
	}

	private static boolean isFullHouse(Collection<Card> allCards) {
		if (allCards.size() < 5) {
			return false;
		}
		return isThreeOfAKind(allCards) && isPair(allCards);
	}

	private static boolean isFourOfAKind(Collection<Card> allCards) {
		for (Card first : allCards) {
			for (Card second : allCards) {
				for (Card third : allCards) {
					for (Card fourth : allCards) {
						if (first != second && second != third && third != fourth && second != third && third != fourth && second != fourth && first.getRank() == second.getRank() && second.getRank() == third.getRank() && third.getRank() == fourth.getRank()) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	private static boolean isStraightFlush(Collection<Card> allCards) {
		return isFlush(allCards) && isStraight(allCards);
	}

	private static int preFlopStrategy(GameState gameState) {
    	System.out.println("Determined we are currently in the preFlop. Cards: ");
    	
    	Player player = gameState.getPlayers()[gameState.getIn_action()];
    	Card[] hole_cards = player.getHole_cards();
		Card first = hole_cards[0];
		Card second = hole_cards[1];
		
		System.out.println(first.toString(""));
		System.out.println(second.toString(""));
		
		int strength = computeHoleCardStrength(first, second);
    	System.out.println("Card Strength is: " + strength);
    	
    	if (strength <= 27) {
    		return 0;
    	} else {
			int call = gameState.getCurrent_buy_in() - player.getBet();
			if (strength <= 31) {
				//Call
				return call;
			} else {
				//Max of (Call, Raise)
				return Math.max(call, gameState.getSmall_blind() * 10);
			}
		}
	}

	public static void showdown(GameState gameState) {
    	System.out.println("showdown");
    	
    	for (Player player : gameState.getPlayers()) {
    		System.out.println("Player " + player.getName() + " has " + player.getStack() + " coins.");
    	}

    	//System.out.println("Parsed Gamestate: " + gameState.toString());
    }
    
	private static int computeHoleCardStrength(Card first, Card second) {
		int result = 0;
		
		result += getSingleCardStrength(first);
		result += getSingleCardStrength(second);
		
		if (first.getRank() == second.getRank()) {
			result += 10;
		}
		if (first.getSuit() == second.getSuit()) {
			result += 4;
		}
		if (Math.abs(first.getRank().getValue() - second.getRank().getValue()) == 1) {
			result += 3;
		}
		if (Math.abs(first.getRank().getValue() - second.getRank().getValue()) == 2) {
			result += 2;
		}
		if (Math.abs(first.getRank().getValue() - second.getRank().getValue()) == 3) {
			result += 1;
		}
		
		//TODO: Also include position at table into this: http://www.poker1x1.de/poker1x1/starthands_poker.php
		
		return result;
	}

	private static int getSingleCardStrength(Card card) {
		switch(card.getRank()) {
		case ACE:
			return 16;
		case KING:
			return 14;
		case QUEEN:
			return 13;
		case JACK:
			return 12;
		case TEN:
			return 11;
		default:
			return card.getRank().getValue();
		}
	}
}
