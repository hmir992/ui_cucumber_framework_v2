package com.cucumberFramework.pageObjects;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.cucumberFramework.helper.Constants;
import com.cucumberFramework.helper.LoggerHelper;
import com.cucumberFramework.helper.SeleniumUtils;

import junit.framework.AssertionFailedError;

public class FlightInformationPage {

	private WebDriver driver;

	static Logger log = LoggerHelper.getLogger(FlightInformationPage.class);

	public FlightInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// selectValueTravelLightPackage

	@FindBy(xpath = "(//flight-info[@class='card-info__col card-info__col--stretch'])[1]")
	private WebElement selectCurrentFlight;

	@FindBy(xpath = "(//span[@class='fare-card__button-text ng-star-inserted'])[1]")
	private WebElement selectValueTravelLightPackage;

	// passenger information

	@FindBy(xpath = "(//div[@class='dropdown b2'])[1]")
	private WebElement selectTitleForAdultPassengerOne;

	@FindBy(xpath = "(//ry-dropdown-item[@class='ng-star-inserted'])[1]")
	private WebElement selectMrTitleAdultPassengers;

	@FindBy(xpath = "(//input[@id='formState.passengers.ADT-0.name'])[1]")
	private WebElement firstNameAdultPassengerOne;

	@FindBy(xpath = "(//input[@id='formState.passengers.ADT-0.surname'])[1]")
	private WebElement surnameAdultPassengerOne;

	@FindBy(xpath = "(//div[@class='dropdown b2'])[2]")
	private WebElement selectTitleForAdultPassengerTwo;

	@FindBy(xpath = "(//input[@id='formState.passengers.ADT-1.name'])[1]")
	private WebElement firstNameAdultPassengerTwo;

	@FindBy(xpath = "(//input[@id='formState.passengers.ADT-1.surname'])[1]")
	private WebElement surnameAdultPassengerTwo;

	@FindBy(xpath = "(//input[@id='formState.passengers.CHD-0.name'])[1]")
	private WebElement firstNameChildPassenger;

	@FindBy(xpath = "(//input[@id='formState.passengers.CHD-0.surname'])[1]")
	private WebElement surNameChildPassenger;

	@FindBy(xpath = "//button[@class='continue-flow__button ry-button--gradient-yellow']")
	private WebElement continueButton;

	@FindBy(xpath = "//div[@class='login-touchpoint__chevron-container']")
	private WebElement loginLater;

	public void selectValueTravelLightPackage() throws InterruptedException, IOException {
		SeleniumUtils.waitAndClickElement(driver, selectCurrentFlight);
		SeleniumUtils.waitAndClickElement(driver, selectValueTravelLightPackage);
	}

	public void ClickloginLater() throws InterruptedException, IOException {

		try {
			SeleniumUtils.waitAndClickElement(driver, loginLater);
		} catch (AssertionFailedError e) {
			log.warn("continue.. no login later button");
		}
	}

	public void enterPassengerInformation() throws Exception {

		enterAdultPassengerOneInformation();

		enterAdultPassengerTwoInformation();

		enterChildPassengerOneInformation();

		continueButton();
	}

	private void continueButton() throws InterruptedException, IOException {
		SeleniumUtils.waitAndClickElement(driver, continueButton);
	}

	private void enterChildPassengerOneInformation() throws Exception {

		SeleniumUtils.sendKeysToWebElement(driver, firstNameChildPassenger, Constants.getChildFirstNameOne());
		SeleniumUtils.sendKeysToWebElement(driver, surNameChildPassenger, Constants.getChildSurNameOne());

	}

	private void enterAdultPassengerTwoInformation() throws InterruptedException, IOException, Exception {
		SeleniumUtils.waitAndClickElement(driver, selectTitleForAdultPassengerTwo);
		SeleniumUtils.waitAndClickElement(driver, selectMrTitleAdultPassengers);

		SeleniumUtils.sendKeysToWebElement(driver, firstNameAdultPassengerTwo, Constants.getAdultFirstNameTwo());
		SeleniumUtils.sendKeysToWebElement(driver, surnameAdultPassengerTwo, Constants.getAdultSurNameTwo());
	}

	private void enterAdultPassengerOneInformation() throws InterruptedException, IOException, Exception {
		SeleniumUtils.waitAndClickElement(driver, selectTitleForAdultPassengerOne);
		SeleniumUtils.waitAndClickElement(driver, selectMrTitleAdultPassengers);

		SeleniumUtils.sendKeysToWebElement(driver, firstNameAdultPassengerOne, Constants.getAdultFirstNameOne());
		SeleniumUtils.sendKeysToWebElement(driver, surnameAdultPassengerOne, Constants.getAdultSurNameOne());
	}
}
