Feature: To test the customer login in Parabank application

  Background: 
    Given launch the application

  Scenario: Login using valid credential
    When username and password are entered
    And click on login button
    Then display the user home page
    And logout the application
    And close the application

  Scenario: Login using invalid credential
    When invalid username and Password are entered
    And click on login button
    Then unable to login
    And close the application
