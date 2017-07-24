package com.athena.automation.framework.browser;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

//import com.athena.automation.framework.tooling.EnvironmentCheck;

public class InitiateBrowser {
	public static WebDriver getBrowser(Properties envParams) throws Exception {
		WebDriver driver;

		String baseURL = envParams.getProperty("base_url");
//		int status = EnvironmentCheck.getResponseCode("https://social.athenahealth.com");
//        if (status != 200){
//            System.out.println("Sever is down. Try again later!!!!");
//            System.exit(0);
//        }
		String browserName = envParams.getProperty("browser");
		String driversPath = envParams.getProperty("drivers");
		switch(browserName) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver", driversPath + "geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", driversPath + "chromedriver.exe" );
			driver = new ChromeDriver();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", driversPath + "IEDriverServer.exe" );
			driver = new InternetExplorerDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		default:
			throw new Exception("Invalid browser : " + browserName + " is specified. Valid values {firefox, chrome, ie, safari}");
		}

		driver.manage().window().maximize();
		driver.navigate().to(baseURL);

		return driver;
	}
}