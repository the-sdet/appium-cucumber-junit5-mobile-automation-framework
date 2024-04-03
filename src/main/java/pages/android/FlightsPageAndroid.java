package pages.android;

import org.openqa.selenium.By;
import pages.base.FlightsPageBase;

import static io.github.the_sdet.web.Utils.customizeXpath;

/**
 * Class to maintain elements of Flights page for Android
 *
 * @author Pabitra Swain (contact.the.sdet@gmail.com)
 */
@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class FlightsPageAndroid extends FlightsPageBase {

    private final String flightsHeader = "//android.widget.TextView[@resource-id='com.makemytrip:id/tv_header_first' and @text='Flight']";
    private final String tab = "//android.widget.TextView[@text='v1']";
    private final String from = "com.makemytrip:id/from_selection_layout";
    private final String fromSelectedCity = "//android.widget.TextView[contains(@resource-id,'from_to_et')]//following-sibling::android.widget.LinearLayout[contains(@resource-id,'from_city_text_layout')]//android.widget.TextView[1]";
    private final String fromSelectedCityCode = "//android.widget.TextView[contains(@resource-id,'from_to_et')]//following-sibling::android.widget.LinearLayout[contains(@resource-id,'from_city_text_layout')]//android.widget.TextView[2]";
    private final String fromSelectedAirport = "//android.widget.TextView[@resource-id='com.makemytrip:id/from_to_et']//following-sibling::android.widget.TextView";
    private final String to = "com.makemytrip:id/to_city_layout";
    private final String toSelectedCity = "//android.widget.TextView[contains(@resource-id,'tv_to_et')]//following-sibling::android.widget.LinearLayout[contains(@resource-id,'to_city_text_layout')]//android.widget.TextView[1]";
    private final String toSelectedCityCode = "//android.widget.TextView[contains(@resource-id,'tv_to_et')]//following-sibling::android.widget.LinearLayout[contains(@resource-id,'to_city_text_layout')]//android.widget.TextView[2]";
    private final String toSelectedAirport = "//android.widget.TextView[@resource-id='com.makemytrip:id/tv_to_et']//following-sibling::android.widget.TextView";
    private final String fromDate = "com.makemytrip:id/from_date_layout";
    private final String fromDateSelected = "com.makemytrip:id/tv_from_date";
    private final String fromDayAndYearSelected = "com.makemytrip:id/tv_from_date_time";
    private final String returnDate = "com.makemytrip:id/to_date_layout";
    private final String returnSelected = "com.makemytrip:id/to_date_layout";
    private final String travelersAndClass = "com.makemytrip:id/traveller_and_cabin_layout";
    private final String travelerCount = "com.makemytrip:id/tv_traveller_count";
    private final String classSelected = "com.makemytrip:id/tv_trip_type";
    private final String searchButton = "com.makemytrip:id/search_button_flat";
    private final String departureCity = "//android.widget.TextView[@resource-id='com.makemytrip:id/from_city'] | " +
            "//android.widget.EditText[@resource-id='com.makemytrip:id/departure_city_input']";
    private final String arrivalCity = "//android.widget.TextView[@resource-id='com.makemytrip:id/to_city'] | " +
            "//android.widget.EditText[@resource-id='com.makemytrip:id/arrival_city_input']";
    private final String suggestions = "//android.view.ViewGroup[.//android.widget.TextView[@text='SUGGESTIONS']]" +
            "//following-sibling::android.view.ViewGroup/android.widget.TextView[@resource-id='com.makemytrip:id/title']";
    private final String cityCode = "//android.widget.TextView[@resource-id='com.makemytrip:id/city_code' and @text='BOM']";
    private final String cityName = "//android.widget.TextView[@resource-id='com.makemytrip:id/city_code' and @text='BOM']" +
            "//preceding-sibling::android.widget.TextView[@resource-id='com.makemytrip:id/title']";
    private final String airportName = "//android.widget.TextView[@resource-id='com.makemytrip:id/city_code' and @text='BOM']" +
            "//following-sibling::android.widget.TextView[@resource-id='com.makemytrip:id/subtitle']";
    private final String backButton = "//android.widget.ImageButton[@resource-id='com.makemytrip:id/ib_back']";

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
        return By.xpath(customizeXpath(tab, tabName.toUpperCase()));
    }

    @Override
    public By getFrom() {
        return By.id(from);
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
        return By.id(to);
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
        return By.id(fromDate);
    }

    @Override
    public By getFromDateSelected() {
        return By.id(fromDateSelected);
    }

    @Override
    public By getFromDayAndYearSelected() {
        return By.id(fromDayAndYearSelected);
    }

    @Override
    public By getReturnDate() {
        return By.id(returnDate);
    }

    @Override
    public By getReturnSelected() {
        return By.id(returnSelected);
    }

    @Override
    public By getTravelersAndClass() {
        return By.id(travelersAndClass);
    }

    @Override
    public By getTravelerCount() {
        return By.id(travelerCount);
    }

    @Override
    public By getClassSelected() {
        return By.id(classSelected);
    }

    @Override
    public By getSearchButton() {
        return By.id(searchButton);
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