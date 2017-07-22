package com.athena.automation.scripts.social.webapp.page_objects.dashboard.profile.calendar;

import org.openqa.selenium.By;

import com.athena.automation.framework.Driver;
import com.athena.automation.framework.support.Element;

public class Calendar_Page_Objects {
	private Driver driver;
	private String baseCss = "div#jive-body div#event-calendar ";
	
	public Calendar_Page_Objects(Driver driver) {
		this.driver = driver;
	}
	
	public Element month_button() throws Exception {
		return driver.getBrowser().findElement(By.cssSelector(baseCss + "span.fc-button-month"));
	}
	public Element week_button() throws Exception {
		return driver.getBrowser().findElement(By.cssSelector(baseCss + "span.fc-button-agendaWeek"));
	}
	public Element day_button() throws Exception {
		return driver.getBrowser().findElement(By.cssSelector(baseCss + "span.fc-button-agendaDay"));
	}
	public Element today_button() throws Exception {
		return driver.getBrowser().findElement(By.cssSelector(baseCss + "span.fc-button-today"));
	}
	public Element prev_button() throws Exception {
		return driver.getBrowser().findElement(By.cssSelector(baseCss + "span.fc-button-prev"));
	}
	public Element next_button() throws Exception {
		return driver.getBrowser().findElement(By.cssSelector(baseCss + "span.fc-button-next"));
	}
	public Element date_label() throws Exception {
		return driver.getBrowser().findElement(By.cssSelector(baseCss + "span.fc-header-title"));
	}
}