package engine;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import logger.Log;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import static io.github.the_sdet.common.CommonUtils.waitFor;
import static utils.ConfigReader.*;

/**
 * Class to handle Appium Driver Initialization, termination and other driver management utils.
 *
 * @author Pabitra Swain (contact.the.sdet@gmail.com)
 */
@SuppressWarnings("unused")
public class Engine {
    static ThreadLocal<AppiumDriver> tlDriver = new ThreadLocal<>();
    private static AppiumDriverLocalService service;
    private static final String platform = getProperties().getProperty("platform").trim().toLowerCase();
    private static final String appPackage = isAndroid() ?
            getAndroidProperties().getProperty("app.package") : getIosProperties().getProperty("app.package");

    /**
     * Check if the platform is Android.
     *
     * @return true if platform is Android, false otherwise.
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public static boolean isAndroid() {
        return platform.equals("android");
    }

    /**
     * Start the Appium server.
     *
     * @return URL of the started Appium server.
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public static URL startAppiumServer() {
        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .withIPAddress(getProperties().getProperty("appium.server.url.local"))
                .usingAnyFreePort();

        // Start the Appium server
        service = AppiumDriverLocalService.buildService(builder);
        service.start();
        service.clearOutPutStreams();
        URL appiumserverUrl = service.getUrl();
        Log.info("Appium Server started at: " + appiumserverUrl);
        return appiumserverUrl;
    }

    /**
     * Stop the Appium server if it is running.
     *
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public static void stopAppiumServer() {
        if (service != null && service.isRunning()) {
            service.stop();
            Log.info("Appium server stopped.");
        }
    }

    /**
     * Initialize the Appium driver based on the platform and execution type.
     *
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public static void initializeDriver() {
        Properties properties = getProperties();
        AppiumDriver driver;
        String executionType = properties.getProperty("execution.type");

        URL appiumServerURL = executionType.equalsIgnoreCase("local") ?
                startAppiumServer() : frameUrl(properties.getProperty("appium.server.url.remote"));

        assert appiumServerURL != null;

        if (isAndroid()) {
            driver = executionType.equalsIgnoreCase("local") ?
                    new AndroidDriver(appiumServerURL, getAndroidDesiredCapabilities()) :
                    new AndroidDriver(appiumServerURL, getAndroidRemoteDesiredCapabilities());
        } else {
            driver = executionType.equalsIgnoreCase("local") ?
                    new AndroidDriver(appiumServerURL, getIosDesiredCapabilities()) :
                    new AndroidDriver(appiumServerURL, getIosRemoteDesiredCapabilities());
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(properties.getProperty("implicit.wait"))));
        Log.info("Driver Started....");
        tlDriver.set(driver);
    }

    /**
     * Get the current Appium driver.
     *
     * @return the current Appium driver.
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public static AppiumDriver getDriver() {
        return tlDriver.get();
    }

    /**
     * Quit the current Appium driver if it is not null.
     * Terminates the app associated with the driver.
     * Waits for a short duration before quitting the driver.
     * Logs information when the app is terminated and driver is quit.
     *
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public static void quitDriver() {
        AppiumDriver driver = tlDriver.get();
        if (driver != null) {
            try {
                ((AndroidDriver) driver).terminateApp(appPackage);
            } catch (WebDriverException e) {
                waitFor(Duration.ofSeconds(2));
                ((AndroidDriver) driver).terminateApp(appPackage);
            }
            waitFor(Duration.ofSeconds(2));
            driver.quit();
            Log.info("App Terminated...");
        }
    }

    /**
     * Activate the app associated with the current driver.
     * Logs information when the app is activated.
     *
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public static void activateApp() {
        if (isAndroid()) {
            ((AndroidDriver) getDriver()).activateApp(appPackage);
            waitFor(Duration.ofSeconds(1));
        } else {
            ((IOSDriver) getDriver()).activateApp(appPackage);
            waitFor(Duration.ofSeconds(1));
        }
        Log.info("App Activated...");
    }

    /**
     * Relaunch the app associated with the current driver.
     *
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public static void relaunchApp() {
        if (isAndroid()) {
            try {
                ((AndroidDriver) getDriver()).terminateApp(appPackage);
            } catch (Exception e) {
                waitFor(Duration.ofSeconds(1));
                ((AndroidDriver) getDriver()).terminateApp(appPackage);
            }
            waitFor(Duration.ofSeconds(1));
            ((AndroidDriver) getDriver()).activateApp(appPackage);
            waitFor(Duration.ofSeconds(1));
        } else {
            ((IOSDriver) getDriver()).terminateApp(appPackage);
            waitFor(Duration.ofSeconds(1));
            ((IOSDriver) getDriver()).activateApp(appPackage);
            waitFor(Duration.ofSeconds(1));
        }
    }

    /**
     * Frame a URL from the provided string.
     *
     * @param url the string representation of the URL.
     * @return the URL object parsed from the string.
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    private static URL frameUrl(String url) {
        try {
            return new URL(url);
        } catch (MalformedURLException e) {
            Log.error("Incorrect URL... Please check and try again...", e);
            return null;
        }
    }

    /**
     * Get Android desired capabilities.
     *
     * @return DesiredCapabilities object for Android.
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    private static DesiredCapabilities getAndroidDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Properties androidProperties = getAndroidProperties();
        capabilities.setCapability("deviceName", androidProperties.getProperty("device.name")); // Use the device name from adb devices
        capabilities.setCapability("platformName", getProperties().getProperty("platform"));
        capabilities.setCapability("platformVersion", androidProperties.getProperty("platform.version"));
        capabilities.setCapability("automationName", "uiAutomator2");
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", androidProperties.getProperty("app.activity"));
        capabilities.setCapability("app", androidProperties.getProperty("app"));
        capabilities.setCapability("noReset", Boolean.parseBoolean(androidProperties.getProperty("no.reset"))); // Do not reset app state before this session
        capabilities.setCapability("autoGrantPermissions", Boolean.parseBoolean(androidProperties.getProperty("auto.grant.permissions"))); // Automatically grant permissions
        capabilities.setCapability("autoAcceptAlerts", Boolean.parseBoolean(androidProperties.getProperty("auto.accept.alerts"))); // Automatically accept alerts
        capabilities.setCapability("disableWindowAnimation", Boolean.parseBoolean(androidProperties.getProperty("disable.window.animation"))); // Disable window animations for faster testing
        capabilities.setCapability("disableAndroidWatchers", Boolean.parseBoolean(androidProperties.getProperty("disable.android.watchers"))); // Disable Android system event watchers
        capabilities.setCapability("ignoreUnimportantViews", Boolean.parseBoolean(androidProperties.getProperty("ignore.unimportant.views"))); // Ignore unimportant views to improve speed
        capabilities.setCapability("disableNotifications", Boolean.parseBoolean(androidProperties.getProperty("disable.notifications"))); // Disable notifications during test
        return capabilities;
    }

    /**
     * Get iOS desired capabilities.
     *
     * @return DesiredCapabilities object for iOS.
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    private static DesiredCapabilities getIosDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Properties iosProperties = getIosProperties();
        capabilities.setCapability("deviceName", iosProperties.getProperty("device.name")); // Use the device name from adb devices
        capabilities.setCapability("platformName", getProperties().getProperty("platform"));
        capabilities.setCapability("platformVersion", iosProperties.getProperty("platform.version"));
        capabilities.setCapability("automationName", "xcuitest");
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", iosProperties.getProperty("app.activity"));
        capabilities.setCapability("app", iosProperties.getProperty("app"));
        capabilities.setCapability("noReset", Boolean.parseBoolean(iosProperties.getProperty("no.reset"))); // Do not reset app state before this session
        capabilities.setCapability("autoGrantPermissions", Boolean.parseBoolean(iosProperties.getProperty("auto.grant.permissions"))); // Automatically grant permissions
        capabilities.setCapability("autoAcceptAlerts", Boolean.parseBoolean(iosProperties.getProperty("auto.accept.alerts"))); // Automatically accept alerts
        capabilities.setCapability("disableWindowAnimation", Boolean.parseBoolean(iosProperties.getProperty("disable.window.animation"))); // Disable window animations for faster testing
        capabilities.setCapability("disableAndroidWatchers", Boolean.parseBoolean(iosProperties.getProperty("disable.android.watchers"))); // Disable Android system event watchers
        capabilities.setCapability("ignoreUnimportantViews", Boolean.parseBoolean(iosProperties.getProperty("ignore.unimportant.views"))); // Ignore unimportant views to improve speed
        capabilities.setCapability("disableNotifications", Boolean.parseBoolean(iosProperties.getProperty("disable.notifications"))); // Disable notifications during test
        return capabilities;
    }

    /**
     * Get Android remote desired capabilities.
     *
     * @return MutableCapabilities object for Android remote execution.
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    private static MutableCapabilities getAndroidRemoteDesiredCapabilities() {
        Properties androidProperties = getAndroidProperties();
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", getProperties().getProperty("platform"));
        caps.setCapability("app", "storage:filename=" + androidProperties.getProperty("app.name"));
        caps.setCapability("deviceName", androidProperties.getProperty("device.name"));
        caps.setCapability("platformVersion", androidProperties.getProperty("platform.version"));
        caps.setCapability("automationName", "uiAutomator2");
        caps.setCapability("sauce:options", getSauceOptions());
        return caps;
    }

    /**
     * Get iOS remote desired capabilities.
     *
     * @return MutableCapabilities object for iOS remote execution.
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    private static MutableCapabilities getIosRemoteDesiredCapabilities() {
        Properties iosProperties = getIosProperties();
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", getProperties().getProperty("platform"));
        caps.setCapability("app", "storage:filename=" + iosProperties.getProperty("app.name"));  // The filename of the mobile app
        caps.setCapability("deviceName", iosProperties.getProperty("device.name"));
        caps.setCapability("platformVersion", iosProperties.getProperty("platform.version"));
        caps.setCapability("automationName", "xcuitest");
        caps.setCapability("sauce:options", getSauceOptions());
        return caps;
    }

    /**
     * Get Sauce Labs options.
     *
     * @return MutableCapabilities object for Sauce Labs options.
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    private static MutableCapabilities getSauceOptions() {
        Properties properties = getProperties();
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", properties.getProperty("sauce.labs.username"));
        sauceOptions.setCapability("accessKey", properties.getProperty("sauce.labs.access.key"));
        sauceOptions.setCapability("build", properties.getProperty("sauce.labs.build"));
        sauceOptions.setCapability("name", properties.getProperty("sauce.labs.name"));
        sauceOptions.setCapability("deviceOrientation", properties.getProperty("sauce.labs.device.orientation"));
        return sauceOptions;
    }
}
