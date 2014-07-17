package org.leanpoker.player;

public class PlayerStrategy {
	
    static final String VERSION = "Default Java folding player with logging";

    public static int betRequest(GameState gameState) {
    	
    	System.out.println("Parsed Gamestate: " + gameState.toString());
    	
        return 0;
    }

    public static void showdown(GameState gameState) {

    	System.out.println("Parsed Gamestate: " + gameState.toString());

    }
}
