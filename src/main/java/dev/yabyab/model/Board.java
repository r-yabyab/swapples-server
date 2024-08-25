package dev.yabyab.model;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class Board {

    private int rows;
    private int cols;
    private String[][] board;
    private List<String> items = List.of("🍒", "🍇", "🍉", "🍋", "🍌", "🍊", "🍍");

    public Board() {
        this.rows = 8;
        this.cols = 8;
        this.board = new String[rows][cols];
        generateBoard();
    }

    private void generateBoard() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                String item;
                do {
                    item = getRandomItem();
                    board[row][col] = item;
                } while (isMatch(row, col));
            }
        }
    }

    private String getRandomItem() {
        int index = (int) (Math.random() * items.size());
        return items.get(index);
    }

    private boolean isMatch(int row, int col) {
        String item = board[row][col];

        // Check horizontal match
        if (col >= 2 && board[row][col - 1].equals(item) && board[row][col - 2].equals(item)) {
            return true;
        }

        // Check vertical match
        if (row >= 2 && board[row - 1][col].equals(item) && board[row - 2][col].equals(item)) {
            return true;
        }

        return false;
    }

    public String[][] getBoard() {
        return board;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board1 = (Board) o;
        return rows == board1.rows && cols == board1.cols && Objects.deepEquals(board, board1.board) && Objects.equals(items, board1.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rows, cols, Arrays.deepHashCode(board), items);
    }
}
