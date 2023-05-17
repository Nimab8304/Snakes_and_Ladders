package ir.ac.kntu;

import ir.ac.kntu.gamelogic.*;

import java.util.Scanner;


public class PrintBoard {

    public static void printboard(Player player, String[][] board, int side,int size) {
        System.out.println("Dice: " + DiceEnum.values()[side]);
        System.out.print("Health: " );
        for (int i = 0; i < player.getHeart(); i++) {
            System.out.print("♥ ");
        }
        System.out.println("\n");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].equals("1")) {
                    System.out.print(" * |");
                    board[i][j] = "0";
                } else if (board[i][j].equals("0")) {
                    System.out.print("   |");
                } else {
                    System.out.print(board[i][j] + " | ");
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
            System.out.println("You finally did it !!! you Genius ♪♫♥♥");
            System.exit(0);
        }
        if (player.getHeart()==0) {
            System.out.println("Wasted!! :(");
            System.exit(0);
        }
        System.out.println("Press Enter to continue-> ");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        Board.handlemove(player, board,size);
    }
}
