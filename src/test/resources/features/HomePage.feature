#Author: Pabitra Swain (contact.the.sdet@gmail.com)
@home
Feature: Home Page

  Background: User is on MakeMyTrip Home Page
    Given User skips language selection and login screen
    And User closes Login Popup and Ads if any

  Scenario: Home Page - UI Elements
    Then User should see the Hamburger Menu Icon at top left
    And Logo should be displayed right to the Hamburger Menu Icon at top left
    And MyBiz button should be displayed at the top right
    And MyCash button should be displayed left to MyBiz
    And Search Bar should be displayed

  Scenario: Home Page - Navigation Bar
    Then User is able to see the Nav Bar
    Then Nav bar should have 5 options
    And Nav bar should have below options
      | Home      |
      | My Trips  |
      | Where2Go  |
      | TripMoney |
      | Be A Host |

  Scenario: Home Page - Primary Line of Businesses
    Then User is able to see the primary LOBs
    Then Primary LOBs should have 4 options
    And Primary LOBs should have below options
      | Flights          |
      | Hotels           |
      | Holiday Packages |
      | Trains/ Bus       |

  Scenario: Home Page - Secondary Line of Businesses
    Then User is able to see the secondary LOBs
    Then Secondary LOBs should have 8 options
    And Secondary LOBs should have below options
      | Airport Cabs          |
      | Homestays & Villas    |
      | Outstation Cabs       |
      | Forex Card & Currency |
      | Gift Cards            |
      | Hourly Stays          |
      | Nearby Staycations    |
      | Travel Insurance      |

  Scenario: Home Page - Extended Secondary Line of Businesses
    Then User is able to see expand button below the secondary LOBs
    And User clicks on expand button below the secondary LOBs
    And Secondary LOBs after expanding should have below options
      | Airport Cabs          |
      | Homestays & Villas    |
      | Outstation Cabs       |
      | Forex Card & Currency |
      | Gift Cards            |
      | Hourly Stays          |
      | Nearby Staycations    |
      | Travel Insurance      |
      | Flight Status         |
      | PNR Status            |
      | Visa                  |