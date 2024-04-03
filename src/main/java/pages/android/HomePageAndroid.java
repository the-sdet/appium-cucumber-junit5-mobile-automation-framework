package pages.android;

import org.openqa.selenium.By;
import pages.base.HomePageBase;

import static io.github.the_sdet.web.Utils.customizeXpath;

/**
 * Class to maintain elements of Home page for Android
 *
 * @author Pabitra Swain (contact.the.sdet@gmail.com)
 */
@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class HomePageAndroid extends HomePageBase {
    private final String selectYourLanguageLabel = "//android.widget.TextView[@text='Select your Language']";
    private final String continueButton = "//android.widget.Button[@resource-id='com.makemytrip:id/continueButton']";
    private final String languageSelectionSkipButton = "com.makemytrip:id/skipTextView";
    private final String loginScreen = "//android.widget.TextView[@text='Signup or Login ']";
    private final String dismissButton = "com.makemytrip:id/snack_bar_footer_left";
    private final String cta = "//android.widget.TextView[@resource-id='com.makemytrip:id/tv_right_cta']";
    private final String ctaClose = "//android.widget.ImageView[@resource-id='com.makemytrip:id/iv_close']";
    private final String completeActionUsingDevicePopUp = "//android.widget.TextView[@resource-id='android:id/title' and @text='Complete action using']";
    private final String continueWithEmail = "com.makemytrip:id/iv_changeToEmail";
    private final String closeLoginAlert = "com.makemytrip:id/back_key";
    private final String adBar = "com.makemytrip:id/rl_ad_bar";
    private final String adBarCloseButton = "//android.widget.ImageView[@resource-id='com.makemytrip:id/iv_cross']";
    private final String adContent = "com.makemytrip:id/tv_ad_text";
    private final String drawerButton = "com.makemytrip:id/iv_drawer";
    private final String logo = "com.makemytrip:id/iv_mmt_icon";
    private final String header = "com.makemytrip:id/tvHeader";
    private final String subHeader = "com.makemytrip:id/tvSubHeader";
    private final String myCash = "com.makemytrip:id/tv_mycash_text";
    private final String myBiz = "com.makemytrip:id/tv_mybiz_text";
    private final String searchIcon = "com.makemytrip:id/iv_universal_search_icon";
    private final String searchBar = "com.makemytrip:id/universal_search";
    private final String menuDrawer = "com.makemytrip:id/nav_view";
    private final String loginSignUpButton = "//android.widget.Button[@text='Login/Sign-up now Login for best deals & offers']";
    private final String primaryItemsInMenuDrawer = "//android.widget.Button[contains(@resource-id,'com.makemytrip:id/item')]";
    private final String myTripsSection = "//android.widget.TextView[@resource-id='com.makemytrip:id/tv_title' and @text='My Trips']";
    private final String myTripsItems = "//android.widget.TextView[@text='My Trips']/following-sibling::android.widget.Button";
    private final String rewardsSection = "//android.widget.TextView[@resource-id='com.makemytrip:id/tv_title' and @text='Rewards']";
    private final String rewardsItems = "//android.widget.TextView[@text='Rewards']/following-sibling::android.widget.Button";
    private final String settingsSection = "//android.widget.TextView[@resource-id='com.makemytrip:id/tv_title' and @text='Settings']";
    private final String settingsItems = "//android.widget.TextView[@text='Settings']/following-sibling::android.widget.Button";
    private final String menuDrawerBottomLinks = "//android.widget.Button[contains(@text,'v1')] | //android.widget.TextView[contains(@text,'v1')]";
    private final String primaryLob = "com.makemytrip:id/primaryLob";
    private final String primaryLobItems = "//android.view.ViewGroup[@resource-id='com.makemytrip:id/primaryLob']//android.widget.Button";
    private final String primaryLobItem = "//android.view.ViewGroup[@resource-id='com.makemytrip:id/primaryLob']//android.widget.Button[@text='v1']";
    private final String secondaryLob = "com.makemytrip:id/secondaryLob";
    private final String secondaryLobItems = "//android.view.ViewGroup[@resource-id='com.makemytrip:id/secondaryLob']//android.widget.Button";
    private final String secondaryLobItem = "//android.view.ViewGroup[@resource-id='com.makemytrip:id/secondaryLob']//android.widget.Button[@text='v1']";
    private final String lobItem = "//android.view.ViewGroup[contains(@resource-id,'Lob')]//android.widget.Button[@text='v1']";
    private final String getSecondaryLobExpand = "//android.view.ViewGroup[contains(@resource-id,'secondaryLob')]//*[contains(@resource-id,'ll_more_container')]";
    private final String HomeTab = "//android.widget.Button[@resource-id='com.makemytrip:id/rl_images' and @text='Home']";
    private final String BottomTabs = "//android.widget.Button[@resource-id='com.makemytrip:id/rl_images' and contains(@text,'')]";
    private final String BottomTab = "//android.widget.Button[@resource-id='com.makemytrip:id/rl_images' and contains(@text,'v1')]";
    private final String backButton = "//android.widget.ImageButton[@resource-id='com.makemytrip:id/ib_back']";

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
        return By.id(languageSelectionSkipButton);
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
        return By.id(continueWithEmail);
    }

    @Override
    public By getCloseLoginAlert() {
        return By.id(closeLoginAlert);
    }

    public By getClose() {
        return By.id(closeLoginAlert);
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
        return By.id(adContent);
    }

    @Override
    public By getDrawerButton() {
        return By.id(drawerButton);
    }

    @Override
    public By getMyCash() {
        return By.id(myCash);
    }

    @Override
    public By getMyBiz() {
        return By.id(myBiz);
    }

    @Override
    public By getSearchIcon() {
        return By.id(searchIcon);
    }

    @Override
    public By getSearchBar() {
        return By.id(searchBar);
    }

    @Override
    public By getMenuDrawer() {
        return By.id(menuDrawer);
    }

    @Override
    public By getLoginSignUpButton() {
        return By.xpath(loginSignUpButton);
    }

    @Override
    public By getPrimaryItemsInMenuDrawer() {
        return By.xpath(primaryItemsInMenuDrawer);
    }

    @Override
    public By getMyTripsSection() {
        return By.xpath(myTripsSection);
    }

    @Override
    public By getMyTripsItems() {
        return By.xpath(myTripsItems);
    }

    @Override
    public By getRewardsSection() {
        return By.xpath(rewardsSection);
    }

    @Override
    public By getRewardsItems() {
        return By.xpath(rewardsItems);
    }

    @Override
    public By getSettingsSection() {
        return By.xpath(settingsSection);
    }

    @Override
    public By getSettingsItems() {
        return By.xpath(settingsItems);
    }

    @Override
    public By getMenuDrawerBottomLinks(String itemText) {
        return By.xpath(menuDrawerBottomLinks.replace("v1", itemText));
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
        return By.id(primaryLob);
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
        return By.id(secondaryLob);
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