
@tag
Feature: Title of your feature
  I want to use this template for my feature file
  
  Background: User is Logged In
	Given I navigate to the login page
	When I submit username and password
	Then I should be logged in 

  Scenario: Coupon creation
    Given I navigate to coupon page
    When I create a coupon from home page 
    Then I verify that the coupon created
    
    
  Scenario: Coupon update
    Given I navigate to coupon page
    When I updating the coupon details
    Then I verify that the coupon updated
    
    
    
    
  Scenario: Delete Coupon    
    Given I navigate to coupon page
    When I deleting the coupon details
    Then I verify that the coupon deleted

    
      
