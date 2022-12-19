Feature: Booking site
  Background: Booking page
    Given user opens Booking page

  Scenario: User is able to search hotel by particular name
    When user fills search with "Turin Palace Hotel"
    And user chooses hotel in search list
    And user clicks search button
    Then "Turin Palace Hotel" displayed in results page
    And amount of hotel stars equals 4