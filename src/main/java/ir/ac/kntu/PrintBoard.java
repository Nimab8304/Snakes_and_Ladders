package ir.ac.kntu;

import ir.ac.kntu.gamelogic.*;

import java.util.Scanner;


public class PrintBoard {

    public static void printboard(Player player, String[][] board, int side,int size) {
        System.out.println("\033[38;5;120m"+"Dice: "+"\033[38;5;87m" + DiceEnum.values()[side]+"\u001B[35m");
        System.out.print("Health: " );
        for (int i = 0; i < player.getHeart(); i++) {
            System.out.print("\u001B[31m"+"♥ "+"\033[0m");
        }
        System.out.println("\n");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].startsWith("1")) {
                    System.out.print(" *"+"\u001B[31m"+" |"+"\033[0m");
                    board[i][j] = "0";
                } else if (board[i][j].equals("0")) {
                    System.out.print("\u001B[31m"+"   |"+"\033[0m");
                } else {
                    System.out.print("\u001B[36m"+board[i][j].substring(1) +"\u001B[31m"+ " | "+"\033[0m");
                }
            }
            System.out.print("\n");
            if (i < board.length - 1) {
                for (int j = 0; j < board.length * 2+3; j++) {
                    System.out.print("\u001B[32m"+"- ");
                }
            }
            System.out.print("\n"+"\033[0m");
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
