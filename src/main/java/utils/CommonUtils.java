package utils;

import io.cucumber.java.Scenario;
import logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static engine.Engine.getDriver;
import static io.github.the_sdet.cucumber.CucumberUtils.*;
import static io.github.the_sdet.cucumber.CucumberUtils.attachScreenshot;

public class CommonUtils {
    public static WebElement findElementByMultipleLocators(WebDriver driver, String... xPaths) {
        for (String xpath : xPaths) {
            try {
                return driver.findElement(By.xpath(xpath));
            } catch (org.openqa.selenium.NoSuchElementException e) {
                Log.info("No element found for Xpath: " + xpath);
            }
        }
        throw new NoSuchElementException("Element NOT found for any of the provided locators...");
    }

    /**
     * This method retrieves and returns the feature name of which the scenario is part of
     *
     * @param scenario Cucumber scenario name
     * @return Cucumber feature name from scenario
     */
    public static String getFeatureNameFromScenario(Scenario scenario, boolean withPackageName) {
        String[] test = scenario.getUri().toString().split("/");
        String featureName = test[1].split("\\.")[0];
        String packageName = test[0].split(":")[1];
        Log.info("Feature: "+featureName);
        Log.info("Package: "+packageName);
        if (withPackageName)
            return packageName + " - " + featureName;
        else return featureName;
    }

    public enum STATUS {
        PASS ("PASS"), FAIL ("FAIL");
        public final String status;
        STATUS(String status){
            this.status = status;
        }
    }

    public static void attachScreenshotPerConfig(Scenario scenario){
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
