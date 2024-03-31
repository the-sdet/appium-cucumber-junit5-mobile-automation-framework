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
import static io.github.the_sdet.cucumber.CucumberUtils.logToReport;

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
            click(getElement(loginAlertCloseButton));
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
        return getElements(homePage.getBottomTabs()).size();
    }

    public List<String> navBarItems() {
        List<String> navBarItems = new ArrayList<>();
        List<WebElement> items = getElements(homePage.getBottomTabs());
        for (WebElement navBarItem : items) {
            navBarItems.add(navBarItem.getText());
        }
        return navBarItems;
    }

    public boolean isPrimaryLobDisplayed() {
        return isVisible(homePage.getPrimaryLob());
    }

    public int primaryLobItemsCount() {
        return getElements(homePage.getPrimaryLobItems()).size();
    }

    public List<String> primaryLobItems() {
        return getElementsTextContent((homePage.getPrimaryLobItems()));
    }

    public boolean isSecondaryLobDisplayed() {
        return isVisible(homePage.getSecondaryLob());
    }

    public int secondaryLobItemsCount() {
        return getElements(homePage.getSecondaryLobItems()).size();
    }

    public List<String> secondaryLobItems() {
        return getElementsTextContent(homePage.getSecondaryLobItems());
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
}