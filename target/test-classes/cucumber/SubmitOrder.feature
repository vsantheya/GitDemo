
@tag
Feature: Purchase order from Ecommerce Website
  I want to use this template for my feature file

Background:
Given I landed on login page

  @Regression
  Scenario Outline: Positive test of the submitting order
    Given logged in with username<userName> and password<passWord>
    When I add product<productName> to cart
    And checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed in confirmation page

    Examples: 
      | userName  						| passWord 			| productName  |
      | santheyav95@gmail.com |     Jesus@123 | ZARA COAT 3 |
    
