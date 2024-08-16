Feature: Banking Application Functionality
  As a bank customer
  I want to perform various banking operations
  So that I can manage my finance effectively

  Background: 
    Given I am a registered bank customer
    And I have logged into my account

  Scenario: Account Balance Inquiry
    When I request to check account balance
    Then I should see my current account balance
    And I have logged out of my account

  Scenario: Deposit money into my Account
    Given My account balance is $1000
    When I deposit $200 into my acount
    Then My account balance should be $1200
    And I have logged out of my account

  Scenario: Withdraw money from account
    Given My account balance is $1200
    When I withdraw $300 from my account
    Then My account balance should be $900
    And I have logged out of my account

  Scenario Outline: Transfer Money Bewtween Accounts
    And My source account balance is <source_balance>
    And i have destination account with a balance of <destination_balance>
    When I transfer <amount> from my souce account to destination account
    Then My source account balance shoud be <updated_source_balance>
    And the destination account balance should be <updated_destination_balance>
    And amount is transferred successfully
    And I have logged out of my account

    Examples: 
      | source_balance | destination_balance | amount | updated_source_balance | updated_destination_balance |
      |           1000 |                 500 |    100 |                    900 |                         600 |
      |           2000 |                1000 |    500 |                   1500 |                        1500 |
      |           3000 |                 500 |    500 |                   2500 |                        1000 |
      |           4000 |                1000 |    500 |                   3500 |                        1500 |

      
      Scenario: View Transaction History
      When I request to view my transaction history
      Then I should see a list of my recent transaction
      And I have logged out of my account
      
      Scenario: Apply for a loan
      When I apply for personal loan of $5000
      Then My loan application should be submitted for review
      And I have logged out of my account
      
      Scenario: Verify Interest Calculation on Savings Account
      Given I have a saving account with an interest rate of 4%
      And I have a balance of $1000 in my savings account
      When The interest is calculated on my savings account
      Then my account balance should be $1040
      And I have logged out of my account


