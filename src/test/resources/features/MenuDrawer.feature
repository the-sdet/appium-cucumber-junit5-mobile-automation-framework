#Author: Pabitra Swain (contact.the.sdet@gmail.com)
@drawer @menu
Feature: Menu Drawer

  Background: User is on MakeMyTrip Home Page
    Given User skips language selection and login screen
    And User closes Login Popup and Ads if any

  Scenario: Hamburger Menu Function
    And User clicks on the Hamburger Menu Icon
    Then App Drawer should be opened
    And User swipes left on App Drawer
    Then App Drawer should closed

  Scenario: Hamburger Menu Items
    And User clicks on the Hamburger Menu Icon
    Then App Drawer should be opened
    And Login and Signup Now Should be displayed
    And Below Items should be present as Icons
      | My Account    |
      | Support       |
      | Notifications |
    And "My Trips" section should be available
    And "My Trips" section should have below 2 items in it
      | View/Manage Trips |
      | Wishlist          |
    And "Rewards" section should be available
    And "Rewards" section should have below 4 items in it
      | Gift Cards            |
      | Rewards               |
      | Refer & Earn          |
      | Holidays Refer & Earn |
    And "Settings" section should be available
    And "Settings" section should have below 2 items in it
      | Language English |
      | Country in       |
    And "Rate Us link" should be present at the bottom of the Menu Drawer
    And "Privacy Policy link" should be present at the bottom of the Menu Drawer
    And "App Version" should be present at the bottom of the Menu Drawer
    And App Version should be "9.1.1"