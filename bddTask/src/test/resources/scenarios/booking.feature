Feature: Booking site
  Background: Booking page
    Given user opens "https://www.booking.com/searchresults.en-gb.html" using Chrome

  Scenario: user finds hotel
    When user fills search with "Turin Palace Hotel"
    And user chooses hotel in search list
    And user clicks search button
    Then "Turin Palace Hotel" displayed in results page
    And amount of hotel stars equals 4