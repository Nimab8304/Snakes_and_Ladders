package ir.ac.kntu.gamelogic;

public class Dice {
    public static int getside(){
        return RandomHelper.nextInt(9);
    }
}
