package stepdefinitions;

import io.cucumber.java.en.Given;
import pages.pageobjects.FlightsPage;

import static engine.Engine.getDriver;

public class FlightsPageSteps {
    FlightsPage flightsPage = new FlightsPage(getDriver());

    @Given("User is on MakeMyTrip Flights Page")
    public void userIsOnMakeMyTripFlightsPage() {

    }
}
