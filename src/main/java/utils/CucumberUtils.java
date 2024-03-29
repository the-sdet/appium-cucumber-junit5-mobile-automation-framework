package utils;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;

import static engine.Engine.getDriver;

@SuppressWarnings("unused")
public class CucumberUtils {
    public static Scenario scenario;

    public static Scenario getCurrentScenario() {
        return scenario;
    }

    public static void setCurrentScenario(Scenario scenario) {
        CucumberUtils.scenario = scenario;
    }

    public static void attachBase64Screenshot() {
        String base64Image = getDriver().getScreenshotAs(OutputType.BASE64);
        scenario.log("<img src=data:image/png;base64," + base64Image + ">");
    }

    public static void attachScreenshot() {
        scenario.attach(getDriver().getScreenshotAs(OutputType.BYTES), "image/png", "Attached Image");
    }

    public static void attachScreenshot(String screenshotName) {
        scenario.attach(getDriver().getScreenshotAs(OutputType.BYTES), "image/png", screenshotName);
    }
}