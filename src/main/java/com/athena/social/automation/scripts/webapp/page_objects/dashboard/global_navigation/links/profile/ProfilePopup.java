package com.athena.social.automation.scripts.webapp.page_objects.dashboard.global_navigation.links.profile;

import org.openqa.selenium.WebDriver;

import com.athena.social.automation.scripts.webapp.page_objects.dashboard.profile.calendar.Calendar_Page;

public class ProfilePopup {
	public ProfilePopup_Objects webElements;
	private WebDriver driver;

	public ProfilePopup(WebDriver driver) {
		this.driver = driver;
		this.webElements = new ProfilePopup_Objects(driver);
	}

	public Calendar_Page openCalendar() {
		webElements.calendar_link().click();
		return new Calendar_Page(driver);
	}
}