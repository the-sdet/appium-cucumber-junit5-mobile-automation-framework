package engine;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
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

@SuppressWarnings("unused")
public class Engine {
    static ThreadLocal<AppiumDriver> tlDriver = new ThreadLocal<>();
    private static AppiumDriverLocalService service;
    private static final String platform = getProperties().getProperty("platform").trim().toLowerCase();
    private static final String appPackage = isAndroid() ?
            getAndroidProperties().getProperty("app.package") : getIosProperties().getProperty("app.package");

    public static boolean isAndroid() {
        return platform.equals("android");
    }

    public static URL startAppiumServer() {
        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingAnyFreePort();

        // Start the Appium server
        service = AppiumDriverLocalService.buildService(builder);
        service.start();
        service.clearOutPutStreams();
        URL appiumserverUrl = service.getUrl();
        Log.info("Appium Server started at: " + appiumserverUrl);
        return appiumserverUrl;
    }

    public static void stopAppiumServer() {
        if (service != null && service.isRunning()) {
            service.stop();
            Log.info("Appium server stopped.");
        }
    }

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
        waitFor(Duration.ofSeconds(2));
        activateApp();
        waitFor(Duration.ofSeconds(2));
        tlDriver.set(driver);
    }

    public static AppiumDriver getDriver() {
        return tlDriver.get();
    }

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

    public static void activateApp() {
        AppiumDriver driver = tlDriver.get();
        if (driver instanceof AndroidDriver androidDriver) {
            String currentPackage = androidDriver.currentActivity();
            if (currentPackage == null || !currentPackage.equals(appPackage)) {
                androidDriver.activateApp(appPackage);
                Log.info("App Activated...");
            } else {
                Log.info("App is already active.");
            }
        } else {
            Log.error("This method is only applicable for AndroidDriver.");
        }
    }

    private static URL frameUrl(String url) {
        try {
            return new URL(url);
        } catch (MalformedURLException e) {
            Log.error("Incorrect URL... Please check and try again...", e);
            return null;
        }
    }

    private static DesiredCapabilities getAndroidDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Properties androidProperties = getAndroidProperties();
        capabilities.setCapability("deviceName", androidProperties.getProperty("device.name")); // Use the device name from adb devices
        capabilities.setCapability("platformName", getProperties().getProperty("platform"));
        capabilities.setCapability("platformVersion", androidProperties.getProperty("platform.version"));
        capabilities.setCapability("automationName", "uiAutomator2");
        capabilities.setCapability("appPackage", appPackage);
        //capabilities.setCapability("appActivity", androidProperties.getProperty("app.activity"));
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

    private static DesiredCapabilities getIosDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Properties iosProperties = getIosProperties();
        capabilities.setCapability("deviceName", iosProperties.getProperty("device.name")); // Use the device name from adb devices
        capabilities.setCapability("platformName", getProperties().getProperty("platform"));
        capabilities.setCapability("platformVersion", iosProperties.getProperty("platform.version"));
        capabilities.setCapability("automationName", "xcuitest");
        capabilities.setCapability("appPackage", appPackage);
        //capabilities.setCapability("appActivity", iosProperties.getProperty("app.activity"));
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
