#Author: shishirchaudhary@gmail.com
#Summary :This is feature test in which the user wants to book a flight via PHP travels.
#Sample Feature Definition Template
Feature: User wants to book a flight
 @tag2
   Scenario: User wants book return flight via PHPTRAVELS
    Given User is on Home Page of PHPTRAVELS
    When User clicks on Flight Booking Page
    And  User selects the Flight details and clicks on Search
    When User books the Flight
    Then User fills form and Confirms the booking
