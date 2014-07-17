package org.leanpoker.player;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    @Test
    public void testBetRequest() throws Exception {

        String rest = "{\"small_blind\": 10,\"current_buy_in\": 320,\"pot\": 400,\"minimum_raise\": 240,\"dealer\": 1,\"orbits\": 7,\"in_action\": 1,\"players\": [{\"id\": 0,\"name\": \"Albert\",\"status\": \"active\",\"version\": \"Default random player\",\"stack\": 1010,\"bet\": 320},        {           \"id\": 1,            \"name\": \"Bob\",           \"status\": \"active\",           \"version\": \"Default random player\",           \"stack\": 1590,            \"bet\": 80,           \"hole_cards\": [                {                    \"rank\": \"6\",                   \"suit\": \"hearts\"              },              {                    \"rank\": \"K\",                    \"suit\": \"spades\"                }            ]        },        {            \"id\": 2,            \"name\": \"Chuck\",            \"status\": \"out\",            \"version\": \"Default random player\",            \"stack\": 0,            \"bet\": 0        }    ],    \"community_cards\": [        {            \"rank\": \"4\",            \"suit\": \"spades\"        },        {            \"rank\": \"A\",            \"suit\": \"hearts\"        },        {            \"rank\": \"6\",            \"suit\": \"clubs\"        }    ]}";
    	ObjectMapper mapper = new ObjectMapper();
    	GameState gameState = mapper.readValue(rest, GameState.class);

        assertEquals(0, PlayerStrategy.betRequest(gameState));

    }
}
