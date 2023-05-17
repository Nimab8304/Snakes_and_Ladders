package ir.ac.kntu;

import ir.ac.kntu.gamelogic.*;

import java.util.Scanner;


public class PrintBoard {

    public static void printboard(Player player, String[][] board, int side) {
        System.out.println("Dice: " + DiceEnum.values()[side]);
        System.out.println("Health: " + player.getHeart());
        System.out.println(CreateSnake.cntFriendlySnake);
        System.out.println(CreateSnake.cntNormalSnake);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].equals("1")) {
                    System.out.print(" * |");
                    board[i][j] = "0";
                } else if (board[i][j].equals("0")) {
                    System.out.print("   |");
                } else {
                    System.out.print(board[i][j] + "|");
                }
            }
            System.out.print("\n");
            if (i < board.length - 1) {
                for (int j = 0; j < board.length * 2; j++) {
                    System.out.print("- ");
                }
            }
            System.out.print("\n");
        }
        if (player.getxPositionPlayer() == 0 && player.getyPositionPlayer() == board.length - 1) {
            System.exit(0);
        }
        System.out.println("Press Enter to continue-> ");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        Board.handlemove(player, board);
    }
}
