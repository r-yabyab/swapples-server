package dev.yabyab.controller;

import dev.yabyab.model.Board;
import dev.yabyab.model.Game;
import dev.yabyab.model.MoveRequest;
import dev.yabyab.service.GameService;
import dev.yabyab.service.MoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@org.springframework.stereotype.Controller
@CrossOrigin
public class GameController {

    private final GameService gameService;
    private final Board board;
    private final MoveService moveService;

    @Autowired
    public GameController(GameService gameService, Board board, MoveService moveService) {
        this.gameService = gameService;
        this.board = board;
        this.moveService = moveService;
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
//            return new Board();
            return new Board();
        }
        return null;
    }

    @MessageMapping("/makeMove")
    @SendTo("/topic/board")
    public Board makeMove(MoveRequest moveRequest) throws Exception {
        moveService.applyMove(moveRequest);

////        if (board.isMatch(moveRequest.getTargetRow(), moveRequest.getTargetCol())) {
////            board.applyMove(moveRequest);
////            return board;
//        }
        return board;
    }
}
