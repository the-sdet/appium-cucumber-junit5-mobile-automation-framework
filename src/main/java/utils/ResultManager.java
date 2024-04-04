package utils;

import io.cucumber.java.Scenario;
import io.github.the_sdet.common.CommonUtils.STATUS;
import logger.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to manage test results.
 * It initializes and updates test results, and prints them.
 *
 * @author Pabitra Swain (contact.the.sdet@gmail.com)
 */
public class ResultManager {

    static HashMap<String, Map<STATUS, Integer>> resultCollector = new HashMap<>();

    /**
     * Initializes the result collector for a given feature.
     *
     * @param featureName The name of the feature.
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public static void initializeResultCollector(String featureName) {
        HashMap<STATUS, Integer> resultInitializer = new HashMap<>();
        resultInitializer.put(STATUS.PASS, 0);
        resultInitializer.put(STATUS.FAIL, 0);
        resultCollector.put(featureName, resultInitializer);
    }

    /**
     * Prints the test results.
     *
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public static void printResult() {
        for (Map.Entry<String, Map<STATUS, Integer>> entry : resultCollector.entrySet()) {
            String feature = entry.getKey();
            int pass = entry.getValue().get(STATUS.PASS);
            int fail = entry.getValue().get(STATUS.FAIL);
            Log.info(String.format("Feature: %s | Pass: %d | Fail: %d", feature, pass, fail));
        }
    }

    /**
     * Updates the test result based on the scenario outcome.
     *
     * @param scenario    The scenario being executed.
     * @param featureName The name of the feature associated with the scenario.
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public static void updateResult(Scenario scenario, String featureName) {
        Map<STATUS, Integer> resultKey = resultCollector.get(featureName);
        if (scenario.isFailed()) {
            resultKey.put(STATUS.FAIL, (resultKey.get(STATUS.FAIL) + 1));
        } else {
            resultKey.put(STATUS.PASS, (resultKey.get(STATUS.PASS) + 1));
        }
    }
}