package com.athena.automation.framework.support;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.allure.annotations.Step;

public class Browser extends AllureActions {
	private WebDriver webDriver;
	private FindActions findActions;

	public Browser(WebDriver webDriver) throws IOException {
		super(webDriver);
		this.webDriver = webDriver;
	}
	
	@Step
	public Element findElement(By by) throws Exception {
		attachScreenshot();
		return this.findActions.findElement(by);
	}
	
	@Step
	public List<Element> findElements(By by) throws Exception {
		attachScreenshot();
		return this.findActions.findElements(by);
	}

	@Step
	public void goBack() {
		attachScreenshot();
		webDriver.navigate().back();
		attachScreenshot();
	}

	@Step
	public void goForward() {
		attachScreenshot();
		webDriver.navigate().forward();
		attachScreenshot();
	}

	@Step
	public void clearCache() { }

	@Step
	public void deleteCookies() {
		attachScreenshot();
		webDriver.manage().deleteAllCookies();
		attachScreenshot();
	}

	@Step
	public boolean exist() { return true; }

	@Step
	public void minimize() { }

	@Step
	public void maximize() {
		attachScreenshot();
		webDriver.manage().window().maximize();
		attachScreenshot();
	}

	@Step
	public void fullScreen() { }

	@Step
	public void navigate(String url) throws InterruptedException {
		attachScreenshot();
		webDriver.navigate().to(url);
		waitForPageLoad();
		attachScreenshot();
	}

	@Step
	public void refresh() {
		attachScreenshot();
		webDriver.navigate().refresh();
		attachScreenshot();
	}

	@Step
	public String getCurrentWindowHandle() {
		attachScreenshot();
		return webDriver.getWindowHandle();
	}

	@Step
	public void sync() { }
	
	@Step
	public void waitForTimeout() { }
	
	@Step
	public void captureScreenshot() { }

	@Step
	public Object executeSyncJavascript(String script) {
		attachScreenshot();
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		return jse.executeScript(script);
	}

	@Step
	public Object executeAsyncJavascript(String script) {
		attachScreenshot();
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		return jse.executeAsyncScript(script);
	}

	@Step
	public void setFocus() {
		attachScreenshot();
		executeSyncJavascript("window.focus();");
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}

	@Step
	public void waitForPageLoad() {
		waitForPageLoad(60);
	}

	@Step
	public void waitForPageLoad(long timeOutInSeconds) {
		attachScreenshot();
		WebDriverWait wdw = new WebDriverWait(webDriver,timeOutInSeconds);
		ExpectedCondition<Boolean> condition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver webDriver) {
				String readyState = (String) (executeSyncJavascript("return document.readyState;"));
				return readyState.equalsIgnoreCase("complete");
			}
		};
		wdw.until(condition);
	}
}