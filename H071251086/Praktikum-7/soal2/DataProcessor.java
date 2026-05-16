package soal2;

import java.util.Random;

public class DataProcessor {

    static final Random random = new Random();

    public static int process(String fileName) {

        try {
            int sleepTime = random.nextInt(1501) + 500;

            Thread.sleep(sleepTime);

            return random.nextInt(901) + 100;

        } catch (InterruptedException e) {

            System.out.println("Proses terganggu pada file: " + fileName);

            return 0;
        }
    }
}
