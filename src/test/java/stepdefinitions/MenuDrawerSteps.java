package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.pageobjects.MenuPage;

import java.util.List;

import static engine.Engine.getDriver;
import static io.github.the_sdet.cucumber.CucumberUtils.logToReport;

/**
 * Step Definitions for Menu Drawer Tests
 *
 * @author Pabitra Swain (contact.the.sdet@gmail.com)
 */
public class MenuDrawerSteps {
    MenuPage menuPage = new MenuPage(getDriver());

    @And("User clicks on the Hamburger Menu Icon")
    public void userClicksOnTheHamburgerMenuIcon() {
        menuPage.clickOnHamburgerMenu();
    }

    @Then("App Drawer should be opened")
    public void appDrawerShouldBeOpened() {
        Assert.assertTrue("App Drawer is still NOT Open...", menuPage.isMenuDrawerDisplayed());
        Assert.assertFalse("Hamburger Menu is still Displayed...", menuPage.isHamburgerMenuDisplayed());
    }

    @And("User swipes left on App Drawer")
    public void userSwipesLeftOnAppDrawer() {
        menuPage.closeMenuDrawer();
    }

    @Then("App Drawer should closed")
    public void appDrawerShouldClosed() {
        Assert.assertFalse("App Drawer is still Open...", menuPage.isMenuDrawerDisplayed());
        Assert.assertTrue("Hamburger Menu is still NOT Displayed...", menuPage.isHamburgerMenuDisplayed());
    }

    @And("Login and Signup Now Should be displayed")
    public void loginAndSignupNowShouldBeDisplayed() {
        Assert.assertTrue("Login and Signup Now is NOT Displayed...", menuPage.isLoginSignUpButtonDisplayed());
    }

    @And("Below Items should be present as Icons")
    public void belowItemsShouldBePresentAsIcons(DataTable items) {
        Assert.assertEquals("Drawer Items Mismatch...", items.asList(), menuPage.drawerPrimaryItems());
    }

    @And("{string} section should be available")
    public void sectionShouldBeAvailable(String sectionName) {
        Assert.assertTrue("Section " + sectionName + " is NOT displayed...",
                menuPage.isSectionDisplayedOnMenuDrawer(sectionName));
    }

    @And("{string} section should have below {int} items in it")
    public void sectionShouldHaveBelowItemsInIt(String sectionName, int itemCount, DataTable items) {
        List<String> actualItems = menuPage.getItemsUnderSection(sectionName);
        logToReport("Items found for Section " + sectionName + ": " + actualItems.toString());
        Assert.assertEquals("Item Count Mismatch...", itemCount, actualItems.size());
        Assert.assertEquals("Item Mismatch...", items.asList(), actualItems);
    }

    @And("{string} should be present at the bottom of the Menu Drawer")
    public void shouldBePresentAtTheBottomOfTheMenuDrawer(String item) {
        Assert.assertTrue(item + " is NOT displayed...", menuPage.verifyMenuDrawerBottom(item));
    }

    @And("App Version should be {string}")
    public void appVersionShouldBe(String appVersion) {
        Assert.assertEquals("App Version Mismatch...", appVersion, menuPage.getAppVersion());
    }
}
