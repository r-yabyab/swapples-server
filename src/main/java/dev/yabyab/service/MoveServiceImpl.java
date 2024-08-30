package dev.yabyab.service;

import dev.yabyab.model.Board;
import dev.yabyab.model.MoveRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoveServiceImpl implements MoveService{

    private final Board board;

    @Autowired
    public MoveServiceImpl(Board board) {
        this.board = board;
    }

    public void applyMove(MoveRequest moveRequest) {
        int srcRow = moveRequest.getSourceRow();
        int srcCol = moveRequest.getSourceCol();
        int tgtRow = moveRequest.getTargetRow();
        int tgtCol = moveRequest.getTargetCol();

        System.out.println(moveRequest.getSourceRow());
        System.out.println(moveRequest.getTargetRow());
        System.out.println("board rows" + board.getBoard());




        // Check for matches and update board
        if (board.isMatch(tgtRow, tgtCol)) {

            // Swap items
            String temp = board.getBoard()[srcRow][srcCol];
            board.getBoard()[srcRow][srcCol] = board.getBoard()[tgtRow][tgtCol];
            board.getBoard()[tgtRow][tgtCol] = temp;

            System.out.println("Match found");
            board.generateBoard();
        } else {
            System.out.println("No match");
        }
//        board.generateBoard(); // Call generateBoard or update logic after applying move
    }

    public void revertMove(MoveRequest moveRequest) {
//        return board.getBoard();
    }

    public void refillAfterMatch(MoveRequest moveRequest) {

    }

}