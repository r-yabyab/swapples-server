package dev.yabyab.model;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class Game {
    // 0 = not started, 1 = started, 2 = ended
    private int gameState;
    private int score;
    private static final int TIMER = 30;

    public Game() {
        this.gameState = 0;
        this.score = 0;
    }

    public int getGameState() {
        return this.gameState;
    }

    public void setGameState(int gameState) {
        this.gameState = gameState;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTimer() {
        return TIMER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return gameState == game.gameState && score == game.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameState, score);
    }
}
