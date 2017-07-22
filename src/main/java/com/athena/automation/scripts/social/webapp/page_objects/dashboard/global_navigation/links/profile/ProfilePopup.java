package com.athena.automation.scripts.social.webapp.page_objects.dashboard.global_navigation.links.profile;

import com.athena.automation.framework.Driver;
import com.athena.automation.scripts.social.webapp.page_objects.dashboard.profile.calendar.Calendar_Page;

public class ProfilePopup {
	public ProfilePopup_Objects webElements;
	private Driver driver;

	public ProfilePopup(Driver driver) {
		this.driver = driver;
		this.webElements = new ProfilePopup_Objects(driver);
	}

	public Calendar_Page openCalendar() throws Exception {
		webElements.calendar_link().click();
		return new Calendar_Page(driver);
	}
}