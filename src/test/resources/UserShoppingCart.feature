#Author: shishirchaudhary@gmail.com
#Summary :This feature is for the user wants to add two items on the cart on EBAY.com
#Sample Feature Definition Template
Feature: User wants to add two items on Shopping cart
 @tag1
  Scenario: User wants to add 2 items to the cart/trolley and go to checkout
			Given User is on Home Page of EBAY
			When User Navigate to Product Page
			And User selects the product and adds to cart 
			Then User goes to checkout