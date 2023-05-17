package ir.ac.kntu.gamelogic;

import ir.ac.kntu.PrintBoard;

import java.util.ArrayList;
import java.util.Scanner;

public class Board {
    public static int lenght;

    public static ArrayList<AngrySnake> angrySnakes = new ArrayList<>();

    public static ArrayList<NormalSnake> normalSnakes = new ArrayList<>();

    public static ArrayList<FriendlySnake> friendlySnakes = new ArrayList<>();

    public static int scalable() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of board: ");
        int size = scanner.nextInt();
        lenght = size;
        return size;
    }


    public static void start() {
        Player player = new Player();
        int size = Board.scalable();
        String[][] board = new String[size][size];
        player.setxPositionPlayer(size - 1);
        player.setyPositionPlayer(0);
        CreateSnake.createSnake();
        handlemove(player, board);
    }

    public static void handlemove(Player player, String[][] board) {
        int side = Dice.getside();
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
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (i == player.getxPositionPlayer() && j == player.getyPositionPlayer()) {
                    board[i][j] = "1";
                    break;
                }else {
                    board[i][j] = "0";
                }
            }
        }

        if (friendlySnakes.size() > 0) {
            setFriendlySnakesOnBoard(board,player);
        }
        if (normalSnakes.size() > 0) {
            setNormalSnakesSnakesOnBoard(board,player);
        }
        CreateSnake.changePosition(board);
        PrintBoard.printboard(player, board, side);

    }

    public static void twoUp(Player player) {
        if (player.getxPositionPlayer() - 2 >= 0) {
            player.setxPositionPlayer(player.getxPositionPlayer() - 2);
        }
    }

    public static void oneUp(Player player) {
        if (player.getxPositionPlayer() - 1 >= 0) {
            player.setxPositionPlayer(player.getxPositionPlayer() - 1);
        }
    }

    public static void twoLeft(Player player) {
        if (player.getyPositionPlayer() - 2 >= 0) {
            player.setyPositionPlayer(player.getyPositionPlayer() - 2);
        }
    }


    public static void oneLeft(Player player) {
        if (player.getyPositionPlayer() - 1 >= 0) {
            player.setyPositionPlayer(player.getyPositionPlayer() - 1);
        }
    }

    public static void twoRight(Player player, String[][] board) {
        if (player.getyPositionPlayer() + 2 < board.length) {
            player.setyPositionPlayer(player.getyPositionPlayer() + 2);
        }
    }

    public static void oneRight(Player player, String[][] board) {
        if (player.getyPositionPlayer() + 1 < board.length) {
            player.setyPositionPlayer(player.getyPositionPlayer() + 1);
        }
    }

    public static void twoDown(Player player, String[][] board) {
        if (player.getxPositionPlayer() + 2 < board.length) {
            player.setxPositionPlayer(player.getxPositionPlayer() + 2);
        }
    }

    public static void oneDown(Player player, String[][] board) {
        if (player.getxPositionPlayer() + 1 < board.length) {
            player.setxPositionPlayer(player.getxPositionPlayer() + 1);
        }
    }

    public static void extraHealth(Player player) {
        if (player.getHeart() < 3) {
            player.setHeart(player.getHeart() + 1);
        }
    }

    public static void setFriendlySnakesOnBoard(String[][] board,Player player) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                for (FriendlySnake friendlySnake : friendlySnakes) {
                    board[i][j] = "0";
                    if (i == player.getxPositionPlayer() && j == player.getyPositionPlayer()) {
                        board[i][j] = "1";
                        break;
                    } else if (i == friendlySnake.getxPositionSnakeHead() && j == friendlySnake.getyPositionSnakeHead()) {
                        board[i][j] = "F" + Board.friendlySnakes.indexOf(friendlySnake);
                        break;
                    } else if (i == friendlySnake.getxPositionSnakeTail() && j == friendlySnake.getyPositionSnakeTail()) {
                        board[i][j] = "f" + Board.friendlySnakes.indexOf(friendlySnake);
                        break;
                    } else {
                        board[i][j] = "0";
                    }
                }
            }
        }
    }

    public static void setNormalSnakesSnakesOnBoard(String[][] board,Player player) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                for (NormalSnake normalSnake:Board.normalSnakes) {
                    if (i == player.getxPositionPlayer() && j == player.getyPositionPlayer()) {
                        board[i][j] = "1";
                        break;
                    } else if (i == normalSnake.getxPositionSnakeHead() && j == normalSnake.getyPositionSnakeHead()) {
                        board[i][j] = "N" + Board.normalSnakes.indexOf(normalSnake);
                        break;
                    } else if (i == normalSnake.getxPositionSnakeTail() && j == normalSnake.getyPositionSnakeTail()) {
                        board[i][j] = "n" + Board.normalSnakes.indexOf(normalSnake);
                        break;
                    }
                }
            }
        }
    }

}
