package ir.ac.kntu.gamelogic;

public class Snake {
    private int xPositionSnakeHead;

    private int yPositionSnakeHead;

    private int xPositionSnakeTail;

    private int yPositionSnakeTail;

    public int getxPositionSnakeHead() {
        return xPositionSnakeHead;
    }

    public void setxPositionSnakeHead(int xPositionSnakeHead) {
        this.xPositionSnakeHead = xPositionSnakeHead;
    }

    public int getyPositionSnakeHead() {
        return yPositionSnakeHead;
    }

    public void setyPositionSnakeHead(int yPositionSnakeHead) {
        this.yPositionSnakeHead = yPositionSnakeHead;
    }

    public int getxPositionSnakeTail() {
        return xPositionSnakeTail;
    }

    public void setxPositionSnakeTail(int xPositionSnakeTail) {
        this.xPositionSnakeTail = xPositionSnakeTail;
    }

    public int getyPositionSnakeTail() {
        return yPositionSnakeTail;
    }

    public void setyPositionSnakeTail(int yPositionSnakeTail) {
        this.yPositionSnakeTail = yPositionSnakeTail;
    }

    public static void moveOnSnake(Player player, Snake snake){
        player.setxPositionPlayer(snake.getxPositionSnakeTail());
        player.setyPositionPlayer(snake.getyPositionSnakeTail());
    }
}
