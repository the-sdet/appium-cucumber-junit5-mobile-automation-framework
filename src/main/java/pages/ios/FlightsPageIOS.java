package pages.ios;

import org.openqa.selenium.By;
import pages.base.FlightsPageBase;

import static gobalconstants.constants.EMPTY_STRING;
import static io.github.the_sdet.web.Utils.customizeXpath;
/**
 * Class to maintain elements of Flights page for IOS
 *
 * @author Pabitra Swain (contact.the.sdet@gmail.com)
 */
@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class FlightsPageIOS extends FlightsPageBase {
    private final String flightsHeader = EMPTY_STRING;
    private final String tab = EMPTY_STRING;
    private final String from = EMPTY_STRING;
    private final String fromSelectedCity = EMPTY_STRING;
    private final String fromSelectedCityCode = EMPTY_STRING;
    private final String fromSelectedAirport = EMPTY_STRING;
    private final String to = EMPTY_STRING;
    private final String toSelectedCity = EMPTY_STRING;
    private final String toSelectedCityCode = EMPTY_STRING;
    private final String toSelectedAirport = EMPTY_STRING;
    private final String fromDate = EMPTY_STRING;
    private final String fromDateSelected = EMPTY_STRING;
    private final String fromDayAndYearSelected = EMPTY_STRING;
    private final String returnDate = EMPTY_STRING;
    private final String returnSelected = EMPTY_STRING;
    private final String travelersAndClass = EMPTY_STRING;
    private final String travelerSelected = EMPTY_STRING;
    private final String classSelected = EMPTY_STRING;
    private final String searchButton = EMPTY_STRING;
    private final String departureCity = EMPTY_STRING;
    private final String arrivalCity = EMPTY_STRING;
    private final String suggestions = EMPTY_STRING;
    private final String cityCode = EMPTY_STRING;
    private final String cityName = EMPTY_STRING;
    private final String airportName = EMPTY_STRING;
    private final String backButton = EMPTY_STRING;
    @Override
    public By getFlightsHeader() {
        return By.xpath(flightsHeader);
    }

    @Override
    public By getBackButton() {
        return By.xpath(backButton);
    }
    @Override
    public By getTab(String tabName) {
        return By.xpath(customizeXpath(tab, tabName));
    }

    @Override
    public By getFrom() {
        return By.xpath(from);
    }

    @Override
    public By getFromSelectedCity() {
        return By.xpath(fromSelectedCity);
    }

    @Override
    public By getFromSelectedCityCode() {
        return By.xpath(fromSelectedCityCode);
    }

    @Override
    public By getFromSelectedAirport() {
        return By.xpath(fromSelectedAirport);
    }

    @Override
    public By getTo() {
        return By.xpath(to);
    }

    @Override
    public By getToSelectedCity() {
        return By.xpath(toSelectedCity);
    }

    @Override
    public By getToSelectedCityCode() {
        return By.xpath(toSelectedCityCode);
    }

    @Override
    public By getToSelectedAirport() {
        return By.xpath(toSelectedAirport);
    }

    @Override
    public By getFromDate() {
        return By.xpath(fromDate);
    }

    @Override
    public By getFromDateSelected() {
        return By.xpath(fromDateSelected);
    }

    @Override
    public By getFromDayAndYearSelected() {
        return By.id(fromDayAndYearSelected);
    }

    @Override
    public By getReturnDate() {
        return By.xpath(returnDate);
    }

    @Override
    public By getReturnSelected() {
        return By.xpath(returnSelected);
    }

    @Override
    public By getTravelersAndClass() {
        return By.xpath(travelersAndClass);
    }

    @Override
    public By getTravelerCount() {
        return By.xpath(travelerSelected);
    }

    @Override
    public By getClassSelected() {
        return By.xpath(classSelected);
    }

    @Override
    public By getSearchButton() {
        return By.xpath(searchButton);
    }

    @Override
    public By getDepartureCity() {
        return By.xpath(departureCity);
    }

    @Override
    public By getArrivalCity() {
        return By.xpath(arrivalCity);
    }

    @Override
    public By getSuggestions() {
        return By.xpath(suggestions);
    }

    @Override
    public By getCityCode() {
        return By.xpath(cityCode);
    }

    @Override
    public By getCityName() {
        return By.xpath(cityName);
    }

    @Override
    public By getAirportName() {
        return By.xpath(airportName);
    }
}