package dev.yabyab.model;

import org.springframework.stereotype.Component;

@Component
public class BoardOptions {
    private static final int BOARD_ROWS = 8;
    private static final int BOARD_COLUMNS = 8;

//    public BoardOptions() {
//    }

    public int getBoardRows() {
        return BOARD_ROWS;
    }

    public int getBoardColumns() {
        return BOARD_COLUMNS;
    }
}