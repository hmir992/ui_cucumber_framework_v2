package com.cucumberFramework.pageObjects;

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

public class LoginPage {

	private WebDriver driver;

	static Logger log = LoggerHelper.getLogger(LoginPage.class);

	//login page
	@FindBy(xpath = "(//a[contains(text(),'Log in')])[1]")
	private WebElement loginLink;

	// loginToAccount
	@FindBy(id = "Email")
	private WebElement LoginUserNameTextBox;
	
	@FindBy(id = "Password")
	private WebElement LoginPasswordTextBox;

	@FindBy(xpath = "(//input[@class='button-1 login-button'])[1]")
	private WebElement loginButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loginToAccount() {
		loginLink.click();
		enterUsername();
		enterPassword();
		loginButton.click();

	}
	
	public void loginToAccountWithIncorrectDetails() {
		loginLink.click();
		enterInCorrectUsername();
		enterIncorrectPassword();
		loginButton.click();

	}
	
	private void enterIncorrectPassword() {
		LoginPasswordTextBox.sendKeys(Constants.getIncorrectPassword());
	}

	private void enterInCorrectUsername() {
		SeleniumUtils.WaitUntilWebElementClickable(driver, LoginUserNameTextBox);
		LoginUserNameTextBox.sendKeys(Constants.getIncorrectUsername());
	}


	private void enterPassword() {
		LoginPasswordTextBox.sendKeys(Constants.getPassword());
	}

	private void enterUsername() {
		SeleniumUtils.WaitUntilWebElementClickable(driver, LoginUserNameTextBox);
		LoginUserNameTextBox.sendKeys(Constants.getUsername());
	}

}
