@calculator
Feature: Calculator for Outline Example

#  Scenario: Add two numbers for outline example
#    Given I have entered 22 into the calculator
#    And I have entered 44 into the calculator
#    When I press add
#    Then the result should be 66 on the screen
#
#  Scenario: Add two numbers for outline example
#    Given I have entered 2 into the calculator
#    And I have entered 4 into the calculator
#    When I press add
#    Then the result should be 6 on the screen
#
#  Scenario: Add two numbers for outline example
#    Given I have entered 5 into the calculator
#    And I have entered 10 into the calculator
#    When I press add
#    Then the result should be 15 on the screen
  Scenario Outline: Add two numbers and get result
    Given I have entered <number1> in the calculator
    And I have entered <number2> in the calculator
    When I press add
    Then the result should be <sum> on the screen

    Examples:
      | number1 | number2 | sum |
      | 22      | 44      | 66  |
      | 4       | 2       | 6   |
      | 5       | 10      | 15  |