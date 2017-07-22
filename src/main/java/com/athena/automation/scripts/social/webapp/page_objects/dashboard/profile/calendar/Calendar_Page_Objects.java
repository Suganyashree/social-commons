package com.athena.automation.scripts.social.webapp.page_objects.dashboard.profile.calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Calendar_Page_Objects {
	private WebDriver driver;
	private String baseCss = "div#jive-body div#event-calendar ";
	
	public Calendar_Page_Objects(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement month_button() {
		return driver.findElement(By.className(baseCss + "fc-button-month"));
	}
	public WebElement week_button() {
		return driver.findElement(By.className(baseCss + "fc-button-agendaWeek"));
	}
	public WebElement day_button() {
		return driver.findElement(By.className(baseCss + "fc-button-agendaDay"));
	}
	public WebElement today_button() {
		return driver.findElement(By.className(baseCss + "fc-button-today"));
	}
	public WebElement prev_button() {
		return driver.findElement(By.className(baseCss + "fc-button-prev"));
	}
	public WebElement next_button() {
		return driver.findElement(By.className(baseCss + "fc-button-next"));
	}
	public WebElement date_label() {
		return driver.findElement(By.className(baseCss + "fc-header-title"));
	}
}