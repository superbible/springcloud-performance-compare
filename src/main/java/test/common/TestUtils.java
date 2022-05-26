package test.common;

import org.apache.commons.lang3.time.StopWatch;

import java.text.NumberFormat;

public class TestUtils {
    public static String runThreads(int threadCount, int repeatTimes, Runnable runnable) {
        StopWatch stopWatch = StopWatch.createStarted();

        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < repeatTimes; j++) {
                    runnable.run();
                }
            });
        }
        for (int i = 0; i < threadCount; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threadCount; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        return "Cost: " + stopWatch.formatTime() + ", thread:" + threadCount + ", repeatTimes:" + repeatTimes
                + ", TPS: " + NumberFormat.getInstance().format(threadCount * repeatTimes / (stopWatch.getTime() / 1000.0));
    }
}
