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

public class DemoWebHomePage {

	private WebDriver driver;

	static Logger log = LoggerHelper.getLogger(DemoWebHomePage.class);

	@FindBy(xpath = "(//a[@class='account'])[1]")
	private WebElement currentLoggedInAccount;
	
	@FindBy(xpath = "(//div[@class='validation-summary-errors'])[1]")
	private WebElement loginErrorMessage;
	
	//search item
	
	@FindBy(id = "small-searchterms")
	private WebElement searchItemBox;
	
	@FindBy(xpath = "(//*[@class='button-1 search-box-button'])[1]")
	private WebElement searchItemButton;

	public DemoWebHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void goToDemoWebPage() throws InterruptedException, IOException {
		driver.get("https://demowebshop.tricentis.com/");
	}
	
	public void searchBook() throws InterruptedException, IOException {
		SeleniumUtils.WaitUntilWebElementClickable(driver, searchItemBox);
		searchItemBox.sendKeys(Constants.getSearchitem());
		searchItemButton.click();

	}
	
	public void assertLoginErrorMessage() throws Exception {
		assertEquals(SeleniumUtils.getText(driver, loginErrorMessage), Constants.getErrorMessage());
	}
	
	public void assertLoginLoggedInUser() throws Exception {
		assertEquals(SeleniumUtils.getText(driver, currentLoggedInAccount), Constants.getloginMessage());
	}
}
