package pages.pageobjects;

import io.appium.java_client.AppiumDriver;

import java.util.List;

public class MenuPage extends HomePage {
    /**
     * Constructor to initialize AppiumUtils.
     *
     * @param driver The Appium Driver (AndroidDriver/IOSDriver) instance to use.
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public MenuPage(AppiumDriver driver) {
        super(driver);
    }

    public void clickOnHamburgerMenu() {
        click(homePage.getDrawerButton());
    }


    public boolean isMenuDrawerDisplayed() {
        return isVisible(homePage.getMenuDrawer());
    }

    public void closeMenuDrawer() {
        swipeLeft(homePage.getMenuDrawer());
    }

    public boolean isLoginSignUpButtonDisplayed() {
        return isVisible(homePage.getLoginSignUpButton());
    }

    public List<String> drawerPrimaryItems() {
        return getElementsTextContent(homePage.getPrimaryItemsInMenuDrawer(), true);
    }

    public boolean isSectionDisplayedOnMenuDrawer(String section) {
        switch (section.toLowerCase()) {
            case "my trips":
                return isVisible(homePage.getMyTripsSection());
            case "rewards":
                return isVisible(homePage.getRewardsSection());
            case "settings":
                return isVisible(homePage.getSettingsSection());
            default:
                throw new IllegalArgumentException("Invalid section: " + section);
        }
    }

    public List<String> getItemsUnderSection(String sectionName) {
        switch (sectionName.toLowerCase()) {
            case "my trips":
                return getElementsTextContent(homePage.getMyTripsItems());
            case "rewards":
                return getElementsTextContent(homePage.getRewardsItems());
            case "settings":
                return getElementsTextContent(homePage.getSettingsItems());
            default:
                throw new IllegalArgumentException("Invalid section: " + sectionName);
        }
    }

    public boolean verifyMenuDrawerBottom(String item) {
        switch (item.toLowerCase()) {
            case "rate us link":
                return isVisible(homePage.getMenuDrawerBottomLinks("Rate Us"));
            case "privacy policy link":
                return isVisible(homePage.getMenuDrawerBottomLinks("Privacy Policy"));
            case "app version":
                return isVisible(homePage.getMenuDrawerBottomLinks("App Version"));
            default:
                throw new IllegalArgumentException("Invalid Item: " + item);
        }
    }

    public String getAppVersion() {
        return getElement(homePage.getMenuDrawerBottomLinks("App Version"))
                .getText().split("Version ")[1];
    }
}
