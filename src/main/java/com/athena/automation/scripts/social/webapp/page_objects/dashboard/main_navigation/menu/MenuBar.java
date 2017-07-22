package com.athena.automation.scripts.social.webapp.page_objects.dashboard.main_navigation.menu;

import com.athena.automation.framework.Driver;

public class MenuBar {
	public MenuBar_Objects webElements;

	public MenuBar(Driver driver) {
		this.webElements = new MenuBar_Objects(driver);
	}
}