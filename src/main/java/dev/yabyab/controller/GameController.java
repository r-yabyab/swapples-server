package dev.yabyab.controller;

import dev.yabyab.model.Board;
import dev.yabyab.model.Game;
import dev.yabyab.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;

@org.springframework.stereotype.Controller
@CrossOrigin
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @MessageMapping("/hello") // client sends here
    @SendTo("/topic/game") // server sends here
    public Game game(String message) throws Exception {
        if ("begin".equalsIgnoreCase(message.trim())) {
            if (gameService.getGame().getGameState() == 0 || gameService.getGame().getGameState() == 2) {
                gameService.resetGame();
            }
            return gameService.getGame();
        } else if ("rejoin".equalsIgnoreCase(message.trim())) {
            if (gameService.getGame().getGameState() == 1) {
                gameService.getGame();
            }
        }
        return null; // Or handle other cases
    }

    @MessageMapping("/generateBoard")
    @SendTo("/topic/board")
    public Board generateBoard(String message) throws Exception {
//        Board board = new Board(8,8);
        if ("generate".equalsIgnoreCase(message.trim())) {
            return new Board();
        }
        return null;
    }
}
