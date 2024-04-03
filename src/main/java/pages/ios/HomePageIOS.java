package pages.ios;

import org.openqa.selenium.By;
import pages.base.HomePageBase;

import static gobalconstants.constants.EMPTY_STRING;
import static io.github.the_sdet.web.Utils.customizeXpath;
/**
 * Class to maintain elements of Home page for IOS
 *
 * @author Pabitra Swain (contact.the.sdet@gmail.com)
 */
@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class HomePageIOS extends HomePageBase {
    private final String selectYourLanguageLabel = EMPTY_STRING;
    private final String continueButton = EMPTY_STRING;
    private final String languageSkipButton = EMPTY_STRING;
    private final String loginScreen = EMPTY_STRING;
    private final String dismissButton = EMPTY_STRING;
    private final String cta = EMPTY_STRING;
    private final String ctaClose = EMPTY_STRING;
    private final String completeActionUsingDevicePopUp = EMPTY_STRING;
    private final String continueWithEmail = EMPTY_STRING;
    private final String closeLoginAlert = EMPTY_STRING;
    private final String adBar = EMPTY_STRING;
    private final String adBarCloseButton = EMPTY_STRING;
    private final String adText = EMPTY_STRING;
    private final String drawerButton = EMPTY_STRING;
    private final String myCash = EMPTY_STRING;
    private final String myBiz = EMPTY_STRING;
    private final String searchIcon = EMPTY_STRING;
    private final String searchBar = EMPTY_STRING;
    private final String logo = EMPTY_STRING;
    private final String header = EMPTY_STRING;
    private final String subHeader = EMPTY_STRING;
    private final String primaryLob = EMPTY_STRING;
    private final String primaryLobItems = EMPTY_STRING;
    private final String primaryLobItem = EMPTY_STRING;
    private final String secondaryLob = EMPTY_STRING;
    private final String secondaryLobItems = EMPTY_STRING;
    private final String secondaryLobItem = EMPTY_STRING;
    private final String getSecondaryLobExpand = EMPTY_STRING;
    private final String lobItem = EMPTY_STRING;
    private final String HomeTab = EMPTY_STRING;
    private final String BottomTabs = EMPTY_STRING;
    private final String BottomTab = EMPTY_STRING;
    private final String backButton = EMPTY_STRING;

    @Override
    public By getSelectYourLanguageLabel() {
        return By.xpath(selectYourLanguageLabel);
    }

    @Override
    public By getContinueButton() {
        return By.xpath(continueButton);
    }

    @Override
    public By getLanguageSelectionSkipButton() {
        return By.id(languageSkipButton);
    }

    @Override
    public By getLoginScreen() {
        return By.xpath(loginScreen);
    }

    @Override
    public By getDismissButton() {
        return By.id(dismissButton);
    }
    @Override
    public By getCta() {
        return By.xpath(cta);
    }

    @Override
    public By getCtaClose() {
        return By.xpath(ctaClose);
    }
    @Override
    public By getCompleteActionUsingDevicePopUp() {
        return By.xpath(completeActionUsingDevicePopUp);
    }

    @Override
    public By getContinueWithEmail() {
        return By.xpath(continueWithEmail);
    }

    @Override
    public By getCloseLoginAlert() {
        return By.xpath(closeLoginAlert);
    }

    @Override
    public By getAdBar() {
        return By.id(adBar);
    }

    @Override
    public By getAdBarCloseButton() {
        return By.xpath(adBarCloseButton);
    }

    @Override
    public By getAdContent() {
        return By.id(adText);
    }

    @Override
    public By getDrawerButton() {
        return By.xpath(drawerButton);
    }

    @Override
    public By getMyCash() {
        return By.xpath(myCash);
    }

    @Override
    public By getMyBiz() {
        return By.xpath(myBiz);
    }

    @Override
    public By getSearchIcon() {
        return By.xpath(searchIcon);
    }

    @Override
    public By getSearchBar() {
        return By.id(searchBar);
    }

    @Override
    public By getMenuDrawer() {
        return null;
    }

    @Override
    public By getLoginSignUpButton() {
        return null;
    }

    @Override
    public By getPrimaryItemsInMenuDrawer() {
        return null;
    }

    @Override
    public By getMyTripsSection() {
        return null;
    }

    @Override
    public By getMyTripsItems() {
        return null;
    }

    @Override
    public By getRewardsSection() {
        return null;
    }

    @Override
    public By getRewardsItems() {
        return null;
    }

    @Override
    public By getSettingsSection() {
        return null;
    }

    @Override
    public By getSettingsItems() {
        return null;
    }

    @Override
    public By getMenuDrawerBottomLinks(String itemText) {
        return null;
    }

    @Override
    public By getLogo() {
        return By.id(logo);
    }

    @Override
    public By getHeader() {
        return By.id(header);
    }

    @Override
    public By getSubHeader() {
        return By.id(subHeader);
    }

    @Override
    public By getPrimaryLob() {
        return By.xpath(primaryLob);
    }

    @Override
    public By getPrimaryLobItems() {
        return By.xpath(primaryLobItems);
    }

    @Override
    public By getPrimaryLobItem(String lobName) {
        return By.xpath(customizeXpath(primaryLobItem, lobName));
    }

    @Override
    public By getSecondaryLob() {
        return By.xpath(secondaryLob);
    }

    @Override
    public By getSecondaryLobItems() {
        return By.xpath(secondaryLobItems);
    }

    @Override
    public By getSecondaryLobItem(String lobName) {
        return By.xpath(customizeXpath(secondaryLobItem, lobName));
    }

    @Override
    public By getLobItem(String lobName) {
        return By.xpath(customizeXpath(lobItem, lobName));
    }

    @Override
    public By getGetSecondaryLobExpand() {
        return By.xpath(getSecondaryLobExpand);
    }

    @Override
    public By getHomeTab() {
        return By.xpath(HomeTab);
    }

    @Override
    public By getBottomTabs() {
        return By.xpath(BottomTabs);
    }

    @Override
    public By getBottomTab() {
        return By.xpath(BottomTab);
    }

    @Override
    public By getBackButton() {
        return By.xpath(backButton);
    }
}