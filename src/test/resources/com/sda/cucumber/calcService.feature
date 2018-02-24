Feature: CalcService

  Scenario: Should Add Digits In String And Produce Result Test
    Given I initialize CalcService
    And I pass text value to compute
    When I execute Calculate method
    Then I get correct result

  Scenario: Should return 0 when null text is passed
    Given I initialize CalcService
    And I pass null text value
    When I execute Calculate method
    Then I get 0 as a result