package ir.ac.kntu.gamelogic;

import ir.ac.kntu.PrintBoard;

import java.util.ArrayList;
import java.util.Scanner;

public class Board {

    ArrayList<AngrySnake> angrySnakes=new ArrayList<>();

    ArrayList<NormalSnake> normalSnakes=new ArrayList<>();

    ArrayList<FriendlySnake> friendlySnakes=new ArrayList<>();

    public static int scalable() {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter the size of board: ");
        int size=scanner.nextInt();
        return size;
    }

    public static void start(){
        Player player =new Player();
        int size=Board.scalable();
        String[][] board=new String[size][size];
        player.setxPositionPlayer(size-1);
        player.setyPositionPlayer(0);
        handlemove(player,board);
    }

    public static void handlemove(Player player,String[][] board){
        int side=Dice.getside();
        PrintBoard.printboard(player,board,side);
    }

}
