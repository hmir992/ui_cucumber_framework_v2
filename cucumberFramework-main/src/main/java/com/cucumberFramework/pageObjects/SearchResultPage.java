package com.cucumberFramework.pageObjects;

import static org.assertj.core.api.Assertions.assertThat;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.swing.text.StyleConstants.CharacterConstants;

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

import cucumber.api.java.eo.Se;

public class SearchResultPage {

	private WebDriver driver;

	static Logger log = LoggerHelper.getLogger(SearchResultPage.class);

	//login page
	@FindBy(xpath = "(//a[contains(text(),'Log in')]")
	private WebElement loginLink;

	// loginToAccount
	@FindBy(id = "Email")
	private WebElement LoginUserNameTextBox;
	
	@FindBy(id = "Password")
	private WebElement LoginPasswordTextBox;

	@FindBy(xpath = "(//input[@class='button-1 login-button']")
	private WebElement loginButton;

	@FindBy(xpath = "(//input[@name='password'])[1]")
	private WebElement passwordTextbox;

	@FindBy(xpath = "(//a[@class='account'])[1]")
	private WebElement currentLoggedInAccount;
	
	@FindBy(xpath = "(//div[@class='validation-summary-errors'])[1]")
	private WebElement loginErrorMessage;
	
	//search item
	
	@FindBy(id = "small-searchterms")
	private WebElement searchItemBox;
	
	@FindBy(id = "button-1 search-box-button")
	private WebElement searchItemButton;
	
	// search item page
	
	@FindBy(className = "product-title")
	private WebElement searchResultItem;
	

	// selectFlightInformationAndClickSearch

	@FindBy(xpath = "(//button[@class='trip-type__button ng-star-inserted'])[2]")
	private WebElement oneWayCheckBox;

	@FindBy(xpath = "(//input[@class='input-button__input ng-star-inserted'])[2]")
	private WebElement selectDestinationInput;

	@FindBy(xpath = "(//span[contains(text(),'Germany')])[1]")
	private WebElement selectGermany;

	@FindBy(xpath = "(//span[contains(text(),' Berlin Brandenburg ')])[1]")
	private WebElement selectBerlinBrandenburg;

	@FindBy(xpath = "(//div[contains(text(),'Mar')])[1]")
	private WebElement selectMarch;

	@FindBy(xpath = "//div[@data-id='2021-03-12']")
	private WebElement select12March2021;

	@FindBy(xpath = "(//div[@class='counter__button-wrapper--enabled'])[1]")
	private WebElement addAnAdultPassenger;

	@FindBy(xpath = "(//div[@class='counter__button-wrapper--enabled'])[4]")
	private WebElement addAChildPassenger;

	@FindBy(xpath = "(//div[@class='_background'])[1]")
	private WebElement clickTermsAndCondtionsCheckbox;

	@FindBy(xpath = "(//button[@class='flight-search-widget__start-search ry-button--gradient-yellow ng-trigger ng-trigger-collapseExpandCta'])[1]")
	private WebElement clickSearchButton;

	@FindBy(xpath = "(//button[contains(text(),'Done')])[1]")
	private WebElement addingPassengerDoneHyperLink;

	@FindBy(xpath = "(//img[@alt='Google'])[1]")
	private WebElement googleLoginImage;

	@FindBy(xpath = "(//div[contains(text(),'Use another account')])[1]")
	private WebElement useAnotherAccountButtonGoogle;

	@FindBy(xpath = "(//input[@type='email'])[1]")
	private WebElement emailaddressTextBoxGoogle;

	@FindBy(xpath = "(//div[@class='VfPpkd-Jh9lGc'])[1]")
	private WebElement nextButtonGoogle;

	@FindBy(xpath = "(//*[contains(text(),'Next')])[2]")
	private WebElement nextButtonGoogleold;

	@FindBy(xpath = "(//input[@type='text'])[1]")
	private WebElement passwordTextBoxGoogle;

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void assertProductSearch() throws Exception {
		assertEquals(SeleniumUtils.getText(driver, searchResultItem), Constants.getSearchItemResult());
		//assertThat(SeleniumUtils.getText(driver, currentLoggedInAccount).equals(Constants.getloginMessage()));
	}

	public void goToDemoWebPage() throws InterruptedException, IOException {
		driver.get("https://demowebshop.tricentis.com/");
		// SeleniumUtils.pause(10);

	}
	
	public void searchBook() throws InterruptedException, IOException {
		SeleniumUtils.WaitUntilWebElementClickable(driver, searchItemBox);
		searchItemButton.sendKeys(Constants.getSearchitem());
		// SeleniumUtils.pause(10);

	}
	
	public void assertLoginErrorMessage() throws Exception {
		assertEquals(SeleniumUtils.getText(driver, loginErrorMessage), Constants.getErrorMessage());
		//assertThat(SeleniumUtils.getText(driver, loginErrorMessage).equals(Constants.getErrorMessage()));
	}
	
	public void assertLoginLoggedInUser() throws Exception {
		assertEquals(SeleniumUtils.getText(driver, currentLoggedInAccount), Constants.getloginMessage());
		//assertThat(SeleniumUtils.getText(driver, currentLoggedInAccount).equals(Constants.getloginMessage()));
	}

	public void loginToAccountViaGoogle() throws Exception {
		//loginHyperLink.click();
		SeleniumUtils.WaitUntilWebElementClickable(driver, googleLoginImage);
		googleLoginImage.click();
		String mainWindowHandle = driver.getWindowHandle();
		for (String childWindowHandle : driver.getWindowHandles()) {
			// If window handle is not main window handle then close it
			if (!childWindowHandle.equals(mainWindowHandle)) {
				driver.switchTo().window(childWindowHandle);
				// SeleniumUtils.sendKeysToWebElement(driver, emailaddressTextBoxGoogle,
				// "1234automation567@gmail.com");
				SeleniumUtils.scrollDown(driver);
				SeleniumUtils.pause(5);
				WebElement we = driver.findElement(By.id("identifierId"));
				we.sendKeys("1234automation567@gmail.com");
				driver.findElement(By.id("identifierNext")).click();
				SeleniumUtils.pause(5);
				// SeleniumUtils.WaitUntilWebElementClickable(driver, nextButtonGoogle);
				// SeleniumUtils.waitAndClickElement(driver, nextButtonGoogle);
				WebElement we2 = driver.findElement(By.xpath("(//*[@type='password'])[1]"));
				we2.sendKeys("Consultant1234@");
				driver.findElement(By.id("passwordNext")).click();

				// SeleniumUtils.sendKeysToWebElement(driver, passwordTextBoxGoogle,
				// "Consultant1234@");
				// SeleniumUtils.waitAndClickElement(driver, nextButtonGoogle);

				// SeleniumUtils.waitAndClickElement(driver, next);

				// Close child windows
				// driver.close();
			}
		}

		// switch back to main window
		driver.switchTo().window(mainWindowHandle);
		SeleniumUtils.pause(5);

	}

	public void loginToAccount() {
		//loginHyperLink.click();
		//enterUsername();
		enterPassword();
		loginButton.click();
		SeleniumUtils.pause(5);

	}

	private void enterPassword() {
		passwordTextbox.sendKeys(Constants.getPassword());
	}

	/*private void enterUsername() {
		SeleniumUtils.WaitUntilWebElementClickable(driver, emailAddressTextBox);
		emailAddressTextBox.sendKeys(Constants.getUsername());
	}
	
	public void assertLoginLoggedInUser() throws Exception {
		assertThat(SeleniumUtils.getText(driver, curre).equals(Constants.getloginMessage()));
	}

	public void clickClosePopup() {
		//closePopup.click();
	}
*/
}
