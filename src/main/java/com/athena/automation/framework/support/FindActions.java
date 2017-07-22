package com.athena.automation.framework.support;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.ArrayList;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

class FindActions {
	private WebDriver webDriver;

	public FindActions(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public Element findElement(By by) throws Exception {
		Wait<WebDriver> wait = new FluentWait<>(webDriver).withTimeout(60, SECONDS).pollingEvery(5, SECONDS).ignoring(NoSuchElementException.class);

		ExpectedCondition<WebElement> condition = new ExpectedCondition<WebElement>() {
			private By by;

			private ExpectedCondition<WebElement> init(By by) {
				this.by = by;
				return this;
			}

			public WebElement apply(WebDriver webDriver) {
				return webDriver.findElement(by);
			}
		}.init(by);

		WebElement webElement = wait.until(condition);
		Element element = new Element(webDriver);
		element.setWebElement(webElement);
		
		return element;
	}

	public List<Element> findElements(By by) throws Exception {
		Wait<WebDriver> wait = new FluentWait<>(webDriver).withTimeout(60, SECONDS).pollingEvery(5, SECONDS).ignoring(NoSuchElementException.class);

		ExpectedCondition<List<WebElement>> condition = new ExpectedCondition<List<WebElement>>() {
			private List<WebElement> webElements = new ArrayList<>();
			private By by;

			private ExpectedCondition<List<WebElement>> init(By by) {
				this.by = by;

				return this;
			}

			public List<WebElement> apply(WebDriver webDriver) {
				this.webElements = webDriver.findElements(by);

				if(webElements.isEmpty()) {
					return null;
				} else {
					return webElements;
				}
			}
		}.init(by);
		
		List<WebElement> webElements = wait.until(condition);
		List<Element> elements = new ArrayList<>();
		for (WebElement webElement : webElements) {
			Element element = new Element(webDriver);
			element.setWebElement(webElement);
			elements.add(element);
		}

		return elements;
	}
}