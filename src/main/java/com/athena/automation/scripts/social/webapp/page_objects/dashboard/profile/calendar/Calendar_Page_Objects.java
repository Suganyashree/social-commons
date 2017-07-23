package com.athena.automation.scripts.social.webapp.page_objects.dashboard.profile.calendar;

import org.openqa.selenium.By;

import com.athena.automation.framework.Driver;
import com.athena.automation.framework.support.Element;

import ru.yandex.qatools.allure.annotations.Step;

public class Calendar_Page_Objects {
	private Driver driver;
	private String baseCss = "div#jive-body div#event-calendar ";
	
	public Calendar_Page_Objects(Driver driver) {
		this.driver = driver;
	}
	
	@Step
	public Element month_button() throws Exception {
		return driver.getBrowser().findElement(By.cssSelector(baseCss + "span.fc-button-month"));
	}
	@Step
	public Element week_button() throws Exception {
		return driver.getBrowser().findElement(By.cssSelector(baseCss + "span.fc-button-agendaWeek"));
	}
	@Step
	public Element day_button() throws Exception {
		return driver.getBrowser().findElement(By.cssSelector(baseCss + "span.fc-button-agendaDay"));
	}
	@Step
	public Element today_button() throws Exception {
		return driver.getBrowser().findElement(By.cssSelector(baseCss + "span.fc-button-today"));
	}
	@Step
	public Element prev_button() throws Exception {
		return driver.getBrowser().findElement(By.cssSelector(baseCss + "span.fc-button-prev"));
	}
	@Step
	public Element next_button() throws Exception {
		return driver.getBrowser().findElement(By.cssSelector(baseCss + "span.fc-button-next"));
	}
	@Step
	public Element date_label() throws Exception {
		return driver.getBrowser().findElement(By.cssSelector(baseCss + "span.fc-header-title"));
	}
}