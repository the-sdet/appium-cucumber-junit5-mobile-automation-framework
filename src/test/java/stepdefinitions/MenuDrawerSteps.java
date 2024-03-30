package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.pageobjects.HomePage;

import static engine.Engine.getDriver;

public class MenuDrawerSteps {
    HomePage homePage = new HomePage(getDriver());

    @And("User clicks on the Hamburger Menu Icon")
    public void userClicksOnTheHamburgerMenuIcon() {
    }

    @Then("App Drawer should be opened")
    public void appDrawerShouldBeOpened() {
        Assert.assertTrue("App Drawer is still NOT Open...", homePage.isAppDrawerDisplayed());
        Assert.assertFalse("Hamburger Menu is still Displayed...", homePage.isHamburgerMenuDisplayed());
    }

    @And("User swipes left on App Drawer")
    public void userSwipesLeftOnAppDrawer() {
        homePage.closeMenuDrawer();
    }

    @Then("App Drawer should closed")
    public void appDrawerShouldClosed() {
        Assert.assertFalse("App Drawer is still Open...", homePage.isAppDrawerDisplayed());
        Assert.assertTrue("Hamburger Menu is still NOT Displayed...", homePage.isHamburgerMenuDisplayed());
    }

    @And("Login and Signup Now Should be displayed")
    public void loginAndSignupNowShouldBeDisplayed() {
        Assert.assertTrue("Login and Signup Now is NOT Displayed...", homePage.isLoginSignUpButtonDisplayed());
    }

    @And("Below Items should be present as Icons")
    public void belowItemsShouldBePresentAsIcons(DataTable items) {
        Assert.assertEquals("Drawer Items Mismatch...", items.asList(), homePage.drawerPrimaryItems());
    }

    @And("{string} section should be available")
    public void sectionShouldBeAvailable(String sectionName) {
    }

    @And("{string} section should have below {int} items in it")
    public void sectionShouldHaveBelowItemsInIt(String sectionName, int itemCount, DataTable items) {
    }

    @And("{string} should be present at the bottom of the Menu Drawer")
    public void shouldBePresentAtTheBottomOfTheMenuDrawer(String item) {
        Assert.assertTrue(item + " is NOT displayed...", homePage.verifyMenuDrawerBottom(item));
    }

    @And("App Version should be {string}")
    public void appVersionShouldBe(String appVersion) {
        Assert.assertEquals("App Version Mismatch...", appVersion, homePage.getAppVersion());
    }
}
