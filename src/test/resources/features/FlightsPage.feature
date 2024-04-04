#Author: Pabitra Swain (contact.the.sdet@gmail.com)
@flights
Feature: Flights Search

  Background: User is on MakeMyTrip Home Page
    Given User skips language selection and login screen
    And User closes Login Popup and Ads if any

  Scenario: Flights Page - UI Elements
    Then User closes the Menu Drawer if opened
    Then User clicks on LOB "Flights"
    Then Flights page should be opened
    Then "One Way" tab is Auto Selected
    Then "From" input box is visible
    Then "To" input box is visible
    Then "Departure Date" input box is visible
    Then "Travellers & Class" input box is visible
    Then Search Flights button should be visible
    And Go back to Home Page