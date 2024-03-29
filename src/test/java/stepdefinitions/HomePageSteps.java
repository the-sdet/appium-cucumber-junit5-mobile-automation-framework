package stepdefinitions;

import io.cucumber.java.en.Given;
import pages.pageobjects.FlightsPage;
import pages.pageobjects.HomePage;

import static engine.Engine.getDriver;

public class HomePageSteps {

    HomePage homePage = new HomePage(getDriver());
    FlightsPage flightsPage = new FlightsPage(getDriver());

    @Given("User is on MakeMyTrip Home Page")
    public void userIsOnMakeMyTripHomePage() {
        homePage.testMethod();
    }

    @Given("User is on MakeMyTrip Flights Page")
    public void userIsOnMakeMyTripFlightsPage() {
        flightsPage.testMethod();
    }
}
