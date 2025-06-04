Feature: Example of cucumber data table implementation


  @demo-datatable
  Scenario: List of fruit I like
    Given I have the following list of fruit
      | fruit  |
      | banana |
      | orange |
      | kiwi   |
      | apple  |
    When I go to the market
    Then I should have 4 fruits in my basket




#    Given I like apple
#    And I like baanana
#    And I like kiwi
#    And I like orange
#    When I go to the market
#    Then I should have 4 fruits in my basket
