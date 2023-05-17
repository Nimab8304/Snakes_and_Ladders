package ir.ac.kntu.gamelogic;

public class AngrySnake extends Snake{

    public static void moveOnAngrySnake(Player player, Snake snake){
        player.setxPositionPlayer(snake.getxPositionSnakeTail());
        player.setyPositionPlayer(snake.getyPositionSnakeTail());
        player.setHeart(player.getHeart()-1);
    }
}
