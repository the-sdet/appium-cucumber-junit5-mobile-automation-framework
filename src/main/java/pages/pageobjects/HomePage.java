package pages.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.github.the_sdet.mobile.AppiumUtils;
import logger.Log;
import pages.android.HomePageAndroid;
import pages.base.HomePageBase;
import pages.ios.HomePageIOS;

import static engine.Engine.isAndroid;
import static utils.CucumberUtils.attachScreenshot;

public class HomePage extends AppiumUtils {
    public HomePageBase homePage;

    /**
     * Constructor to initialize AppiumUtils.
     *
     * @param driver The Appium Driver (AndroidDriver/IOSDriver) instance to use.
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public HomePage(AppiumDriver driver) {
        super(driver);
        homePage = isAndroid() ? new HomePageAndroid() : new HomePageIOS();
    }

    public void testMethod() {
        Log.info("This is Flights Page...");
        attachScreenshot("Flights Page Screenshot");
    }

}