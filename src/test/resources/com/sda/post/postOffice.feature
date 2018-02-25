Feature: PostOffice scenarios

  Scenario: Should create a new user
    Given I instantiate PostOffice
    And I mock userStorage to return true when createUser method called
    When I create new user with nickname qwerty
    Then User with nickname qwerty is present

  Scenario: Should send new message successfully
    Given I instantiate PostOffice
    And I mock userStorage to return true when createUser method called
    And I mock senderService to return true when sendMessage method called
    When I create new user with nickname qwerty
    And I create new user with nickname abc
    And I send new message Hello World from qwerty to abc
    Then User with nickname qwerty is present
    And User with nickname abc is present
    And Message Hello World from qwerty is sent to abc

