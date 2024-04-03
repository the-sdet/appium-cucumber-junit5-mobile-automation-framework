package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.pageobjects.HomePage;

import static engine.Engine.getDriver;

/**
 * Step Definitions for Home Page Tests
 *
 * @author Pabitra Swain (contact.the.sdet@gmail.com)
 */
public class HomePageSteps {
    HomePage homePage = new HomePage(getDriver());

    public static boolean isFirstScenario = true;

    @Given("User skips language selection and login screen")
    public void userSkipsLanguageSelectionAndLoginScreen() {
        //Background is needed only for first scenario.
        if (isFirstScenario) {
            homePage.skipLanguageSelection();
            homePage.skipInitialLoginScreen();
            isFirstScenario = false;
        }
    }

    @And("User closes Login Popup and Ads if any")
    public void userClosesLoginPopupAndAdsIfAny() {
        homePage.closeLoginPopUp();
        homePage.closeAdsIfAny();
        homePage.handleBottomSheetAd();
        homePage.handleCta();
    }

    @Then("User should see the Hamburger Menu Icon at top left")
    public void userShouldSeeTheHamburgerMenuIconAtTopLeft() {
        Assert.assertTrue(homePage.isHamburgerMenuDisplayed());
    }

    @And("Logo should be displayed right to the Hamburger Menu Icon at top left")
    public void logoShouldBeDisplayedRightToTheHamburgerMenuIconAtTopLeft() {
        Assert.assertTrue(homePage.isLogoDisplayed());
    }

    @And("MyBiz button should be displayed at the top right")
    public void myBizButtonShouldBeDisplayedAtTheTopRight() {
        Assert.assertTrue(homePage.isMyBizDisplayed());
    }

    @And("MyCash button should be displayed left to MyBiz")
    public void myCashButtonShouldBeDisplayedLeftToMyBiz() {
        Assert.assertTrue(homePage.isMyCashDisplayed());
    }

    @And("Search Icon/Bar should be displayed")
    public void searchIconShouldBeDisplayed() {
        Assert.assertTrue(homePage.isSearchIconDisplayed());
    }

    @Then("User is able to see the Nav Bar")
    public void userIsAbleToSeeTheNavBar() {
        Assert.assertTrue(homePage.isNavBarDisplayed());
    }

    @Then("Nav bar should have {int} options")
    public void navBarShouldHaveOptions(int expectedNavBarItemCount) {
        Assert.assertEquals("Nav Bar Items Count Mismatch...", expectedNavBarItemCount, homePage.navBarItemsCount());
    }

    @And("Nav bar should have below options")
    public void navBarShouldHaveBelowOptions(DataTable navBars) {
        Assert.assertEquals("Nav Bar Items Mismatch...", navBars.asList(), homePage.navBarItems());
    }

    @Then("User is able to see the primary LOBs")
    public void userIsAbleToSeeThePrimaryLOBs() {
        Assert.assertTrue("Primary LOB NOT found...", homePage.isPrimaryLobDisplayed());
    }

    @Then("Primary LOBs should have {int} options")
    public void primaryLOBsShouldHaveOptions(int expectedLobItemCount) {
        Assert.assertEquals("Primary LOB Items Count Mismatch...", expectedLobItemCount, homePage.primaryLobItemsCount());
    }

    @And("Primary LOBs should have below options")
    public void primaryLOBsShouldHaveBelowOptions(DataTable primaryLobItems) {
        Assert.assertEquals("Primary LOB Items Mismatch...", primaryLobItems.asList(), homePage.primaryLobItems());
    }

    @Then("User is able to see the secondary LOBs")
    public void userIsAbleToSeeTheSecondaryLOBs() {
        Assert.assertTrue("Secondary LOB NOT found...", homePage.isSecondaryLobDisplayed());
    }

    @Then("Secondary LOBs should have {int} options")
    public void secondaryLOBsShouldHaveOptions(int expectedLobItemCount) {
        Assert.assertEquals("Secondary LOB Items Count Mismatch...", expectedLobItemCount, homePage.secondaryLobItemsCount());
    }

    @And("Secondary LOBs should have below options")
    public void secondaryLOBsShouldHaveBelowOptions(DataTable secondaryLobItems) {
        Assert.assertEquals("Secondary LOB Items Mismatch...", secondaryLobItems.asList(), homePage.secondaryLobItems());
    }

    @Then("User is able to see expand button below the secondary LOBs")
    public void userIsAbleToSeeExpandButtonBelowTheSecondaryLOBs() {
        Assert.assertTrue("Expand LOB button is NOT found...", homePage.isExpandLobButtonVisible());
    }

    @And("User clicks on expand button below the secondary LOBs")
    public void userClicksOnExpandButtonBelowTheSecondaryLOBs() {
        homePage.clickOnExpandLobButton();
    }

    @And("Secondary LOBs after expanding should have below options")
    public void secondaryLOBsAfterExpandingShouldHaveBelowOptions(DataTable secondaryLobItems) {
        Assert.assertEquals("Secondary LOB Items Mismatch after Expanding...", secondaryLobItems.asList(), homePage.secondaryLobItems());
    }
}
