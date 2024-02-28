Feature: Justdial

  Scenario Outline: Location and services
    Given User is on the homepage of justdial
    When user sends location and services "<service>" required
    And after selecting rating
    Then all the five services are printed
    
    Examples:
    | service |
    | car washing services |

  Scenario: FreeListing
    Given user clicks on freelisting icon
    When invalid mobile number is passed and clicks on startnow icon
    Then the error message is validated
    
  Scenario: Sub-menu in Gym
    Given user moves to homepage
    When clicks on gym icon in homepage
    Then the sub-menu items are printed
    