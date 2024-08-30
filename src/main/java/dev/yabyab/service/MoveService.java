package dev.yabyab.service;

import dev.yabyab.model.Board;
import dev.yabyab.model.MoveRequest;

public interface MoveService {

    void applyMove(MoveRequest moveRequest);
    void revertMove(MoveRequest moveRequest);
    void refillAfterMatch(MoveRequest moveRequest);

}
