package dev.yabyab.service;

import dev.yabyab.model.Game;

public interface GameService {
    void updateTimer();
    void startGame();
    Game getGame();
    void resetGame();
}
