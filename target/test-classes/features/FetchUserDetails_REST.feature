Feature: User data validation
  As a user, I want to validate users data

  # Example for Rest service validation and asserting a tag,body and header values from response
  @demo2
  Scenario Outline: Users data validation
    Given the required inputs are ready to validate users
    When user request the users data end point with value "<Name>" and "<Job>"
    Then user should get the entered name  "<Name>" and "<Job>"
    And assert json body,header,tag

    Examples: 
      | Name  | Job               |
      | murug | Automation Tester |

  # Example for Rest service validation and asserting list values from response
  @demo2
  Scenario: List validation
    Given the required inputs are ready to validate list
    When user request the users data end point
    Then user should get the expected response
    And assert json list of values
