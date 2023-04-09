package com.cucumberFramework.stepdefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.cucumberFramework.helper.Constants;
import com.cucumberFramework.helper.LoggerHelper;
import com.cucumberFramework.helper.SeleniumUtils;
import com.cucumberFramework.pageObjects.*;
import com.cucumberFramework.testBase.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DemoWebPageStepDefinitions extends TestBase {

	static Logger log = LoggerHelper.getLogger(DemoWebPageStepDefinitions.class);

	// initialize pages

	DemoWebHomePage demoWebPage = new DemoWebHomePage(driver);
	LoginPage loginPage = new LoginPage(driver);
	SearchResultPage searchResultPage = new SearchResultPage(driver);

	@Given("^I go to demo web home page$")
	public void IGoToDemoWebHomePage() throws Throwable {
		demoWebPage.goToDemoWebPage();
		log.info(
				"got to page https://demowebshop.tricentis.com/ ");

	}
	@When("^I login to demo web page$")
	public void ILoginToDemoWebPage() throws Throwable {
		loginPage.loginToAccount();
		log.info(
				"logged into https://demowebshop.tricentis.com/ with user " + Constants.getUsername()+ " and password " + Constants.getPassword());

	}
	
	@When("^I login to demo web page with incorrect login details$")
	public void ILoginToDemoWebPageWithIncorrectLoginDetails() throws Throwable {
		loginPage.loginToAccountWithIncorrectDetails();
		log.info(
				"cannot login to https://demowebshop.tricentis.com/ with user " + Constants.getIncorrectUsername()+ " and password " + Constants.getIncorrectPassword());

	}
	
	@Then("^I should be logged in as the correct user$")
	public void IShouldBeLoggedInAsCorrectUser() throws Throwable {

		demoWebPage.assertLoginLoggedInUser();
	}
	
	
	@Then("^I should not be logged in and error message should be displayed$")
	public void IShouldNotBeLoggedInAndErrorMessageShouldBeDisplayed() throws Throwable {

		demoWebPage.assertLoginErrorMessage();
	}
	
	
	@When("^I search for a book$")
	public void i_search_for_a_book() throws Throwable {
		demoWebPage.searchBook();
	}

	@Then("^a book result should be displayed$")
	public void a_book_result_should_be_displayed() throws Throwable {
		searchResultPage.assertProductSearch();
	}

}