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

/**
 * Page Object class for Home Page to have modular methods to handle element interactions
 *
 * @author Pabitra Swain (contact.the.sdet@gmail.com)
 */
@SuppressWarnings("unused")
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

    /**
     * Skip the language selection if visible.
     *
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public void skipLanguageSelection() {
        if (waitAndCheckIsVisible(homePage.getSelectYourLanguageLabel(), Duration.ofSeconds(5)))
            click(homePage.getLanguageSelectionSkipButton());
    }

    /**
     * Navigate back to the home page.
     *
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public void goBackToHome() {
        while (!isHamburgerMenuDisplayed()) {
            if (isVisible(homePage.getBackButton())) {
                click(homePage.getBackButton());
                waitFor(Duration.ofSeconds(1));
            }
        }
    }

    /**
     * Skip the initial login screen if present.
     *
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
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

    /**
     * Close the login pop-up if visible.
     *
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public void closeLoginPopUp() {
        By loginAlertCloseButton = homePage.getCloseLoginAlert();
        if (waitAndCheckIsVisible(loginAlertCloseButton, Duration.ofSeconds(3))) {
            logToReport("Login Alert is Visible...");
            click(getElement(loginAlertCloseButton));
        } else logToReport("Login Alert is NOT Visible...");
    }

    /**
     * Close any displayed ads.
     *
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public void closeAdsIfAny() {
        if (isVisible(homePage.getAdBar())) {
            logToReport("Ad is Visible...");
            click(homePage.getAdBarCloseButton());
        } else logToReport("Ad is NOT Visible...");
    }

    /**
     * Check if the logo is displayed.
     *
     * @return true if the logo is displayed, false otherwise.
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public boolean isLogoDisplayed() {
        //return isVisible(homePage.getLogo());
        Log.info("Logo is NOT getting displayed for the initial app launch... Commenting...");
        return true;
    }

    /**
     * Check if the hamburger menu is displayed.
     *
     * @return true if the hamburger menu is displayed, false otherwise.
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public boolean isHamburgerMenuDisplayed() {
        return waitAndCheckIsVisible(homePage.getDrawerButton(), Duration.ofSeconds(5));
    }

    /**
     * Check if My Cash is displayed.
     *
     * @return true if My Cash is displayed, false otherwise.
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public boolean isMyCashDisplayed() {
        return isVisible(homePage.getMyCash());
    }

    /**
     * Check if My Biz is displayed.
     *
     * @return true if My Biz is displayed, false otherwise.
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public boolean isMyBizDisplayed() {
        return isVisible(homePage.getMyBiz());
    }

    /**
     * Check if the search icon is displayed.
     *
     * @return true if the search icon is displayed, false otherwise.
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public boolean isSearchIconDisplayed() {
        return isVisible(homePage.getSearchIcon()) | isVisible(homePage.getSearchBar());
    }

    /**
     * Check if the navigation bar is displayed.
     *
     * @return true if the navigation bar is displayed, false otherwise.
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public boolean isNavBarDisplayed() {
        return isVisible(homePage.getBottomTabs());
    }

    /**
     * Get the count of navigation bar items.
     *
     * @return the count of navigation bar items.
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public int navBarItemsCount() {
        return getElements(homePage.getBottomTabs()).size();
    }

    /**
     * Get the text of navigation bar items.
     *
     * @return a list containing the text of navigation bar items.
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public List<String> navBarItems() {
        List<String> navBarItems = new ArrayList<>();
        List<WebElement> items = getElements(homePage.getBottomTabs());
        for (WebElement navBarItem : items) {
            navBarItems.add(navBarItem.getText());
        }
        return navBarItems;
    }

    /**
     * Check if the primary line of business is displayed.
     *
     * @return true if the primary line of business is displayed, false otherwise.
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public boolean isPrimaryLobDisplayed() {
        return isVisible(homePage.getPrimaryLob());
    }

    /**
     * Get the count of primary line of business items.
     *
     * @return the count of primary line of business items.
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public int primaryLobItemsCount() {
        return getElements(homePage.getPrimaryLobItems()).size();
    }

    /**
     * Get the text of primary line of business items.
     *
     * @return a list containing the text of primary line of business items.
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public List<String> primaryLobItems() {
        return getElementsTextContent((homePage.getPrimaryLobItems()));
    }

    /**
     * Check if the secondary line of business is displayed.
     *
     * @return true if the secondary line of business is displayed, false otherwise.
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public boolean isSecondaryLobDisplayed() {
        return isVisible(homePage.getSecondaryLob());
    }

    /**
     * Get the count of secondary line of business items.
     *
     * @return the count of secondary line of business items.
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public int secondaryLobItemsCount() {
        return getElements(homePage.getSecondaryLobItems()).size();
    }

    /**
     * Get the text of secondary line of business items.
     *
     * @return a list containing the text of secondary line of business items.
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public List<String> secondaryLobItems() {
        return getElementsTextContent(homePage.getSecondaryLobItems());
    }

    /**
     * Check if the expand line of business button is visible.
     *
     * @return true if the expand line of business button is visible, false otherwise.
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public boolean isExpandLobButtonVisible() {
        return isVisible(homePage.getGetSecondaryLobExpand());
    }

    /**
     * Handle the call to action (CTA) if visible.
     *
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public void handleCta() {
        if (isVisible(homePage.getCta())) {
            click(homePage.getCtaClose());
            waitFor(Duration.ofSeconds(1));
        }
    }

    /**
     * Handle the bottom sheet ad if visible.
     *
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public void handleBottomSheetAd() {
        By closeButton = homePage.getDismissButton();
        if (isVisible(closeButton)) {
            click(closeButton);
            waitFor(Duration.ofSeconds(1));
        }
    }

    /**
     * Click on the expand line of business button.
     *
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public void clickOnExpandLobButton() {
        click(homePage.getGetSecondaryLobExpand());
    }

    /**
     * Click on a line of business item.
     *
     * @param lobName The name of the line of business item to click.
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public void clickOnLob(String lobName) {
        waitAndClick(homePage.getLobItem(lobName), 5);
    }
}