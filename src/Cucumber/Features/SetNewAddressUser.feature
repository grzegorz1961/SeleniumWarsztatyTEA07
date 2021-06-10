Feature: I add a new address

  Scenario Outline: I add a new address shipping
    Given I am logged in to CodersLab
    When I and create new address
    And I enter my "<alias>" in the alias input
    And I enter my "<address1>" in the address input
    And I enter my "<city>" in the city input
    And I enter my "<postcode>" in the postcode input
    And I select my "<country>" in the country input
    And I enter my "<phone>" in the phone input
    And I click the Submit button
    Then I check the correctness of the saved address

    Examples:
      | alias    | address1        | city        | postcode        | country        | phone            |
      | janek01  | Nawrot 24       | Lodz        | 91-609          | United Kingdom | 48 987- 896-567  |




