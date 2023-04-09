$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/demo/login.feature");
formatter.feature({
  "line": 1,
  "name": "As a demo web user if i enter correct data i should be able to login correctly",
  "description": "",
  "id": "as-a-demo-web-user-if-i-enter-correct-data-i-should-be-able-to-login-correctly",
  "keyword": "Feature"
});
formatter.before({
  "duration": 2285256100,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Login to demo web shop",
  "description": "",
  "id": "as-a-demo-web-user-if-i-enter-correct-data-i-should-be-able-to-login-correctly;login-to-demo-web-shop",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@test1"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I go to demo web home page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I login to demo web page",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I should be logged in as the correct user",
  "keyword": "Then "
});
formatter.match({
  "location": "DemoWebPageStepDefinitions.IGoToDemoWebHomePage()"
});
formatter.result({
  "duration": 1106678800,
  "status": "passed"
});
formatter.match({
  "location": "DemoWebPageStepDefinitions.ILoginToDemoWebPage()"
});
formatter.result({
  "duration": 931465900,
  "status": "passed"
});
formatter.match({
  "location": "DemoWebPageStepDefinitions.IShouldBeLoggedInAsCorrectUser()"
});
formatter.result({
  "duration": 94519900,
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 1124224300,
  "status": "passed"
});
formatter.before({
  "duration": 1368909700,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "Login with incorrect should display an error message",
  "description": "",
  "id": "as-a-demo-web-user-if-i-enter-correct-data-i-should-be-able-to-login-correctly;login-with-incorrect-should-display-an-error-message",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 10,
      "name": "@test2"
    }
  ]
});
formatter.step({
  "line": 12,
  "name": "I go to demo web home page",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "I login to demo web page with incorrect login details",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "I should not be logged in and error message should be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "DemoWebPageStepDefinitions.IGoToDemoWebHomePage()"
});
formatter.result({
  "duration": 1397226400,
  "status": "passed"
});
formatter.match({
  "location": "DemoWebPageStepDefinitions.ILoginToDemoWebPageWithIncorrectLoginDetails()"
});
formatter.result({
  "duration": 728692400,
  "status": "passed"
});
formatter.match({
  "location": "DemoWebPageStepDefinitions.IShouldNotBeLoggedInAndErrorMessageShouldBeDisplayed()"
});
formatter.result({
  "duration": 69311100,
  "status": "passed"
});
formatter.embedding("image/png", "embedded1.png");
formatter.after({
  "duration": 759261800,
  "status": "passed"
});
formatter.before({
  "duration": 1450186800,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "I login to the system and search for a book",
  "description": "",
  "id": "as-a-demo-web-user-if-i-enter-correct-data-i-should-be-able-to-login-correctly;i-login-to-the-system-and-search-for-a-book",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 17,
      "name": "@test3"
    }
  ]
});
formatter.step({
  "line": 19,
  "name": "I go to demo web home page",
  "keyword": "Given "
});
formatter.step({
  "line": 20,
  "name": "I login to demo web page",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "I search for a book",
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "a book result should be displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 23,
  "name": "I should be logged in as the correct user",
  "keyword": "And "
});
formatter.match({
  "location": "DemoWebPageStepDefinitions.IGoToDemoWebHomePage()"
});
formatter.result({
  "duration": 975920700,
  "status": "passed"
});
formatter.match({
  "location": "DemoWebPageStepDefinitions.ILoginToDemoWebPage()"
});
formatter.result({
  "duration": 895272800,
  "status": "passed"
});
formatter.match({
  "location": "DemoWebPageStepDefinitions.i_search_for_a_book()"
});
formatter.result({
  "duration": 646071700,
  "status": "passed"
});
formatter.match({
  "location": "DemoWebPageStepDefinitions.a_book_result_should_be_displayed()"
});
formatter.result({
  "duration": 59209400,
  "status": "passed"
});
formatter.match({
  "location": "DemoWebPageStepDefinitions.IShouldBeLoggedInAsCorrectUser()"
});
formatter.result({
  "duration": 61051700,
  "status": "passed"
});
formatter.embedding("image/png", "embedded2.png");
formatter.after({
  "duration": 752646700,
  "status": "passed"
});
});