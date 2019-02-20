Feature: withdraw
  As a customer
  I want to withdraw with a negotiated amount from my account using ATM

  Background:
    Given a customer with id 1 and pin 111 with overdraft 500 and balance 200 exists
    And I login to ATM with id 1 and pin 111

  Scenario: Withdraw amount less than balance and overdraft
    When I withdraw 50 from ATM
    Then my account overdraft is 500 and balance 150

  Scenario: Withdraw amount morn than balance but less than overdraft
    When I withdraw 600 from ATM
    Then my account overdraft is 100 and balance 0

  Scenario: Withdraw amount equal to balance and overdraft
    When I withdraw 700 from ATM
    Then my account overdraft is 0 and balance 0

  Scenario: Withdraw amount more than balance and overdraft
    When I overdraw 5000 from ATM
    Then my account overdraft is 500 and balance 200

