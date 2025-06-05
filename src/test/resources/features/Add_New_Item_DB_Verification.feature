@crater @db-test
Feature: Add Item and Verify DB
  As a User
  I want to add an item to the list of items
  So I can see it as part of the list

  Scenario: Successfully add a a new item and verify it in the DB
    Given User is logged in successfully
    When User clicks on the Add Item button
    And User enters the item name
    And User enters the item description
    And User enters the item price "12.99"
    And User enters the item unit "grams"
    And User clicks on the Save Item button
    Then Item should be listed in the items table
    And the item is added into the DB