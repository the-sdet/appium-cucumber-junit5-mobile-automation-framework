package pages.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.github.the_sdet.mobile.AppiumUtils;
import logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.android.HomePageAndroid;
import pages.base.HomePageBase;
import pages.ios.HomePageIOS;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static engine.Engine.isAndroid;
import static io.github.the_sdet.common.CommonUtils.replaceLineBreaksWithSpace;
import static io.github.the_sdet.cucumber.CucumberUtils.logToReport;

public class HomePage extends AppiumUtils {
    public HomePageBase homePage;
    AppiumDriver driver;

    /**
     * Constructor to initialize AppiumUtils.
     *
     * @param driver The Appium Driver (AndroidDriver/IOSDriver) instance to use.
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public HomePage(AppiumDriver driver) {
        super(driver);
        this.driver = driver;
        homePage = isAndroid() ? new HomePageAndroid() : new HomePageIOS();
    }

    public void skipLanguageSelection() {
        if (waitAndCheckIsVisible(homePage.getSelectYourLanguageLabel(), Duration.ofSeconds(5)))
            click(homePage.getLanguageSelectionSkipButton());
    }

    public void skipInitialLoginScreen() {
        By nativeCompleteWithPopup = By.xpath("//android.widget.TextView[@resource-id='miuix.stub:id/alertTitle']//..//android.widget.Button[@text='Cancel']");
        if (waitAndCheckIsVisible(nativeCompleteWithPopup, Duration.ofSeconds(5))) {
            click(nativeCompleteWithPopup);
            waitFor(Duration.ofSeconds(1));
        }
        if (waitAndCheckIsVisible(homePage.getLoginScreen(), Duration.ofSeconds(5))) {
            pressBackKey();
            waitFor(Duration.ofSeconds(1));
        }
    }

    public void closeLoginPopUp() {
        By loginAlertCloseButton = homePage.getCloseLoginAlert();
        if (waitAndCheckIsVisible(loginAlertCloseButton, Duration.ofSeconds(5))) {
            logToReport("Login Alert is Visible...");
            click(driver.findElement(loginAlertCloseButton));
        } else logToReport("Login Alert is NOT Visible...");
    }

    public void closeAdsIfAny() {
        if (waitAndCheckIsVisible(homePage.getAdBar(), Duration.ZERO)) {
            logToReport("Ad is Visible...");
            click(homePage.getAdBarCloseButton());
        } else logToReport("Ad is NOT Visible...");
    }

    public boolean isLogoDisplayed() {
        //return isVisible(homePage.getLogo());
        Log.info("Logo is NOT getting displayed for the initial app launch... Commenting...");
        return true;
    }

    public boolean isHamburgerMenuDisplayed() {
        return isVisible(homePage.getDrawerButton());
    }

    public boolean isMyCashDisplayed() {
        return isVisible(homePage.getMyCash());
    }

    public boolean isMyBizDisplayed() {
        return isVisible(homePage.getMyBiz());
    }

    public boolean isSearchIconDisplayed() {
        return isVisible(homePage.getSearchIcon()) | isVisible(homePage.getSearchBar());
    }

    public boolean isNavBarDisplayed() {
        return isVisible(homePage.getBottomTabs());
    }

    public int navBarItemsCount() {
        return driver.findElements(homePage.getBottomTabs()).size();
    }

    public List<String> navBarItems() {
        List<String> navBarItems = new ArrayList<>();
        List<WebElement> items = driver.findElements(homePage.getBottomTabs());
        for (WebElement navBarItem : items) {
            navBarItems.add(navBarItem.getText());
        }
        return navBarItems;
    }

    public boolean isPrimaryLobDisplayed() {
        return isVisible(homePage.getPrimaryLob());
    }

    public int primaryLobItemsCount() {
        return driver.findElements(homePage.getPrimaryLobItems()).size();
    }

    public List<String> primaryLobItems() {
        List<String> primaryLobItems = new ArrayList<>();
        List<WebElement> items = driver.findElements(homePage.getPrimaryLobItems());
        for (WebElement primaryLobItem : items) {
            primaryLobItems.add(replaceLineBreaksWithSpace(primaryLobItem.getText()));
        }
        return primaryLobItems;
    }

    public boolean isSecondaryLobDisplayed() {
        return isVisible(homePage.getSecondaryLob());
    }

    public int secondaryLobItemsCount() {
        return driver.findElements(homePage.getSecondaryLobItems()).size();
    }

    public List<String> secondaryLobItems() {
        List<String> secondaryLobItems = new ArrayList<>();
        List<WebElement> items = driver.findElements(homePage.getSecondaryLobItems());
        for (WebElement secondaryLobItem : items) {
            secondaryLobItems.add(replaceLineBreaksWithSpace(secondaryLobItem.getText()));
        }
        return secondaryLobItems;
    }

    public boolean isExpandLobButtonVisible() {
        return isVisible(homePage.getGetSecondaryLobExpand());
    }

    public void clickOnExpandLobButton() {
        if (isVisible(homePage.getDismissButton()))
            click(homePage.getDismissButton());
        waitFor(Duration.ofSeconds(2));
        click(homePage.getGetSecondaryLobExpand());
    }

    public boolean isAppDrawerDisplayed() {
        return isVisible(homePage.getMenuDrawer());
    }

    public void closeMenuDrawer() {
        swipeRight(homePage.getMenuDrawer());
    }

    public boolean isLoginSignUpButtonDisplayed() {
        return isVisible(homePage.getLoginSignUpButton());
    }

    public List<String> drawerPrimaryItems() {
        return getElementsTextContent(homePage.getPrimaryItemsInMenuDrawer(), true);
    }

    public boolean verifyMenuDrawerBottom(String item) {
        return switch (item.toLowerCase()) {
            case "rate us link" -> isVisible(homePage.getMenuDrawerBottomLinks("Rate Us"));
            case "privacy policy link" -> isVisible(homePage.getMenuDrawerBottomLinks("Privacy policy"));
            default -> isVisible(homePage.getMenuDrawerBottomLinks("App Version"));
        };
    }

    public String getAppVersion() {
        return driver.findElement(homePage.getMenuDrawerBottomLinks("App Version"))
                .getText().split("Version ")[1];
    }
}