package ir.ac.kntu.gamelogic;

import java.util.Random;

public class RandomHelper {
    private static final Random RANDOM_GENERATOR = new Random();

    public static double nextDouble() {
        return RANDOM_GENERATOR.nextDouble();
    }

    public static boolean nextBoolean() {
        return RANDOM_GENERATOR.nextBoolean();
    }

    public static int nextInt() {
        return RANDOM_GENERATOR.nextInt();
    }

    public static int nextInt(int bound) {
        return RANDOM_GENERATOR.nextInt(bound);
    }
}
