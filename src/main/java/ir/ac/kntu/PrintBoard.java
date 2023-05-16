package ir.ac.kntu;

import ir.ac.kntu.gamelogic.DiceEnum;
import ir.ac.kntu.gamelogic.Player;


public class PrintBoard {

    public static void printboard(Player player,String[][] board,int side){
        System.out.println("Dice: "+ DiceEnum.values()[side]);
        System.out.println("Health: "+player.getHeart());
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (i== player.getxPositionPlayer()&&j== player.getyPositionPlayer()){
                    System.out.print("*|");
                }else {
                    System.out.print(" |");
                }
            }
            System.out.print("\n");
            if (i<board.length-1) {
                for (int j = 0; j < board.length + 1; j++) {
                    System.out.print("- ");
                }
            }
            System.out.print("\n");
        }
    }
}
