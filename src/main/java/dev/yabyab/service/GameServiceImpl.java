package dev.yabyab.service;

import dev.yabyab.model.Game;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

    private SimpMessagingTemplate messagingTemplate;
    private Game game;

    public GameServiceImpl(SimpMessagingTemplate messagingTemplate, Game game) {
        this.messagingTemplate = messagingTemplate;
        this.game = game;
    }

    @Scheduled(fixedRate = 1000)
    @Override
    public void updateTimer() {
        if (game.getGameState() == 1 && game.getTimer() > 0) {
            game.setTimer(game.getTimer() - 1);

            messagingTemplate.convertAndSend("/topic/game", game);

            if (game.getTimer() == 0) {
                game.setGameState(2);

                messagingTemplate.convertAndSend("/topic/game", game);
            }

        }
    }

    @Override
    public void startGame() {
        if (game.getGameState() == 0) {
            game.setGameState(1);
            game.setTimer(Game.TIMER_START);
        }
    }

    @Override
    public void resetGame() {
        game.setGameState(1);
        game.setTimer(Game.TIMER_START);
        game.setScore(0);
    }


    @Override
    public Game getGame() {
        return this.game;
    }
}
