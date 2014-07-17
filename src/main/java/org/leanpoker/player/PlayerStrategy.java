package org.leanpoker.player;

public class PlayerStrategy {
	
    static final String VERSION = "Always calling player";

    public static int betRequest(GameState gameState) {
    	
    	System.out.println("Parsed Gamestate: " + gameState.toString());
    	
        int bet = gameState.getCurrent_buy_in() - gameState.getPlayers()[gameState.getIn_action()].getBet();
        
        System.out.println("Betting: " + bet);
        
		return bet;
    }

    public static void showdown(GameState gameState) {

    	System.out.println("Parsed Gamestate: " + gameState.toString());

    }
}
