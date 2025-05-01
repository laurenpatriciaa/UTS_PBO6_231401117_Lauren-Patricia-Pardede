package soal3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        soal3.LotreBoard board = new soal3.LotreBoard();
        System.out.println("Welcome to E-Lottery Gosok");

        while (!board.isGameOver()) {
            board.displayBoard();
            System.out.print("Masukkan tebakan anda (baris dan kolom) : ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            boolean safe = board.guess(row, col);
            if (!safe) {
                System.out.println("BOOM! Anda menemukan bom! Permainan berakhir.");
                board.displayBoard();
                break;
            }
            if (board.isGameOver()) {
                System.out.println("Selamat! Anda membuka semua kotak aman. Permainan selesai.");
                board.displayBoard();
                break;
            }
            System.out.println("Kotak Aman");
        }

        scanner.close();
    }
}