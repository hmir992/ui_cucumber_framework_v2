Feature: As a demo web user if i enter correct data i should be able to login correctly

    @test1
  	Scenario: Login to demo web shop
    Given I go to demo web home page
    When I login to demo web page
    Then I should be logged in as the correct user
    
    
    @test2
  	Scenario: Login with incorrect should display an error message 
    Given I go to demo web home page
    When I login to demo web page with incorrect login details
    Then I should not be logged in and error message should be displayed