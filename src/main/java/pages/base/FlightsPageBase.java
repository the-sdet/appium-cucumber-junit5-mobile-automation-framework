package pages.base;

import org.openqa.selenium.By;

/**
 * Class to maintain abstract methods for of Flights page Elements,
 * so that Android and IOS both have the same methods
 *
 * @author Pabitra Swain (contact.the.sdet@gmail.com)
 */
@SuppressWarnings({"FieldCanBeLocal", "unused"})
public abstract class FlightsPageBase {
    public abstract By getFlightsHeader();

    public abstract By getBackButton();

    public abstract By getTab(String tabName);

    public abstract By getFrom();

    public abstract By getFromSelectedCity();

    public abstract By getFromSelectedCityCode();

    public abstract By getFromSelectedAirport();

    public abstract By getTo();

    public abstract By getToSelectedCity();

    public abstract By getToSelectedCityCode();

    public abstract By getToSelectedAirport();

    public abstract By getFromDate();

    public abstract By getFromDateSelected();

    public abstract By getFromDayAndYearSelected();

    public abstract By getReturnDate();

    public abstract By getReturnSelected();

    public abstract By getTravelersAndClass();

    public abstract By getTravelerCount();

    public abstract By getClassSelected();

    public abstract By getSearchButton();

    public abstract By getDepartureCity();

    public abstract By getArrivalCity();

    public abstract By getSuggestions();

    public abstract By getCityCode();

    public abstract By getCityName();

    public abstract By getAirportName();
}
