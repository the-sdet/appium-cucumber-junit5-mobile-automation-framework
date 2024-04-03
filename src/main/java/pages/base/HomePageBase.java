package pages.base;

import org.openqa.selenium.By;

/**
 * Class to maintain abstract methods for of Home page Elements,
 * so that Android and IOS both have the same methods
 *
 * @author Pabitra Swain (contact.the.sdet@gmail.com)
 */
@SuppressWarnings({"FieldCanBeLocal", "unused"})
public abstract class HomePageBase {

    public abstract By getSelectYourLanguageLabel();

    public abstract By getContinueButton();

    public abstract By getLanguageSelectionSkipButton();

    public abstract By getLoginScreen();

    public abstract By getDismissButton();
    public abstract By getCta();
    public abstract By getCtaClose();

    public abstract By getCompleteActionUsingDevicePopUp();

    public abstract By getContinueWithEmail();

    public abstract By getCloseLoginAlert();

    public abstract By getAdBar();

    public abstract By getAdBarCloseButton();

    public abstract By getAdContent();

    public abstract By getDrawerButton();

    public abstract By getMyCash();

    public abstract By getMyBiz();

    public abstract By getSearchIcon();

    public abstract By getSearchBar();

    public abstract By getMenuDrawer();

    public abstract By getLoginSignUpButton();

    public abstract By getPrimaryItemsInMenuDrawer();

    public abstract By getMyTripsSection();

    public abstract By getMyTripsItems();

    public abstract By getRewardsSection();

    public abstract By getRewardsItems();

    public abstract By getSettingsSection();

    public abstract By getSettingsItems();

    public abstract By getMenuDrawerBottomLinks(String itemText);

    public abstract By getLogo();

    public abstract By getHeader();

    public abstract By getSubHeader();

    public abstract By getPrimaryLob();

    public abstract By getPrimaryLobItems();

    public abstract By getPrimaryLobItem(String lobName);

    public abstract By getSecondaryLob();

    public abstract By getSecondaryLobItems();

    public abstract By getSecondaryLobItem(String lobName);

    public abstract By getLobItem(String lobName);

    public abstract By getGetSecondaryLobExpand();

    public abstract By getHomeTab();

    public abstract By getBottomTabs();

    public abstract By getBottomTab();

    public abstract By getBackButton();
}