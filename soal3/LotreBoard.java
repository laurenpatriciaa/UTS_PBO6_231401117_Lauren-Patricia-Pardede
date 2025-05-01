package soal3;

import java.util.Random;

public class LotreBoard {
    private char[][] board;
    private boolean[][] revealed;
    private int[][] data;
    private int safeRevealedCount;
    private boolean bombRevealed;
    private static final int ROWS = 4;
    private static final int COLS = 5;
    private static final int TOTAL_BOMBS = 2;
    private static final int TOTAL_SAFE = ROWS * COLS - TOTAL_BOMBS;

    public LotreBoard() {
        board = new char[ROWS][COLS];
        revealed = new boolean[ROWS][COLS];
        data = new int[ROWS][COLS];
        safeRevealedCount = 0;
        bombRevealed = false;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = '*';
                revealed[i][j] = false;
                data[i][j] = 0;
            }
        }
        generateBoard();
    }

    public void generateBoard() {
        Random rand = new Random();
        int placed = 0;
        while (placed < TOTAL_BOMBS) {
            int r = rand.nextInt(ROWS);
            int c = rand.nextInt(COLS);
            if (data[r][c] == 0) {
                data[r][c] = 1;
                placed++;
            }
        }
    }

    public void displayBoard() {
        System.out.println("Kotak Saat Ini:");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean guess(int row, int col) {
        if (row < 0 || row >= ROWS || col < 0 || col >= COLS) {
            System.out.println("Posisi di luar batas!");
            return true;
        }
        if (revealed[row][col]) {
            System.out.println("Kotak telah dibuka sebelumnya!");
            return true;
        }
        revealed[row][col] = true;
        if (data[row][col] == 1) {
            board[row][col] = 'X';
            bombRevealed = true;
            return false;
        } else {
            board[row][col] = 'O';
            safeRevealedCount++;
            return true;
        }
    }

    public boolean isGameOver() {
        return bombRevealed || safeRevealedCount >= TOTAL_SAFE;
    }
}