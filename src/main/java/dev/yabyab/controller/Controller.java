package dev.yabyab.controller;

import dev.yabyab.model.Game;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;

@org.springframework.stereotype.Controller
@CrossOrigin
public class Controller {

    @MessageMapping("/hello") // client sends here
    @SendTo("/topic/game") // server sends here
    public Game game(Game game) throws Exception {
        return game;
    }
}
