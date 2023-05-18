package ir.ac.kntu.gamelogic;

public class CreateSnake {
    public static int cntNormalSnake;

    public static int cntAngrySnake;

    public static int cntFriendlySnake;

    public static void createSnake(int size) {
        cntNormalSnake = RandomHelper.nextInt((size / 2)) + 1;
        cntAngrySnake = RandomHelper.nextInt((size / 2)) + 1;
        cntFriendlySnake = RandomHelper.nextInt((size / 2)) + 1;
        for (int i = 0; i < cntNormalSnake; i++) {
            NormalSnake normalSnake = new NormalSnake();
            Board.normalSnakes.add(normalSnake);
        }

        for (int i = 0; i < cntAngrySnake; i++) {
            AngrySnake angrySnake = new AngrySnake();
            Board.angrySnakes.add(angrySnake);
        }

        for (int i = 0; i < cntFriendlySnake; i++) {
            FriendlySnake friendlySnake = new FriendlySnake();
            Board.friendlySnakes.add(friendlySnake);
        }
        setPosition(size);
    }

    public static void setPosition(int size) {
        for (FriendlySnake friendlySnake : Board.friendlySnakes) {
            friendlySnake.setyPositionSnakeHead(RandomHelper.nextInt(size));
            friendlySnake.setyPositionSnakeTail(RandomHelper.nextInt(size));
            friendlySnake.setxPositionSnakeHead(RandomHelper.nextInt(size - 1) + 1);
            friendlySnake.setxPositionSnakeTail(0);
            while (friendlySnake.getxPositionSnakeTail() > friendlySnake.getxPositionSnakeHead()) {
                friendlySnake.setxPositionSnakeTail(RandomHelper.nextInt(size - 1) + 1);
            }
        }
        for (NormalSnake normalSnake : Board.normalSnakes) {
            normalSnake.setyPositionSnakeHead(RandomHelper.nextInt(size));
            normalSnake.setyPositionSnakeTail(RandomHelper.nextInt(size));
            normalSnake.setxPositionSnakeHead(RandomHelper.nextInt(size - 1));
            normalSnake.setxPositionSnakeTail(0);
            while (normalSnake.getxPositionSnakeTail() <= normalSnake.getxPositionSnakeHead()) {
                normalSnake.setxPositionSnakeTail(RandomHelper.nextInt(size));
            }
        }
        for (AngrySnake angrySnake : Board.angrySnakes) {
            angrySnake.setyPositionSnakeHead(RandomHelper.nextInt(size));
            angrySnake.setyPositionSnakeTail(RandomHelper.nextInt(size));
            angrySnake.setxPositionSnakeHead(RandomHelper.nextInt(size - 1));
            angrySnake.setxPositionSnakeTail(0);
            while (angrySnake.getxPositionSnakeTail() <= angrySnake.getxPositionSnakeHead()) {
                angrySnake.setxPositionSnakeTail(RandomHelper.nextInt(size));
            }
        }
    }

    public static void changePosition(String[][] board, int size) {
        int xposition = size - 1;
        for (FriendlySnake friendlySnake : Board.friendlySnakes) {
            do {
                friendlySnake.setyPositionSnakeTail(RandomHelper.nextInt(size));
                while (xposition >= friendlySnake.getxPositionSnakeHead()) {
                    xposition = RandomHelper.nextInt(size - 1);
                }
                friendlySnake.setxPositionSnakeTail(xposition);
            } while (!board[friendlySnake.getxPositionSnakeTail()][friendlySnake.getyPositionSnakeTail()].equals("0"));
        }
        for (NormalSnake normalSnake : Board.normalSnakes) {
            do {
                normalSnake.setyPositionSnakeTail(RandomHelper.nextInt(size));
                xposition = 0;
                while (xposition <= normalSnake.getxPositionSnakeHead()) {
                    xposition = RandomHelper.nextInt(size - 1) + 1;
                }
                normalSnake.setxPositionSnakeTail(xposition);
            } while (!board[normalSnake.getxPositionSnakeTail()][normalSnake.getyPositionSnakeTail()].equals("0"));
        }
        for (AngrySnake angrySnake : Board.angrySnakes) {
            do {
                angrySnake.setyPositionSnakeHead(RandomHelper.nextInt(size));
                angrySnake.setyPositionSnakeTail(RandomHelper.nextInt(size));
                angrySnake.setxPositionSnakeHead(RandomHelper.nextInt(size - 1));
                xposition = 0;
                while (xposition <= angrySnake.getxPositionSnakeHead()) {
                    xposition = RandomHelper.nextInt(size - 1) + 1;
                }
                angrySnake.setxPositionSnakeTail(xposition);
            } while (!board[angrySnake.getxPositionSnakeHead()][angrySnake.getyPositionSnakeHead()].equals("0") ||
                    !board[angrySnake.getxPositionSnakeTail()][angrySnake.getyPositionSnakeTail()].equals("0"));
        }
    }
}
