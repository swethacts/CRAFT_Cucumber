@Completed
Feature: Skinny Ties

  @Completed
  Scenario Outline: Purchase a Tie
    Given I Launch the Application
    And Navigate to Collections and select the tie
    Then I select the Quantity
    And provide details and checkout with all details <Name> <Email> <Phone> <Message>

    Examples: 
      | Name | Email         | Phone       | Message                                |
      | John | abc@gmail.com | 91234567890 | Is shipping option available for India |
