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
        switch (side) {
            case 0 -> twoUp(player);
            case 1 -> oneUp(player);
            case 2 -> twoLeft(player);
            case 3 -> oneLeft(player);
            case 4 -> twoRight(player, board);
            case 5 -> oneRight(player, board);
            case 6 -> twoDown(player, board);
            case 7 -> oneDown(player, board);
            case 8 -> extraHealth(player);
            default -> {
                return;
            }
        }

        PrintBoard.printboard(player,board,side);
    }

    public static void twoUp(Player player){
        if (player.getxPositionPlayer()-2>=0){
            player.setxPositionPlayer(player.getxPositionPlayer()-2);
        }
    }

    public static void oneUp(Player player){
        if (player.getxPositionPlayer()-1>=0){
            player.setxPositionPlayer(player.getxPositionPlayer()-1);
        }
    }

    public static void twoLeft(Player player){
        if (player.getyPositionPlayer()-2>=0){
            player.setyPositionPlayer(player.getyPositionPlayer()-2);
        }
    }


    public static void oneLeft(Player player){
        if (player.getyPositionPlayer()-1>=0){
            player.setyPositionPlayer(player.getyPositionPlayer()-1);
        }
    }

    public static void twoRight(Player player,String[][] board){
        if (player.getyPositionPlayer()+2<board.length){
            player.setyPositionPlayer(player.getyPositionPlayer()+2);
        }
    }

    public static void oneRight(Player player,String[][] board){
        if (player.getyPositionPlayer()+1<board.length){
            player.setyPositionPlayer(player.getyPositionPlayer()+1);
        }
    }

    public static void twoDown(Player player,String[][] board){
        if (player.getxPositionPlayer()+2<board.length){
            player.setxPositionPlayer(player.getxPositionPlayer()+2);
        }
    }

    public static void oneDown(Player player,String[][] board){
        if (player.getxPositionPlayer()+1<board.length){
            player.setxPositionPlayer(player.getxPositionPlayer()+1);
        }
    }

    public static void extraHealth(Player player){
        player.setHeart(player.getHeart()+1);
    }
}
