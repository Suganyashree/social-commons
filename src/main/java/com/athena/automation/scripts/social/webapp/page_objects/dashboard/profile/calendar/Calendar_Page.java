package com.athena.automation.scripts.social.webapp.page_objects.dashboard.profile.calendar;

import org.openqa.selenium.WebDriver;

public class Calendar_Page {
	public Calendar_Page_Objects webElements;

	public Calendar_Page(WebDriver driver) {
		this.webElements = new Calendar_Page_Objects(driver);
	}
}