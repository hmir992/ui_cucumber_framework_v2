package com.cucumberFramework.stepdefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.cucumberFramework.helper.LoggerHelper;
import com.cucumberFramework.helper.SeleniumUtils;
import com.cucumberFramework.pageObjects.AddBagPage;
import com.cucumberFramework.pageObjects.ContactDetailsPage;
import com.cucumberFramework.pageObjects.ExtrasForFlightPage;
import com.cucumberFramework.pageObjects.FlightInformationPage;
import com.cucumberFramework.pageObjects.GoogleLoginPage;
import com.cucumberFramework.pageObjects.RyanairHomePage;
import com.cucumberFramework.pageObjects.PlanYourWholeTripPage;
import com.cucumberFramework.pageObjects.SelectSeatsPage;
import com.cucumberFramework.testBase.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RyanAirProjectStepDefinitions extends TestBase {

	static Logger log = LoggerHelper.getLogger(RyanAirProjectStepDefinitions.class);

	// initialize pages

	RyanairHomePage ryanairHomePage = new RyanairHomePage(driver);
	FlightInformationPage flightInformationPage = new FlightInformationPage(driver);
	SelectSeatsPage selectSeatsPage = new SelectSeatsPage(driver);
	AddBagPage addBagPage = new AddBagPage(driver);
	ExtrasForFlightPage extrasForFlightPage = new ExtrasForFlightPage(driver);
	PlanYourWholeTripPage planYourWholeTripPage = new PlanYourWholeTripPage(driver);
	ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);
	GoogleLoginPage googleLoginPage = new GoogleLoginPage(driver);

	@Given("^I make a booking from DUB to BER on 12/03/2020 for 2 adults and 1 child$")
	public void IMakeABooking() throws Throwable {
		driver.get("https://demowebshop.tricentis.com/");
		ryanairHomePage.clickClosePopup();
		log.warn(
				"Note: there is a bug with the login both implemented via ryanair method and google method but disabled for the tests as its not working");
		// TODO: there is a bug with the login so i cannot complete the test
		// ryanairHomePage.loginToAccount();
		// TODO: there is a bug with the login so i cannot complete the test
		// googleLoginPage.loginToAccountViaGoogle();
		ryanairHomePage.selectFlightInformationAndClickSearch();
		flightInformationPage.selectValueTravelLightPackage();
		flightInformationPage.ClickloginLater();
		flightInformationPage.enterPassengerInformation();
		selectSeatsPage.selectSeatsForPassengers();
		addBagPage.selectNoBags();
		extrasForFlightPage.selectNoExtrasAndClickContinue();
		planYourWholeTripPage.clickBasketAndCheckoutButton();

	}

	@When("^I pay for booking with card details \"([^\"]*)\" , 10/21 and \"([^\"]*)\"$")
	public void IPayForBookingWithCardDetails(String cardNumber, String cvvInput) throws Throwable {
		contactDetailsPage.enterCardDetailsAndClickPayNow(cardNumber, cvvInput);

	}

	@Then("^I should get the login required popup$")
	public void IShouldGetTheLoginRequiredPopup() throws Throwable {

		contactDetailsPage.assertLoginPopupMessage();
	}

	@Then("^I should get payment declined message$")
	public void IShouldGetPaymentDeclinedMessage() throws Throwable {

		contactDetailsPage.assertPaymentDeclinedMessage();
	}

}