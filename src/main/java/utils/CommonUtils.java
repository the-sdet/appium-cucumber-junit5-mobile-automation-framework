package utils;

import io.github.the_sdet.logger.Log;

public class CommonUtils {
    public static void waitForSeconds(int seconds) {
        Log.info("Wait started for " + seconds + " seconds...");
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Log.error("Error while applying wait...", e);
        }
        Log.info(seconds + " seconds of wait completed...");
    }
}
