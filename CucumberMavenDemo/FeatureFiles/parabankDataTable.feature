Feature: ParaBank login functionality

  Scenario: Login using valid credential
    Given user on login page
    When user enters the credentials
      | UserName | Password |
      | pkg1982  | pkg1982  |
    And clicks at login button
    Then display view home page
    And close application
