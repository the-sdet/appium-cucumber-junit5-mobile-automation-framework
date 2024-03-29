package pages.ios;

import org.openqa.selenium.By;
import pages.base.HomePageBase;

import static gobal_constants.constants.EMPTY_STRING;

@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class HomePageIOS extends HomePageBase {
    private final String selectYourLanguageLabel = EMPTY_STRING;
    private final String continueButton = EMPTY_STRING;
    private final String completeActionUsingDevicePopUp = EMPTY_STRING;
    private final String continueWithEmail = EMPTY_STRING;
    private final String closeLoginAlert = EMPTY_STRING;
    private final String drawerButton = EMPTY_STRING;
    private final String myCash = EMPTY_STRING;
    private final String myBiz = EMPTY_STRING;
    private final String searchBar = EMPTY_STRING;
    private final String primaryLob = EMPTY_STRING;
    private final String primaryLobItems = EMPTY_STRING;
    private final String primaryLobItem = EMPTY_STRING;
    private final String secondaryLob = EMPTY_STRING;
    private final String secondaryLobItems = EMPTY_STRING;
    private final String secondaryLobItem = EMPTY_STRING;
    private final String getSecondaryLobExpand = EMPTY_STRING;
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
    public By getSearchBar() {
        return By.xpath(searchBar);
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
    public By getPrimaryLobItem() {
        return By.xpath(primaryLobItem);
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
    public By getSecondaryLobItem() {
        return By.xpath(secondaryLobItem);
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