package racingcar.utils;

import java.util.Random;

public class RandomNumberGenerator {
    static final Random random = new Random();

    public static int generate(int minNumber, int maxNumber) {
        if (minNumber > maxNumber) {
            throw new IllegalArgumentException();
        }

        if (minNumber < 0) {
            throw new IllegalArgumentException();
        }

        if (minNumber == maxNumber) {
            return minNumber;
        }

        return minNumber + random.nextInt(maxNumber - minNumber + 1);
    }
}
