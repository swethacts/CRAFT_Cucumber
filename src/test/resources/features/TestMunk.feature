@Completed
Feature: SignIn to TestMunk

  @Completed
  Scenario Outline: Login to TestMunk
    Given Application is Launched
    When I SignIn with valid username as <Username> and password as <Password>
    Then Home Page of the application is displayed
    And Perform Operations

    Examples: 
      | Username          | Password |
      | test@testname.com | testmunk |
