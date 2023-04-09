package com.cucumberFramework.pageObjects;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import static org.assertj.core.api.Assertions.assertThat;

import com.cucumberFramework.helper.Constants;
import com.cucumberFramework.helper.LoggerHelper;
import com.cucumberFramework.helper.SeleniumUtils;

public class ContactDetailsPage {

	private WebDriver driver;

	static Logger log = LoggerHelper.getLogger(ContactDetailsPage.class);

	public ContactDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//input[@name='undefined'])[1]")
	private WebElement phoneNumberTextbox;

	@FindBy(xpath = "(//div[@class='_label'])[2]")
	private WebElement uncheckSubscribeCheckbox;

	@FindBy(xpath = "(//div[@class='_container'])[5]")
	private WebElement iDontWantToBeInsuredRadioButton;

	@FindBy(xpath = "(//*[@name='undefined'])[2]")
	private WebElement cardNumberTextBox;

	@FindBy(xpath = "(//div[@class='dropdown b2'])[2]")
	private WebElement expiryDateMonthDropDown;

	@FindBy(xpath = "//div[contains(text(),'October')][1]")
	private WebElement selectCardMonthDropDown;

	@FindBy(xpath = "(//button[@class='dropdown__toggle b2'])[1]")
	private WebElement expiryDateYearDropDown;

	@FindBy(xpath = "//div[contains(text(),'2021')][1]")
	private WebElement selectCardYearDropDown;

	@FindBy(xpath = "(//input[@name='undefined'])[3]")
	private WebElement securityCodeCvvTextbox;

	@FindBy(xpath = "(//input[@name='undefined'])[4]")
	private WebElement cardHolderNameTextbox;

	@FindBy(xpath = "(//input[@name='undefined'])[5]")
	private WebElement addressLine1Textbox;

	@FindBy(xpath = "(//input[@name='undefined'])[6]")
	private WebElement addressLine2Textbox;

	@FindBy(xpath = "(//input[@name='undefined'])[7]")
	private WebElement cityTextbox;

	@FindBy(xpath = "(//input[@type='text'])[5]")
	private WebElement countryTextBox;

	@FindBy(xpath = "(//input[@name='undefined'])[8]")
	private WebElement zipcodeTextBox;

	@FindBy(xpath = "(//span[@class='dropdown__toggle-text ng-star-inserted'])[3]")
	private WebElement selectCurrencyDropDown;

	@FindBy(xpath = "//div[contains(text(),'EUR')][1]")
	private WebElement selectCurrencyEuroDropDown;

	@FindBy(xpath = "(//div[@class='_background'])[8]")
	private WebElement checkAcceptTermsAndConditions;

	@FindBy(xpath = "(//button[@class='pay-button ry-button--gradient-yellow'])[1]")
	private WebElement paynowButton;

	@FindBy(xpath = "//div[@class='b2 ng-star-inserted'][1]")
	private WebElement paymentDeclinedMessage;

	@FindBy(xpath = "(//span[@class='b2 ng-star-inserted'])[1]")
	private WebElement loginPopupMessage;

	public void enterCardDetailsAndClickPayNow(String cardInput, String cvvInput) throws Exception {

		enterPhoneNumberAndUnCheckBoxes();
		enterCardInformation(cardInput, cvvInput);
		enterAddress();
		selectCurrency();
		checkTermsAndConditionsAndPayNow();

	}

	private void checkTermsAndConditionsAndPayNow() throws InterruptedException, IOException {
		SeleniumUtils.waitAndClickElement(driver, checkAcceptTermsAndConditions);
		SeleniumUtils.waitAndClickElement(driver, paynowButton);
	}

	private void selectCurrency() throws InterruptedException, IOException {
		SeleniumUtils.waitAndClickElement(driver, selectCurrencyDropDown);
		SeleniumUtils.waitAndClickElement(driver, selectCurrencyEuroDropDown);
	}

	private void enterAddress() throws Exception {
		SeleniumUtils.sendKeysToWebElement(driver, addressLine1Textbox, Constants.getAddressLine());
		SeleniumUtils.sendKeysToWebElement(driver, addressLine2Textbox, Constants.getAddressLine());
		SeleniumUtils.sendKeysToWebElement(driver, cityTextbox, Constants.getCity());
		SeleniumUtils.sendKeysToWebElement(driver, countryTextBox, Constants.getCountry());
		SeleniumUtils.sendKeysToWebElement(driver, countryTextBox, Keys.RETURN);
		SeleniumUtils.sendKeysToWebElement(driver, zipcodeTextBox, Constants.getZipCode());
	}

	private void enterCardInformation(String cardInput, String cvvInput)
			throws InterruptedException, IOException, Exception {
		SeleniumUtils.waitAndClickElement(driver, cardNumberTextBox);
		SeleniumUtils.sendKeysToWebElement(driver, cardNumberTextBox, cardInput);
		SeleniumUtils.waitAndClickElement(driver, expiryDateMonthDropDown);
		SeleniumUtils.WaitUntilWebElementClickable(driver, selectCardMonthDropDown);
		SeleniumUtils.waitAndClickElement(driver, selectCardMonthDropDown);
		SeleniumUtils.waitAndClickElement(driver, expiryDateYearDropDown);
		SeleniumUtils.waitAndClickElement(driver, selectCardYearDropDown);
		SeleniumUtils.waitAndClickElement(driver, securityCodeCvvTextbox);
		SeleniumUtils.sendKeysToWebElement(driver, securityCodeCvvTextbox, cvvInput);
		SeleniumUtils.waitAndClickElement(driver, cardHolderNameTextbox);
		SeleniumUtils.sendKeysToWebElement(driver, cardHolderNameTextbox, Constants.getCardHolderName());
	}

	private void enterPhoneNumberAndUnCheckBoxes() throws Exception, InterruptedException, IOException {
		SeleniumUtils.sendKeysToWebElement(driver, phoneNumberTextbox, Constants.getPhoneNumber());
		SeleniumUtils.waitAndClickElement(driver, uncheckSubscribeCheckbox);
		SeleniumUtils.waitAndClickElement(driver, iDontWantToBeInsuredRadioButton);
	}

	public void assertPaymentDeclinedMessage() throws Exception {
		assertThat(SeleniumUtils.getText(driver, paymentDeclinedMessage).equals(Constants.getErrorMessage()));
	}

	public void assertLoginPopupMessage() throws Exception {
		assertThat(SeleniumUtils.getText(driver, loginPopupMessage).equals(Constants.getloginMessage()));
	}
}
