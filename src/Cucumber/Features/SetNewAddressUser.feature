Feature: I add a new address

  Scenario Outline: I add a new address shipping
    Given I am logged in to CodersLab and create new address
    When I enter my "<alias>" in the alias input
    And I enter my "<address1>" in the address input
    And I enter my "<city>" in the city input
    And I enter my "<postcode>" in the postcode input
    And I select my "<country>" in the country input
    And I enter my "<phone>" in the phone input
    And I click the Submit button
#    And  I check if  "<alias>" in the alias added address is correct
#    And  I check if "<address1>" in the address added address is correct
    And  I check if "<city>" in the city added address is correct
#    And  I check if "<postcode>" in the the postcode added address is correct
#    And  I check if "<country>"in the country added address is correct
#    And  I check if "<phone>" in the phone added address is correct
#    Then I deletes the added address


    Examples:
      | alias    | address1        | city        | postcode        | country        | phone            |
      | janek01  | Nawrot 24       | Lodz        | 91-609          | United Kingdom | 44 987- 896-567  |
#      | wojtek02 | Nowa 3          | Wroclaw     | 89-508          | United Kingdom | 44 567-908-657   |
#      | marek03  | Okoniowa 45     | Zgierz      | 90-967          | United Kingdom | 44 678-098-567   |
#      | adam04   | Wysoka 67       | Warszawa    | 02-789          | United Kingdom | 48 601-509-678   |


