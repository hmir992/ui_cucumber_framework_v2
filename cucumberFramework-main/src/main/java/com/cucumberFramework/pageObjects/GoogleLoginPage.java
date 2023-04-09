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

public class GoogleLoginPage {

	private WebDriver driver;

	static Logger log = LoggerHelper.getLogger(GoogleLoginPage.class);

	@FindBy(xpath = "(//span[@class='ry-header__menu-item-title ng-star-inserted'])[4]")
	private WebElement loginHyperLink;

	@FindBy(xpath = "(//img[@alt='Google'])[1]")
	private WebElement googleLoginImage;

	@FindBy(xpath = "(//div[contains(text(),'Use another account')])[1]")
	private WebElement useAnotherAccountButtonGoogle;

	@FindBy(id = "identifierId")
	private WebElement emailaddressTextBoxGoogle;

	@FindBy(id = "identifierNext")
	private WebElement userNameNextButtonGoogle;

	@FindBy(xpath = "(//*[@type='password'])[1]")
	private WebElement passwordTextBoxGoogle;

	@FindBy(id = "passwordNext")
	private WebElement passwordNextButtonGoogle;

	public GoogleLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loginToAccountViaGoogle() throws Exception {
		loginHyperLink.click();
		SeleniumUtils.WaitUntilWebElementClickable(driver, googleLoginImage);
		googleLoginImage.click();

		String mainWindowHandle = driver.getWindowHandle();
		for (String childWindowHandle : driver.getWindowHandles()) {
			// If window handle is not main window handle then close it
			if (!childWindowHandle.equals(mainWindowHandle)) {
				driver.switchTo().window(childWindowHandle);
				SeleniumUtils.scrollDown(driver);
				SeleniumUtils.pause(5);
				SeleniumUtils.sendKeysToWebElement(driver, emailaddressTextBoxGoogle, Constants.getUsername());
				SeleniumUtils.waitAndClickElement(driver, userNameNextButtonGoogle);
				SeleniumUtils.sendKeysToWebElement(driver, passwordTextBoxGoogle, Constants.getPassword());
				SeleniumUtils.waitAndClickElement(driver, passwordNextButtonGoogle);
			}
		}

		// switch back to main window
		driver.switchTo().window(mainWindowHandle);
		SeleniumUtils.pause(5);

	}

}
