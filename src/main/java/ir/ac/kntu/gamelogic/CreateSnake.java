package ir.ac.kntu.gamelogic;

public class CreateSnake {

    public static void createSnake(){
        int cntNormalSnake=RandomHelper.nextInt(4);

        int cntAngrySnake=RandomHelper.nextInt(4);

        int cntFriendlySnake=RandomHelper.nextInt(4);

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
                friendlySnake.setxPositionSnakeTail(RandomHelper.nextInt(Board.lenght - 1));
            }
        }
    }
}
