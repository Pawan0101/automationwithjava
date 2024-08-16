@smoke
Feature: parabank login functionality

  Scenario Outline: parabank login scenario
    Given user launch parabank page
    When user enter credentials "<Username>" and "<Password>"
    And click at login buttons
    Then user should view home page
    And user should close the application

    Examples: 
      | Username  | Password    |
      | todayrun  | todayrun123 |
      | sample123 | sample123   |
