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

import com.cucumberFramework.helper.LoggerHelper;
import com.cucumberFramework.helper.SeleniumUtils;

public class AddBagPage {

	private WebDriver driver;

	static Logger log = LoggerHelper.getLogger(AddBagPage.class);

	public AddBagPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// select no bags

	@FindBy(xpath = "(//label[@class='ry-radio-circle-button__label'])[1]")
	private WebElement onlyOneSmallBag;

	@FindBy(xpath = "(//button[@class='ry-button--gradient-yellow'])[1]")
	private WebElement selectPriorityBagsContinueButton;

	public void selectNoBags() throws InterruptedException, IOException {

		SeleniumUtils.waitAndClickElement(driver, onlyOneSmallBag);
		SeleniumUtils.waitAndClickElement(driver, selectPriorityBagsContinueButton);
	}
}
