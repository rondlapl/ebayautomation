#This feature file is to validate the home page
Feature: Home page validation

  Scenario: Validate Home Page
    Given I am on ebay page "http://www.ebay.com.au/signin/"
    When I enter credentials ""
    Then validate the sign in error details