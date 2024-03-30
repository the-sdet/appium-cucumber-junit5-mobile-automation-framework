package hooks;

import io.cucumber.java.*;
import logger.Log;

import static engine.Engine.*;
import static io.github.the_sdet.cucumber.CucumberUtils.*;

@SuppressWarnings("unused")
public class Hooks {
    @BeforeAll
    public static void beforeAll() {
        initializeDriver();
    }

    @Before
    public void beforeTest(Scenario scenario) {
        setCurrentScenario(scenario);
        logToReport(scenario.getName() + " Started...");
    }

    @After
    public void afterTest(Scenario scenario) {
        if (scenario.isFailed())
            logFailureToReport(scenario.getName() + " Completed...");
        else
            logSuccessToReport(scenario.getName() + " Completed...");
        attachScreenshot(getDriver(), scenario.getName());
    }

    @AfterAll
    public static void afterAll() {
        quitDriver();
        stopAppiumServer();
        String home = System.getProperty("user.dir");
        Log.info("------------------------------------------------------");
        Log.info("Reports Generated...");
        Log.info("------------------------------------------------------");
        Log.info("Cucumber: " + home + "\\testReports\\CucumberReport.html");
        Log.info("Cucumber Enhanced: " + home + "\\testReports\\cucumber-html-reports\\overview-features.html");
        Log.info("Time Line: " + home + "\\testReports\\timelineReport\\index.html");
        Log.info("Extent HTML: " + home + "\\testReports\\ExtentReport.html");
        Log.info("Extent PDF: " + home + "\\testReports\\ExtentReport.pdf");
        Log.info("------------------------------------------------------");
    }
}