Feature: Temp Conversion
  As a user, I want to convert temprature from Fahrenheit To Celsius vice versa

# Example for soap service validation and asserting a tag,body and header values from response
  @demo1
  Scenario Outline: Temp_Conversion_FahrenheitToCelsius
    Given the required inputs are ready
    When user request the temp conversion end point with Fahrenheit value "<Fahrenheit>"
    Then user should get the celcius value "<Celsius>"
    And assert xml body,header,tag

    Examples: 
      | Fahrenheit | Celsius |
      |         50 |      10 |

#Example for running soap services in sequence
  @demo1
  Scenario Outline: Temp_Conversion_FahrenheitToCelsius_CelsiusToFahrenheit
    Given the required inputs are ready
    When user request the temp conversion end point with Fahrenheit value "<Fahrenheit>"
    Then user should get the celcius value "<Celsius>"
    And user upadte the celcius value
    And user request the temp conversion end point with Celcius value
    And user should get the Fahrenheit value "<Fahrenheit>"

    Examples: 
      | Fahrenheit | Celsius |
      |         50 |      10 |

#Example for ruuning soap services with multiple set of data
  @demo1
  Scenario Outline: Temp_Conversion_FahrenheitToCelsius
    Given the required inputs are ready
    When user request the temp conversion end point with Fahrenheit value "<Fahrenheit>"
    Then user should get the celcius value "<Celsius>"

    Examples: 
      | Fahrenheit | Celsius |
      |         50 |      10 |
      |        500 |     260 |
      |          5 |     -15 |
