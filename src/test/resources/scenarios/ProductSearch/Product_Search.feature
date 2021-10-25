#This feature file is to search an item in ebay website
Feature: Ebay Search

   Scenario: ebay search
    Given I am on ebay page "http://www.ebay.com.au"
    And I search for "Bike"
    When I select the search item and add to cart
    Then validate the selected item
