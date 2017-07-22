package com.athena.automation.scripts.social.webapp.page_objects.dashboard.main_navigation;

import com.athena.automation.framework.Driver;
import com.athena.automation.scripts.social.webapp.page_objects.dashboard.main_navigation.menu.MenuBar;

public class MainNavigation {
	public MenuBar menuBar;

	public MainNavigation(Driver driver) {
		this.menuBar = new MenuBar(driver);
	}
}