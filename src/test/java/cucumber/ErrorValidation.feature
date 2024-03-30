@tag
Feature: Error Validation
  I want to use this template for my feature file



 @ErrorValidation
  Scenario Outline: Negative test of the submitting order
  Given I landed on login page
    When logged in with username<userName> and password<passWord>
    Then "Incorrect email or password." message is displayed in login page

    Examples: 
      | userName  						| passWord 			|
      | santheyav95@gmail.com |     Jesus@12 |