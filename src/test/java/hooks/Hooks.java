package hooks;

import io.cucumber.java.*;
import logger.Log;

import java.util.HashSet;

import static engine.Engine.*;
import static io.github.the_sdet.cucumber.CucumberUtils.*;
import static utils.CommonUtils.attachScreenshotPerConfig;
import static utils.ResultManager.*;


/**
 * Hooks class containing setup and tear-down methods for test scenarios.
 *
 * @author Pabitra Swain (contact.the.sdet@gmail.com)
 */
@SuppressWarnings("unused")
public class Hooks {

    static String featureName;
    static HashSet<String> features = new HashSet<>();

    /**
     * Method executed before all tests.
     *
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    @BeforeAll
    public static void beforeAll() {
        initializeDriver();
    }

    /**
     * Method executed before each test.
     *
     * @param scenario The scenario being executed.
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    @Before
    public void beforeTest(Scenario scenario) {
        String currentFeatureName = getFeatureNameFromScenario(scenario, false);
        if (!features.contains(currentFeatureName)) {
            featureName = currentFeatureName;
            features.add(featureName);

            // Initialize Result Map for Current Feature
            initializeResultCollector(featureName);
        }
        setCurrentScenario(scenario);
        logToReport(scenario.getName() + " Started...");
    }

    /**
     * Method executed after each test.
     *
     * @param scenario The scenario being executed.
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    @After
    public void afterTest(Scenario scenario) {
        // Update Result for Current Scenario
        updateResult(scenario, featureName);
        attachScreenshotPerConfig(scenario);
    }

    /**
     * Method executed after all tests.
     *
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    @AfterAll
    public static void afterAll() {
        printResult();
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