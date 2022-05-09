@SmokeTest
Feature: Order

@AC1
  Scenario Outline: As a customer, I should checked whether  My address is inside delivery areas
      Given User should navigate to url
      Given User should be able to click delivery address box
      When  User should be able to enter a "<valid address>"
      And   User should be able to hit the enter on keyboard and not see error message "This address is outside of our delivery area."
      Then  User should be able to see Deliver here button is clickable

    Examples:
      | valid address                        |
      |Langemarckstraße 38-42, 28199 Bremen  |
      |Erlenstraße 76, 28199 Bremen          |


@AC2
  Scenario Outline: As a customer, I should select one of the pick up locations and land Order page
      Given User should navigate to url
      When User should click "<branch for pickup>" and land "<branch for pickup>" page

    Examples:
      | branch for pickup     |
      |Enjoy+Pizza+Bremen     |
      |Enjoy Pizza Delmenhorst|

@AC3
    Scenario Outline: As a customer,  I should order Pizza click preorder and enter my info and(dell and change extras and checked it) checkout  select cash payment, and click place my order
    Given User should navigate to url
    And   User should click "Enjoy+Pizza+Bremen" and land "Enjoy+Pizza+Bremen" page
    When  User should click "Pizza Salami" and land ingredients page
    And   User should select "<Please choose a size>", "<Free ingredients>", "<Extracted 1>", "<Extracted 2>", "<Extracted 3>", "<Extracted 4>", "<Cheese crust>", "<Dip of your choice>"
    And   User should click Confirm
    Then  User should see orders in shopping cart
    And   User should click order now
    And   User should fill out address form
    And   User should click checkout
    And   User should select "<payment method>"
    And   User should click place my order
    And   User should land payment page

      Examples:
      | Please choose a size | Free ingredients | Extracted 1 | Extracted 2 | Extracted 3 | Extracted 4 | Cheese crust  | Dip of your choice   |payment method |
      |  26 cm               | Knoblauch        | Basilikum   | Jalapenos   | Gorgonzola  | Gambas      | Mozzarellarand| Joghurt-Dip          | Cash          |
      |  36 cm               | Oregano          | Paprika     | Sardellen   | Gyros       | Krabben     | Goudarand     | Curry-Dip            | Online payment|


@AC4-Api
  Scenario: Verify the Enjoy Pizza Api is working
    When Logging Enjoy Pizza Api using url
    Then Status code should be 200
    And  Response header should be "text/html; charset=utf-8"








