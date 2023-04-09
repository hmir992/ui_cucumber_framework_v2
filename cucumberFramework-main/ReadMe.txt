# cucumberFramework
Cucumber framework

Overview
• https://www.ryanair.com/ie/en/ - Automated 2 tests
• Test one card payments declined (tests fails due to a login bug on website) - failing test
• Test two making a flight booking without logging in up to the contact details page - passing test
• Page Object Pattern, java, maven, cucumber, testng, selenium was used
• Many pages such as Constants, SeleniumUtils was used to make the code more reusable
• LoggerHelper was used to help with logging
• enums where used for managing the OS and BROWSER code which links into the testbase method
• ServiceHooks was used to keep @before and @after test methods
• RyanAirProjectStepDefinitions was used to keep the glue  between cucumber and code including page initializations with the webdriver
• com.cucumberFramework.pageObjects contains all page objects used
• com.cucumberFramework.testRunner contains all the runners for the test
• /cucumberFramework/src/test/resources/drivers contains all the drivers for windows and mac
• /ryanairCucumberFramework/src/test/resources/features/ryanair contains all the feature files for this test project

Feature Files:

Test 1:
ryanair_payment_test.feature - Failing Test - tests fails due to a login bug on website

Feature: As a Ryanair user I login, attempt to make book a flight and payment is declined
		@test1
  	Scenario Outline: Login into Ryanair, Book a flight, enter invalid card information and payment is declined
    Given I make a booking from DUB to BER on 12/03/2020 for 2 adults and 1 child
    When I pay for booking with card details "<cardNumber>" , 10/21 and "<cvv>"
    Then I should get payment declined message
		
 	Examples:
	 | cardNumber 					| cvv |
	 | 5555 5555 5555 5557  		| 265 |

Test 2:
ryanair_payment_test_no_login.feature  - Passing test

Feature: As a Ryanair user I do not login and attempt to make book a flight login popup is displayed
  
  	@test2
  	Scenario: Book a flight, without Logging into RyanAir and assert login popup
    Given I make a booking from DUB to BER on 12/03/2020 for 2 adults and 1 child
    Then I should get the login required popup
	
	
How to run these tests and reporting please see word doc in root of the project