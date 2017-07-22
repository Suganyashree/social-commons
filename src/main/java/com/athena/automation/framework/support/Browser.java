package com.athena.automation.framework.support;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.allure.annotations.Step;

public class Browser {
	private WebDriver webDriver;
	private FindActions findActions;

	public Browser(WebDriver webDriver) throws IOException {
		this.webDriver = webDriver;
	}
	
	@Step
	public Element findElement(By by) throws Exception {
		return this.findActions.findElement(by);
	}
	
	@Step
	public List<Element> findElements(By by) throws Exception {
		return this.findActions.findElements(by);
	}

	@Step
	public void goBack() {
		webDriver.navigate().back();
	}

	@Step
	public void goForward() {
		webDriver.navigate().forward();
	}

	@Step
	public void clearCache() { }

	@Step
	public void deleteCookies() {
		webDriver.manage().deleteAllCookies();
	}

	@Step
	public boolean exist() { return true; }

	@Step
	public void minimize() { }

	@Step
	public void maximize() {
		webDriver.manage().window().maximize();
	}

	@Step
	public void fullScreen() { }

	@Step
	public void navigate(String url) throws InterruptedException {
		webDriver.navigate().to(url);
		waitForPageLoad();
	}

	@Step
	public void refresh() {
		webDriver.navigate().refresh();
	}

	@Step
	public String getCurrentWindowHandle() {
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
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		return jse.executeScript(script);
	}

	@Step
	public Object executeAsyncJavascript(String script) {
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		return jse.executeAsyncScript(script);
	}

	@Step
	public void setFocus() {
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