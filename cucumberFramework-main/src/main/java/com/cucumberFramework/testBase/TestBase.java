package com.cucumberFramework.testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.cucumberFramework.enums.Browsers;
import com.cucumberFramework.enums.OS;
import com.cucumberFramework.pageObjects.AddBagPage;
import com.cucumberFramework.pageObjects.ContactDetailsPage;
import com.cucumberFramework.pageObjects.ExtrasForFlightPage;
import com.cucumberFramework.pageObjects.FlightInformationPage;
import com.cucumberFramework.pageObjects.GoogleLoginPage;
import com.cucumberFramework.pageObjects.PlanYourWholeTripPage;
import com.cucumberFramework.pageObjects.RyanairHomePage;
import com.cucumberFramework.pageObjects.SelectSeatsPage;

public class TestBase {

	public static WebDriver driver;

	public WebDriver selectBrowser(String browser) {
		if (System.getProperty("os.name").toLowerCase().contains(OS.WINDOW.name().toLowerCase())) {
			if (browser.equalsIgnoreCase(Browsers.CHROME.name())) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe");

				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("incognito");
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);

				driver = new ChromeDriver(capabilities);
				driver.manage().window().maximize();
			} else if (browser.equalsIgnoreCase(Browsers.FIREFOX.name())) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "/src/test/resources/drivers/geckodriver.exe");

				DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("-private");
				capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);

				driver = new FirefoxDriver(capabilities);
				driver.manage().window().maximize();
			}
		} else if (System.getProperty("os.name").toLowerCase().contains(OS.MAC.name().toLowerCase())) {
			if (browser.equalsIgnoreCase(Browsers.CHROME.name())) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver");

				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("incognito");
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);

				driver = new ChromeDriver(capabilities);
				driver.manage().window().maximize();

			} else if (browser.equalsIgnoreCase(Browsers.FIREFOX.name())) {
				System.setProperty("webdriver.firefox.marionette",
						System.getProperty("user.dir") + "/src/test/resources/drivers/geckodriver");

				DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("-private");
				capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);

				driver = new FirefoxDriver(capabilities);
				driver.manage().window().maximize();
			}
		}
		return driver;
	}
}
