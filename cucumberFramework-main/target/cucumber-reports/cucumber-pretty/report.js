$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/demo/login.feature");
formatter.feature({
  "line": 1,
  "name": "As a demo web user if i enter correct data i should be able to login correctly",
  "description": "",
  "id": "as-a-demo-web-user-if-i-enter-correct-data-i-should-be-able-to-login-correctly",
  "keyword": "Feature"
});
formatter.before({
  "duration": 2504619100,
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
  "duration": 1031640000,
  "status": "passed"
});
formatter.match({
  "location": "DemoWebPageStepDefinitions.ILoginToDemoWebPage()"
});
formatter.result({
  "duration": 910048700,
  "status": "passed"
});
formatter.match({
  "location": "DemoWebPageStepDefinitions.IShouldBeLoggedInAsCorrectUser()"
});
formatter.result({
  "duration": 59444600,
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 900559900,
  "status": "passed"
});
formatter.before({
  "duration": 1319438000,
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
  "duration": 791055400,
  "status": "passed"
});
formatter.match({
  "location": "DemoWebPageStepDefinitions.ILoginToDemoWebPageWithIncorrectLoginDetails()"
});
formatter.result({
  "duration": 737827100,
  "status": "passed"
});
formatter.match({
  "location": "DemoWebPageStepDefinitions.IShouldNotBeLoggedInAndErrorMessageShouldBeDisplayed()"
});
formatter.result({
  "duration": 55546900,
  "status": "passed"
});
formatter.embedding("image/png", "embedded1.png");
formatter.after({
  "duration": 774800700,
  "status": "passed"
});
});