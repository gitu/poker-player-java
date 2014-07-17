package org.leanpoker.player;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import java.io.IOException;

@WebServlet("/")
public class PlayerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print("Java player is running");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	if (req.getParameter("action").equals("check")) {
            resp.getWriter().print("Java player is running");
        }
    	if (req.getParameter("action").equals("version")) {
            resp.getWriter().print(PlayerStrategy.VERSION);
        }
    	
        if (req.getParameter("action").equals("bet_request")) {
            String gameStateStr = req.getParameter("game_state");
        	ObjectMapper mapper = new ObjectMapper();
        	GameState gameState = mapper.readValue(gameStateStr, GameState.class);

            resp.getWriter().print(PlayerStrategy.betRequest(gameState));
        }
        if (req.getParameter("action").equals("showdown")) {
        	String gameStateStr = req.getParameter("game_state");
        	ObjectMapper mapper = new ObjectMapper();
        	GameState gameState = mapper.readValue(gameStateStr, GameState.class);

            PlayerStrategy.showdown(gameState);
        }
        
    }
}
