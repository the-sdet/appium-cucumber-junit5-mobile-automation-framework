package pages.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.github.the_sdet.mobile.AppiumUtils;
import logger.Log;
import pages.android.FlightsPageAndroid;
import pages.base.FlightsPageBase;
import pages.ios.FlightsPageIOS;

import static engine.Engine.isAndroid;
import static utils.CucumberUtils.attachScreenshot;

public class FlightsPage extends AppiumUtils {
    public FlightsPageBase flightsPage;

    /**
     * Constructor to initialize AppiumUtils.
     *
     * @param driver The Appium Driver (AndroidDriver/IOSDriver) instance to use.
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public FlightsPage(AppiumDriver driver) {
        super(driver);
        flightsPage = isAndroid() ? new FlightsPageAndroid() : new FlightsPageIOS();
    }

    public void testMethod() {
        Log.info("This is Flights Page...");
        attachScreenshot("Flights Page Screenshot");
    }

}
