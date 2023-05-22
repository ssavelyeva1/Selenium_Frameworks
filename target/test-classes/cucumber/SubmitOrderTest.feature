@tag
Feature: Purchase the order from E-commerce Website
  I want to use this template for my feature file

	Background:
	Given I landed on E-commerce page

  @Regression
  Scenario Outline: Positive test of submitting the order
    Given Logged in with username <email> and password <password>
    When I add product <productName> to cart
    And checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples: 
      | email  									| password 	| productName  |
      | savelyeva1.20@gmail.com | Abc_12345 | ZARA COAT 3  |
