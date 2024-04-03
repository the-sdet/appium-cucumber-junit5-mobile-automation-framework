package utils;

import io.cucumber.java.Scenario;
import logger.Log;

import java.util.HashMap;
import java.util.Map;

public class ResultManager {
    static HashMap<String, Map<CommonUtils.STATUS, Integer>> resultCollector = new HashMap<>();

    public static void initializeResultCollector(String featureName){
        HashMap<CommonUtils.STATUS, Integer> resultInitializer = new HashMap<>();
        resultInitializer.put(CommonUtils.STATUS.PASS, 0);
        resultInitializer.put(CommonUtils.STATUS.FAIL, 0);
        resultCollector.put(featureName, resultInitializer);
    }

    public static void printResult(){
        for (Map.Entry<String, Map<CommonUtils.STATUS, Integer>> entry : resultCollector.entrySet()) {
            String feature = entry.getKey();
            int pass = entry.getValue().get(CommonUtils.STATUS.PASS);
            int fail = entry.getValue().get(CommonUtils.STATUS.FAIL);
            Log.info(String.format("Feature: %s | Pass: %d | Fail: %d", feature, pass, fail));
        }
    }

    public static void updateResult(Scenario scenario, String featureName){
        Map<CommonUtils.STATUS, Integer> resultKey = resultCollector.get(featureName);
        if (scenario.isFailed()) {
            resultKey.put(CommonUtils.STATUS.FAIL, (resultKey.get(CommonUtils.STATUS.FAIL) + 1));
        } else {
            resultKey.put(CommonUtils.STATUS.PASS, (resultKey.get(CommonUtils.STATUS.PASS) + 1));
        }

    }
}
