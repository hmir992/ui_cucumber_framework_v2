Feature: As a demo web user if i search for an item i should be able to find it

    @test3
  	Scenario: I login to the system and search for a book
    Given I go to demo web home page
    And I login to demo web page
    When I search for a book
    Then a book result should be displayed
    And I should be logged in as the correct user