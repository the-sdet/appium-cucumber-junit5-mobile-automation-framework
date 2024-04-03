package pages.pageobjects;

import io.appium.java_client.AppiumDriver;
import logger.Log;
import pages.android.FlightsPageAndroid;
import pages.base.FlightsPageBase;
import pages.ios.FlightsPageIOS;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static engine.Engine.isAndroid;
import static gobalconstants.constants.APP_DATE_FORMAT;
import static gobalconstants.constants.PREFERRED_DATE_FORMAT;
import static io.github.the_sdet.cucumber.CucumberUtils.logToReport;

public class FlightsPage extends HomePage {
    public FlightsPageBase flightsPage;

    /**
     * Constructor to initialize AppiumUtils.
     *
     * @param driver The Appium Driver (AndroidDriver/IOSDriver) instance to use.
     * @author Pabitra Swain (contact.the.sdet@gmail.com)
     */
    public FlightsPage(AppiumDriver driver) {
        super(driver);
        flightsPage = isAndroid() ? new FlightsPageAndroid() : new FlightsPageIOS();
    }

    public boolean isFlightsPageHeaderDisplayed() {
        return waitAndCheckIsVisible(flightsPage.getFlightsHeader(), Duration.ofSeconds(10));
    }

    public boolean isBackButtonDisplayed() {
        return isVisible(flightsPage.getBackButton());
    }

    public void clickOnBackButton() {
        click(flightsPage.getBackButton());
    }

    public void clickOnTab(String tabName) {
        click(flightsPage.getTab(tabName));
    }

    public boolean isTabSelected(String tabName) {
        return waitAndFindElement(flightsPage.getTab(tabName)).isSelected();
    }

    public boolean isDepartureInputDisplayed() {
        return isVisible(flightsPage.getSearchButton());
    }

    public boolean isDestinationInputDisplayed() {
        return isVisible(flightsPage.getSearchButton());
    }

    public boolean isFromDateDisplayed() {
        return isVisible(flightsPage.getFromDate());
    }

    public boolean isTravellerAndClassInputDisplayed() {
        return isVisible(flightsPage.getSearchButton());
    }

    public boolean isSearchFlightsButtonDisplayed() {
        return isVisible(flightsPage.getSearchButton());
    }

    public String getSelectedFromCity() {
        return getElementTextContent(flightsPage.getFromSelectedCity());
    }

    public String getSelectedFromCityCode() {
        return getElementTextContent(flightsPage.getFromSelectedCityCode());
    }

    public String getSelectedFromCityAirport() {
        return getElementTextContent(flightsPage.getFromSelectedAirport());
    }

    public String getSelectedToCity() {
        return getElementTextContent(flightsPage.getToSelectedCity());
    }

    public String getSelectedToCityCode() {
        return getElementTextContent(flightsPage.getToSelectedCityCode());
    }

    public String getSelectedToCityAirport() {
        return getElementTextContent(flightsPage.getToSelectedAirport());
    }

    public String getSelectedDate() {
        String dateAndMonth = getElementTextContent(flightsPage.getFromDateSelected());
        Log.info("Date and Month from App: " + dateAndMonth);
        String dayAndYear = getElementTextContent(flightsPage.getFromDayAndYearSelected());
        Log.info("Day and Year from App: " + dayAndYear);
        String dateFromApp = dateAndMonth + dayAndYear;
        if (dateFromApp.length() != 16)
            dateFromApp = "0" + dateFromApp;
        Log.info("Date From App: " + dateFromApp);
        return formatDate(dateFromApp, APP_DATE_FORMAT, PREFERRED_DATE_FORMAT);
    }

    public boolean isInputBoxDisplayed(String inputBox) {
        switch (inputBox.toLowerCase()) {
            case "from":
            case "departure":
                return isDepartureInputDisplayed();
            case "to":
            case "destination":
                return isDestinationInputDisplayed();
            case "from date":
            case "departure date":
            case "return date":
                return isFromDateDisplayed();
            case "travellers & class":
            case "travellers and class":
                return isTravellerAndClassInputDisplayed();
            default:
                Log.error("Unexpected Value: " + inputBox);
                return false;
        }
    }

    public static String formatDate(String inputDateStr, String inputDateFormat, String outputDateFormat) {
        DateFormat inputFormatter = new SimpleDateFormat(inputDateFormat);
        DateFormat outputFormatter = new SimpleDateFormat(outputDateFormat);
        try {
            Date inputDate = inputFormatter.parse(inputDateStr);
            return outputFormatter.format(inputDate);
        } catch (ParseException e) {
            Log.error("Parse Exception...", e);
            return null;
        }
    }
}
