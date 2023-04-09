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

public class SelectSeatsPage {

	private WebDriver driver;

	static Logger log = LoggerHelper.getLogger(SelectSeatsPage.class);

	public SelectSeatsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// select seats

	@FindBy(xpath = "(//button[contains(text(),' Okay, got it. ')])[1]")
	private WebElement okayGotItPopup;

	@FindBy(xpath = "(//button[@class='ng-star-inserted seatmap__seat seatmap__seat--priority'])[1]")
	private WebElement selectSeats;

	@FindBy(xpath = "(//button[@class='ng-star-inserted seatmap__seat seatmap__seat--standard'])[1]")
	private WebElement selectSeatsnew;

	@FindBy(xpath = "//button[@class='ry-button ry-button--gradient-yellow seats-action__button ry-button--flat-blue']")
	private WebElement selectSeatscontinueButton;

	@FindBy(xpath = "(//button[@class='enhanced-takeover-beta__product-dismiss-cta ry-button--anchor-blue ry-button--anchor'])[1]")
	private WebElement NoThanksPopup;

	public void selectSeatsForPassengers() throws InterruptedException, IOException {

		closepopupAndScrollUp();
		selectSeats();
	}

	private void selectSeats() throws InterruptedException, IOException {
		SeleniumUtils.waitAndClickElement(driver, selectSeats);
		SeleniumUtils.waitAndClickElement(driver, selectSeats);
		SeleniumUtils.waitAndClickElement(driver, selectSeats);
		SeleniumUtils.waitAndClickElement(driver, selectSeatscontinueButton);
		SeleniumUtils.waitAndClickElement(driver, NoThanksPopup);
	}

	private void closepopupAndScrollUp() throws InterruptedException, IOException {
		SeleniumUtils.WaitUntilWebElementClickable(driver, okayGotItPopup);
		SeleniumUtils.waitAndClickElement(driver, okayGotItPopup);
		SeleniumUtils.scrollUp(driver);
		SeleniumUtils.pause(5);
	}

}
