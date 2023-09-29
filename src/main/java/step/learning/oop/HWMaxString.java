package step.learning.oop;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class HWMaxString {
    public static String generateString(int min, int max) {
        StringBuilder randomString = new StringBuilder();

        int length = ThreadLocalRandom.current().nextInt(min, max + 1);

        for (int i = 0; i < length; i++) {
            int randomAscii = ThreadLocalRandom.current().nextInt(20, 127 + 1);
            char randomChar = (char) randomAscii;
            randomString.append(randomChar);
        }

        return randomString.toString();
    }
}