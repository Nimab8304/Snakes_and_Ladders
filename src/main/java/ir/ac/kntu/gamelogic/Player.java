package ir.ac.kntu.gamelogic;

public class Player {
    private int heart=3;

    private int xPositionPlayer;

    private int yPositionPlayer;

    public int getxPositionPlayer() {
        return xPositionPlayer;
    }

    public void setxPositionPlayer(int xPositionPlayer) {
        this.xPositionPlayer = xPositionPlayer;
    }

    public int getyPositionPlayer() {
        return yPositionPlayer;
    }

    public void setyPositionPlayer(int yPositionPlayer) {
        this.yPositionPlayer = yPositionPlayer;
    }

    public int getHeart() {
        return heart;
    }

    public void setHeart(int heart) {
        this.heart = heart;
    }
}
