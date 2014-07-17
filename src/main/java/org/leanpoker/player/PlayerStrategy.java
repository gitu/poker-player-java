package org.leanpoker.player;

public class PlayerStrategy {
	
    static final String VERSION = "Always calling player";

    public static int betRequest(GameState gameState) {
    	System.out.println("betRequest");
    	//System.out.println("Parsed Gamestate: " + gameState.toString());
    	
        int bet = gameState.getCurrent_buy_in() - gameState.getPlayers()[gameState.getIn_action()].getBet();
    	
        if (gameState.getCommunity_cards().length == 0) {
    		bet = preFlopStrategy(gameState);
    	} else {
    		
    	}

        System.out.println("Betting: " + bet);
        
		return bet;
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
    	
    	if (strength <= 25) {
    		return 0;
    	} else {
			int call = gameState.getCurrent_buy_in() - player.getBet();
			if (strength <= 29) {
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
