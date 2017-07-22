package com.athena.automation.framework;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.athena.automation.framework.browser.InitiateBrowser;
import com.athena.automation.framework.support.Browser;
import com.athena.automation.framework.support.Utils;

import ru.yandex.qatools.allure.annotations.Step;

public class Driver {
	private WebDriver webDriver;
	private Browser browser;
	
	public Driver() throws Exception {
		Properties properties = new Properties();
		properties.load(new FileInputStream(Utils.getResourcesPath() + "environment.properties"));
		webDriver = InitiateBrowser.getBrowser(properties);
		this.browser = new Browser(webDriver);
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public Browser getBrowser() {
		return browser;
	}
	
	@Step
	public void close() {
		webDriver.close();
		webDriver.quit();
	}
}