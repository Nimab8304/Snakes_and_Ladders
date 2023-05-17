package ir.ac.kntu.gamelogic;

public class CreateSnake {
    public static int cntNormalSnake;

    public static int cntAngrySnake;

    public static int cntFriendlySnake;

    public static void createSnake(){
        cntNormalSnake=RandomHelper.nextInt((Board.lenght/2)-1)+1;
        cntAngrySnake=RandomHelper.nextInt((Board.lenght/2)-1)+1;
        cntFriendlySnake=RandomHelper.nextInt((Board.lenght/2)-1)+1;
        for (int i = 0; i < cntNormalSnake; i++) {
            NormalSnake normalSnake=new NormalSnake();
            Board.normalSnakes.add(normalSnake);
        }

        for (int i = 0; i < cntAngrySnake; i++) {
            AngrySnake angrySnake=new AngrySnake();
            Board.angrySnakes.add(angrySnake);
        }

        for (int i = 0; i < cntFriendlySnake; i++) {
            FriendlySnake friendlySnake=new FriendlySnake();
            Board.friendlySnakes.add(friendlySnake);
        }
        setPosition();
    }

    public static void setPosition(){
        for (FriendlySnake friendlySnake:Board.friendlySnakes) {
            friendlySnake.setyPositionSnakeHead(RandomHelper.nextInt(Board.lenght));
            friendlySnake.setyPositionSnakeTail(RandomHelper.nextInt(Board.lenght));
            friendlySnake.setxPositionSnakeHead(RandomHelper.nextInt(Board.lenght-1)+1);
            friendlySnake.setxPositionSnakeTail(0);
            while (friendlySnake.getxPositionSnakeTail()>friendlySnake.getxPositionSnakeHead()) {
                friendlySnake.setxPositionSnakeTail(RandomHelper.nextInt(Board.lenght - 1)+1);
            }
        }
        for (NormalSnake normalSnake:Board.normalSnakes) {
            normalSnake.setyPositionSnakeHead(RandomHelper.nextInt(Board.lenght));
            normalSnake.setyPositionSnakeTail(RandomHelper.nextInt(Board.lenght));
            normalSnake.setxPositionSnakeHead(RandomHelper.nextInt(Board.lenght-1));
            normalSnake.setxPositionSnakeTail(0);
            while (normalSnake.getxPositionSnakeTail()<=normalSnake.getxPositionSnakeHead()) {
                normalSnake.setxPositionSnakeTail(RandomHelper.nextInt(Board.lenght - 1));
            }
        }
    }

    public static void changePosition(String [][] board){
        for (FriendlySnake friendlySnake:Board.friendlySnakes) {
            friendlySnake.setyPositionSnakeTail(RandomHelper.nextInt(Board.lenght));
            int xposition=Board.lenght-1;
            while (xposition>=friendlySnake.getxPositionSnakeHead()) {
                xposition=RandomHelper.nextInt(Board.lenght - 1);
            }
            friendlySnake.setxPositionSnakeTail(xposition);
        }
        for (NormalSnake normalSnake:Board.normalSnakes) {
            normalSnake.setyPositionSnakeTail(RandomHelper.nextInt(Board.lenght));
            int xposition=0;
            while (xposition<normalSnake.getxPositionSnakeHead()) {
                xposition=RandomHelper.nextInt(Board.lenght -1)+1;
            }
            normalSnake.setxPositionSnakeHead(xposition);
        }
    }
}
