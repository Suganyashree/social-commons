package com.athena.automation.framework.support;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class Element extends AllureActions {
	private List<WebElement> webElements;
	private WebElement webElement;
	private WebDriver webDriver;

	public Element(WebDriver webDriver) {
		super(webDriver);
		this.webDriver = webDriver;
	}

	@Step
	public void click() {
		attachScreenshot();
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(getWebElement()));
		getWebElement().click();
		attachScreenshot();
	}

	@Step
	public void submit() {
		attachScreenshot();
		getWebElement().submit();
		attachScreenshot();
	}
	
	@Step
	public String getAttribute(String attr) {
		attachScreenshot();
		return getWebElement().getAttribute(attr);
	}

	@Step
	public String getText() {
		attachScreenshot();
		return getWebElement().getText();
	}
	
	@Step
	public void clear() {
		attachScreenshot();
		getWebElement().clear();
		attachScreenshot();
	}
	
	@Step
	public void sendkeys(String text) {
		attachScreenshot();
		getWebElement().sendKeys(text);
		attachScreenshot();
	}

	public List<WebElement> getWebElements() {
		return webElements;
	}

	public void setWebElements(List<WebElement> webElements) {
		this.webElements = webElements;
	}

	public WebElement getWebElement() {
		return webElement;
	}

	public void setWebElement(WebElement webElement) {
		this.webElement = webElement;
	}
}