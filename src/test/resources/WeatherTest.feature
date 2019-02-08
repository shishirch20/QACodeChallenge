#Author: shishirchaudhary@gmail.com
#Summary :The user wants to query the weatner for next 5 days and go out on given day.  
#Sample Feature Definition Template
Feature: User wants to Query the weather for next five days
 @tag1
  Scenario: A happy holidaymaker
	Given I like to holiday in Sydney
	And I only like to holiday on given Day
	When I look up the weather forecast
	Then I receive the weather forecast
	And the temperature is warmer than 10 degrees
