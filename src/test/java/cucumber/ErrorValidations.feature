@tag
Feature: Error validation
  I want to use this template for my feature file

  @tag2
  Scenario Outline: Title of your scenario outline
    Given I landed on E-commerce page
    When Logged in with username <email> and password <password>
    Then "Incorrect email or password." message is displayed

    Examples: 
      | email                  | password |
      | invanova1.20@gmail.com | Def_6789 |
