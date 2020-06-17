@checkout
Feature: From EDP to Checkout Page scenarios

Background:
When i launch the EDP Application

  Scenario Outline: From EDP go to the cancel Order Screen
    When I Login into EDP with the <userName> and Password and <password>
    And user choose anyone of the ticket on the EDP page and move to CheckOutPage
    Then the user is on the Place Order checkout page
    And go to the Cancel OrderConfirmation Page and confirm the Cancel Order
    Examples:
      | userName                   | password   |
      | checkout2.teamqa@gmail.com | Test12345! |

  Scenario Outline: Logged in EDP user try to perform a purchase flow
    When I Login into EDP with the <userName> and Password and <password>
    And user choose anyone of the ticket on the EDP page and move to CheckOutPage
    Then the user is on the Place Order checkout page
    And I verify the order summary details
    Examples:
      | userName                   | password   |
      | checkout2.teamqa@gmail.com | Test12345! |