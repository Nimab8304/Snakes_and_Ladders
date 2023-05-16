package ir.ac.kntu.gamelogic;

public class AngrySnake extends Snake{

    @Override
    public void moveOnSnake(Player player, Snake snake){
        player.setxPositionPlayer(snake.getxPositionSnakeTail());
        player.setyPositionPlayer(snake.getyPositionSnakeTail());
        player.setHeart(player.getHeart()-1);
    }
}
