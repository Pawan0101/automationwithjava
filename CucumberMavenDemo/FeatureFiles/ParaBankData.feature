Feature: ParaBank login functionality

  Scenario: Login using valid credential
    Given user is on login page
    When user enters the "testdemo12" and "testdemo123"
    And clicks on login button
    Then display user home page
    And user will close the application
