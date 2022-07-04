Feature: Payback Feature Test

  Scenario: Activate Coupon for New user
    Given Initialise Payback Application
    And Payback Application is Launched
    And Start Registration Proccess
    When Validate if user is registered successfully
    Then Activate Coupon
    Then Validate coupon is activated
