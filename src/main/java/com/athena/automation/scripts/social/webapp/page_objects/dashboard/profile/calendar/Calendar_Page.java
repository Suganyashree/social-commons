package com.athena.automation.scripts.social.webapp.page_objects.dashboard.profile.calendar;

import com.athena.automation.framework.Driver;

public class Calendar_Page {
	public Calendar_Page_Objects webElements;

	public Calendar_Page(Driver driver) {
		this.webElements = new Calendar_Page_Objects(driver);
	}
}