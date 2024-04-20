package utils;

import io.cucumber.java.Scenario;
import logger.Log;

import java.util.Properties;

import static engine.Engine.getDriver;
import static io.github.the_sdet.cucumber.CucumberUtils.*;

/**
 * Class to handle common utilities
 *
 * @author Pabitra Swain (contact.the.sdet@gmail.com)
 */
public class CommonUtils {
    /**
     * Attaches screenshot to the Cucumber report based on the configuration.
     *
     * @param scenario The Scenario object from Cucumber.
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public static void attachScreenshotPerConfig(Scenario scenario) {
        Properties properties = ConfigReader.getProperties();
        if (properties.getProperty("screenshot").equals("only.fail")) {
            if (scenario.isFailed()) {
                logFailureToReport(scenario.getName() + " Failed...");
                attachScreenshot(getDriver());
            }
        } else if (properties.getProperty("screenshot").equals("only.pass")) {
            if (!scenario.isFailed()) {
                logSuccessToReport(scenario.getName() + " Passed...");
                attachScreenshot(getDriver());
            }
        } else {
            Log.info("Taking Screenshot.");
            attachScreenshot(getDriver());
        }
    }
}
