Feature: I add a new address

  Scenario Outline: I add a new address shipping
    Given I am logged in to CodersLab and create new address
    When I enter my "<alias>" in the alias input
    And I enter my "<address>" in the address input
    And I enter my "<city>" in the city input
    And I enter my "<zip/postal code>" in the zip/postal code input
    And I select my "<country>" in the country input
    And I enter my "<phone>" in the phone input
    And I click the Submit button
#    Then I check if "<alias>" in the added address is correct

    Examples:
      | alias    | address        | city        | zip/postal code | country        | phone             |
      | janek01  | Nawrot 24      | Lodz        | 91-609          | United Kingdom | + 44 987- 896-567 |
#      | wojtek2  | Nowa 3         | Wroclaw     | 89-508          | United Kingdom | + 44 567-908-657  |
#      | marek03  | Okoniowa 45    | Zgierz      | 90-967          | United Kingdom | + 44 678-098-567  |
#      | adam04   | Wysoka 67      | Warszawa    | 02-789          | United Kingdom | + 48 601-509-678  |

